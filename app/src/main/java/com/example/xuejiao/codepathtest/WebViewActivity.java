package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

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
//        mWvNormal.loadUrl("http://kymjs.com/code/2015/05/03/01/");
        mWvNormal.loadUrl("http://guides.codepath.com/android/Working-with-the-WebView");

        mWvNormal.getSettings().setJavaScriptEnabled(true);
        mWvNormal.getSettings().setSupportZoom(false);
        mWvNormal.getSettings().setBuiltInZoomControls(true);
        /*
          如果页面中链接,如果希望点击链接继续在当前browser中响应,而不是新开Android的系统browser中响应该链接,必须覆盖 WebView的WebViewClient对象.
          所以如果将下面这段代码去掉，则页面中有链接，点击就会到浏览器打开
       */
        mWvNormal.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                //指定只有含有guide的时候才在当前webView中打开，否则还是启动浏览器打开
                if (url.contains("guide")) {
                    view.loadUrl(url);
                    return true;
                } else {
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                    startActivity(intent);
                    return true;
                }
//                return  super.shouldOverrideUrlLoading(view,url);
            }
        });
    }
    private  void initViews(){
        mWvNormal =(WebView)findViewById(R.id.wv_normal);
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if((keyCode == KeyEvent.KEYCODE_BACK) && mWvNormal.canGoBack()){
            mWvNormal.goBack();
            return  true;
        }
        return  super.onKeyDown(keyCode,event);
    }
}
