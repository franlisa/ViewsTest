package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by xuejiao on 15/10/12.
 */
public class EditTextActivity extends Activity {
    private TextInputLayout mTilUserName;
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
}
