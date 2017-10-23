package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.chen.realtime.R;
import com.example.chen.realtime.bean.LiveCategory;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.presenter.CategoryPresenter;
import com.example.chen.realtime.mvp.view.ICategoryView;
import com.king.base.adapter.ViewPagerFragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/23.
 */

public class HomeFragment extends BaseFragment <ICategoryView,CategoryPresenter> implements ICategoryView {

    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.ivTitle)
    ImageView ivTitle;
    @BindView(R.id.ivRight)
    ImageView ivRight;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.btnMore)
    ImageView btnMore;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

/*
    @BindView(R.id.fab)
    FloatingActionButton fab;*/

    private ViewPagerFragmentAdapter viewPagerFragmentAdapter;
    private List<LiveCategory> listCategory;
    private List<CharSequence> listTitle;
    private List<Fragment> listData;

    public static HomeFragment newInstance(){
        Bundle args = new Bundle();
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void onGetLiveCategory(List<LiveCategory> list) {

        if (list != null){
            toSetList(listCategory,list,false);
            listData.clear();
            List<CharSequence> listTemp = new ArrayList<>();

            //----------------------------------------
            listTemp.add(getText(R.string.recommend));
            listData.add(RecommendFragment.)
        }


    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initUI() {
        listCategory = new ArrayList<>();
        listTitle = new ArrayList<>();
        listData = new ArrayList<>();

        viewPagerFragmentAdapter = new ViewPagerFragmentAdapter(getChildFragmentManager(),listData,listTitle);
        viewPager.setAdapter(viewPagerFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);//使tab和viewPager联动来

    }

    @Override
    public void initData() {
        getPresenter().getAllCategories();

    }

    @Override
    public CategoryPresenter createPresenter() {
        return new CategoryPresenter(getApp());
    }
}
