package com.example.chen.realtime.mvp.presenter;

import com.example.chen.realtime.App;
import com.example.chen.realtime.bean.LiveInfo;
import com.example.chen.realtime.bean.LiveListResult;
import com.example.chen.realtime.bean.P;
import com.example.chen.realtime.bean.SearchRequestBody;
import com.example.chen.realtime.bean.SearchResult;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.view.ILiveListView;
import com.king.base.util.LogUtils;
import com.king.base.util.StringUtils;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/20.
 */

public class LiveListPresenter extends BasePresenter<ILiveListView> {
    public LiveListPresenter(App app) {
        super(app);
    }

    public void getLiveList(String slug){
        if (StringUtils.isBlank(slug)){
            getLiveList();
        }else {
            getLiveListBySlug(slug);
        }
    }

    public void getLiveList(){
        if (isViewAttached()){
            getView().showProgress();
        }
        getAppComponent().getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveListResult>() {
                    @Override
                    public void onCompleted() {
                        if (isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached())
                            getView().onError(e);

                    }

                    @Override
                    public void onNext(LiveListResult liveListResult) {
                        LogUtils.d("Response:"+liveListResult);

                        List<LiveInfo> list =null;
                        if (liveListResult != null){
                            list = liveListResult.getData();
                        }
                        if (isViewAttached())
                            getView().onGetLiveList(list);

                    }
                });

    }

    public void getLiveListBySlug(String slug){

        if (isViewAttached()){
            getView().showProgress();
        }
        getAppComponent().getAPIService()
                .getLiveListResult()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LiveListResult>() {
                    @Override
                    public void onCompleted() {
                        if (isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached())
                            getView().onError(e);
                    }

                    @Override
                    public void onNext(LiveListResult liveListResult) {
                        LogUtils.d("Response:" + liveListResult);
                        List<LiveInfo> list = null;
                        if (liveListResult!= null){
                            list = liveListResult.getData();
                        }
                        if (isViewAttached())
                            getView().onGetLiveList(list);

                    }
                });
    }
    public void getLiveListByKey(String key,int page){
        getLiveListByKey(key, page, P.DEFAULT_SIZE);
    }

    public void getLiveListByKey(String key,final int page,int pageSize){
        if (isViewAttached()){
            getView().showProgress();
        }
        getAppComponent().getAPIService()
                .search(SearchRequestBody.getInstance(new P(page,key,pageSize)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Func1<SearchResult, List<LiveInfo>>() {
                    @Override
                    public List<LiveInfo> call(SearchResult searchResult) {
                        LogUtils.d("Response:" + searchResult);
                        if (searchResult != null){
                            if (searchResult.getData()!=null){
                                return searchResult.getData().getItems();
                            }else {
                                LogUtils.d(searchResult.toString());
                            }
                        }
                        return null;
                    }
                });

    }
}
