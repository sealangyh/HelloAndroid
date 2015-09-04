package com.example.mh.helloandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MiCoordinationActivity extends AppCompatActivity {

    private LinearLayout ll_coor;
    private TextView tvCoorX;
    private TextView tvCoorY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_coordination);

        ll_coor = (LinearLayout)findViewById(R.id.ll_coor);
        tvCoorX = (TextView) findViewById(R.id.tvCoorX);
        tvCoorY = (TextView) findViewById(R.id.tvCoorY);

        ll_coor.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        System.out.println("action down");
                        break;
                    case MotionEvent.ACTION_MOVE:
                        tvCoorX.setText("X:" + event.getX());
                        tvCoorY.setText("Y:" + event.getY());
                        System.out.println("action move");
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
