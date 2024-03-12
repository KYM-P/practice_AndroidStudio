package com.example.practice_androidstudio_java_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer_l;
    View drawer_v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        drawer_l = (DrawerLayout)findViewById(R.id.drawer_l);
        drawer_v = (View)findViewById(R.id.drawer_v);

        // drawer open
        Button btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                drawer_l.openDrawer(drawer_v);
            }
        });
        // drawer setting
        drawer_l.setDrawerListener(listner);
        // drawer close
        Button btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawer_l.closeDrawers();
            }
        });
        drawer_v.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });

    }

    // drawer
    DrawerLayout.DrawerListener listner = new DrawerLayout.DrawerListener() {
        @Override
        // slide 시
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

        }

        @Override
        // 열렸을 때
        public void onDrawerOpened(@NonNull View drawerView) {

        }

        @Override
        // 닫혔을 때
        public void onDrawerClosed(@NonNull View drawerView) {

        }

        @Override
        // 상태가 변화했을 때
        public void onDrawerStateChanged(int newState) {

        }
    };
}