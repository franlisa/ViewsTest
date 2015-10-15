package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by xuejiao on 15/10/15.
 */
public class HorizonScrollViewActivity extends Activity {
    private LinearLayout mLlScrollView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horizon_scrollview_layout);
        initViews();
        for(int i=0;i<8;i++){
            ImageView imageView = new ImageView(this);
            LinearLayout.LayoutParams  layoutParams= new LinearLayout.LayoutParams(200,200);
//            layoutParams.setMargins(2,2,2,2);
            imageView.setLayoutParams(layoutParams);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setImageDrawable(getResources().getDrawable(R.mipmap.ic_launcher));
            imageView.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_solid_color));

//
            mLlScrollView.addView(imageView);



        }
    }
    private void initViews(){
        mLlScrollView =(LinearLayout) findViewById(R.id.ll_horizon_scrollview);

    }

}
