package com.narkang.mvpdemo.view;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.narkang.mvpdemo.R;
import com.narkang.mvpdemo.contract.HttpContract;
import com.narkang.mvpdemo.model.HttpModel;
import com.narkang.mvpdemo.model.netBean.DailyListBean;
import com.narkang.mvpdemo.model.netBean.WelcomeBean;
import com.narkang.mvpdemo.presenter.HttpPresenter;
import com.narkang.util.mvp.base.BaseMVPActivity;

import butterknife.BindView;

public class MVPActivity extends BaseMVPActivity<HttpPresenter, HttpModel> implements HttpContract.View{

    @BindView(R.id.tv)
    TextView tv;

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {
        mPresenter.getDailyList();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_mvp;
    }

    @Override
    public void getWelecomeDataSuccess(WelcomeBean welcomeBean) {

    }

    @Override
    public void getDailyList(DailyListBean respBean) {
        tv.setText(respBean.toString());
    }
}
