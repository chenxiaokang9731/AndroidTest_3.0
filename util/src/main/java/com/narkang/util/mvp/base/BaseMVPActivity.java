package com.narkang.util.mvp.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.narkang.util.type.TUtil;

/**
 * Created by Administrator on 2017/11/28.
 * base MVP service
 */
public abstract class BaseMVPActivity<P extends BasePresenter, M extends BaseModel> extends BaseActivity implements BaseView{

    protected P mPresenter;
    protected M mModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        mPresenter.attachVM(this, mModel);

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(mPresenter != null){
            mPresenter.detachVM();
        }
    }

    @Override
    public Context getContext() {
        return mContext;
    }

    @Override
    public void dealMsgError(String msg) {
    }
}
