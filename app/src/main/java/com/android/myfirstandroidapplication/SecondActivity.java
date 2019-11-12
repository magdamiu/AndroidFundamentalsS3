package com.android.myfirstandroidapplication;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.webkit.WebView;

public class SecondActivity extends AppCompatActivity {

    private WebView webViewAndroid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.scrollview_example);
        setContentView(R.layout.webview_example);

        initView();
        loadUrl("https://developer.android.com/reference/android/widget/ScrollView");
    }

    private void initView() {
        webViewAndroid = findViewById(R.id.webViewAndroid);
    }

    private void loadUrl(String url) {
        webViewAndroid.getSettings().setJavaScriptEnabled(true);
        webViewAndroid.loadUrl(url);
    }
}
