package com.example.chen.realtime.mvp.fragment;

import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.example.chen.realtime.R;
import com.example.chen.realtime.bean.Banner;
import com.example.chen.realtime.bean.Recommend;
import com.example.chen.realtime.mvp.adapter.RecommendAdapter;
import com.jude.easyrecyclerview.EasyRecyclerView;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/23.
 */

public class RecommendFragment {
    private ConvenientBanner<Banner> convenientBanner;

    private TextView tvTips;
    @BindView(R.id.easyRecyclerView)
    EasyRecyclerView easyRecyclerView;

    RecommendAdapter
}
