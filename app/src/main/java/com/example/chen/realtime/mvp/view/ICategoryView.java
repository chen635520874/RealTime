package com.example.chen.realtime.mvp.view;

import com.example.chen.realtime.bean.LiveCategory;
import com.example.chen.realtime.mvp.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public interface ICategoryView extends BaseView {
    void onGetLiveCategory(List<LiveCategory> list);
}
