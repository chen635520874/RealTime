package com.example.chen.realtime.mvp.view;

import com.example.chen.realtime.bean.Room;
import com.example.chen.realtime.mvp.base.BaseView;

/**
 * Created by Administrator on 2017/10/20.
 */

public interface IRoomView extends BaseView {

    void enterRoom(Room room);

    void playUrl(String url);
}
