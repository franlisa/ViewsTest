package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.xuejiao.codepathtest.adapter.SpinnerCustomeAdapter;
import com.example.xuejiao.codepathtest.model.Person;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuejiao on 15/10/13.
 */
public class SpinnerActivity extends Activity {
    private Spinner mSpLanguage;
    private Spinner mSpLanguageUsingAdapet;
    private Spinner mSpCustom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spinner_layout);
        initViews();
        mSpLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.spinner_language);
                Toast.makeText(view.getContext(), "you click " + languages[position], Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //标准的数据绑定方式--使用adapter
        String[] items = getResources().getStringArray(R.array.spinner_language);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//不设定的话下拉就沿用构造函数的simple_spinner_item
        mSpLanguageUsingAdapet.setAdapter(adapter);
        mSpLanguageUsingAdapet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] languages = getResources().getStringArray(R.array.spinner_language);
                Toast.makeText(view.getContext(), "you click " + languages[position], Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        //自定义adapter
        List<Person> mList=new ArrayList<Person>();
        mList.add(new Person("张三","上海"));
        mList.add(new Person("李四","北京"));
        mList.add(new Person("王伍","厦门"));
        mList.add(new Person("李六","杭州"));
        mList.add(new Person("周七","厦门"));
        SpinnerCustomeAdapter spinnerCustomeAdapter = new SpinnerCustomeAdapter(mList,this);
        mSpCustom.setAdapter(spinnerCustomeAdapter);




    }
    private  void initViews(){
        mSpLanguage = (Spinner) findViewById(R.id.spinner_language);
        mSpLanguageUsingAdapet= (Spinner)findViewById(R.id.spinner_adapter);
        mSpCustom= (Spinner)findViewById(R.id.spinner_custom);
    }
}
