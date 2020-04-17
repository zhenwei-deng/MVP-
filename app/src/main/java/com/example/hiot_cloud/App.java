package com.example.hiot_cloud;

import android.app.Application;
import com.example.hiot_cloud.main.MainActivity;
import com.example.hiot_cloud.injection.component.ApplicationComponent;
import com.example.hiot_cloud.injection.component.DaggerApplicationComponent;
import com.example.hiot_cloud.injection.module.ApplicationModule;

/**
 * 所有程序的入口
 * App做注入
 */

public class App extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeInjector();
    }

    private void initializeInjector() {
        //DaggerApplicationComponent子方法生成component
        component = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        //生成component之后再做注入inject
        component.inject(this);
    }

    public ApplicationComponent component() {
        return component;
    }

}

