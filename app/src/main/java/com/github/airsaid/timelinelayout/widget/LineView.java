package com.github.airsaid.timelinelayout.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.ColorInt;
import android.support.annotation.IntDef;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author airsaid
 * @github https://github.com/airsaid
 * @date 2017/9/30
 * @desc 时间轴的分割线 View。
 */
public class LineView extends View {

    @IntDef({ALL, TOP, BOTTOM})
    @Retention(RetentionPolicy.SOURCE)
    public @interface LineType{};

    public static final int ALL     = 1;
    public static final int TOP     = 2;
    public static final int BOTTOM  = 3;
    private int mType = ALL;

    private Paint mPaint;
    /** 圆半径 */
    private float mDotRadius = 4f;
    /** 线宽度 */
    private float mLineWidth = 1f;
    /** 线颜色 */
    private int mLineColor = Color.parseColor("#E4E5E6");
    /** 圆颜色 */
    private int mDotColor = Color.parseColor("#F29EAE");

    public LineView(Context context) {
        this(context, null);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        if(widthMode == MeasureSpec.AT_MOST){
            width = (int) (mDotRadius * 2);
        }
        setMeasuredDimension(widthMode != MeasureSpec.AT_MOST ? widthSize : width,
                heightSize);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLine(canvas);
        drawDot(canvas);
    }

    /**
     * 绘制原点。
     */
    private void drawDot(Canvas c){
        mPaint.setColor(mDotColor);
        float cx = getWidth() / 2;
        float cy = getHeight() / 2;
        c.drawCircle(cx, cy, mDotRadius, mPaint);
    }

    /**
     * 绘制线。
     */
    private void drawLine(Canvas c){
        mPaint.setColor(mLineColor);
        mPaint.setStrokeWidth(mLineWidth);

        float startY = 0;
        float stopY  = getHeight();
        if(mType == TOP){
            stopY = getHeight() / 2;
        }else if(mType == BOTTOM){
            startY = getHeight() / 2;
        }
        float startX = getWidth() / 2;
        float stopX  = getWidth() / 2;
        c.drawLine(startX, startY, stopX, stopY, mPaint);
    }

    /**
     * 设置时间轴线类型。
     * @param type 只有顶部线: {@link #TOP}, 只有底部线: {@link #BOTTOM}.
     * 默认是顶部和底部都有: {@link #ALL}.
     */
    public void setLineType(@LineType int type){
        this.mType = type;
    }

    /**
     * 设置圆点颜色。
     * @param color 颜色值
     */
    public void setDotColor(@ColorInt int color){
        this.mDotColor = color;
        invalidate();
    }

    /**
     * 设置圆点半径。
     * @param radius 半径
     */
    public void setDotRadius(int radius){
        this.mDotRadius = radius;
        invalidate();
    }

    /**
     * 设置时间轴线颜色。
     * @param color 颜色值
     */
    public void setLineColor(@ColorInt int color){
        this.mLineColor = color;
        invalidate();
    }

    /**
     * 设置时间轴线宽度。
     * @param width 宽度
     */
    public void setLineWidth(int width){
        this.mLineWidth = width;
        invalidate();
    }
}
