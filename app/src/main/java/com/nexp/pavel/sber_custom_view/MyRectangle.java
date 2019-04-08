package com.nexp.pavel.sber_custom_view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class MyRectangle extends View {

    private Paint mPaint;
    private int desiredWidth = 200;
    private int desiredHeight = 500;

    {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
    }

    public MyRectangle(Context context) {
        super(context);
    }

    public MyRectangle(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRectangle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyRectangle(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void resize(int newWidth, int newHeight){
        desiredWidth = newWidth;
        desiredHeight = newHeight;
        requestLayout();
    }

    public void changeColor(int color){
        mPaint.setColor(color);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureDimension(desiredWidth, widthMeasureSpec), measureDimension(desiredHeight, heightMeasureSpec));
    }

    private int measureDimension(int desiredSize, int measureSpec){
        int result;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);
        if(specMode == MeasureSpec.EXACTLY){
            result = specSize;
        } else {
            result = desiredSize;
            if(specMode == MeasureSpec.AT_MOST){
                result = Math.min(result, specSize);
            }
        }
        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(new Rect(0, 0, getWidth(), getHeight()), mPaint);
    }
}
