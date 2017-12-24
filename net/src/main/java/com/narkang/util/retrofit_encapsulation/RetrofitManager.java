package com.narkang.util.retrofit_encapsulation;

import android.content.Context;
import android.util.Log;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 介绍：通过这个类 获取 Retrofit的实例。
 * 使用者 通过这个Retrofit实例，创建Api Service
 * 作者：zhangxutong 
 * 邮箱：mcxtzhang@163.com
 * 主页：http://blog.csdn.net/zxt0601
 * 时间： 2017/2/28.
 */
public class RetrofitManager {
    private static Context mContext;

    private OkHttpClient mOkHttpClient;

    private static class InnerHolder {
        private static RetrofitManager INSTACE = new RetrofitManager();
    }

    /**
     * 需要context时候调用，可以在Application中调用
     * @param context
     */
    public static void init(Context context) {
        //防止内存泄露
        mContext = context.getApplicationContext();
    }

    public static RetrofitManager getInstance() {
        return InnerHolder.INSTACE;
    }

    public Retrofit newRetrofit(String url) {
        // 拿到Retrofit实例
        return new Retrofit.Builder()
                .baseUrl(url)

                //引入Gson解析库 ，就可以直接以实体的形式拿到返回值
                //.addConverterFactory(GsonConverterFactory.create())

                //加入我们自定义的Gson解析库，就可以更友好的处理错误
                .addConverterFactory(GsonConverterFactory.create())

                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                //将我们客制化的OkHttp实例传入
                .client(mOkHttpClient)
                .build();
    }


    private RetrofitManager() {
        //在构造方法里 最终是为了得到一个单例的OkhttpClient实例
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        //加入自己业务需要的拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.i("OkHttp", message);
            }
        });

        //缓存设置
        //构建缓存位置
        mOkHttpClient = builder.addInterceptor(loggingInterceptor).build();
    }
}
