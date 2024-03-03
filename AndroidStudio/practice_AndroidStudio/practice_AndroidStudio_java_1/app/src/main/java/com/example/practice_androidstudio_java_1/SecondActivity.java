package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button First_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        // Intent(정보받기)
        Intent priv = getIntent();
        Toast.makeText(this,priv.getStringExtra("edt"), Toast.LENGTH_LONG).show();
        // Intent(화면전환)
        First_View = (Button)findViewById(R.id.First_View);
        First_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}