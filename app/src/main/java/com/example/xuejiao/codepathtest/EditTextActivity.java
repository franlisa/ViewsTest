package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

/**
 * Created by xuejiao on 15/10/12.
 */
public class EditTextActivity extends Activity implements TextView.OnEditorActionListener {
    private TextInputLayout mTilUserName;
    private TextView  mTvMultiLine;
    private TextView mTv01;
    private TextView mTvUserName;
    private TextView mTvInputLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edittext_layout);
        initViews();
        mTilUserName.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!checkType(s)){
                    mTilUserName.setErrorEnabled(true);
                    mTilUserName.setError("请输入小写字母");
                }else{
                    mTilUserName.setErrorEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
    private  void initViews(){
        mTilUserName =(TextInputLayout)findViewById(R.id.textInputLayout);
        mTv01 =(TextView)findViewById(R.id.ed_zero_one);
        mTvInputLayout =(TextView)findViewById(R.id.ed_input_layout);
        mTvUserName =(TextView)findViewById(R.id.ed_userName);
        mTvMultiLine =(TextView)findViewById(R.id.ed_multiline);
        mTv01.setOnEditorActionListener(this);
        mTvInputLayout.setOnEditorActionListener(this);
        mTvMultiLine.setOnEditorActionListener(this);
        mTvUserName.setOnEditorActionListener(this);


    }
    private boolean checkType(CharSequence s){
        for(int i=0;i<s.length();i++){
            char tempChar=s.charAt(i);
            if(tempChar < 'a' || tempChar > 'z'){
                return false;
            }
        }
        return  true;


    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        switch (actionId){
            case  EditorInfo.IME_NULL:
                Log.e("fxj",v.getHint()+",null");
                break;
            case EditorInfo.IME_ACTION_DONE:
                Log.e("fxj",v.getHint()+",done");
                break;
            case EditorInfo.IME_ACTION_NEXT:
                Log.e("fxj",v.getHint()+",next");
                break;
            default:
                Log.e("fxj",v.getHint()+",default");
                break;

        }
        return false;
    }
}
