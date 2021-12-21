package com.example.myqrcodescanner;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    private WebView resultWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        resultWebView = findViewById(R.id.resultWebView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String linkResult = extras.getString("link");
            displayPage(linkResult);
        }
    }

    private void displayPage(String linkResult){
        resultWebView.setWebViewClient(new MyWebViewClient());
        resultWebView
                .getSettings()
                .setJavaScriptEnabled(true);

        resultWebView.loadUrl(linkResult);
    }

    public class MyWebViewClient extends WebViewClient{
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && resultWebView.canGoBack()) {
            resultWebView.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}