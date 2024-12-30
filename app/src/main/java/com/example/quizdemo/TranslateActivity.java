package com.example.quizdemo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TranslateActivity extends AppCompatActivity {

    private TextView buttonLang1, buttonLang2, textViewAdd, textViewHistory;
    private Button swapButton;
    private SearchView searchView;
    private ListView listViewHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_translate); // Replace with your actual layout name if different

        // Initialize Toolbar
        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Initialize Views
        buttonLang1 = findViewById(R.id.buttonLang1);
        buttonLang2 = findViewById(R.id.buttonLang2);
        swapButton = findViewById(R.id.buttonSwap);
        textViewAdd = findViewById(R.id.textViewAdd);
        textViewHistory = findViewById(R.id.textView);
        searchView = findViewById(R.id.searchView);
        listViewHistory = findViewById(R.id.listViewHistory);

        // Set initial text for language buttons
        buttonLang1.setText("English");
        buttonLang2.setText("Vietnamese");
        
        // Set onClickListener for the Swap Button
        swapButton.setOnClickListener(view -> {
            String temp = buttonLang1.getText().toString();
            buttonLang1.setText(buttonLang2.getText().toString());
            buttonLang2.setText(temp);
            Toast.makeText(TranslateActivity.this, "Languages swapped", Toast.LENGTH_SHORT).show();
        });

        // Set SearchView listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                // Perform translation or search action
                Toast.makeText(TranslateActivity.this, "Searching for: " + query, Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                // Handle text changes if needed
                return false;
            }
        });

        // Set ListView (for demo purposes, use static data)
        String[] historyData = {"word1 - nghĩa1", "word2 - nghĩa2", "word3 - nghĩa3"};
        android.widget.ArrayAdapter<String> adapter = new android.widget.ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                historyData
        );
        listViewHistory.setAdapter(adapter);

        // Handle "Add to Library" visibility toggle (for demo purposes)
        textViewAdd.setVisibility(View.GONE);
    }
}
