package com.narkang.mvpdemo;

import android.app.Application;

import com.narkang.util.app.AppConstant;

/**
 * Created by Administrator on 2017/11/28.
 */

public class App extends Application{

    String HOST = "http://news-at.zhihu.com/api/4/";  //自己公司的域名地址1

    @Override
    public void onCreate() {
        super.onCreate();
        AppConstant.init(this)
                .withApiHost(HOST)
                .configure();
    }
}
