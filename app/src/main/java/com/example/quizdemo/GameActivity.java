package com.example.quizdemo;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity {

    private Button buttonPlay;
    private Spinner spinnerF;

    private ArrayList<String> listFolder = new ArrayList<>(); // Example folder list
    private int idF = 0; // Selected folder ID
    private int numOfWord = 0; // Number of words in the selected folder
    private Animation anim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        createUI();
        setupSpinner();
        setupButtonPlay();
    }

    private void createUI() {
        buttonPlay = findViewById(R.id.buttonPlay);
        spinnerF = findViewById(R.id.spinnerFolder);
        anim = AnimationUtils.loadAnimation(GameActivity.this, R.anim.sacle);
        buttonPlay.setAnimation(anim);
    }

    private void setupSpinner() {
        // Example folder names
        listFolder.add("Folder 1");
        listFolder.add("Folder 2");
        listFolder.add("Folder 3");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, listFolder);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerF.setAdapter(arrayAdapter);

        spinnerF.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idF = position;
                numOfWord = getNumOfWordsForFolder(idF);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void setupButtonPlay() {
        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (numOfWord > 4) {
                    showGameDialog();
                } else {
                    Toast.makeText(GameActivity.this, "Số lượng từ vựng của bạn phải lớn hơn 4: " + numOfWord, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void showGameDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.menu_game);
        dialog.show();

        Button buttonCC = dialog.findViewById(R.id.buttonCC);
        Button buttonGW = dialog.findViewById(R.id.buttonGW);
        buttonCC.startAnimation(anim);
        buttonGW.startAnimation(anim);

        buttonCC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, GameCCActivity.class);
                intent.putExtra("idfolder", idF);
                dialog.dismiss();
                startActivity(intent);
            }
        });

        // New logic for transitioning to GameGWActivity
        buttonGW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GameActivity.this, GameGWActivity.class);
                intent.putExtra("idfolder", idF); // Pass folder ID
                dialog.dismiss();
                startActivity(intent);
            }
        });
    }

    private int getNumOfWordsForFolder(int folderId) {

        if (folderId == 0) return 10; // Folder 1
        if (folderId == 1) return 5;  // Folder 2
        if (folderId == 2) return 3;  // Folder 3
        return 0;
    }
}
