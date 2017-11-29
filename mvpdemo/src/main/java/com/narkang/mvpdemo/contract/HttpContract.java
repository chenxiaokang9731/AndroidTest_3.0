package com.narkang.mvpdemo.contract;

import com.narkang.mvpdemo.model.HttpModel;
import com.narkang.mvpdemo.model.netBean.DailyListBean;
import com.narkang.mvpdemo.model.netBean.WelcomeBean;
import com.narkang.util.mvp.base.BasePresenter;
import com.narkang.util.mvp.base.BaseView;

/**
 * Created by Administrator on 2017/11/29.
 */

public interface HttpContract {

    interface View extends BaseView{
        void getWelecomeDataSuccess(WelcomeBean welcomeBean);

        void getDailyList(DailyListBean respBean);
    }

    abstract class Presenter extends BasePresenter<View, HttpModel>{
        public abstract void getWelecomData(String res);

        public abstract void getDailyList();
    }
}
