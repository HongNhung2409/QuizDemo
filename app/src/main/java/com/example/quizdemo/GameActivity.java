package com.example.quizdemo;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Spinner;

public class GameActivity extends AppCompatActivity {

    private Button buttonPlay;
    private Spinner spinnerF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        createUI();
    }

    private void createUI() {
        buttonPlay = findViewById(R.id.buttonPlay);
        spinnerF = findViewById(R.id.spinnerFolder);
    }
}
