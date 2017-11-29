package com.narkang.mvpdemo.util.recy_divider;

import android.graphics.Color;

import com.narkang.util.recyclerview.NarDivider;
import com.narkang.util.recyclerview.NarDividerItemDecoration;

/**
 * Created by Administrator on 2017/11/29.
 */

public class DividerLookup extends NarDividerItemDecoration.SimpleDividerLookup{
    @Override
    public NarDivider getHorizontalDivider(int position) {
        return new NarDivider.Builder().color(Color.parseColor("#000000")).size(2).margin(100, 100).build();
    }
}
