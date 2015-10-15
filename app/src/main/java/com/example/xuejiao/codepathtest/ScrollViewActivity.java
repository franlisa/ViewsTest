package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by xuejiao on 15/10/15.
 */
public class ScrollViewActivity extends Activity {
    private Button mBtnHorizon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scrollview_layout);
        initViews();
        mBtnHorizon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollViewActivity.this,HorizonScrollViewActivity.class);
                startActivity(intent);
            }
        });
    }
    private void  initViews(){
        mBtnHorizon =(Button)findViewById(R.id.btn_horizon);
    }
}
