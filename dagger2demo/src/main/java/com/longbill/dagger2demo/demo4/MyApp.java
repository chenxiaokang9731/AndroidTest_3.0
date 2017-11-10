package com.longbill.dagger2demo.demo4;

import android.app.Application;

/**
 * Created by Administrator on 2017/11/10.
 */

public class MyApp extends Application {

    private static KnifeComponent knifeComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        knifeComponent = DaggerKnifeComponent.builder().knifeModule(new KnifeModule()).build();
    }

    public static KnifeComponent getKnifeComponent() {
        return knifeComponent;
    }
}
