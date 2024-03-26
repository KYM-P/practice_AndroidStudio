package com.example.androidstudio_function_set;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class listview_sample extends AppCompatActivity {

    ListView listv_sample_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_sample);

        /* List */
        List<String> list_1 = new ArrayList<String>();
        list_1.add("test4");

        /* ArrayAdapter */
        ArrayAdapter<String> ad = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_1);
        /* ArrayAdapter<String>(접근할 Activity(context 아래의 객체), list 표현 양식, list 값);
         * 현재 list 의 값을 Adapter에 저장 후 View 생성
         */

        /* ListView */
        listv_sample_1 = (ListView)findViewById(R.id.listv_sample_1);
        listv_sample_1.setAdapter(ad); // ListView 의 어뎁터 설정 (list와의 연동)

        list_1.add("test1");
        list_1.add("test2");
        list_1.add("test3");
        ad.notifyDataSetChanged(); // list_1의 변화를 Adapter에 반영 (반영하지 않으면 변경사항 출력X)

        listv_sample_1.setOnItemClickListener(new AdapterView.OnItemClickListener() { // 특정 position 의 item 을 눌렀을 때
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) { // position : 누른 값의 위치, id : position 과 기본적으로 같은 값을 가지고 있다.
                Toast.makeText(listview_sample.this,"" + position,Toast.LENGTH_SHORT).show();
            }
        });
    }
}