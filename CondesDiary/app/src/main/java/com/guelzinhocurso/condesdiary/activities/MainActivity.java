package com.guelzinhocurso.condesdiary.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.guelzinhocurso.condesdiary.R;

public class MainActivity extends AppCompatActivity {

    private ImageButton newButton, allButton, creditsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        newButton = findViewById(R.id.newButton);
        allButton = findViewById(R.id.allButton);
        creditsButton = findViewById(R.id.creditsButton);

        newButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openNewnote = new Intent(MainActivity.this, NewNoteActivity.class);
                startActivity(openNewnote);
            }
        });

        allButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openAllNote = new Intent(MainActivity.this, AllNoteActivity.class);
                startActivity(openAllNote);
            }
        });

        creditsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openCredits = new Intent(MainActivity.this, CreditsActivity.class);
                startActivity(openCredits);
            }
        });


    }
}