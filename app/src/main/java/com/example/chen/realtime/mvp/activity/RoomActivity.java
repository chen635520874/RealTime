package com.example.chen.realtime.mvp.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.WindowManager;

import com.example.chen.realtime.Constants;
import com.example.chen.realtime.R;
import com.example.chen.realtime.mvp.base.PureActivity;
import com.example.chen.realtime.mvp.fragment.RoomFragment;

/**
 * Created by Administrator on 2017/10/27.
 */

public class RoomActivity extends PureActivity {


    private RoomFragment roomFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_HIDE_NAVIGATION//隐藏虚拟按键(导航栏)。有些手机会用虚拟按键来代替物理按键
                    |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }

        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getRootViewId() {
        return R.layout.content;
    }

    @Override
    public void initUI() {
        roomFragment = RoomFragment.newInstance(getIntent().getStringExtra(Constants.KEY_UID));
        replaceFragment(roomFragment);
    }
}
