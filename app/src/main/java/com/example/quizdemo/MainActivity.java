package com.example.quizdemo;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class    MainActivity extends AppCompatActivity {

    Button buttonPLib,buttonGame,buttonGoogle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonPLib= findViewById(R.id.btnLib);
        buttonPLib.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sacle));
        buttonGame= findViewById(R.id.btnGame);
        buttonGame.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sacle));
        buttonGoogle= findViewById(R.id.btnGoogle);
        buttonGoogle.setAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.sacle));
        buttonGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });
        buttonPLib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,FolderActivity.class);
                startActivity(intent);
            }
        });
        buttonGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,TranslateActivity.class);
                startActivity(intent);
            }
        });
    }
}