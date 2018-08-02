package custom.graphics.techtown.org.paintboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

public class PaintBoard extends View {

    int lastX;
    int lastY;
    Paint mPaint;
    Canvas mCanvas;

    public PaintBoard(Context context){
        super(context);

        // create a new paint object
        this.mPaint = new Paint();
        this.mPaint.setColor(Color.BLACK);

        this.lastX = -1;
        this.lastY = -1;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        int X = (int) event.getX();
        int Y = (int) event.getY();
        mCanvas = new Canvas();

        switch (action) {
            case MotionEvent.ACTION_UP:
                lastX = -1;
                lastY = -1;
                break;

            case MotionEvent.ACTION_DOWN:
                if (lastX != -1) {
                    if (X != lastX || Y != lastY) {
                        mCanvas.drawLine(lastX, lastY, X, Y, mPaint);
                    }
                }

                lastX = X;
                lastY = Y;

                break;

            case MotionEvent.ACTION_MOVE:
                if (lastX != -1) {
                    mCanvas.drawLine(lastX, lastY, X, Y, mPaint);
                }

                lastX = X;
                lastY = Y;

                break;
        }

        invalidate();

        return true;
    }
}
