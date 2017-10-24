package com.example.chen.realtime.mvp.fragment;

import android.os.Bundle;
import android.view.View;

import com.example.chen.realtime.R;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.base.BaseView;
import com.king.base.util.LogUtils;
import com.pili.pldroid.player.PLMediaPlayer;
import com.pili.pldroid.player.widget.PLVideoTextureView;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/24.
 */

public class VideoFragment extends BaseFragment <BaseView,BasePresenter<BaseView>>{

    @BindView(R.id.vtv)
    PLVideoTextureView vtv;

    private int mRotation;
    private String url;
    private boolean isFull;

    public static VideoFragment newInstance(String url,boolean isFull){
        Bundle args =new Bundle();

        VideoFragment fragment =new VideoFragment();
        fragment.url =url;
        fragment.isFull = isFull;
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public int getRootViewId() {
        return R.layout.fragment_video;
    }

    @Override
    public void initUI() {
        LogUtils.d("url:"+url);
        vtv.setVideoPath(url);
        if (isFull){
            vtv.setDisplayOrientation(PLVideoTextureView.ASPECT_RATIO_PAVED_PARENT);
        }else {
            vtv.setDisplayOrientation(PLVideoTextureView.ASPECT_RATIO_16_9);
        }
        vtv.setOnPreparedListener(new PLMediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(PLMediaPlayer plMediaPlayer) {
                LogUtils.d("onPrepared:"+url);
                start();
            }
        });
        vtv.setOnBufferingUpdateListener(new PLMediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(PLMediaPlayer plMediaPlayer, int i) {
                if (i>0){
                    LogUtils.d("onBufferingUpdate|" + i);
                }
            }
        });
        vtv.setOnCompletionListener(new PLMediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(PLMediaPlayer plMediaPlayer) {
                LogUtils.d("onCompletion");
            }
        });
        vtv.setOnInfoListener(new PLMediaPlayer.OnInfoListener() {
            @Override
            public boolean onInfo(PLMediaPlayer plMediaPlayer, int i, int i1) {
                LogUtils.d("onInfo|i:"+i+"--i1:"+i1);
                return false;
            }
        });
        vtv.setOnErrorListener(new PLMediaPlayer.OnErrorListener() {
            @Override
            public boolean onError(PLMediaPlayer plMediaPlayer, int i) {
                LogUtils.w("onError:i:" + i);
                return false;
            }
        });

    }

    public PLVideoTextureView getVideoView(){
        return vtv;
    }
    public boolean isPlaying(){
        return isPlaying();
    }

    private void start(){
        if (vtv!=null){
            vtv.start();
        }
    }
    public void pause(){
        if (vtv!=null){
            vtv.pause();
        }
    }
    public void stopPlayback(){
        if (vtv!=null){
            vtv.stopPlayback();
        }
    }
    public void seekTo(long i){
        vtv.seekTo(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        start();
    }

    @Override
    public void onPause() {
        super.onPause();
        pause();
    }
    public int getDisplayAspectRatio(){
        return vtv.getDisplayAspectRatio();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayback();
    }

    public void onClickRotate(View view){
        mRotation = (vtv.getDisplayAspectRatio()+90) % 360;
        setDisplayAspectRatio(mRotation);
    }

    /**
     *
     * @param ratio
     *      PLVideoView.ASPECT_RATIO_ORIGIN
     *      PLVideoView.ASPECT_RATIO_FIT_PARENT
     *      PLVideoView.ASPECT_RATIO_PAVED_PARENT
     *      PLVideoView.ASPECT_RATIO_16_9
     *      PLVideoView.ASPECT_RATIO_4_3
     *
     */
    public void setDisplayAspectRatio(int ratio){
        vtv.setDisplayAspectRatio(ratio);
    }

    public void setDisplayOrientation(int orientation){
        vtv.setDisplayOrientation(orientation);
    }
    public void play(String url){
        this.url = url;
        LogUtils.d("url:"+url);
        vtv.setVideoPath(url);
        vtv.start();
    }

    @Override
    public void initData() {

    }

    @Override
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter(getApp());
    }
}
