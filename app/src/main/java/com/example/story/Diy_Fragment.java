//DIY的fragm代码
package com.example.story;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.app.Fragment;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class Diy_Fragment extends Fragment {
    Button btn1, btn2, btn3, btn4;
    float lastRawX, lastRawY;//用于记录按钮上一次状态坐标

    @Nullable
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_diy, null);
        return view;
    }

    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        /*
        btn1 = (Button) getActivity().findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), diy1.class);
                startActivity(intent);
            }
        });
        btn2 = (Button) getActivity().findViewById(R.id.btn2);
        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), diy2.class);
                startActivity(intent);
            }
        });
        btn3 = (Button) getActivity().findViewById(R.id.btn3);
        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), diy3.class);
                startActivity(intent);
            }
        });
        btn4 = (Button) getActivity().findViewById(R.id.btn4);
        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), diy4.class);
                startActivity(intent);
            }
        });*/
        btn1 = (Button) getActivity().findViewById(R.id.btn1);
        btn1.setOnTouchListener(new MyOnTouchListener());
        btn2 = (Button) getActivity().findViewById(R.id.btn2);
        btn2.setOnTouchListener(new MyOnTouchListener());
        btn3 = (Button) getActivity().findViewById(R.id.btn3);
        btn3.setOnTouchListener(new MyOnTouchListener());
        btn4 = (Button) getActivity().findViewById(R.id.btn4);
        btn4.setOnTouchListener(new MyOnTouchListener());
    }

    class MyOnTouchListener implements View.OnTouchListener {

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    lastRawX = event.getRawX();
                    lastRawY = event.getRawY();
                    v.bringToFront();
                    break;
                case MotionEvent.ACTION_MOVE:
                    int dx = (int) (event.getRawX() - lastRawX);//相对坐标
                    int dy = (int) (event.getRawY() - lastRawY);//相对坐标
                    setRelativeViewLocation(v, v.getLeft() + dx, v.getTop() + dy, v.getRight() + dx, v.getBottom() + dy);//设置按钮位置
                    lastRawX = event.getRawX();
                    lastRawY = event.getRawY();
                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    break;
            }
            return false;
        }
    }


//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.fragment_diy);
//        btn1 = (Button) getActivity().findViewById(R.id.btn1);
//        btn1.setOnTouchListener((View.OnTouchListener) this);
//        btn2 = (Button) getActivity().findViewById(R.id.btn2);
//        btn2.setOnTouchListener((View.OnTouchListener) this);
//        btn3 = (Button) getActivity().findViewById(R.id.btn3);
//        btn3.setOnTouchListener((View.OnTouchListener) this);
//        btn4 = (Button) getActivity().findViewById(R.id.btn4);
//        btn4.setOnTouchListener((View.OnTouchListener) this);
//    }
//
//    private void setContentView(int fragment_diy) {
//    }
//
//
//    public boolean onTouch(View v, MotionEvent event) {
//        switch (v.getId()) {
//            case R.id.btn2:
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
//            default:
//
//                break;
//        }
//
//
//        return false;//一般这个保留false,若为true,此控件其他事件会被截断
//    }
//
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

