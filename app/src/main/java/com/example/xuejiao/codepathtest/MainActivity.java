package com.example.xuejiao.codepathtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView mLvItems;
    private EditText mEtNewItem;
    private Button mBtnAddItem;
    private ArrayList<String> mItems;
    private ArrayAdapter<String> mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        mItems = new ArrayList<>();
        mAdapter =new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,mItems);
        mLvItems.setAdapter(mAdapter);
        mItems.add("TextView");
        mItems.add("EditText");
        mItems.add("ImageView");
        mItems.add("Spinner");
        mItems.add("WebView");
        mBtnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newItem = mEtNewItem.getText().toString();
                if (!TextUtils.isEmpty(newItem)) {
                    mItems.add(newItem);//发现这里用mItems.add跟mAdapter.add 都可以,也不需要notifyDataSetChanged
//                    mAdapter.notifyDataSetChanged();
                    mEtNewItem.setText("");
                }
            }
        });
        mLvItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mItems.remove(position);
                mAdapter.notifyDataSetChanged();
                return true;
            }
        });
       mLvItems.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String text=mItems.get(position);
               if(! TextUtils.isEmpty(text) ){
                   if(text.equals("TextView")){
                       Intent intent = new Intent(MainActivity.this,TextViewActivity.class);
                       startActivity(intent);
                   }else if(text.equals("EditText")){
                       Intent intent = new Intent(MainActivity.this,EditTextActivity.class);
                       startActivity(intent);
                   }else if(text.equals("ImageView")){
                       Intent intent = new Intent(MainActivity.this,ImageViewActivity.class);
                       startActivity(intent);
                   }else if(text.equals("Spinner")){
                       Intent intent = new Intent(MainActivity.this,SpinnerActivity.class);
                       startActivity(intent);
                   }else if(text.equals("WebView")){
                       Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                       startActivity(intent);
                   }
               }


           }
       });

    }

    private void initViews(){
        mLvItems = (ListView)findViewById(R.id.lvItems);
        mEtNewItem = (EditText)findViewById(R.id.edNewItem);
        mBtnAddItem = (Button) findViewById(R.id.btnAddItems);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
