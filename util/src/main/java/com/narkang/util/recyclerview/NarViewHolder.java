package com.narkang.util.recyclerview;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/29.
 */

public class NarViewHolder extends RecyclerView.ViewHolder {

    private NarRecyclerViewAdapter mAdapter;
    private SparseArray<View> mViews;

    public NarViewHolder(View itemView) {
        super(itemView);
        mViews = new SparseArray<>();

        //设置onItemClick
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAdapter.mClickListener != null){
                    mAdapter.mClickListener.onItemClick(mAdapter, v, getLayoutPosition());
                }
            }
        });
    }

    public NarViewHolder setTextView(@IdRes int idRes, String msg){
        TextView tv = getView(idRes);
        tv.setText(msg);
        return this;
    }

    public TextView getTextView(@IdRes int idRes){
        TextView tv = getView(idRes);
        return tv;
    }

    public NarViewHolder setImageViewRes(@IdRes int idRes, @DrawableRes int drawableRes){
        ImageView iv = getView(idRes);
        iv.setImageResource(drawableRes);
        return this;
    }

    public NarViewHolder setImageViewBitmap(@IdRes int idRes, Bitmap bitmap){
        ImageView iv = getView(idRes);
        iv.setImageBitmap(bitmap);
        return this;
    }

    public ImageView getImageView(@IdRes int idRes){
        ImageView iv = getView(idRes);
        return iv;
    }

    public NarViewHolder addOnItemClickListener(@IdRes int idRes){
        View view = getView(idRes);
        if(view != null){
            if(!view.isClickable()){
                view.setClickable(true);
            }
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mAdapter.mListener != null){
                        mAdapter.mListener.onItemChildClick(mAdapter, v, getLayoutPosition());
                    }
                }
            });
        }
        return this;
    }

    public <T extends View> T getView(@IdRes int idRes){
        View view = mViews.get(idRes);
        if(view == null){
            view = itemView.findViewById(idRes);
            mViews.put(idRes, view);
        }
        return (T)view;
    }

    protected NarViewHolder setAdapter(NarRecyclerViewAdapter adapter){
        this.mAdapter = adapter;
        return this;
    }
}
