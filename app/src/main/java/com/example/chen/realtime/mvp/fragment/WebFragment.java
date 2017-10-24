package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.chen.realtime.R;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class WebFragment extends SimpleFragment {

    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.progressBar)
    ProgressBar progressBar;
    @BindView(R.id.vError)
    LinearLayout vError;
    @BindView(R.id.webView)
    WebView webView;

    private String url;
    private String title;

    protected boolean isError;
    private boolean isShowError;

    public static WebFragment newInstance(String url,String title){
        Bundle args = new Bundle();

        WebFragment fragment = new WebFragment();
        fragment.url = url;
        fragment.title = title;
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return 0;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void initData() {

    }
}
