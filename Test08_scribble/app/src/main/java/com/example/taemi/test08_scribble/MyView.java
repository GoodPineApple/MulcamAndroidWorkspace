package com.example.taemi.test08_scribble;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

/**
 * Created by taemi on 2017-01-11.
 */

public class MyView extends View {
    private Paint paint;
    private Path path_red;
    private Path path_blue;
    private Path path_orange;
    private String btnChecker;

    public MyView(Context context, AttributeSet attr) {
        super(context,attr);

        path_red = new Path();
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10f);
        paint.setColor(Color.RED);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setAntiAlias(true);

        path_blue = new Path();
//        paint_blue = new Paint();
//        paint_blue.setStyle(Paint.Style.STROKE);
//        paint_blue.setStrokeWidth(10f);
//        paint_blue.setColor(Color.BLUE);
//        paint_blue.setStrokeJoin(Paint.Join.ROUND);
//        paint_blue.setAntiAlias(true);

        path_orange = new Path();
//        paint_orange = new Paint();
//        paint_orange.setStyle(Paint.Style.STROKE);
//        paint_orange.setStrokeWidth(10f);
//        paint_orange.setColor(Color.YELLOW);
//        paint_orange.setStrokeJoin(Paint.Join.ROUND);
//        paint_orange.setAntiAlias(true);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(Color.RED);
        canvas.drawPath(path_red,paint);
        paint.setColor(Color.BLUE);
        canvas.drawPath(path_blue,paint);
        paint.setColor(Color.YELLOW);
        canvas.drawPath(path_orange,paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        if(btnChecker=="red"){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    path_red.moveTo(eventX,eventY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    path_red.lineTo(eventX,eventY);
            }
        } else if(btnChecker=="blue"){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    path_blue.moveTo(eventX,eventY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    path_blue.lineTo(eventX,eventY);
            }
        } else if(btnChecker=="yellow"){
            switch (event.getAction()){
                case MotionEvent.ACTION_DOWN:
                    path_orange.moveTo(eventX,eventY);
                    break;
                case MotionEvent.ACTION_MOVE:
                    path_orange.lineTo(eventX,eventY);
            }
        }
        invalidate();
        return true;
    }

    public void setBtninfo(String color){
        btnChecker = color;
    }
}
