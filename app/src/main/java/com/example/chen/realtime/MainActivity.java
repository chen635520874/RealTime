package com.example.chen.realtime;

import android.os.SystemClock;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.chen.realtime.mvp.base.PureActivity;
import com.example.chen.realtime.mvp.fragment.FollowFragment;
import com.example.chen.realtime.mvp.fragment.HomeFragment;
import com.example.chen.realtime.mvp.fragment.LiveFragment;
import com.example.chen.realtime.mvp.fragment.MineFragment;
import com.king.base.util.ToastUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends PureActivity {

    @BindView(R.id.rbHome)
    RadioButton rbHome;
    @BindView(R.id.rbLive)
    RadioButton rbLive;
    @BindView(R.id.rbFollw)
    RadioButton rbFollow;
    @BindView(R.id.rbMe)
    RadioButton rbMe;

    private HomeFragment homeFragment;
    private LiveFragment liveFragment;
    private FollowFragment followFragment;
    private MineFragment mineFragment;

    private boolean isExit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        isExit =false;
    }

    @Override
    public int getRootViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initUI() {

    }

    @Override
    public void onBackPressed() {
        if (!isExit){
            ToastUtils.showToast(context,R.string.press_again_to_exit);
            isExit =true;
            EventBus.getDefault().post(isExit);
        }else{
            super.onBackPressed();
        }
    }

    @Subscribe(threadMode = ThreadMode.ASYNC)
    public void onEventExit(Boolean isBool){
        SystemClock.sleep(1000);
        isExit=false;
    }

    public void showHomeFragmnet(){
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        hideAllFragment(fragmentTransaction);
        if (homeFragment == null){
            homeFragment = HomeFragment.
        }

    }

    public void hideAllFragment(FragmentTransaction fragmentTransaction){

    }
    public void hideAllFragment(FragmentTransaction fragmentTransaction,Fragment fragment){

    }

    public void replaceFragment(@IdRes int id, Fragment fragment){

    }
}
