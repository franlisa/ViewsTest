# 该工程是在学习常用的view的一些重要及不常见用法
##view中共用的但是比较容易混淆的如下属性
###Views Margin and Padding
Margins and padding values for views allows us to position and space elements in a layout.  
Layout Margin defines the amount of space around the outside of a view  
Padding defines the amount of space around the contents or children of a view.（内容对该view某些方向上的具体距离空间， gravity只能指定大方向）
###View GravityVView
Gravity can be used to define the direction of the contents of a view.  
gravity determines the direction that the contents of a view will align (like CSS text-align). 
layout_gravity determines the direction of the view within it's parent (like CSS float).  
##TextView
详细的看 TextViewActivity及textview_layout
###一些属性
Typeface:设置字体
Textstyle:设置例如斜体，粗体等样式
maxLines,minLines:可以指定最大最小行数，同时可以通过ellipsize来设置当内容超出所设行数时候，省略的形式。
跟行数有关的还是有Lines, singleLine属性
字体颜色相关的：除了TextColor,还有textColorHighlight,textColorHint,textColrLink来设置高亮，提示，链接的字体颜色
autoLink,linksClickable: 用来设置当内容是类型"http",email,电话号码等等等时候，可以点击，在浏览器中打开
###在文本中插入html文本
在setText时候使用Html.fromHtml(formattedText))；
如果html文本是写在value/string中的话，需要使用CDATA区分，如下
<string name="htmlFormattedText">   
    <![CDATA[   
        Please <a href="http://highlight.com">let us know</a> if you have <b>feedback on this</b> or if     
        you would like to log in with <i>another identity service</i>. Thanks!      
    ]]>   
</string>   
###在TextView中放入图片
textView可以直接使用drawableRight/left/bottom/top来在内容中插入图片，同时通过android:drawablePadding来指定与文字内容的距离。
另外，因为EditText,Button,RadioButton等都是继承于textView 所以他们也都支持Textview这些功能。
###同一TextView设置不同样式  Span使用
Span相关可以用来对一个TextView设置不同的样式。例如不同的颜色，大小，字体等等。
主要通过SpannableStringBuilder的setSpan来实现，具体要用的样式例如有ForegroundColorSpan，StrikethroughSpan等等。
关于setSpan相关参数
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
                                        mSpannableStringBuilder.length(),//the end of the span(exclusive)   
                                        Spanned.SPAN_INCLUSIVE_EXCLUSIVE  //behavior when text is latter inserted into theSpannableStringBuilder    
                ); 
具体使用见TextViewActivity.java



