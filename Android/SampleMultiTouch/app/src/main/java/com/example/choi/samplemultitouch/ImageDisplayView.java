package com.example.choi.samplemultitouch;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class ImageDisplayView extends View {

    Paint mPaint;
    Matrix mMatrix;

    last = -1

    public ImageDisplayView(Context context) {
        super(context);

        init(context);
    }

    public ImageDisplayView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context){
        mPaint = new Paint();
        mMatrix = new Matrix();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}
