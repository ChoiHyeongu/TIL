package custom.graphics.techtown.org.samplesurfaceview;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback {

    SurfaceHolder mHolder;

    public MySurfaceView(Context context) {
        super(context);
        mHolder = getHolder();
        mHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }


    private void draw() {
        Canvas _canvas = null;

        try{
            _canvas = mHolder.lockCanvas(null);
        } finally {
            if(_canvas != null){

            }
        }
    }

    private void redraw(){

    }
}
