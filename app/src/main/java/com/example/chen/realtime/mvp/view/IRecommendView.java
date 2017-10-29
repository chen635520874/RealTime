package com.example.chen.realtime.mvp.view;

import com.example.chen.realtime.bean.Banner;
import com.example.chen.realtime.bean.Recommend;
import com.example.chen.realtime.mvp.base.BaseView;

import java.util.List;

/**
 * Created by Administrator on 2017/10/20.
 */

public interface IRecommendView extends BaseView {

    void onGetRecommend(Recommend recommend);

    void onGetRooms(List<Recommend.RoomBean> list);

    void onGetBanner(List<Banner> list);
}
