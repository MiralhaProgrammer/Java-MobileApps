package com.guelzinhocurso.riotgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class ValorantVideoActivity extends AppCompatActivity {
    VideoView videoView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valorant_video);

        videoView2 = findViewById(R.id.videoView2);


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        getSupportActionBar().hide();

        videoView2.setMediaController(new MediaController(this));
        videoView2.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.valorantvideo);

        videoView2.start();
    }
}