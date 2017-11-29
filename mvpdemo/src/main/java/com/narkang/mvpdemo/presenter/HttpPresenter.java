package com.narkang.mvpdemo.presenter;

import com.narkang.mvpdemo.contract.HttpContract;
import com.narkang.mvpdemo.model.netBean.DailyListBean;
import com.narkang.mvpdemo.model.netBean.WelcomeBean;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class HttpPresenter extends HttpContract.Presenter{

    @Override
    public void getWelecomData(String res) {
        rxManager.add(mModel.getWelecomeData(res).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<WelcomeBean>() {
            @Override
            public void accept(WelcomeBean welcomeBean) throws Exception {
                mView.getWelecomeDataSuccess(welcomeBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.dealMsgError(throwable.getMessage());
            }
        }));
    }

    @Override
    public void getDailyList() {
        rxManager.add(mModel.getDailyList().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<DailyListBean>() {
            @Override
            public void accept(DailyListBean dailyListBean) throws Exception {
                mView.getDailyList(dailyListBean);
            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {
                mView.dealMsgError(throwable.getMessage());
            }
        }));
    }
}
