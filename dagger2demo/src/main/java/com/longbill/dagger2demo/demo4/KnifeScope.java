package com.longbill.dagger2demo.demo4;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/11/10.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface KnifeScope{
    
}
