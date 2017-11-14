package com.longbill.dagger2demo.demo5;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by 陈小康 on 2017/11/14.
 */
@Module
public class UserModel {

    private Context context;

    public UserModel(Context context){
        this.context = context;
    }

    @Provides
    public User provideUser(){
        return new User();
    }
}
