package com.narkang.mvpdemo.model;

import com.narkang.mvpdemo.model.netBean.DailyListBean;
import com.narkang.mvpdemo.model.netBean.WelcomeBean;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Administrator on 2017/11/28.
 */

public interface HttpService {

    @GET("start-image/{res}")
    Observable<WelcomeBean> getWelcomeInfo(@Path("res") String res);

    @GET("news/latest")
    Observable<DailyListBean> getDailyList();
}
