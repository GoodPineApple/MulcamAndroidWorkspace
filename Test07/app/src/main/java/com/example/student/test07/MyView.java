package com.example.student.test07;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by student on 2017-01-11.
 */

public class MyView extends View {
    private int x=100, y=100;

    public MyView(Context context) {
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawRect(x, y, x+50, y+50, paint);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int eventX = (int)event.getX();
        int eventY = (int)event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                Log.d("yangyu", "눌림!!");
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("yangyu", "돌아다님!!");
                break;
            case MotionEvent.ACTION_UP:
                Log.d("yangyu", "떨어짐!!");
                break;
        }

        x = eventX;
        y = eventY;

        invalidate(); // 새로운 좌표로 다시그려라

        return true;
    }
}







