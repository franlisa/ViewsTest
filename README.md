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
##EditText
EditText继承于TextView,所以TextView中的东西EditText也可以用，例如android:textColorHighlight,lines等
###一些属性
android:digits 限制输入的数字有哪些     
maxLength: 限制输入的长度，注意与此类似的还有ems的设置，可以blog他们的区别      
inputType:输入类型限制，例如number等，常见的如下：            
*textUri: Text that will be used as a URI     
*textEmailAddress	Text that will be used as an e-mail address     
*textPersonName	    Text that is the name of a person       
*textPassword	    Text that is a password that should be obscured     
*number	            A numeric only field        
*phone	            For entering a phone number     
*date	            For entering a date     
*time	            For entering a time     
*textMultiLine	    Allow multiple lines of text in the field       
###修改底部横线颜色
Assuming you are using the AppCompat library, you can override the styles colorControlNormal,        colorControlActivated, and colorControlHighlight:       
    
<style name="Theme.App.Base" parent="Theme.AppCompat.Light.DarkActionBar">      
    <item name="colorControlNormal">#d32f2f</item>      
    <item name="colorControlActivated">#ff5722</item>       
    <item name="colorControlHighlight">#f44336</item>       
</style>        
###TextInputLayout 监听输入
如果想如下效果      
![](https://github.com/franlisa/ViewsTest/blob/master/app/UM7NmiK.gif)     
则可以借助TextInputLayout，首先要添加依赖
然后在布局中，将editText添加一层TextInputLayout
<android.support.design.widget.TextInputLayout>
....
然后在代码中对EditText设置监听器，addTextChangedListener，在onTextChange中处理我们的限定判断逻辑，然后调用TextInputLayout相应的setError,setErrorEnable函数来实现，具体使用见EditTextActivity.java
###imeOptions属性与软键盘有下角不同图标
虽然通常输入法软键盘右下角会是回车按键，但我们经常会看到点击不同的编辑框，输入法软键盘右下角会有不同的图标，例如go 搜索，发送，完成等等，这个是通过EditText的imeOptions来设置的(有actionGo、 actionSend 、actionSearch、actionDone等)，然后在代码中通过editText.setOnEditorActionListener方法添加相应的监听，因为有些action是需要在代码中添加具体的相关操作的。但是会发现我们设置的没生效，图标还是回车。经过实验发现当我们有设置了singleLine，或者inputTpye为text的时候，imeOptions就生效了

##ImageView 
对于ImageView，主要要注意scaleType的使用，使用不当会引起图片拉伸，截取等问题        
1.center ： Displays the image centered in the view with no scaling.        
2.centerCrop: Scales the image such that both the x and y dimensions are greater than or equal to the   view, while maintaining the image aspect ratio; centers the image in the view.        
3.centerInside:Scales the image to fit inside the view, while maintaining the image aspect ratio. If the image is already smaller than the view, then this is the same as center.        
4.fitCenter:Scales the image to fit inside the view, while maintaining the image aspect ratio. At least one axis will exactly match the view, and the result is centered inside the view.       
5.fitStart:Same as fitCenter but aligned to the top left of the view.      
6.fitEnd:Same as fitCenter but aligned to the bottom right of the view.      
7.fitXY:Scales the x and y dimensions to exactly match the view size; does not maintain the image aspect ratio.      
8.matrix:Scales the image using a supplied Matrix class. The matrix can be supplied using the setImageMatrix method. A Matrix class can be used to apply transformations such as rotations to an image.     
使用效果如下：

第一行依次是  center, centerCrop, centerInside.     
第二行依次是  fitCenter, fitStart, fitEnd, fitXY.
所以当我们在开发photo相关的应用时，应该使用center或fitCenter
如果我们要使用fitXY，一定要注意拉伸的问题，因为它不能保持纵横比，如果要解决纵横比问题，可以结合android:adjustViewBounds来使用，但是height 跟width要有一个是被另一个适应的，所以我们要width拉伸到我们要的指定dp,那么设置height为wrap_content或maxHeigth，相应的如果height要拉伸到指定dp,设置width是被适应的，然后加上android:adjustViewBounds＝"true"这样就能保证纵横比
###setImageResource VS setImageDrawable
 setImageResource does Bitmap reading and decoding on the UI thread, which can cause a latency hiccup.所以我们更多的是使用setImageDrawable
 ##WebView
 webview注意以下几个问题：
 1.如果load的页面是远程的url页面，需要加入访问internet权限；但是如果是load工程下assets的本地html，则无需加入internet权限
 2.如果访问的页面中有 javascript，则webView必须设置支持javaScript；而webView的设置都是通过webViewSettings来做的，例如WebView.getSettings().setJavaScriptEnabled(true);，还可以设置是否可以缩放，是否显示缩放图标等
 3. 如果页面中链接,如果希望点击链接继续在当前browser中响应,而不是新开Android的系统browser中响应该链接,必须覆盖 WebView的WebViewClient对象.      
mWebView.setWebViewClient(new WebViewClient(){      
	public boolean shouldOverrideUrlLoading(WebView view, String url){      
		view.loadUrl(url);      
		return true;        
	}          
});     
shouldOverrideUrlLoading用来处理页面中国有链接的情况
4. 如果我们选择了在当前browser中来显示点击抵链接，那么我们点 返回键 会直接退出了webView,如果要能够回到之前的webView内容，需要重写onKeyDown,对back键进行处理，调用webView的goBack函数来返回到历史webView内容。
5. 与 js的互调是通过addJavascriptInterface来实现。
 
 





