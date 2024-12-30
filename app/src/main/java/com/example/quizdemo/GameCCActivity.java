package com.example.quizdemo;

import static com.example.quizdemo.R.id.library;
import static com.example.quizdemo.R.id.quit;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class GameCCActivity extends AppCompatActivity {

    private ProgressBar progressBarLoad;
    private Button buttonStart;
    private ConstraintLayout constraintLayoutLoad;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_cc);

        // Initialize UI components
        progressBarLoad = findViewById(R.id.progressBar);
        buttonStart = findViewById(R.id.buttonStart);
        constraintLayoutLoad = findViewById(R.id.layoutLoad);
        toolbar = findViewById(R.id.toolbar);

        // Setup toolbar menu
        setSupportActionBar(toolbar); // Set the toolbar as the action bar
        toolbar.inflateMenu(R.menu.menu_game); // Inflate the menu

        final AlertDialog.Builder alBuilder = new AlertDialog.Builder(this);
        alBuilder.setTitle("Xác nhận thoát trò chơi");
        alBuilder.setIcon(android.R.drawable.ic_menu_close_clear_cancel);
        alBuilder.setMessage("Bạn muốn thoát khỏi trò chơi mà không có điểm ?");
        alBuilder.setPositiveButton("Đúng rồi", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(GameCCActivity.this, FolderActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }
        });
        alBuilder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // Do nothing
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case quit:
                        finish();
                        return true;
                    case library:
                        alBuilder.show();
                        return true;
                    default:
                        return false;
                }
            }
        });

        // Handle start button click
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                constraintLayoutLoad.setVisibility(View.GONE);
            }
        });
    }
}
