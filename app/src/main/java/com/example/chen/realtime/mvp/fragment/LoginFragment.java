package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chen.realtime.R;
import com.king.base.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/26.
 */

public class LoginFragment extends SimpleFragment {


    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.tvRight)
    TextView tvRight;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.etUsername)
    EditText etUsername;
    @BindView(R.id.etPassword)
    EditText etPassword;
    @BindView(R.id.btnLogin)
    Button btnLogin;
    @BindView(R.id.tvForgetPwd)
    TextView tvForgetPwd;
    @BindView(R.id.ivQQ)
    ImageView ivQQ;
    @BindView(R.id.ivSina)
    ImageView ivSina;
    @BindView(R.id.ivWeixin)
    ImageView ivWeixin;


    public static LoginFragment newInstance() {

        Bundle args = new Bundle();

        LoginFragment fragment = new LoginFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_login;
    }

    @Override
    public void initUI() {
        tvTitle.setText(R.string.login);
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ivLeft, R.id.tvRight, R.id.btnLogin, R.id.tvForgetPwd, R.id.ivQQ, R.id.ivSina, R.id.ivWeixin})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                finish();
                break;
            case R.id.tvRight:
                ToastUtils.showToast(context,R.string.signup);
                break;
            case R.id.btnLogin:
                ToastUtils.showToast(context,R.string.login);
                break;
            case R.id.tvForgetPwd:
                ToastUtils.showToast(context,R.string.forget_password);
                break;
            case R.id.ivQQ:
                Toast.makeText(context,"该功能暂未开放哟！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivSina:
                Toast.makeText(context,"该功能暂未开放哟！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.ivWeixin:
                Toast.makeText(context,"该功能暂未开放哟！",Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
