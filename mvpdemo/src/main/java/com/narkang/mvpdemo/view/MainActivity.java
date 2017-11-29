package com.narkang.mvpdemo.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.narkang.mvpdemo.R;
import com.narkang.util.mvp.base.BaseActivity;
import com.narkang.util.recyclerview.NarDividerItemDecoration;
import com.narkang.util.recyclerview.NarRecyclerViewAdapter;
import com.narkang.util.recyclerview.NarViewHolder;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv)
    RecyclerView rv;

    private NarRecyclerViewAdapter mAdapter;
    private List<String> mActivityDatas = new ArrayList<String>(){
        {
            add("MVP框架模板");
        }
    };

    @Override
    protected void onBindView(@Nullable Bundle savedInstanceState) {
        rv.setLayoutManager(new LinearLayoutManager(this));
        NarDividerItemDecoration itemDecoration = new NarDividerItemDecoration();
        rv.addItemDecoration(itemDecoration);
        rv.setAdapter(mAdapter = new NarRecyclerViewAdapter<String>(mActivityDatas, R.layout.item_recyclerview) {
            @Override
            public void bindView(NarViewHolder viewHolder, String s) {
                viewHolder.setTextView(R.id.tv_1, s).addOnItemClickListener(R.id.tv_1);
            }
        });

        mAdapter.setOnItemChildClickListener(new NarRecyclerViewAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(NarRecyclerViewAdapter adapter, View view, int position) {
                switch (position){
                    case 0:
                        MainActivity.this.startActivity(new Intent(MainActivity.this, MVPActivity.class));
                        break;
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
}
