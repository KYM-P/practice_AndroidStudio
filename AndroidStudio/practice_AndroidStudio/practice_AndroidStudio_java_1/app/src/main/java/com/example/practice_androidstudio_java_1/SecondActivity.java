package com.example.practice_androidstudio_java_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    Button First_View;
    WebView web_v;
    String url;

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