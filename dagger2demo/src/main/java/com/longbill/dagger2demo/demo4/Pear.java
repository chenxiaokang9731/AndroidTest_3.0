package com.longbill.dagger2demo.demo4;

import android.util.Log;

import com.longbill.dagger2demo.demo2.Knife;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Pear {
    @Inject
    Knife knife;

    public Pear(){
        Log.e("TAG", "我是一个梨");
        MyApp.getKnifeComponent().inject(this);
        Log.e("knife", "梨里的knife内存地址："+knife.toString());
    }
}
