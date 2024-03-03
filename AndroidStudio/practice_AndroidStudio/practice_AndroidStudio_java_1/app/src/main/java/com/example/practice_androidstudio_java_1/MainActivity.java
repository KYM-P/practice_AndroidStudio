package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edt_1;
    Button btn_1;
    ImageView img_1;
    Button Second_View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // EditText
        edt_1 = (EditText)findViewById(R.id.edt_1);

        // Button
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edt_1.setText("Edit!");
            }
        });

        // ImageView

        img_1 = (ImageView)findViewById(R.id.img_1);
        img_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext() , "Image" , Toast.LENGTH_SHORT).show();
            }
        });

        // intent(화면전환)
        Second_View = (Button)findViewById(R.id.Second_View);
        Second_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , SecondActivity.class);
                intent.putExtra("edt", edt_1.getText().toString());
                startActivity(intent);
            }
        });
    }
}