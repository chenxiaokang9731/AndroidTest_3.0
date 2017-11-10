package com.longbill.dagger2demo.demo3;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/10.
 */
@Component(modules = {SaladModle.class})
public interface SaladComponent {
    void inject(Salad salad);
}
