package com.example.story;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class ZoneActivity extends AppCompatActivity {
    //    huang
    //   ------ begin------
    private TextView tvFbImg;

    private  void initView()
    {
        tvFbImg = findViewById(R.id.fbImg);
    }

    //    ------ end------
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zone);
        Button send = (Button)findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ZoneActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
        //    huang
        //   ------ begin------
        initView();
        tvFbImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //读取图片并返回图片路径

            }
        });

        //    ------ end------
    }
}



