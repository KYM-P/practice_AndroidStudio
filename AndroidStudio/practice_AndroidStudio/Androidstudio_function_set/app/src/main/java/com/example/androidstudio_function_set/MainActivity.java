package com.example.androidstudio_function_set;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static Toast t;

    static TextView tv;

    static Button go_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Toast */
        t = Toast.makeText(MainActivity.this, "" , Toast.LENGTH_SHORT); // Toast 생성
        t.setText("hi"); // Toast 메시지 설정
        t.setGravity(Gravity.CENTER,0,300); // Toast 메시지 위치 설정
        t.setDuration(Toast.LENGTH_LONG); // Toast 메시지 시간 설정
        t.show(); // Toast 메시지 출력

        /* TextView */
        tv = (TextView)findViewById(R.id.hello_text);
        tv.setText("Hello_World"); // TextView Text 설정
        tv.setSelected(true); // TextView Select

        /* Spannable */
        Spannable text1 = new SpannableStringBuilder(tv.getText().toString()); // Spannable 생성
        text1.setSpan(Typeface.BOLD, 0, 1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 BOLD 효과 적용
        text1.setSpan(new ForegroundColorSpan(Color.RED), 0, 1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 Color 효과 적용
        text1.setSpan(new RelativeSizeSpan(3.0f), 0 ,1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 크기 2배 효과 적용
        tv.setText(text1); // 해당 Spannable 정보를 tv 에 적용


        go_btn = (Button)findViewById(R.id.go_btn);
        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class c = Imageview_sample.class;
                Intent i = new Intent(MainActivity.this, c);
                startActivity(i);
            }
        });
    }

}