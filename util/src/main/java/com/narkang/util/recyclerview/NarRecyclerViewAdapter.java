package com.narkang.util.recyclerview;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public abstract class NarRecyclerViewAdapter<Data> extends RecyclerView.Adapter<NarViewHolder>{

    private List<Data> mDataList;
    private int mLayoutRes = -1;

    @SuppressWarnings("unused")
    public NarRecyclerViewAdapter(){
        this(null);
    }

    public NarRecyclerViewAdapter(List<Data> dataList){
        this.mDataList = dataList;
    }

    public NarRecyclerViewAdapter(List<Data> dataList, @LayoutRes int layoutRes){
        this.mDataList = dataList;
        this.mLayoutRes = layoutRes;
    }

    @SuppressWarnings("unused")
    public void setLayoutRes(@LayoutRes int layoutRes){
        this.mLayoutRes = layoutRes;
    }

    @Override
    public NarViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if(mLayoutRes == -1){
            throw new RuntimeException("layout is null!!");
        }

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(mLayoutRes, parent, false);

        return new NarViewHolder(view).setAdapter(this);
    }

    @Override
    public void onBindViewHolder(NarViewHolder holder, int position) {
        Data data = mDataList.get(position);
        bindView(holder, data);
    }

    @Override
    public int getItemCount() {
        return mDataList == null? 0: mDataList.size();
    }

    public abstract void bindView(NarViewHolder viewHolder, Data data);

    OnItemChildClickListener mListener;

    public interface OnItemChildClickListener{
        void onItemChildClick(NarRecyclerViewAdapter adapter, View view, int position);
    }

    public void setOnItemChildClickListener(OnItemChildClickListener listener){
        this.mListener = listener;
    }
}
