package com.example.chen.realtime.thread;

/**
 * Created by chen on 2017/10/18.
 */

public class ThreadPoolManager {

    private static ThreadPoolProxy mInstance;

    public static ThreadPoolProxy getInstance(){
        if (mInstance==null){
            synchronized (ThreadPoolManager.class){
                if (mInstance==null){
                    mInstance = new ThreadPoolProxy();
                }
            }
        }

        return mInstance;
    }

    public static class ThreadPoolProxy{

    }
}
