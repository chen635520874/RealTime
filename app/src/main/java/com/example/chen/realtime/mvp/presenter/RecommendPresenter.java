package com.example.chen.realtime.mvp.presenter;

import com.example.chen.realtime.App;
import com.example.chen.realtime.bean.AppStart;
import com.example.chen.realtime.bean.Recommend;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.view.IRecommendView;
import com.king.base.util.LogUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/20.
 */

public class RecommendPresenter extends BasePresenter<IRecommendView> {
    public RecommendPresenter(App app) {
        super(app);
    }

    public void getRecommend(){
        if (isViewAttached())
            getView().showProgress();

        getAppComponent().getAPIService()
                .getRecommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<Recommend>() {
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
                    public void onNext(Recommend recommend) {
                        LogUtils.d("Response:"+ recommend);
                        if (isViewAttached())
                            getView().onGetRecommend(recommend);

                        if (recommend !=null){
                            if (isViewAttached())
                                getView().onGetRooms(recommend.getRoom());
                        }
                    }
                });
    }

    public void getBanner(){
        getAppComponent().getAPIService()
                .getAppStartInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<AppStart>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(AppStart appStart) {
                        if (appStart != null){
                            if (isViewAttached())
                                getView().onGetBanner(appStart.getBanners());
                        }

                    }
                });

    }

}
