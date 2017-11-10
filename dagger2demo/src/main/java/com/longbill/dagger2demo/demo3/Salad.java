package com.longbill.dagger2demo.demo3;

import android.util.Log;

import com.longbill.dagger2demo.demo1.Banana;
import com.longbill.dagger2demo.demo1.Pear;
import com.longbill.dagger2demo.demo1.SaladSauce;
import com.longbill.dagger2demo.demo2.Orange;
import com.longbill.dagger2demo.demo3.Apple;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/11/10.
 */

public class Salad {

    @Inject
    @Type("color")
    Apple colorApple;

    @Inject
    @Type("normal")
    Apple normalApple;

    @Inject
    Orange orange;

    @Inject
    Pear pear;

    @Inject
    Banana banana;

    @Inject
    SaladSauce saladSauce;

    public Salad(){
        DaggerSaladComponent.builder().saladModle(new SaladModle()).build().inject(this);
        makeSalad(pear, banana, saladSauce, orange);
    }

    public void makeSalad(Pear pear, Banana banana, SaladSauce saladSauce, Orange orange) {
        Log.e("TAG", "我在搅拌制作水果沙拉");
    }
}