package com.development.hellowolrd;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class WebViewDemo extends AppCompatActivity {
    EditText edt_query;
    Button btn_search;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view_demo);

        edt_query = findViewById(R.id.edt_url);
        btn_search = findViewById(R.id.btn_search);
        webView = findViewById(R.id.webview);
    }

    public void searchWeb(View view){
        webView.getSettings().setJavaScriptEnabled(true);
        String srch = edt_query.getText().toString();
        String fin = "";
        String[] arr = srch.split(" ");
        for(String word : arr){
            fin = fin + word + "+";
        }
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("https://www.google.com/search?q=" + fin);
    }

    @Override
    public void onBackPressed() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Exit Application");
        builder.setMessage("Do you really want to exit?");
        builder.setPositiveButton("Yes!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                WebViewDemo.super.onBackPressed();
            }
        });

        builder.setNegativeButton("No!!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }
}