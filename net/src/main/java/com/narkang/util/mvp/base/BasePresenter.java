package com.narkang.util.mvp.base;

import com.narkang.util.rx_encapsulation.RxManager;

/**
 * Created by Administrator on 2017/11/28.
 */

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {

    protected V mView;
    protected M mModel;
    protected RxManager rxManager = new RxManager();

    public void attachVM(V view, M model) {
        mView = view;
        mModel = model;
    }

    public void detachVM(){
        rxManager.clear();
        mView = null;
        mModel = null;
    }
}
