package com.longbill.dagger2demo.demo4;

import com.longbill.dagger2demo.demo2.Knife;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/10.
 */
@Module
public class KnifeModule {

    @KnifeScope
    @Provides
    public Knife provideKnife(){
        Knife knife = new Knife();
        return knife;
    }
}
