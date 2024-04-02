package com.example.androidstudio_function_set;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class webview_sample extends AppCompatActivity {

    WebView webv_sample_1;
    String url = "https://www.naver.com";
    // ERR_CLEARTEXT_NOT_PERMITTED 오류 발생시 Manifest 에 application 항목에 android:usesCleartextTraffic="true" 추가
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview_sample);

        /* WebView */ // Manifest에 <uses-permission android:name="android.permission.INTERNET"/> 선언 필요
        webv_sample_1 = (WebView)findViewById(R.id.webv_sample_1);
        webv_sample_1.getSettings().setJavaScriptEnabled(true); // javascript 허용
        webv_sample_1.loadUrl(url); // url 설정
        webv_sample_1.setWebChromeClient(new WebChromeClient()); // ChromeClient 설정
        webv_sample_1.setWebViewClient(new WebViewClientClass()); // WebViewClient 설정


    }
    @Override
    public boolean onKeyDown (int KeyCode, KeyEvent event) {
        if ((KeyCode == KeyEvent.KEYCODE_BACK)&&(webv_sample_1.canGoBack())) {
            webv_sample_1.goBack();
        }

        return super.onKeyDown(KeyCode, event);
    }

    // WebViewClient * webview 에서의 여러 상황에 대한 콜백을 조작 가능
    private class WebViewClientClass extends WebViewClient { // WebViewClinet 기반 재정의
        @Override // PageLoading 시작시
        public void onPageStarted(WebView view, String url, Bitmap favicon) {super.onPageStarted(view, url, favicon);}

        @Override // PageLoading 종료시
        public void onPageFinished(WebView view, String url) {super.onPageFinished(view, url);}

        @Override // url 에 의해 특정 resource 를 load 시
        public void onLoadResource(WebView view, String url) {super.onLoadResource(view, url);}

        @Override // request 에 대해 애러가 발생 했을때
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {super.onReceivedError(view, request, error);}

        @Nullable
        @Override // resource request 를 응답 하기 전에 실행
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {return super.shouldInterceptRequest(view, request);}

        @Override // WebView 에 load 되는 중에 조작 (true 반환시 url 로드 중단, false 는 계속 진행)
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            // request.getUrl() : request 를 요구한 Url 반환
            return false;
        }

    }
}