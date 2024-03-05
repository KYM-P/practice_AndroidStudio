package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class activity_side extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side);

        //* ListView
        ListView list_v_2;
        list_v_2 = (ListView)findViewById(R.id.list_v_2);
        // List
        List<String> data_1 = new ArrayList<>();
        // ArrayAdapter ( Array 와 ListView 의 연결 )
        ArrayAdapter<String> data_link = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data_1);
        list_v_2.setAdapter(data_link);

        data_1.add("1");
        data_1.add("2");
        data_1.add("3");
        data_link.notifyDataSetChanged(); // 데이터 변화 감지 후 적용
    }
}