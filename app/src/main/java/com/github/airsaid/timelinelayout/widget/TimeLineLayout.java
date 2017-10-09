package com.github.airsaid.timelinelayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.airsaid.timelinelayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author airsaid
 * @github https://github.com/airsaid
 * @date 2017/9/30
 * @desc 时间轴样式布局。（只适用于数据量少情况，数据多建议使用利用 RecyclerView 实现的时间轴。）
 */
public class TimeLineLayout extends LinearLayout {

    /** 每行高度 */
    private int mHeight;
    /** 文字大小 */
    private int mTextSize;
    /** 文字颜色 */
    private int mTextColor;
    /** 文字和时间轴间距 */
    private int mPadding;
    /** 时间轴圆点颜色 */
    private int mDotColor;
    /** 时间轴圆点半径 */
    private int mDotRadius;
    /** 时间线颜色 */
    private int mLineColor;
    /** 时间线宽度 */
    private int mLineWidth;

    private List<CharSequence> mData = new ArrayList<>();

    public TimeLineLayout(Context context) {
        this(context, null);
    }

    public TimeLineLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TimeLineLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        initAttrs(attrs);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.TimeLineLayout);
        mHeight = (int) a.getDimension(R.styleable.TimeLineLayout_tll_height, 40);
        mTextSize = (int) a.getDimension(R.styleable.TimeLineLayout_tll_textSize, -1);
        mTextColor = a.getColor(R.styleable.TimeLineLayout_tll_textColor, Color.BLACK);
        mPadding = (int) a.getDimension(R.styleable.TimeLineLayout_tll_padding, 10);
        mDotColor = a.getColor(R.styleable.TimeLineLayout_tll_dotColor, Color.RED);
        mDotRadius = (int) a.getDimension(R.styleable.TimeLineLayout_tll_dotRadius, 4);
        mLineColor = a.getColor(R.styleable.TimeLineLayout_tll_lineColor, Color.GRAY);
        mLineWidth = (int) a.getDimension(R.styleable.TimeLineLayout_tll_lineWidth, 1);
        a.recycle();
    }

    /**
     * 设置时间轴数据。
     * @param data 数据集合
     */
    public void setData(List<CharSequence> data) {
        this.mData = data;
        generateLine(data);
    }

    /**
     * 添加一行数据。
     * @param line 数据
     */
    public void addLine(String line){
        mData.add(line);
        setData(mData);
    }

    /**
     * 删除指定行数据。
     * @param line 数据
     */
    public void removeLine(String line){
        mData.remove(line);
        setData(mData);
    }

    /**
     * 清空所有数据。
     */
    public void clear() {
        mData.clear();
        removeAllViews();
    }

    private void generateLine(@NonNull List<CharSequence> data) {
        removeAllViews();
        for (int i = 0; i < data.size(); i++) {
            generateLine(data.get(i), i);
        }
    }

    private void generateLine(CharSequence text, int index) {
        if (text == null) return;

        // 创建容器
        LinearLayout container = maskContainer();
        // 添加分割线
        container.addView(maskLine(index));
        // 添加文字
        container.addView(maskTextView(text));
        // 添加容器
        addView(container);
    }

    private LinearLayout maskContainer(){
        LinearLayout container = new LinearLayout(getContext());
        container.setGravity(Gravity.CENTER_VERTICAL);
        container.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT
                , mHeight));
        return container;
    }

    private View maskLine(int index){
        LineView lineView = new LineView(getContext());
        lineView.setDotColor(mDotColor);
        lineView.setDotRadius(mDotRadius);
        lineView.setLineColor(mLineColor);
        lineView.setLineWidth(mLineWidth);
        if(index == 0){
            lineView.setLineType(LineView.BOTTOM);
        }else if(index == mData.size() - 1){
            lineView.setLineType(LineView.TOP);
        }
        return lineView;
    }

    private TextView maskTextView(CharSequence text){
        LayoutParams lp = new LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        lp.leftMargin = mPadding;
        TextView textView = new TextView(getContext());
        textView.setText(text);
        textView.setLayoutParams(lp);
        textView.setTextColor(mTextColor);
        if(mTextSize != -1) textView.getPaint().setTextSize(mTextSize);
        return textView;
    }
}
