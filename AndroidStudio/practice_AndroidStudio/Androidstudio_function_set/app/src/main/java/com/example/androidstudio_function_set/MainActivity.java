package com.example.androidstudio_function_set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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

import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {
    // Toast , TextView , Spannable , SharedPreferences 서술
    static Toast t;

    static TextView tv;

    static Button go_btn;

    static String shared_file = "file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        go_btn = (Button)findViewById(R.id.go_btn);
        go_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Class c = webview_sample.class;
                Intent i = new Intent(MainActivity.this, c);
                startActivity(i);
            }
        });


        /* Toast */ // 메시지 출력
        t = Toast.makeText(MainActivity.this, "" , Toast.LENGTH_SHORT); // Toast 생성
        t.setText("hi"); // Toast 메시지 설정
        t.setGravity(Gravity.CENTER,0,300); // Toast 메시지 위치 설정
        t.setDuration(Toast.LENGTH_LONG); // Toast 메시지 시간 설정
        t.show(); // Toast 메시지 출력


        /* TextView */
        tv = (TextView)findViewById(R.id.hello_text);
        tv.setText("Hello_World"); // TextView Text 설정
        tv.setSelected(true); // TextView Select


        /* Spannable */ // 텍스트 위치별 효과
        Spannable text1 = new SpannableStringBuilder(tv.getText().toString()); // Spannable 생성
        text1.setSpan(Typeface.BOLD, 0, 1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 BOLD 효과 적용
        text1.setSpan(new ForegroundColorSpan(Color.RED), 0, 1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 Color 효과 적용
        text1.setSpan(new RelativeSizeSpan(3.0f), 0 ,1,Spannable.SPAN_EXCLUSIVE_EXCLUSIVE); // index 0 부터 index 1 전의 내용에 크기 2배 효과 적용
        tv.setText(text1); // 해당 Spannable 정보를 tv 에 적용


        /* SharedPreferences */ // 앱 내부 데이터를 file로 저장, 불러오기
        SharedPreferences sp_s = getSharedPreferences(shared_file, 0);
        // getSharedPrefrences(파일명, mode) mode: 0 Private(앱 내부만 가능), 1 World_readable(외부에서 읽기만 가능), 2 World_writeable(외부에서 읽기, 쓰기 모두 가능)
        String shared_string = sp_s.getString("key1", "not");
        // getString(key, defValue)  해당 key값의 데이터를 가져옴, 없을시 defValue 출력
    }
    protected void onDestroy() { // 앱이 종료 되었을 때
        super.onDestroy();

        /* sharedPreferences */ // 앱 내부 데이터를 file로 저장, 불러오기
        SharedPreferences sp_e = getSharedPreferences(shared_file, 0);
        SharedPreferences.Editor editor = sp_e.edit();
        editor.putString("key1", "Hi"); // editor에 key값이 key1, value값이 Hi 인 데이터 추가
        // editor.remove(key)  해당 key값을 가지는 데이터 제거
        // editor.clear() 모든 데이터 삭제
        editor.commit(); // edito에 있는 값을 연결된 객체에 저장(sp_e) = 파일에 저장
        // editor.commit() or editor.apply() 를 해주어야 저장됨
    }

}