package com.example.chen.realtime.mvp.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.chen.realtime.R;
import com.example.chen.realtime.mvp.base.BaseFragment;
import com.example.chen.realtime.mvp.base.BasePresenter;
import com.example.chen.realtime.mvp.base.BaseView;
import com.king.base.util.StringUtils;
import com.king.base.util.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/26.
 */

public class SearchFragment extends BaseFragment<BaseView,BasePresenter<BaseView>> {

    @BindView(R.id.ivLeft)
    ImageView ivLeft;
    @BindView(R.id.etKey)
    EditText etKey;
    @BindView(R.id.tvRight)
    TextView tvRight;

    private LiveListFragment liveListFragment;

    public static SearchFragment newInstance(){
        Bundle args = new Bundle();

        SearchFragment fragment = new SearchFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getRootViewId() {
        return R.layout.fragment_search;
    }

    @Override
    public void initUI() {
        etKey.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP){
                    if (keyCode == KeyEvent.KEYCODE_ENTER||keyCode == KeyEvent.KEYCODE_SEARCH){
                        clickSearch();
                        return true;
                    }
                }
                return false;
            }
        });
    }

    @Override
    public void initData() {
        liveListFragment = LiveListFragment.newInstance(null,false);
        replaceChildFragment(R.id.fragment,liveListFragment);
    }

    @Override
    public BasePresenter<BaseView> createPresenter() {
        return new BasePresenter(getApp());
    }

    /**
     * 隐藏软键盘（输入法）
     * @param v
     */
    public void hideInputMethod(final EditText v){
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }

    /**
     * 显示软键盘
     * @param v
     */
    public void showInputMethod(final EditText v){
        v.requestFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(v,InputMethodManager.SHOW_IMPLICIT);
    }

    private boolean checkInputKey(){
        if (StringUtils.isBlank(etKey.getText())){
            ToastUtils.showToast(context,R.string.tips_search_keywords_cannot_be_empty);
            return false;
        }
        return true;
    }

    private void clickSearch(){
        if (checkInputKey()){
            hideInputMethod(etKey);
            liveListFragment.search(etKey.getText().toString(),0);
        }
    }

    @OnClick({R.id.ivLeft, R.id.tvRight})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ivLeft:
                finish();
                break;
            case R.id.tvRight:
                clickSearch();
                break;
        }
    }
}
