//跳转四个fragment的代码
package com.example.story;
import androidx.appcompat.app.AppCompatActivity;
import android.app.FragmentManager;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
public class MainActivity2 extends AppCompatActivity {
    private ImageView ivmine, ivforest, ivdiy, ivscan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main2);
        ivmine = (ImageView) findViewById(R.id.mine);
        ivforest = (ImageView) findViewById(R.id.forest);
        ivdiy = (ImageView) findViewById(R.id.diy);
        ivscan = (ImageView) findViewById(R.id.scan);
        ivforest.setOnClickListener(l);
        ivdiy.setOnClickListener(l);
        ivscan.setOnClickListener(l);
        ivmine.setOnClickListener(l);

    }
    final View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            FragmentManager fm =  getFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            Fragment f = new Fragment();
            switch (view.getId()) {
                case R.id.forest:
                    f = new Forest_Fragment();
                    break;
                case R.id.diy:
                    f = new Diy_Fragment();
                    break;
                case R.id.scan:
                    f = new Scan_Fragment();
                    break;
                case R.id.mine:
                    f = new Mine_Fragment();
                    break;
                default:
                    break;
            }
            ft.replace(R.id.fragment,f);
            ft.commit();
        }
    };
}