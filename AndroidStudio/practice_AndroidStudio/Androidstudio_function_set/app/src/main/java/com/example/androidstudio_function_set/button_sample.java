package com.example.androidstudio_function_set;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class button_sample extends AppCompatActivity {

    static Button btn_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_sample);

        /* Button */
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener(){ // Button onClickListener 생성
            @Override
            public void onClick(View v) { // Button 클릭시
                Toast.makeText(button_sample.this, "Hi!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}