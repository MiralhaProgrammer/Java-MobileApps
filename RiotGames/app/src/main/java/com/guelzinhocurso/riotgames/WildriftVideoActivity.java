package com.guelzinhocurso.riotgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class WildriftVideoActivity extends AppCompatActivity {
    VideoView videoView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wildrift_video);
        videoView4 = findViewById(R.id.videoView4);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        getSupportActionBar().hide();

        videoView4.setMediaController(new MediaController(this));
        videoView4.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.wildrifttrailer);

        videoView4.start();
    }
}