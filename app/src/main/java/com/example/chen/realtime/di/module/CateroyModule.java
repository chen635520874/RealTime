package com.example.chen.realtime.di.module;

import com.example.chen.realtime.App;
import com.example.chen.realtime.di.scope.FragmentScope;
import com.example.chen.realtime.mvp.presenter.CategoryPresenter;

import dagger.Provides;

/**
 * Created by Administrator on 2017/10/20.
 */

public class CateroyModule {

    private App app;

    public CateroyModule(App app) {
        this.app = app;
    }
    @FragmentScope
    @Provides
    public CategoryPresenter provideCateroyPresenter(){
        return new CategoryPresenter(app);
    }

}
