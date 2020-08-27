package com.example.ask;

import android.os.Bundle;

import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ask.R;

@SuppressWarnings("deprecation")
public class WebActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        final String url=getIntent().getStringExtra("url");
        WebView webView=findViewById(R.id.web_view);
        webView.loadUrl(url);


    }
}