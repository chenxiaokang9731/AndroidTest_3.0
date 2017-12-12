package com.longpiao.androidloaddemo.view;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenxk on 2017/12/12.
 */

public class GalleryView extends RecyclerView{

    private static final int LOADER_ID = 0x0100;
    private static final int MIN_IMAGE_FILE_SIZE = 10 * 1024; // 最小的图片大小

    private LoaderCallback mLoaderCallback = new LoaderCallback();
    private SelectedChangeListener mListener;

    private List<Image> mImages = new ArrayList<>();

    public GalleryView(Context context) {
        this(context, null);
    }

    public GalleryView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GalleryView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setUp(LoaderManager loaderManager, SelectedChangeListener listener){
        this.mListener = listener;
        loaderManager.initLoader(LOADER_ID, null, mLoaderCallback);
    }

    private class LoaderCallback implements LoaderManager.LoaderCallbacks<Cursor>{

        private final String[] IMAGE_PROJECTION = new String[]{
                MediaStore.Images.Media._ID, // Id
                MediaStore.Images.Media.DATA, // 图片路径
                MediaStore.Images.Media.DATE_ADDED // 图片的创建时间ø
        };

        /**
         * 根据给定的id初始化和创建一个loader
         * @param id
         * @param args
         * @return
         */
        @Override
        public Loader<Cursor> onCreateLoader(int id, Bundle args) {
            // 创建一个Loader
            if (id == LOADER_ID) {
                // 如果是我们的ID则可以进行初始化
                return new CursorLoader(getContext(),
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI,
                        IMAGE_PROJECTION,
                        null,
                        null,
                        IMAGE_PROJECTION[2] + " DESC"); // 倒序查询
            }
            return null;
        }

        /**
         * 当加载器完成加载，会被回调
         * @param loader
         * @param data
         */
        @Override
        public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
            mImages.clear();
            if(data != null){

                int count = data.getCount();
                if(count > 0){
                    data.moveToFirst();

                    int id_index = data.getColumnIndex(IMAGE_PROJECTION[0]);
                    int path_index = data.getColumnIndex(IMAGE_PROJECTION[1]);
                    int date_index = data.getColumnIndex(IMAGE_PROJECTION[2]);

                    do{
                        String img_path = data.getString(path_index);
                        File file = new File(img_path);
                        if(!file.exists() || file.length() < MIN_IMAGE_FILE_SIZE) continue;

                        Image image = new Image();
                        image.id = data.getInt(id_index);
                        image.path = img_path;
                        image.date = data.getLong(date_index);

                        mImages.add(image);
                    }while (data.moveToNext());
                }
            }
        }

        /**
         * 当Loader销毁或者重置了，会被回调
         * @param loader
         */
        @Override
        public void onLoaderReset(Loader<Cursor> loader) {

        }
    }

    /**
     * 内部的数据结构
     */
    private static class Image {
        int id; // 数据的ID
        String path; // 图片的路径
        long date; // 图片的创建日期
        boolean isSelect = false; // 是否选中

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Image image = (Image) o;

            return path != null ? path.equals(image.path) : image.path == null;
        }

        @Override
        public int hashCode() {
            return path != null ? path.hashCode() : 0;
        }
    }

    /**
     * 对外的一个监听器
     */
    public interface SelectedChangeListener {
        void onSelectedCountChanged(int count);
    }
}
