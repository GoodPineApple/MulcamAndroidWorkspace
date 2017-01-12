package com.example.taemi.test08_scribble_yangyu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by taemi on 2017-01-12.
 */

public class DrawPanel extends View {
    private List<Paint> paintList = new ArrayList<Paint>();
    private List<Path> pathList = new ArrayList<>();

    private Paint currentPaint = new Paint();
    private Path currentPath = new Path();

    public DrawPanel(Context context, AttributeSet attrs) {
        super(context, attrs);
        setBackgroundColor(Color.YELLOW);
//      실행하자마자 버튼 안누르고 그릴경우 대비
        currentPaint.setColor(Color.BLACK);
        currentPaint.setStrokeWidth(12f);
        currentPaint.setAntiAlias(true);
        currentPaint.setStyle(Paint.Style.STROKE);

        paintList.add(currentPaint);
        pathList.add(currentPath);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < pathList.size(); i++){
            canvas.drawPath(pathList.get(i),paintList.get(i));
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float eventX = event.getX();
        float eventY = event.getY();

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                currentPath.moveTo(eventX,eventY);
                break;
            case MotionEvent.ACTION_MOVE:
                currentPath.lineTo(eventX,eventY);
        }
        invalidate(); // 작성하고 갱신
        return true;
    }

    public void chageColor(String selectColor){
        currentPath = new Path();
        currentPaint = new Paint();

        currentPaint.setStrokeWidth(12f);
        currentPaint.setAntiAlias(true);
        currentPaint.setStyle(Paint.Style.STROKE);

        switch (selectColor){
            case "RED":
                currentPaint.setColor(Color.RED);
                break;
            case "BLUE":
                currentPaint.setColor(Color.BLUE);
                break;
            case "GREEN":
                currentPaint.setColor(Color.GREEN);
                break;
        }
        paintList.add(currentPaint);
        pathList.add(currentPath);
    }

}
