package com.example.chen.realtime.di.component;

import android.content.Context;

import com.example.chen.realtime.App;
import com.example.chen.realtime.di.module.AppModule;
import com.example.chen.realtime.http.converter.APIService;

import javax.inject.Singleton;

import dagger.Component;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by chen on 2017/10/18.
 */

@Singleton
@Component(modules= AppModule.class)
public interface AppComponent {
    void inject(App app);

    Context getContext();

    Retrofit getRetrofit();

    OkHttpClient getOkHttpClient();

    APIService getAPIService();

}
