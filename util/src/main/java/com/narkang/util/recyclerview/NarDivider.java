package com.narkang.util.recyclerview;

import android.support.annotation.ColorInt;

/**
 * Created by Administrator on 2017/11/2.
 */

public class NarDivider {
    @ColorInt
    public int color;
    public int size;
    public int marginStart;
    public int marginEnd;

    private NarDivider() {
    }

    public static class Builder {
        private int color;
        private int size;
        private int marginStart;
        private int marginEnd;

        public Builder color(int color) {
            this.color = color;
            return this;
        }

        public Builder size(int size) {
            this.size = size;
            return this;
        }

        public Builder margin(int marginStart, int marginEnd) {
            this.marginStart = marginStart;
            this.marginEnd = marginEnd;
            return this;
        }

        public NarDivider build() {
            NarDivider divider = new NarDivider();
            divider.size = this.size;
            divider.color = this.color;
            divider.marginStart = this.marginStart;
            divider.marginEnd = this.marginEnd;
            return divider;
        }

    }
}
