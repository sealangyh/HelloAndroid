package com.example.mh.helloandroid;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MiFrameActivity extends AppCompatActivity {

    private FrameLayout fl;
    private ImageView ivA;
    private ImageView ivB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_frame2);

        fl = (FrameLayout) findViewById(R.id.fl_mi_frame2);
        ivA = (ImageView) findViewById(R.id.ivA);
        ivB = (ImageView) findViewById(R.id.ivB);

        showA();

        fl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ivA.getVisibility() == View.VISIBLE) {
                    showB();
                }else{
                    showA();
                }
            }
        });
    }

    private void showA() {
        ivA.setVisibility(View.VISIBLE);
        ivB.setVisibility(View.INVISIBLE);
    }

    private void showB() {
        ivA.setVisibility(View.INVISIBLE);
        ivB.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi_frame, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
