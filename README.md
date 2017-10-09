# TimeLineLayout
This is a simple timeline layout that applies to less data. (这是一个简单的时间轴布局，适用于数据量少的情况)

## 预览
![](https://github.com/Airsaid/TimeLineLayout/blob/master/preview/preview.gif)

## 使用
- 布局中：
```
 <com.github.airsaid.timelinelayout.widget.TimeLineLayout
        android:id="@+id/timeLineLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@android:color/white"
        android:paddingLeft="20dp"
        android:paddingRight="16dp"
        app:tll_dotColor="@color/colorAccent"
        app:tll_dotRadius="4dp"
        app:tll_height="40dp"
        app:tll_lineColor="#E4E4E4"
        app:tll_lineWidth="1px"
        app:tll_padding="16dp"
        app:tll_textColor="@android:color/black"
        app:tll_textSize="14sp"/>
```
- 代码中：
```
ArrayList<CharSequence> data = new ArrayList<>();
data.add("拍摄时间：2017-9-10至2017-11-20");
data.add("拍摄周期：1");
data.add("拍摄地址：北京");
data.add("出品方：某某传媒");
data.add("报名截止日期：2017-09-30");

TimeLineLayout timeLineLayout = (TimeLineLayout) findViewById(R.id.timeLineLayout);
timeLineLayout.setData(data);
```

## 自定义属性
```
<!--时间轴样式布局-->
    <declare-styleable name="TimeLineLayout">
        <!--每行高度-->
        <attr name="tll_height" format="dimension|reference"/>
        <!--文字大小-->
        <attr name="tll_textSize" format="dimension|reference"/>
        <!--文字颜色-->
        <attr name="tll_textColor" format="color|reference"/>
        <!--文字和时间轴间距-->
        <attr name="tll_padding" format="dimension|reference"/>
        <!--时间轴圆点颜色-->
        <attr name="tll_dotColor" format="color|reference"/>
        <!--时间轴圆点半径-->
        <attr name="tll_dotRadius" format="dimension|reference"/>
        <!--时间线颜色-->
        <attr name="tll_lineColor" format="color|reference"/>
        <!--时间线宽度-->
        <attr name="tll_lineWidth" format="dimension|reference"/>
    </declare-styleable>
```

## 联系我
- **QQ 群：** 5707887
- **Email：** airsaid1024@gmail.com
- **CSDN：**[http://blog.csdn.net/airsaid](http://blog.csdn.net/airsaid)
- **掘 金：** [https://juejin.im/user/576915101532bc00603df0e2](https://juejin.im/user/576915101532bc00603df0e2)
- **简 书：** [http://www.jianshu.com/u/c3fe0e582f1e](http://www.jianshu.com/u/c3fe0e582f1e)
