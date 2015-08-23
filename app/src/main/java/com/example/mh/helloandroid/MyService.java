package com.example.mh.helloandroid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

public class MyService extends Service {

    boolean bServiceRunning = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return new Binder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        System.out.println("MyService::onCreate");

        bServiceRunning = true;

        new Thread(){
            @Override
            public void run() {
                super.run();

                while (bServiceRunning){
                    System.out.println("service is running");

                    try{
                        sleep(1000);
                    }catch (InterruptedException ex){
                        ex.printStackTrace();
                    }
                }
            }
        }.start();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        System.out.println("MyService::onStartCommand");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        System.out.println("MyService::onDestroy");
        bServiceRunning = false;
    }
}
