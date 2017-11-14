package com.longbill.dagger2demo.demo5;

import dagger.Component;

/**
 * Created by 陈小康 on 2017/11/14.
 */
@Component(modules = {UserModel.class})
public interface UserComponent {

    void inject(Demo5Activity demo5Activity);

}
