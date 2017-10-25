package com.example.chen.realtime.mvp.fragment;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.chen.realtime.R;
import com.example.chen.realtime.bean.Recommend;
import com.example.chen.realtime.bean.Room;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.presenter.RoomPresenter;
import com.example.chen.realtime.mvp.view.IRoomView;
import com.example.chen.realtime.util.DensityUtil;
import com.king.base.adapter.ViewPagerFragmentAdapter;
import com.king.base.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/24.
 */

public class RoomFragment extends BaseFragment <IRoomView,RoomPresenter> implements IRoomView{

    private VideoFragment videoFragment;

    @BindView(R.id.frameVideo)
    FrameLayout frameVideo;
    @BindView(R.id.ivBack)
    ImageView ivBack;
    @BindView(R.id.ivShare)
    ImageView ivShare;
    @BindView(R.id.tvRoomTitle)
    TextView tvRoomTitle;
    @BindView(R.id.ivFullScreen)
    ImageView ivFullScreen;
    @BindView(R.id.rlRoomInfo)
    RelativeLayout rlRoomInfo;
    @BindView(R.id.llRoomChat)
    LinearLayout llRoomChat;

    @BindView(R.id.videoContent)
    RelativeLayout videoContent;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    @BindView(R.id.tvFollow)
    TextView tvFollow;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private ViewPagerFragmentAdapter viewPagerFragmentAdapter;

    private List<CharSequence> listTitle;
    private List<Fragment> listData;
    private Room room;
    private String uid;
    private AnchorInfoFragment anchorInfoFragment;

    public static RoomFragment newInstance(String uid){
        Bundle  args =new Bundle();

        RoomFragment fragment = new RoomFragment();
        fragment.uid = uid;
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

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
        LogUtils.d("room");
        this.room = room;
        anchorInfoFragment.onUpdateAnchor(room);
        viewPagerFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void playUrl(String url) {
        LogUtils.d("playUrl:" + url);
        if (videoFragment == null){
            videoFragment =VideoFragment.newInstance(url,false);
        }
        replaceChildFragment(R.id.frameVideo,videoFragment);
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_room;
    }

    @Override
    public void initUI() {
        updateVideoLayoutParams();

        listTitle =new ArrayList<>();
        listTitle.add(getText(R.string.room_chat));
        listTitle.add(getText(R.string.room_ranking));
        listTitle.add(getText(R.string.room_anchor));

        listData =new ArrayList<>();
        listData.add(ChatFragment.newInstance());
        listData.add(RankFragment.newInstance());
        anchorInfoFragment  = new AnchorInfoFragment().newInstance(room);
        listData.add(anchorInfoFragment);

        viewPagerFragmentAdapter =  new ViewPagerFragmentAdapter(getFragmentManager(),listData,listTitle);

        viewPager.setAdapter(viewPagerFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    public void updateVideoLayoutParams(){
        ViewGroup.LayoutParams lp = videoContent.getLayoutParams();

            if (isLandscape()){
                lp.height = DensityUtil.getDisplayMetrics(context).heightPixels;
            }else {
                lp.height = (int) (DensityUtil.getDisplayMetrics(context).widthPixels/16.0f*9.0f);
            }
            videoContent.setLayoutParams(lp);
    }

    @Override
    public void initData() {
        getPresenter().enterRoom(uid);
    }

    @Override
    public RoomPresenter createPresenter() {
        return new RoomPresenter(getApp());
    }


    public boolean isLandscape(){
        return getActivity().getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;//重力感应
    }

    public void onConfigurationChanged(Configuration newConfig){
        super.onConfigurationChanged(newConfig);

        if (isLandscape()){
            llRoomChat.setVisibility(View.GONE);
            ivFullScreen.setVisibility(View.GONE);
        }else {
            llRoomChat.setVisibility(View.VISIBLE);
            ivFullScreen.setVisibility(View.VISIBLE);
        }
        updateVideoLayoutParams();
    }

    public void clickFrameVideo(){

    }

    public void clickBack(){
        if (isLandscape()){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            finish();
        }
    }

    public void clickShare(){

    }

    public void clickFullScreen(){
        if (isLandscape()){
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }else {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        }
    }

    public void clickFollow(){

    }

    @OnClick({R.id.frameVideo,R.id.ivBack,R.id.ivShare,R.id.ivFullScreen,R.id.videoContent,R.id.ivFollow})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.videoContent:
            case R.id.frameVideo:
                clickFrameVideo();
                break;
            case R.id.ivBack:
                clickBack();
                break;
            case R.id.ivShare:
                clickShare();
                break;
            case R.id.ivFullScreen:
                clickFullScreen();
                break;
            case R.id.ivFollow:
                clickFollow();
                break;
        }
    }
}






















