package com.example.quizdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class GameGWActivity extends AppCompatActivity {

    private Button buttonStart, buttonScore, buttonQues, buttonA, buttonB, buttonC, buttonD;
    private ProgressBar progressBar;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_gw);  // Set the layout for the activity

        // Initialize Toolbar
        toolbar = findViewById(R.id.toolbarGame);
        setSupportActionBar(toolbar); // Set the toolbar as the action bar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle("Trắc nghiệm hoàn hảo");
        }

        // Initialize Buttons
        buttonStart = findViewById(R.id.buttonStart);
        buttonScore = findViewById(R.id.buttonScore);
        buttonQues = findViewById(R.id.buttonQues);
        buttonA = findViewById(R.id.buttonA);
        buttonB = findViewById(R.id.buttonB);
        buttonC = findViewById(R.id.buttonC);
        buttonD = findViewById(R.id.buttonD);

        // Initialize ProgressBar
        progressBar = findViewById(R.id.progressBar);

        // Set onClickListeners for the buttons
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the start button click
                buttonStart.setVisibility(View.INVISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
        });

        // You can add functionality for other buttons as well
        buttonScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the score button click
            }
        });

        buttonQues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle the question button click
            }
        });

        buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle answer button click (A)
            }
        });

        buttonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle answer button click (B)
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle answer button click (C)
            }
        });

        buttonD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle answer button click (D)
            }
        });
    }
}
