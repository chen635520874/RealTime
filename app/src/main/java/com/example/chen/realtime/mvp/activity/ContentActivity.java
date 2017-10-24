package com.example.chen.realtime.mvp.activity;

import android.content.Intent;
import android.icu.text.Replaceable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.example.chen.realtime.Constants;
import com.example.chen.realtime.R;

/**
 * Created by Administrator on 2017/10/19.
 */

public class ContentActivity extends AppCompatActivity{

   /* public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
    }*/

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content);
        swichFragment(getIntent());
    }

    public void swichFragment(Intent intent){
        int fragmentKey = intent.getIntExtra(Constants.KEY_FRAGMENT,0);
        switch (fragmentKey){
            case  Constants.ROOM_FRAGMENT:
                replaceFragment(RoomFragment);
        }
    }

    public void replaceFragment(Fragment fragment){

    }
}
