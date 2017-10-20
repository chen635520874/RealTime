package com.example.chen.realtime.mvp.view;

import com.example.chen.realtime.bean.LiveInfo;
import com.example.chen.realtime.mvp.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public interface ILiveListView extends BaseView {
    void onGetLiveList(List<LiveInfo> list);
    void onMoreLiveList(List<LiveInfo> list);
}
