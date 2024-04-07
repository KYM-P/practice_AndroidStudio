package com.example.androidstudio_function_set;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class nevigationmenu_sample extends AppCompatActivity {

    DrawerLayout drawerLayout;
    View menu_view;
    Button open_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nevigationmenu_sample);

        /* Nevigation menu */
        drawerLayout = (DrawerLayout)findViewById(R.id.nevi_sample_main_layout); // nevigation menu 가 나올 layout
        menu_view = (View)findViewById(R.id.nevi_sample_menu_layout); // 보여줄 nevigation menu
        open_btn = (Button)findViewById(R.id.nevi_smaple_btn_open);
        open_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {   // 버튼을 누를 때
                drawerLayout.openDrawer(menu_view);     // nevigation menu 를 연다
                // dewerLayout.closeDrawers(); 현재 모든 drawer 들을 닫음
            }
        });
        drawerLayout.addDrawerListener(listener);   // DrawerListener 설정
        menu_view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
    }
    DrawerLayout.DrawerListener listener = new DrawerLayout.DrawerListener() {
        @Override
        public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {     // slide 시

        }

        @Override
        public void onDrawerOpened(@NonNull View drawerView) {  // 열렸을 때

        }

        @Override
        public void onDrawerClosed(@NonNull View drawerView) {  // 닫혔을 때

        }

        @Override
        public void onDrawerStateChanged(int newState) {    // 변화되었을 때

        }
    };

}