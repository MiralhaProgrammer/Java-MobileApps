package com.guelzinhocurso.condesdiary.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.guelzinhocurso.condesdiary.R;

public class CreditsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        getSupportActionBar().setTitle("Créditos");

    }
}