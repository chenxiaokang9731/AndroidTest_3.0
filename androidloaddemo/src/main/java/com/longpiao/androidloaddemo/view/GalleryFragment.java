package com.longpiao.androidloaddemo.view;

import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.longpiao.androidloaddemo.R;

import butterknife.BindView;

/**
 * Created by chenxk on 2017/12/12.
 */

public class GalleryFragment extends BottomSheetDialogFragment implements GalleryView.SelectedChangeListener{

    private GalleryView mGvGallery;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        mGvGallery = root.findViewById(R.id.gv_gallery);
        mGvGallery.setUp(getLoaderManager(), this);
        return root;
    }

    @Override
    public void onSelectedCountChanged(int count) {

    }
}
