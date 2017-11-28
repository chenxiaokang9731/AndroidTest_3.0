package com.narkang.util.recyclerview;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/11/28.
 */
public abstract class NarRecyclerViewAdapter<Data> extends RecyclerView.Adapter<NarRecyclerViewAdapter.ViewHolder>{

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

    public void setLayoutRes(@LayoutRes int layoutRes){
        this.mLayoutRes = layoutRes;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(mLayoutRes, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = mDataList.get(position);
        bindView(holder, data);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public abstract void bindView(ViewHolder viewHolder, Data data);

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
        }

        public ViewHolder setTextView(@IdRes int idRes, String msg){
            TextView tv = itemView.findViewById(idRes);
            tv.setText(msg);
            return this;
        }

        public TextView getTextView(@IdRes int idRes){
            TextView tv = itemView.findViewById(idRes);
            return tv;
        }

        public ViewHolder setImageViewRes(@IdRes int idRes, @DrawableRes int drawableRes){
            ImageView iv = itemView.findViewById(idRes);
            iv.setImageResource(drawableRes);
            return this;
        }

        public ViewHolder setImageViewBitmap(@IdRes int idRes, Bitmap bitmap){
            ImageView iv = itemView.findViewById(idRes);
            iv.setImageBitmap(bitmap);
            return this;
        }

        public ImageView getImageView(@IdRes int idRes){
            ImageView iv = itemView.findViewById(idRes);
            return iv;
        }
    }
}
