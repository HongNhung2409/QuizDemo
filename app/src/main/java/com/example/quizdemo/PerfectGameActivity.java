package com.example.quizdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PerfectGameActivity extends AppCompatActivity {

    private LinearLayout layoutLoad;
    private ProgressBar progressBar;
    private Button buttonStart;
    private Button button, button1, button2, button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfect_game);

        // Initialize UI components
        layoutLoad = findViewById(R.id.layoutLoad);
        progressBar = findViewById(R.id.progressBar);
        buttonStart = findViewById(R.id.buttonStart);
        button = findViewById(R.id.button);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        // Set up buttonStart behavior
        buttonStart.setVisibility(View.VISIBLE);
        buttonStart.setOnClickListener(v -> {
            layoutLoad.setVisibility(View.GONE);
            button.setVisibility(View.VISIBLE);
            button1.setVisibility(View.VISIBLE);
            button2.setVisibility(View.VISIBLE);
            button3.setVisibility(View.VISIBLE);
        });

        // Set up individual buttons
        setupButtonActions();
    }

    private void setupButtonActions() {
        button.setOnClickListener(v -> handleButtonClick("Button 1 clicked"));
        button1.setOnClickListener(v -> handleButtonClick("Button 2 clicked"));
        button2.setOnClickListener(v -> handleButtonClick("Button 3 clicked"));
        button3.setOnClickListener(v -> handleButtonClick("Button 4 clicked"));
    }

    private void handleButtonClick(String message) {
        // Handle button click, e.g., show a Toast or perform an action
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
