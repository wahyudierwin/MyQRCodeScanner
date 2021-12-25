package com.example.myqrcodescanner;

import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    private WebView resultWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        resultWebView = findViewById(R.id.resultWebView);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String link = extras.getString("link");
            displayPage(link);
        }
    }

    private void displayPage(String link){
        resultWebView.setWebViewClient(new MyWebViewClient());
        resultWebView
                .getSettings()
                .setJavaScriptEnabled(true);

        resultWebView.loadUrl(link);
    }

    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
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