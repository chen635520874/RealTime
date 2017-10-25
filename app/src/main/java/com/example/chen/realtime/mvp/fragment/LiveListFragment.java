package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.chen.realtime.R;
import com.example.chen.realtime.bean.LiveInfo;
import com.example.chen.realtime.bean.P;
import com.example.chen.realtime.mvp.adapter.EasyLiveAdapter;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.presenter.LiveListPresenter;
import com.example.chen.realtime.mvp.view.ILiveListView;
import com.example.chen.realtime.util.DensityUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.SpaceDecoration;
import com.king.base.util.LogUtils;
import com.king.base.util.StringUtils;
import com.king.base.util.SystemUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class LiveListFragment extends BaseFragment<ILiveListView,LiveListPresenter> implements ILiveListView {

    View loadMore;
    TextView tvEmpty;
    TextView tvTips;

    @BindView(R.id.easyRecyclerView)
    EasyRecyclerView easyRecyclerView;
    EasyLiveAdapter easyLiveAdapter;

    List<LiveInfo> listData;

    private String slug;
    private boolean isSearch;
    private int page;
    private String key;
    private boolean isMore;

    public static LiveListFragment newInstance(String slug){
        return newInstance(slug,false);
    }
    public static LiveListFragment newInstance(String slug,boolean isSearch){
        Bundle args = new Bundle();

        LiveListFragment fragment = new LiveListFragment();
        fragment.slug = slug;
        fragment.isSearch = isSearch;
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

        LogUtils.w(e);
        if (SystemUtils.isNetWorkActive(context)){
            tvTips.setText(R.string.page_load_failed);
        }else {
            tvTips.setText(R.string.network_unavailable);
        }
        easyRecyclerView.showError();

    }

    @Override
    public LiveListPresenter createPresenter() {
        return null;
    }

    @Override
    public void onGetLiveList(List<LiveInfo> list) {
        easyLiveAdapter.clear();
        easyLiveAdapter.addAll(list);
        refreshView();
    }
    public void onGetMoreLiveList(List<LiveInfo> list){
        easyLiveAdapter.addAll(list);
        refreshView();
    }

    @Override
    public void onMoreLiveList(List<LiveInfo> list) {

    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_live_list;
    }

    @Override
    public void initUI() {
        tvTips = (TextView) easyRecyclerView.findViewById(R.id.tvTips);
        tvEmpty = (TextView) easyRecyclerView.findViewById(R.id.tvEmpty);

        SpaceDecoration spaceDecoration = new SpaceDecoration(DensityUtil.dp2px(context,6));
        easyRecyclerView.addItemDecoration(spaceDecoration);

        easyRecyclerView.setRefreshingColorResources(R.color.progress_color);
        listData = new ArrayList<>();
        easyLiveAdapter = new EasyLiveAdapter(context,listData,isSearch);
        easyLiveAdapter.setNotifyOnChange(false);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,2);
        easyRecyclerView.setLayoutManager(gridLayoutManager);

        easyRecyclerView.setAdapter(easyLiveAdapter);
        easyRecyclerView.setRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isSearch){
                    if (!StringUtils.isBlank(key)){
                        page =0;
                        getPresenter().getLiveListByKey(key,page);
                    }
                }else {
                    getPresenter().getLiveList(slug);
                }
            }
        });
        if (isSearch){
            loadMore = LayoutInflater.from(context).inflate(R.layout.load_more,null);
            easyLiveAdapter.setMore(loadMore, new RecyclerArrayAdapter.OnMoreListener() {
                @Override
                public void onMoreShow() {
                    if (isMore){
                        if (loadMore != null){
                            loadMore.setVisibility(View.VISIBLE);
                        }
                        getPresenter().getLiveListByKey(key,page);
                    }
                }

                @Override
                public void onMoreClick() {

                }
            });
        }
        easyLiveAdapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                startRoom(easyLiveAdapter.getItem(position));
            }
        });
    }


    /**
     * 搜索
     * @param key
     * @param page
     */
    public void search(String key,int page){
        this.key = key;
        this.page = page;
        getPresenter().getLiveListByKey(key, page);
    }

    @Override
    public void initData() {
        if (!isSearch){
            easyRecyclerView.showProgress();
            getPresenter().getLiveList(slug);
        }
    }

    public LiveListPresenter creatPresenter(){
        return new LiveListPresenter(getApp());
    }

    public void refreshView(){
        easyLiveAdapter.notifyDataSetChanged();
        easyRecyclerView.setRefreshing(false);
        if (easyLiveAdapter.getCount() == 0){
            if (isSearch){
                if (SystemUtils.isNetWorkActive(context)){
                    tvEmpty.setText(R.string.can_not_find_relevant_content);
                }else {
                    tvTips.setText(R.string.network_unavailable);
                }
            }else {
                tvEmpty.setText(R.string.swipe_down_to_refresh);
            }
            easyRecyclerView.showEmpty();
        }
        if (isSearch){
            if (easyLiveAdapter.getCount()>=(page+1)* P.DEFAULT_SIZE){
                page++;
                isMore = true;
            }else{
                if (loadMore !=null){
                    loadMore.setVisibility(View.GONE);
                }
                isMore = false;
            }
        }
    }


}















