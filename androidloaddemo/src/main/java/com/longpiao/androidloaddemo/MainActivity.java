package com.longpiao.androidloaddemo;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.longpiao.androidloaddemo.view.GalleryFragment;
import com.narkang.util.mvp.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {
        findViewById(R.id.tv_choose_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new GalleryFragment().show(getSupportFragmentManager(), GalleryFragment.class.getName());
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

}
