package com.example.nhom03_tuan07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView = findViewById(R.id.web_view);

        // Lấy link được truyền từ WatchActivity
        String link = getIntent().getStringExtra("link");
        // Tải và hiển thị trang web
        webView.loadUrl(link);
        // Bật JavaScript nếu cần
        webView.getSettings().setJavaScriptEnabled(true);
    }
}