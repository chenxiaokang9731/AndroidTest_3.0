package com.longbill.dagger2demo.demo1;

import com.longbill.dagger2demo.demo2.Knife;
import com.longbill.dagger2demo.demo2.Orange;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/11/10.
 */

@Module
public class SaladModle{

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
