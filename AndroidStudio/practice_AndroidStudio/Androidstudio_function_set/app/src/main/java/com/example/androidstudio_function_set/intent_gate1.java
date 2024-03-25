package com.example.androidstudio_function_set;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class intent_gate1 extends AppCompatActivity {

    Button next_btn;
    EditText ed_gate1_1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_gate1);

        next_btn = (Button)findViewById(R.id.next_btn);
        ed_gate1_1 = (EditText)findViewById(R.id.et_gat1_1);
        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Intent : Activity 이동 */
                Intent i_next = new Intent(intent_gate1.this, intent_gate2.class); // Intent(출발Activity, 도착Activity)
                i_next.putExtra("Key",ed_gate1_1.getText().toString());
                startActivity(i_next); // Activity 이동

            }
        });
    }
}