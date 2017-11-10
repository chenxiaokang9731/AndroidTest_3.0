package com.longbill.dagger2demo.demo1;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Salad{

    @Inject
    Pear pear;

    @Inject
    Banana banana;

    @Inject
    SaladSauce saladSauce;

    public Salad(){
        DaggerSaladComponent.builder().saladModle(new SaladModle()).build().inject(this);
        makeSalad(pear, banana, saladSauce);
    }

    public void makeSalad(Pear pear, Banana banana, SaladSauce saladSauce) {
        Log.e("TAG", "我在搅拌制作水果沙拉");
    }
}