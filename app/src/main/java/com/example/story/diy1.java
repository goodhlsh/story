package com.example.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.RelativeLayout;

public class diy1 extends AppCompatActivity implements View.OnTouchListener{
    Button btn1;//第一个按钮
    float lastRawX, lastRawY;//用于记录按钮上一次状态坐标
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diy1);
        btn1 = (Button) findViewById(R.id.button_1);
        btn1.setOnTouchListener(this);
//        btn2 = (Button) findViewById(R.id.button_2);
//        btn2.setOnTouchListener(this);
    }


    public boolean onTouch(View v, MotionEvent event) {
        switch (v.getId()) {
            case R.id.button_1:
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        lastRawX = event.getRawX();
                        lastRawY = event.getRawY();
                        btn1.bringToFront();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) (event.getRawX() - lastRawX);//相对坐标
                        int dy = (int) (event.getRawY() - lastRawY);//相对坐标
                        setRelativeViewLocation(btn1, btn1.getLeft() + dx, btn1.getTop() + dy, btn1.getRight() + dx, btn1.getBottom() + dy);//设置按钮位置
                        lastRawX = event.getRawX();
                        lastRawY = event.getRawY();
                        break;
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_CANCEL:

                        break;
                }
                break;
//            case R.id.button_2:
//                switch (event.getAction()) {
//                    case MotionEvent.ACTION_DOWN:
//                        v.bringToFront();
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int lastX = (int) (v.getLeft() + event.getX());//现在的相对Parent触摸坐标点
//                        int lastY = (int) (v.getTop() + event.getY());//现在的相对Parent触摸坐标点
//                        int width = v.getWidth();
//                        int height = v.getHeight();
//                        setRelativeViewLocation(v, lastX - width / 2, lastY - height / 2, lastX + width / 2, lastY + height / 2);
//
//                        break;
//                    case MotionEvent.ACTION_UP:
//                    case MotionEvent.ACTION_CANCEL:
//
//                        break;
//                }
//                break;
            default:

                break;
        }


        return false;//一般这个保留false,若为true,此控件其他事件会被截断
    }

    private void setRelativeViewLocation(View view, int left, int top, int right, int bottom) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(right - left, bottom - top);
        params.addRule(RelativeLayout.ALIGN_PARENT_LEFT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, RelativeLayout.TRUE);
        params.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM, RelativeLayout.TRUE);
        ViewParent parent = view.getParent();
        View p = (View) parent;
        int marginRight = p.getWidth() - right;
        int marginBottom = p.getHeight() - bottom;
        params.setMargins(left, top, marginRight, marginBottom);
        view.setLayoutParams(params);
    }
}