package com.longbill.dagger2demo.demo2;

import com.longbill.dagger2demo.demo1.Banana;
import com.longbill.dagger2demo.demo1.Pear;
import com.longbill.dagger2demo.demo1.SaladSauce;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/10.
 */

@Module
public class SaladModle {

    @Provides
    public Knife provideKnife(){
        return new Knife();
    }

    @Provides
    public Orange provideOrange(Knife knife){
        return new Orange(knife);
    }


    @Provides
    public Pear providePear(){
        return new Pear();
    }

    @Provides
    public Banana provideBanana(){
        return new Banana();
    }

    @Provides
    public SaladSauce provideSaladSauce(){
        return new SaladSauce();
    }
}
