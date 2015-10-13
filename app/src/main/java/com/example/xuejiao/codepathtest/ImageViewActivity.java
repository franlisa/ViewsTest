package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

/**
 * Created by xuejiao on 15/10/13.
 */
public class ImageViewActivity extends Activity {
    private ImageView mIvFixXy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.imageview_layout);
        initViews();
        /*
         setImageResource does Bitmap reading and decoding on the UI thread, which can cause a latency hiccup.
         */
//        mIvFixXy.setImageResource(R.mipmap.contact);
        mIvFixXy.setImageDrawable(getResources().getDrawable(R.mipmap.contact));

    }
    private  void initViews(){
        mIvFixXy = (ImageView)findViewById(R.id.iv_fitXy);

    }
}
