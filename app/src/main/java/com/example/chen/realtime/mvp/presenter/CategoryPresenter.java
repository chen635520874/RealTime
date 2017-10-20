package com.example.chen.realtime.mvp.presenter;

import com.example.chen.realtime.App;
import com.example.chen.realtime.bean.LiveCategory;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.view.ICategoryView;
import com.example.chen.realtime.thread.ThreadPoolManager;
import com.king.base.util.LogUtils;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Administrator on 2017/10/20.
 */

public class CategoryPresenter extends BasePresenter<ICategoryView> {

    @Inject
    public CategoryPresenter(App app) {
        super(app);
    }

    public void getAllCategories(){
        getView().showProgress();
        getAppComponent().getAPIService()
                .getAllCategories()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<LiveCategory>>() {
                    @Override
                    public void onCompleted() {
                        if (isViewAttached())
                            getView().onCompleted();
                    }

                    @Override
                    public void onError(Throwable e) {
                        if (isViewAttached()){
                            getView().onError(e);
                        }

                    }

                    @Override
                    public void onNext(final List<LiveCategory> list) {
                        LogUtils.d("Response:" + list);

                        ThreadPoolManager.getInstance().execute(new Runnable() {
                            @Override
                            public void run() {
                                getDaoSession().getLiveCategoryDao().insertOrReplaceInTx(list);
                            }
                        });
                        if (isViewAttached())
                            getView().onGetLiveCategory(list);

                    }
                });
    }


    public void getAllCategoriesByDB(){
        List<LiveCategory> list = getDaoSession().getLiveCategoryDao().loadAll();
        LogUtils.d("list:"+list);
        if (list!=null&&list.size()>0){
            if (isViewAttached()){
                getView().onGetLiveCategory(list);
            }
        }
    }

}
