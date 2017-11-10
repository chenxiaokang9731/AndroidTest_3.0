package com.longbill.dagger2demo.demo1;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/10.
 */
@Component(modules = {SaladModle.class})
public interface SaladComponent {

    Pear providePear();

    Banana provideBanana();

    SaladSauce provideSaladSauce();

    void inject(Salad salad);
}
