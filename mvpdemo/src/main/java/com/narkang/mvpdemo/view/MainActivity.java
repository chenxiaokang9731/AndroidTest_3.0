package com.narkang.mvpdemo.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.narkang.mvpdemo.R;
import com.narkang.util.mvp.base.BaseActivity;
import com.narkang.util.recyclerview.NarDividerItemDecoration;
import com.narkang.util.recyclerview.NarRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {

        List<String> mData = new ArrayList<>();
        mData.add("1");
        mData.add("1");
        mData.add("1");
        mData.add("1");

        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new NarDividerItemDecoration(this, NarDividerItemDecoration.VERTICAL_LIST));
        rv.setAdapter(new NarRecyclerViewAdapter<String>(mData, R.layout.item_recyclerview) {
            @Override
            public void bindView(ViewHolder viewHolder, String s) {
                viewHolder.setTextView(R.id.tv_1, s);
            }
        });

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
