package com.example.chen.realtime.mvp.base;

import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2017/10/20.
 */

public interface BaseView extends MvpView{
    void showProgress();

    void onCompleted();

    void onError(Throwable e);
}
