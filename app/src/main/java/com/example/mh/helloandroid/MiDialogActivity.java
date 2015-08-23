package com.example.mh.helloandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MiDialogActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mi_dialog);

        Intent i = getIntent();
        tv = (TextView) findViewById(R.id.tvGreeting);
        tv.setText(i.getStringExtra("msg_greeting"));

        Bundle b = i.getExtras();
        System.out.println(b.getString("name"));

//        User u = (User) i.getSerializableExtra("user");
        User u = (User) i.getParcelableExtra("user");
        System.out.println(String.format("user name = %s, age = %d", u.getName(), u.getAge()));

        System.out.println("Dialog onCreate");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_mi_dialog, menu);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Dialog onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Dialog onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Dialog onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Dialog onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Dialog onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Dialog onDestory");
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
