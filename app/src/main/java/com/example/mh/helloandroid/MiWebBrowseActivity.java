package com.example.mh.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MiWebBrowseActivity extends AppCompatActivity {

    private WebView wv;
    private EditText etURL;
    private Button btnGo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_web_browse);

        wv = (WebView) findViewById(R.id.wv_miWebView);
        wv.loadUrl("http://www.baidu.com");

        etURL = (EditText) findViewById(R.id.etURL);
        btnGo = (Button) findViewById(R.id.btnGoBrowse);

        wv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //return super.shouldOverrideUrlLoading(view, url);

                view.loadUrl(url);
                return true;
            }
        });

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = etURL.getText().toString();
                Log.i("web url", "URL = " + url);

                wv.loadUrl("http://www.baidu.com");
                //wv.reload();
            }
        });
    }
}
