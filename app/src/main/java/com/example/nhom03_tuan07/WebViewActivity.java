package com.example.nhom03_tuan07;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.URLUtil;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
        webView.setWebViewClient(webViewClient);
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);

        if (URLUtil.isValidUrl(link)) {
            webView.loadUrl(link);
        } else {
            // Chuyển đến trang lỗi 404 hoặc hiển thị thông báo lỗi
            webView.loadUrl("file:///android_asset/404.html"); // Giả sử bạn có trang 404 trong assets
        }
    }
    WebViewClient webViewClient = new WebViewClient() {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // Không cho phép mở URL bằng trình duyệt mặc định
            view.loadUrl(url);
            return true; // WebView xử lý URL
        }
    };

}