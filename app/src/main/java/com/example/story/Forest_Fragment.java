//我的森林的fragment代码
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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
public class Forest_Fragment extends Fragment {
    private Button dianzan,dianzan1,dianzan2,dianzan3;
    private Button dianzana,dianzanb,dianzanc,dianzand;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_forest, null);
        return view;
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ImageButton plus = (ImageButton) getActivity().findViewById(R.id.plus);
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getActivity(), ZoneActivity.class);
                startActivity(intent);
            }
        });
        dianzan = (Button)getActivity().findViewById(R.id.dianzan);
        final int[] flag = {0};
        dianzan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch( flag[0]){
                    case 0:
                        dianzan.setActivated(false);
                        flag[0] = 1;
                        break;
                    case 1:
                        dianzan.setActivated(true);
                        flag[0] = 0;
                        break;
                }
            }
        });
        dianzan1 = (Button)getActivity().findViewById(R.id.dianzan1);
        final int[] flag1 = {0};
        dianzan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch( flag1[0]){
                    case 0:
                        dianzan1.setActivated(false);
                        flag1[0] = 1;
                        break;
                    case 1:
                        dianzan1.setActivated(true);
                        flag1[0] = 0;
                        break;
                }
            }
        });
        dianzan2 = (Button)getActivity().findViewById(R.id.dianzan2);
        final int[] flag2 = {0};
        dianzan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch( flag2[0]){
                    case 0:
                        dianzan2.setActivated(false);
                        flag2[0] = 1;
                        break;
                    case 1:
                        dianzan2.setActivated(true);
                        flag2[0] = 0;
                        break;
                }
            }
        });
        dianzan3 = (Button)getActivity().findViewById(R.id.dianzan3);
        final int[] flag3 = {0};
        dianzan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch( flag3[0]){
                    case 0:
                        dianzan3.setActivated(false);
                        flag3[0] = 1;
                        break;
                    case 1:
                        dianzan3.setActivated(true);
                        flag3[0] = 0;
                        break;
                }
            }
        });
        dianzana = (Button)getActivity().findViewById(R.id.dianzana);
        dianzana.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

//        diy = (Button)getActivity().findViewById(R.id.diy);
//        diy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent;
//                intent = new Intent(getActivity(), GestureDemoView.class);
//                startActivity(intent);
//            }
//        });
    }
}

