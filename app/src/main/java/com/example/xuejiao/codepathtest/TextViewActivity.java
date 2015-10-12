package com.example.xuejiao.codepathtest;

import android.app.Activity;
import android.os.Bundle;
import android.text.Html;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

/**
 * Created by xuejiao on 15/10/12.
 */
public class TextViewActivity extends Activity {
    private TextView mTvHtml;
    private  TextView mTvHtmlColor;
    private  TextView mTvCustom;
    private String mStringCustomFirst="hello";
    private String mStringCustomSec="world";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.textview_layout);
       initViews();
        String htmlText=getString(R.string.htmlFormattedText);
        mTvHtml.setText(Html.fromHtml(htmlText));
//       mTvHtmlColor.setText(Html.fromHtml(htmlText));
        SpannableStringBuilder mSpannableStringBuilder= new SpannableStringBuilder(mStringCustomFirst);
        /*setSpan
         * 第一个参数:要设置的样式
         * 第二个参数:开始位置(包含)
         * 第三个参数:终止位置(不包含)
         * 第三个参数:. 用规范后面如果有新的字符串加入时候的规则，
         * SPAN_INCLUSIVE_EXCLUSIVE:表示在该规范字符串的前边加入的还是应用这个样式，在后面加入的不应用这个样式
         * SPAN_EXCLUSIVE_EXCLUSIVE  // means to not extend the span when additional text is added in later
         * 以此类推
         */
        mSpannableStringBuilder.setSpan(new ForegroundColorSpan(getResources().getColor(android.R.color.holo_red_dark)),// the span to add
                                        0,//the start ofn the span(inclusive)
                                        mSpannableStringBuilder.length(),//the end of the span(exclusive)_
                                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE  //behavior when text is latter inserted into theSpannableStringBuilder
                );
        mSpannableStringBuilder.insert(0,"girl,");
        mSpannableStringBuilder.append(mStringCustomSec);
        mSpannableStringBuilder.setSpan(new StrikethroughSpan(),
                mSpannableStringBuilder.length() - mStringCustomFirst.length(),
                mSpannableStringBuilder.length(),
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE  // means to not extend the span when additional text is added in later


        );
        mTvCustom.setText(mSpannableStringBuilder, TextView.BufferType.EDITABLE);

    }
    private void initViews(){
        mTvHtml = (TextView)findViewById(R.id.tvHtml);
//        mTvHtmlColor = (TextView)findViewById(R.id.tvHtmlColor);
        mTvCustom=(TextView)findViewById(R.id.tvCustom);

    }
}
