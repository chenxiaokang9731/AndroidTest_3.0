package com.narkang.util.retrofit_encapsulation;

import com.narkang.util.app.AppConstant;

import retrofit2.Retrofit;

public class RetrofitNet {

    private static Retrofit mRetrofit;

    public static <T> T getService(Class<T> clazz) {
        return retrofit().create(clazz);
    }

    private static Retrofit retrofit() {
        if (mRetrofit == null) {
            mRetrofit = RetrofitManager.getInstance().newRetrofit(AppConstant.getApiHost());
        }
        return mRetrofit;
    }

}
