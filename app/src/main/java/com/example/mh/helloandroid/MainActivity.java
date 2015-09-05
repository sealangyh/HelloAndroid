package com.example.mh.helloandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.my_layout1);

        tvResult = (TextView) findViewById(R.id.tvResult);
        tvInfo = (TextView) findViewById(R.id.tvInfo);

        String sInfo = String.format("Task ID: %s\n Current Activity id: %s", getTaskId(), this.toString());
        tvInfo.setText(sInfo);

        findViewById(R.id.btnStartMainActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MainActivity.class);
                startActivity(i);
            }
        });

        findViewById(R.id.btnStartAnotherActivity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//              startActivity(new Intent(MainActivity.this, MiAnotherActivity.class));

                Intent i = new Intent(MainActivity.this, MiAnotherActivity.class);
                int req_code = 100;
                startActivityForResult(i, req_code);
            }
        });

        findViewById(R.id.btnOpenWebPage).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.baidu.com")));
            }
        });

        findViewById(R.id.btnOpenDialogActivity).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MiDialogActivity.class);
                i.putExtra("msg_greeting", "hello, this is a greeting message.");

                Bundle b = new Bundle();
                b.putString("name", "michael");
                b.putInt("number", 100);
                i.putExtras(b);

                i.putExtra("user", new User("tod", 10));

                startActivity(i);
            }
        });

        findViewById(R.id.btnShowToast).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    startActivity(new Intent("unknown"));
                }
                catch (Exception ex){
                    Toast.makeText(MainActivity.this, "无法启动指定Activity", Toast.LENGTH_SHORT).show();
                }
            }
        });

        findViewById(R.id.btnTestService).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, TestServiceActivity.class));
            }
        });

        findViewById(R.id.btnOpenFramelayout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MiFrameActivity.class));
            }
        });

        findViewById(R.id.btnOpenTabbedFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MiTabs2Activity.class));
            }
        });

        findViewById(R.id.btnOpenWebBrowser).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MiWebBrowseActivity.class));
            }
        });

        findViewById(R.id.btnTestCursorCoordination).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MiCoordinationActivity.class));
            }
        });

        System.out.println("onCreate");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        tvResult.setText(String.format("输入的消息是：%s",data.getStringExtra("msg_result")));
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestory");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
