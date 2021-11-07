package com.example.story;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;
public class SplashActivity extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_splash);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            startMainActivity();
        }
        private void startMainActivity(){
            TimerTask delayTask = new TimerTask() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(SplashActivity.this,Geniematch.class);
                    startActivity(mainIntent);
                    SplashActivity.this.finish();
                }
            };
            Timer timer = new Timer();
            timer.schedule(delayTask,2000);//延时两秒执行 run 里面的操作
        }
}

