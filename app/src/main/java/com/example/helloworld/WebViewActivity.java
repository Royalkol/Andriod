package com.example.helloworld;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.helloworld.R;

public class WebViewActivity extends AppCompatActivity {

    private WebView mWvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        mWvmain = findViewById(R.id.wv);
//        mWvmain.loadUrl("file:///android_asset/test.html");
        mWvmain.getSettings().setJavaScriptEnabled(true);
        mWvmain.setWebViewClient(new MyWebViewClient());
//        mWvmain.addJavascriptInterface();
        mWvmain.setWebChromeClient(new MyWebChromedClient() );
        mWvmain.loadUrl("https://m.baidu.com");
    }

    class MyWebViewClient extends WebViewClient {
        @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            view.loadUrl(request.getUrl().toString());
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            Log.d("webview", "onPageStarted");

        }

        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            Log.d("webview", "onPageFinished");
            mWvmain.evaluateJavascript("javascript:alert('hello')",null);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWvmain.canGoBack()) {
            mWvmain.goBack();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    class MyWebChromedClient extends WebChromeClient{

        @Override
        public void onProgressChanged(WebView view, int newProgress) {
            super.onProgressChanged(view, newProgress);
        }

        @Override
        public void onReceivedTitle(WebView view, String title) {
            super.onReceivedTitle(view, title);
            setTitle(title);
        }
    }
}