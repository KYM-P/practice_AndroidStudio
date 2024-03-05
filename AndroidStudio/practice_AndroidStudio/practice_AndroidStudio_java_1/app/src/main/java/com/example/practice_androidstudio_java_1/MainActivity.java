package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText edt_1;
    Button btn_1;
    ImageView img_1;
    Button Second_View;
    String save = "file1";

    @Override
    // 이 activitiy 생성시
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //* EditText
        edt_1 = (EditText)findViewById(R.id.edt_1);

        //* Button
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_1.setText("Edit!");
            }
        });

        //* ImageView

        img_1 = (ImageView)findViewById(R.id.img_1);
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Image" , Toast.LENGTH_SHORT).show();
            }
        });

        //* intent(화면전환)
        Second_View = (Button)findViewById(R.id.Second_View);
        Second_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                intent.putExtra("edt", edt_1.getText().toString());
                startActivity(intent);
            }
        });

        //* ListView
        ListView list_v_1;
        list_v_1 = (ListView)findViewById(R.id.list_v_1);
        // List
        List<String> data = new ArrayList<>();
        // ArrayAdapter ( Array 와 ListView 의 연결 )
        ArrayAdapter<String> data_link = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        list_v_1.setAdapter(data_link);

        data.add("Hi");
        data.add("Hello");
        data_link.notifyDataSetChanged(); // 데이터 변화 감지 후 적용

        // SharedPreference
        SharedPreferences shar_p = getSharedPreferences(save, 0);
        String value = shar_p.getString("key_1", "");
        edt_1.setText(value);

    }
    @Override
    // 이 activitiy를 나갔을 때 (intent는 안됨)
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences shar_p = getSharedPreferences(save, 0);
        SharedPreferences.Editor editor = shar_p.edit();
        String value = edt_1.getText().toString();
        editor.putString("key_1", value); // key 값과 value 값으로 editor에 기록
        editor.commit(); // editor 저장

    }
}