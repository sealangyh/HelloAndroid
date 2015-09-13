package com.example.mh.helloandroid;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created by mh on 2015/9/13.
 */
public class MiCanvasView extends SurfaceView implements SurfaceHolder.Callback, View.OnTouchListener{

    private Paint p = new Paint();
    private Path path = new Path();

    public MiCanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getHolder().addCallback(this);

        p.setColor(Color.RED);
        p.setTextSize(10);
        p.setStyle(Paint.Style.STROKE);
        p.setAntiAlias(true);

        setOnTouchListener(this);
    }

    public void draw() {
        Canvas canvas = getHolder().lockCanvas();

        canvas.drawColor(Color.WHITE);
        canvas.drawPath(path, p);

        getHolder().unlockCanvasAndPost(canvas);
    }


    public void clean() {
        path.reset();
        draw();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        draw();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                draw();
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(event.getX(), event.getY());
                draw();
                break;
            default:
                break;
        }

        return true;
    }
}
