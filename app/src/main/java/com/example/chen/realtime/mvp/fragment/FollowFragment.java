package com.example.chen.realtime.mvp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chen.realtime.Constants;
import com.example.chen.realtime.R;
import com.example.chen.realtime.register.Login;
import com.example.chen.realtime.register.Resetpwd;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/23.
 */

public class FollowFragment extends SimpleFragment {

    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.ivRight)
    ImageView ivRight;
    @BindView(R.id.tvLogin)
    TextView tvLogin;

    public static FollowFragment newInstance() {

        Bundle args = new Bundle();

        FollowFragment fragment = new FollowFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_follow;
    }

    @Override
    public void initUI() {
        tvTitle.setText(R.string.tab_follw);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ivLeft, R.id.ivRight, R.id.tvLogin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                startActivity(getFragmentIntent(Constants.SEARCH_FRAGMENT));
                break;
            case R.id.ivRight:
                startLogin();
                break;
            case R.id.tvLogin:
                //Toast.makeText(context,"111",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(),Login.class);
                startActivity(intent);
        }
    }
}
