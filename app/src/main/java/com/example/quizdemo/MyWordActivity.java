package com.example.quizdemo;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MyWordActivity extends AppCompatActivity {

    private TextView textViewWord;
    private WebView webViewAll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_word);

        textViewWord = findViewById(R.id.textViewWord);
        webViewAll = findViewById(R.id.webViewAll);




}

}
