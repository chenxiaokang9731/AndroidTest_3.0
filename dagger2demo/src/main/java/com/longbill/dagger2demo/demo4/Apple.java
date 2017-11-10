package com.longbill.dagger2demo.demo4;

import android.util.Log;

import com.longbill.dagger2demo.demo2.Knife;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Apple {
    @Inject
    Knife knife;

    public Apple() {
        Log.e("knife", "苹果里的knife内存地址：" + knife.toString());
        MyApp.getKnifeComponent().inject(this);
    }
}