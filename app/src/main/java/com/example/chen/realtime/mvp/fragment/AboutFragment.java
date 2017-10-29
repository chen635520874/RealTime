package com.example.chen.realtime.mvp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.realtime.R;
import com.king.base.util.SystemUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/26.
 */

public class AboutFragment extends SimpleFragment {

    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvVersion)
    TextView tvVersion;
    @BindView(R.id.tvAuthor)
    TextView tvAuthor;
    @BindView(R.id.tvCSDN)
    TextView tvCSDN;
    @BindView(R.id.tvGitHub)
    TextView tvGitHub;

    public static AboutFragment newInstance() {

        Bundle args = new Bundle();

        AboutFragment fragment = new AboutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_about;
    }

    @Override
    public void initUI() {
        tvTitle.setText(R.string.about);

        tvVersion.setText(String.format(getString(R.string.current_version_), SystemUtils.getVersionName(context)));
    }

    @Override
    public void initData() {

    }

    private void clickEmail(){
        Uri uri = Uri.parse("mailto:chen63552874@gmail.com");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        startActivity(Intent.createChooser(intent, "Choose Email Client"));
    }

    @OnClick({R.id.ivLeft,R.id.tvCSDN, R.id.tvGitHub})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                finish();
                break;
            case R.id.tvCSDN:
                startWeb("CodeChenL",tvCSDN.getText().toString());
                break;
            case R.id.tvGitHub:
                startWeb("CodeChenL",tvGitHub.getText().toString());
                break;
        }
    }
}
