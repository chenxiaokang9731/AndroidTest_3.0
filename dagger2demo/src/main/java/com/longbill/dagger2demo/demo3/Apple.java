package com.longbill.dagger2demo.demo3;

import android.util.Log;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Apple {
    String color;

    public Apple() {
        Log.e("TAG", "我是一个普通的苹果");

    }

    public Apple(String color) {
        this.color = color;
        Log.e("TAG", "我是一个有颜色的苹果"+ color);

    }
}