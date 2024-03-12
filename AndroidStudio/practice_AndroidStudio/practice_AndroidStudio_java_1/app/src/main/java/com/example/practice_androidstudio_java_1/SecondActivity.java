package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class SecondActivity extends AppCompatActivity {
    Button First_View;
    WebView web_v;
    String url;

    private static final int REQUEST_IMAGE_CAPTURE = 672;
    private  String imageFilePath;
    private Uri photoUri;

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


        // WebView
        /*
        AndroidMainfest.xml 에 아래 두 요소 추가시 사용가능
        <uses-permission android:name="android.permission.INTERNET"/>
        <application
            android:usesCleartextTraffic="true"
            />
         */
        url = "https://www.naver.com/";
        web_v = (WebView)findViewById(R.id.web_v);
        web_v.getSettings().setJavaScriptEnabled(true);
        web_v.loadUrl(url);
        web_v.setWebChromeClient(new WebChromeClient());
        web_v.setWebViewClient(new WebViewClientClass());

        // Camera
        Button btn_camera = (Button)findViewById(R.id.btn_camera);
        btn_camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager()) != null) {
                    File photoFile = null;
                    try {
                        photoFile = createImageFile();
                    }catch (IOException e){

                    }

                    if(photoFile != null) {
                        photoUri = FileProvider.getUriForFile(getApplicationContext(), getPackageName(), photoFile);
                        intent.putExtra(MediaStore.EXTRA_OUTPUT, photoUri);
                        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

                    }
                }
            }
        });
    }

    private File createImageFile() throws IOException {
        String timeStamp = new SimpleDateFormat("yyyMMdd_HHmmss").format(new Date());
        String imageFileName = "TEST_" + timeStamp + "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File image = File.createTempFile(imageFileName, ".jpg", storageDir);
        imageFilePath = image.getAbsolutePath();
        return image;
    }

    // WebView
    @Override
    // 지정된 Key를 입력했을 때
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && web_v.canGoBack()){
            web_v.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    private class WebViewClientClass extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}