package com.example.chen.realtime;

import android.app.Application;

import com.example.chen.realtime.dao.greendao.DaoMaster;
import com.example.chen.realtime.dao.greendao.DaoSession;
import com.example.chen.realtime.di.component.AppComponent;
import com.example.chen.realtime.di.component.DaggerAppComponent;
import com.example.chen.realtime.di.module.AppModule;

/**
 * Created by chen on 2017/10/18.
 */

public class App extends Application {

    private DaoMaster.DevOpenHelper mHelper;
    private DaoSession mDaoSession;
    private AppComponent mAppComponent;

    public void onCreate(){
        super.onCreate();
        initDatabase();

        mAppComponent = DaggerAppComponent.builder().appModule(new AppModule(this,Constants.BASE_URL)).build();
    }

    public void initDatabase(){
        mHelper = new DaoMaster.DevOpenHelper(this,"tv-db",null);
        DaoMaster daoMaster = new DaoMaster(mHelper.getWritableDatabase());
        mDaoSession = daoMaster.newSession();
    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }

    public DaoSession getDaoSession(){
        return mDaoSession;
    }
}
