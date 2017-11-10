package com.longbill.dagger2demo.demo2;

import android.util.Log;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Orange {

    private Knife knife;

    public Orange(Knife knife){
        this.knife = knife;
        knife.cut();
        Log.e("TAG", "我是一个桔子");
    }
}
