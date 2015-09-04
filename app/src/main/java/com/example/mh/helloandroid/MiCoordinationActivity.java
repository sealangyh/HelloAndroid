package com.example.mh.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
    private TextView tvCoorX;
    private TextView tvCoorY;
    private ImageView ivCar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_coordination);

        ll_coor = (FrameLayout)findViewById(R.id.ll_coor);
        tvCoorX = (TextView) findViewById(R.id.tvCoorX);
        tvCoorY = (TextView) findViewById(R.id.tvCoorY);
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
                        tvCoorX.setText("X:" + event.getX());
                        tvCoorY.setText("Y:" + event.getY());

                        RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) ivCar.getLayoutParams();
                        lp.leftMargin = (int) (event.getX()-200);
                        lp.topMargin = (int) (event.getY()-200);
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
