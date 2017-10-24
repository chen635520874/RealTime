package com.example.chen.realtime.mvp.fragment;

import com.example.chen.realtime.bean.Recommend;
import com.example.chen.realtime.bean.Room;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.presenter.RoomPresenter;
import com.example.chen.realtime.mvp.view.IRoomView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class RoomFragment extends BaseFragment <IRoomView,RoomPresenter> implements IRoomView{
    @Override
    public void showProgress() {

    }

    @Override
    public void onCompleted() {

    }

    @Override
    public void onError(Throwable e) {

    }

    @Override
    public void enterRoom(Room room) {

    }

    @Override
    public void playUrl(String url) {

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

    @Override
    public Recommend.RoomBean createPresenter() {
        return null;
    }
}
