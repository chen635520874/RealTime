package com.example.chen.realtime.di.component;

import com.example.chen.realtime.di.module.CateroyModule;
import com.example.chen.realtime.di.module.LiveListModule;
import com.example.chen.realtime.di.scope.FragmentScope;
import com.example.chen.realtime.mvp.fragment.HomeFragment;
import com.example.chen.realtime.mvp.fragment.LiveListFragment;
import com.example.chen.realtime.mvp.presenter.CategoryPresenter;
import com.example.chen.realtime.mvp.presenter.LiveListPresenter;

import dagger.Component;

/**
 * Created by Administrator on 2017/10/27.
 */

@FragmentScope
@Component(modules = {CateroyModule.class,LiveListModule.class},dependencies = AppComponent.class)
public interface HomeComponent {

    void inject(HomeFragment homeFragment);
    void inject(LiveListFragment liveListFragment);

    CategoryPresenter getCateroyPresenter();

    LiveListPresenter getLiveListPresenter();

}