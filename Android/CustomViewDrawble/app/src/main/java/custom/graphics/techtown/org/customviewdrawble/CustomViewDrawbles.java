package custom.graphics.techtown.org.customviewdrawble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class CustomViewDrawbles extends View {

    private ShapeDrawable upperDrawbles;
    private ShapeDrawable lowerDrawbles;

    public CustomViewDrawbles(Context context){
        super(context);

        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = manager.getDefaultDisplay();
        Point sizePoint = new Point();
        display.getSize(sizePoint);
        int width = sizePoint.x;
        int height = sizePoint.y;

        Resources curRes = getResources();
        int blackColor = curRes.getColor(R.color.color1);
        int grayColor = curRes.getColor(R.color.color2);
        int darkGrayColor = curRes.getColor(R.color.color3);

        upperDrawbles = new ShapeDrawable();

        RectShape rectangle = new RectShape();
        rectangle.resize(width, height*2/3);
        upperDrawbles.setShape(rectangle);
        upperDrawbles.setBounds(0, 0, width, height*2/3);

        LinearGradient gradient = new LinearGradient(0, 0, 0, height*2/3, grayColor, blackColor, Shader.TileMode.CLAMP);

        Paint paint = upperDrawbles.getPaint();

        paint.setShader(gradient);
        lowerDrawbles = new ShapeDrawable();

        RectShape rectangle2 = new RectShape();
        rectangle2.resize(width, height*1/3);

        lowerDrawbles.setShape(rectangle2);
        lowerDrawbles.setBounds(0, height*2/3, width, height);

        LinearGradient gradient2 = new LinearGradient(0, 0, 0, height*1/3, blackColor, darkGrayColor, Shader.TileMode.CLAMP);

        Paint paint2 = lowerDrawbles.getPaint();
        paint2.setShader(gradient2);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        upperDrawbles.draw(canvas);
        lowerDrawbles.draw(canvas);

        Paint pathPaint = new Paint();

        pathPaint.setAntiAlias(true);
        pathPaint.setColor(Color.YELLOW);
        pathPaint.setStyle(Paint.Style.STROKE);
        pathPaint.setStrokeWidth(16.0F);
        pathPaint.setStrokeCap(Paint.Cap.BUTT);
        pathPaint.setStrokeJoin(Paint.Join.MITER);

        Path path = new Path();
        path.moveTo(20, 20);
        path.lineTo(120, 120);
        path.lineTo(160, 160);
        path.lineTo(180, 180);
        path.lineTo(200, 200);

        canvas.drawPath(path, pathPaint);
        pathPaint.setColor(Color.WHITE);
        pathPaint.setStrokeCap(Paint.Cap.ROUND);
        pathPaint.setStrokeJoin(Paint.Join.ROUND);

        path.offset(30, 120);
        canvas.drawPath(path, pathPaint);

        pathPaint.setColor(Color.CYAN);
        pathPaint.setStrokeCap(Paint.Cap.SQUARE);
        pathPaint.setStrokeJoin(Paint.Join.ROUND);

        path.offset(30, 120);
        canvas.drawPath(path, pathPaint);

    }
}
