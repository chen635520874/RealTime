package com.example.chen.realtime.mvp.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.example.chen.realtime.App;
import com.example.chen.realtime.R;

/**
 * Created by Administrator on 2017/10/20.
 */

public abstract class PureActivity extends AppCompatActivity {

    private static final int INVALID_VAL = -1;
    private static final int COLOR_DEFAULT = Color.parseColor("#7f000000");

    protected Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        }
        context  =this;
        setContentView(getRootViewId());

        initUI();
    }

    public void replaceFragment(Fragment fragmnet){
        replaceFragment(R.id.fragmentContent,fragmnet);
    }

    public void replaceFragment(@IdRes int id, Fragment fragmnet){
        getSupportFragmentManager().beginTransaction().replace(id, fragmnet).commit();
    }

    public App getApp(){
        return (App) getApplication();
    }


    /**
     * 状态栏颜色，高度
     */

    public void setStatusViewColorDefault(){
        setStatusViewColor(COLOR_DEFAULT);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public void setStatusViewColor(int statusColor){
        if (Build.VERSION.SDK_INT >=Build.VERSION_CODES.LOLLIPOP){
            if (statusColor != INVALID_VAL){
                getWindow().setStatusBarColor(statusColor);
            }
            return;
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT <Build.VERSION_CODES.LOLLIPOP){
            int color = COLOR_DEFAULT;
            ViewGroup contentView = (ViewGroup) findViewById(android.R.id.content);
            if (statusColor != INVALID_VAL){
                color =statusColor;
            }
            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    getStatusBarHeight(this));
            statusBarView.setBackgroundColor(color);
            contentView.addView(statusBarView,lp);
        }
    }

    public int getStatusBarHeight(Context context){
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId>0){
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return  result;
    }





    public abstract int getRootViewId();
    public abstract void initUI();
}
