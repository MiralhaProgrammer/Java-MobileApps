
package com.guelzinhocurso.riotgames;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class LorVideoActivity extends AppCompatActivity {
    VideoView videoView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lor_video);

        videoView3 = findViewById(R.id.videoView3);


        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        getSupportActionBar().hide();

        videoView3.setMediaController(new MediaController(this));
        videoView3.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.lorvideo);

        videoView3.start();
    }
}