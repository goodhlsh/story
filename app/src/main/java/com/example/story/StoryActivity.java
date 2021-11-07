package com.example.story;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;



public class StoryActivity extends AppCompatActivity {
    static boolean isPlay = true;
    MediaPlayer mediaPlayer;
    ImageButton run, run1;

    //huang
    //-----begin----
    boolean flag = true;
    boolean btnFlag = true;
    //-----------end-----
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        run = (ImageButton) findViewById(R.id.run);
        run1 = (ImageButton) findViewById(R.id.run1);
        //huang
        //-----begin----
        run.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (flag) {
                        mediaPlayer.setDataSource("/mnt/sdcard/data/Video.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        run.setImageResource(R.drawable.stop);
                        flag = false;
                    } else {
                        flag = true;
                        mediaPlayer.stop();
                        run.setImageResource(R.drawable.run);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        run1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    MediaPlayer mediaPlayer = new MediaPlayer();
                    if (btnFlag) {
                        mediaPlayer.setDataSource("/mnt/sdcard/data/Video.mp3");
                        mediaPlayer.prepare();
                        mediaPlayer.start();
                        run.setImageResource(R.drawable.stop);
                        btnFlag = false;

                    } else {
                        btnFlag = true;
                        run.setImageResource(R.drawable.run);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //-----------end------
    }
}


