package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by xuejiao on 15/10/15.
 */
public class WebViewActivity extends Activity {
    private WebView mWvNormal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        initViews();
        mWvNormal.loadUrl("http://kymjs.com/code/2015/05/03/01/");

        mWvNormal.getSettings().setJavaScriptEnabled(true);
        mWvNormal.getSettings().setSupportZoom(false);
        mWvNormal.getSettings().setBuiltInZoomControls(true);

    }
    private  void initViews(){
        mWvNormal =(WebView)findViewById(R.id.wv_normal);
    }
}
