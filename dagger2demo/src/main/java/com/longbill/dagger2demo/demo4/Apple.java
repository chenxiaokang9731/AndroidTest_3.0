package com.longbill.dagger2demo.demo4;

import android.util.Log;

import com.longbill.dagger2demo.demo2.Knife;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */
//http://blog.csdn.net/android_study_ok/article/details/52430576
public class Apple {
    @Inject
    Knife knife;

    public Apple() {
        MyApp.getKnifeComponent().inject(this);
        Log.e("knife", "苹果里的knife内存地址：" + knife.toString());
    }
}