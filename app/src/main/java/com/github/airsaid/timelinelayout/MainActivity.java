package com.github.airsaid.timelinelayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.github.airsaid.timelinelayout.widget.TimeLineLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TimeLineLayout mTimeLineLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTimeLineLayout = (TimeLineLayout) findViewById(R.id.timeLineLayout);
        mTimeLineLayout.setData(getLines());
    }

    private List<CharSequence> getLines(){
        ArrayList<CharSequence> list = new ArrayList<>();
        list.add("拍摄时间：2017-9-10至2017-11-20");
        list.add("拍摄周期：1");
        list.add("拍摄地址：北京");
        list.add("出品方：某某传媒");
        list.add("报名截止日期：2017-09-30");
        return list;
    }

    public void add(View v){
        mTimeLineLayout.addLine("说明：这是新添加的一行");
    }

    public void clear(View v){
        mTimeLineLayout.clear();
    }
}
