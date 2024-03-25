package com.example.androidstudio_function_set;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class intent_gate2 extends AppCompatActivity {

    Button prev_btn;
    TextView tv_gate2_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_gate2);

        prev_btn = (Button)findViewById(R.id.prev_btn);
        tv_gate2_1 = (TextView)findViewById(R.id.tv_gate2_1);

        /* Intent 받기 */
        Intent i_data = getIntent(); // getIntent() : 넘어오기 전 intent 받기
        tv_gate2_1.setText(i_data.getStringExtra("Key"));

        prev_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i_prev = new Intent(intent_gate2.this, intent_gate1.class);
                startActivity(i_prev); // Activity 이동
            }
        });
    }
}