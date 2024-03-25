package com.example.androidstudio_function_set;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Imageview_sample extends AppCompatActivity {
    ImageView imv_sample_1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageview_sample);
        /* ImageView */
        imv_sample_1 = (ImageView)findViewById(R.id.imv_sample_1);
        imv_sample_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { // imageview 클릭시
                imv_sample_1.setImageDrawable(getDrawable(R.drawable.ic_launcher_background)); // image 교체
                // 위의 구문은 imv_sample_1.setImageResource(R.drawable.ic_launcher_background); 와 동일
            }
        });
    }
}