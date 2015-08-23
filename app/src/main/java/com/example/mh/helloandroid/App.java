package com.example.mh.helloandroid;

import android.app.Application;
import android.content.res.Configuration;

/**
 * Created by mh on 2015/8/24.
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        System.out.println("App::onCreate");
    }

    @Override
    public void onTerminate() {
        super.onTerminate();

        System.out.println("App::onTerminate");
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();

        System.out.println("App::onLowMemory");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        System.out.println("App::onTrimMemory");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        System.out.println("App:onConfigurationChanged");
    }
}
