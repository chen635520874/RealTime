package com.example.chen.realtime.mvp.fragment;

import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.base.BaseView;

/**
 * Created by Administrator on 2017/10/24.
 */

public abstract class SimpleFragment extends BaseFragment <BaseView,BasePresenter<BaseView>> {

    @Override
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter<>(getApp());
    }
}
