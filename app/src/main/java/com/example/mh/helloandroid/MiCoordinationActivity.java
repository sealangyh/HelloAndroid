package com.example.mh.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MiCoordinationActivity extends AppCompatActivity {

    private FrameLayout ll_coor;
    private TextView tvCoorX1;
    private TextView tvCoorY1;
    private TextView tvCoorX2;
    private TextView tvCoorY2;
    private ImageView ivCar;
    private float prevDistance = -1;
    private float currDistance = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_coordination);

        ll_coor = (FrameLayout)findViewById(R.id.ll_coor);
        tvCoorX1 = (TextView) findViewById(R.id.tvCoorX1);
        tvCoorY1 = (TextView) findViewById(R.id.tvCoorY1);
        tvCoorX2 = (TextView) findViewById(R.id.tvCoorX2);
        tvCoorY2 = (TextView) findViewById(R.id.tvCoorY2);
        ivCar = (ImageView) findViewById(R.id.ivCar);

        ll_coor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("action down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        System.out.println("action move");

//                        Log.i("info", "this is info message");
//                        Log.d("debug", "this is debug message");
//                        Log.v("verbose", "this is verbose message");
//                        Log.w("warning", "this is warning message");
//                        Log.e("error", "this is error message");

                        int nCountOfPt = event.getPointerCount();
                        Log.i("debug", "count of pointer: " + nCountOfPt);

                        tvCoorX1.setText("X1:" + event.getX(0));
                        tvCoorY1.setText("Y1:" + event.getY(0));

                        if( nCountOfPt >= 2) {
                            tvCoorX2.setText("X2:" + event.getX(1));
                            tvCoorY2.setText("Y2:" + event.getY(1));
                            tvCoorX2.setVisibility(View.VISIBLE);
                            tvCoorY2.setVisibility(View.VISIBLE);

                            float offsetX = event.getX(0) - event.getX(1);
                            float offsetY = event.getY(0) - event.getY(1);

                            currDistance = (float) Math.sqrt(offsetX*offsetX + offsetY*offsetY);

                            if (currDistance - prevDistance > 15) {
                                Log.i("info", "scale out");

                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ivCar.getLayoutParams();
                                lp.width = (int) (1.3f*ivCar.getWidth());
                                lp.height = (int) (1.3f*ivCar.getHeight());
                                ivCar.setLayoutParams(lp);

                                prevDistance = currDistance;
                            }
                            else if(prevDistance - currDistance > 15) {
                                Log.i("info", "scale in");

                                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ivCar.getLayoutParams();
                                lp.width = (int) (ivCar.getWidth()*0.9f);
                                lp.height = (int) (ivCar.getHeight()*0.9f);
                                ivCar.setLayoutParams(lp);

                                prevDistance = currDistance;
                            }
                        }
                        else {
                            tvCoorX2.setVisibility(View.INVISIBLE);
                            tvCoorY2.setVisibility(View.INVISIBLE);
                        }


                        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ivCar.getLayoutParams();
                        lp.leftMargin = (int) (event.getX()-50);
                        lp.topMargin = (int) (event.getY()-50);
                        ivCar.setLayoutParams(lp);

                        break;
                    case MotionEvent.ACTION_UP:
                        System.out.println("action up");
                        break;
                }
                return true;
            }
        });
    }
}
