package com.example.xuejiao.codepathtest.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.xuejiao.codepathtest.R;
import com.example.xuejiao.codepathtest.model.Person;

import java.util.List;

/**
 * Created by xuejiao on 15/10/13.
 */
public class SpinnerCustomeAdapter extends BaseAdapter {
    private List<Person> mList;
    private Context mContext;

    public SpinnerCustomeAdapter(List<Person> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView ==null){
            LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.spinner_dropdown_custom,null);
            holder = new ViewHolder();
            holder.tv= (TextView)convertView.findViewById(R.id.tv_custom_adpater);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv.setText(mList.get(position).getName() + " " + mList.get(position).getCity());
        Drawable drawable=mContext.getResources().getDrawable(R.mipmap.contact);
//        必须setBounds不然图片不显示，或者直接用setCompoundDrawablesWithIntrinsicBounds
//        drawable.setBounds(0,0,drawable.getMinimumWidth(),drawable.getMinimumHeight());
//        holder.tv.setCompoundDrawables(drawable,null,null.null);
        holder.tv.setCompoundDrawablesWithIntrinsicBounds(drawable, null, null, null);

        return convertView;
    }
    private static class  ViewHolder{
        TextView tv;
    }

}
