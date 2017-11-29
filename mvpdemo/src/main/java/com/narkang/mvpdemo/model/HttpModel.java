package com.narkang.mvpdemo.model;

import com.narkang.mvpdemo.model.netBean.DailyListBean;
import com.narkang.mvpdemo.model.netBean.WelcomeBean;
import com.narkang.util.mvp.base.BaseModel;
import com.narkang.util.retrofit_encapsulation.RetrofitNet;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/11/29.
 */

public class HttpModel implements BaseModel{

     public Observable<WelcomeBean> getWelecomeData(String res){
        return RetrofitNet.getService(HttpService.class).getWelcomeInfo(res);
     }

    public Observable<DailyListBean> getDailyList(){
        return RetrofitNet.getService(HttpService.class).getDailyList();
    }
}
