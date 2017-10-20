package com.example.chen.realtime.mvp.presenter;

import com.example.chen.realtime.App;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.view.IChatView;

/**
 * Created by Administrator on 2017/10/20.
 */

public class ChatPresenter extends BasePresenter<IChatView> {
    public ChatPresenter(App app) {
        super(app);
    }
}
