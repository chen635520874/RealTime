package com.example.chen.realtime.di.module;

import com.example.chen.realtime.App;
import com.example.chen.realtime.di.scope.FragmentScope;
import com.example.chen.realtime.mvp.presenter.LiveListPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/10/19.
 */

@Module
public class LiveListModule {
    private App app;

    public LiveListModule(App app){
        this.app =app;
    }


    @FragmentScope
    @Provides
    public LiveListPresenter provideLiveListPresenter(){
        return new LiveListPresenter(app);
    }
}
