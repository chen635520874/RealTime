package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;

import com.example.chen.realtime.R;

/**
 * Created by Administrator on 2017/10/26.
 */

public class AboutFragment extends SimpleFragment {

    public static AboutFragment newInstance(){
        Bundle args =new Bundle();

        AboutFragment aboutFragment= new AboutFragment();
        aboutFragment.setArguments(args);
        return aboutFragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_about;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }
}
