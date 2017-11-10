package com.longbill.dagger2demo.demo4;

import dagger.Component;

/**
 * Created by Administrator on 2017/11/10.
 */
@KnifeScope
@Component(modules = KnifeModule.class)
public interface KnifeComponent {

    void inject(Apple apple);

    void inject(Pear pear);
}
