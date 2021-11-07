package com.example.story;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;
public class imgActivity extends AppCompatActivity {
//    private int[] arrayPicture = new int[]{R.drawable.ai_08,R.drawable.ai_09,R.drawable.ai_10,
//            R.drawable.ai_11,R.drawable.ai_12,R.drawable.ai_13,R.drawable.ai_14,
//            R.drawable.ai_15,R.drawable.ai_16,R.drawable.ai_17,R.drawable.ai_18,
//            R.drawable.ai_19,R.drawable.ai_20,R.drawable.ai_21,R.drawable.ai_22};
    private int[] arrayPicture = new int[]{R.drawable.bs,R.drawable.cp,R.drawable.cb,
            R.drawable.dg,R.drawable.dxc,R.drawable.fl,R.drawable.hq,
            R.drawable.jyh,R.drawable.lz,R.drawable.lr,R.drawable.pp,
            R.drawable.pgy,R.drawable.rs,R.drawable.sz,R.drawable.wlx,R.drawable.xhc};
    private ImageSwitcher imageSwitcher;
    private int index;
    private float touchDownX;
    private float touchUpX;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        imageSwitcher = (ImageSwitcher)findViewById(R.id.imageswitcher);
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(imgActivity.this);
                imageView.setImageResource(arrayPicture[index]);
                return imageView;
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    touchDownX=event.getX();
                    return true;
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    touchUpX = event.getX();
                    if (touchUpX-touchDownX>100){
                        index = index==0?arrayPicture.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(imgActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(imgActivity.this,R.anim.slide_out_right));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }else if (touchDownX-touchUpX>100){
                        index = index==arrayPicture.length?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(imgActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(imgActivity.this,R.anim.slide_out_left));
                        imageSwitcher.setImageResource(arrayPicture[index]);
                    }
                    return true;
                }
                return false;
            }
        });
    }
}

