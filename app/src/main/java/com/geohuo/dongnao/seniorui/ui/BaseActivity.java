package com.geohuo.dongnao.seniorui.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.geohuo.dongnao.seniorui.widget.splashView.SplashView;

/**
 * Created by geohuo on 2017/6/16.
 */

public abstract class BaseActivity extends AppCompatActivity {


    private View mContextView;
    private FrameLayout mMainView;
    private SplashView splashView;

    private boolean isShowSplash = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBeforeOnCreate();
        mContextView = LayoutInflater.from(this)
                .inflate(bindLayout(), null);

        if (isShowSplash) {
            mMainView = new FrameLayout(this);
            mMainView.addView(mContextView);
            splashView = new SplashView(this);
            mMainView.addView(splashView);
            setContentView(mMainView);
            startAnimator();
        } else {
            setContentView(mContextView);
        }
        initView(savedInstanceState);
    }

    public abstract void initBeforeOnCreate();

    public abstract int bindLayout();

    public abstract void initView(Bundle savedInstanceState);

    // 开始动画
    public void startAnimator() {
        if (!isShowSplash) return;
        splashView.start();
    }

    // 结束动画
    public void endAnimator() {
        if (!isShowSplash) return;
        splashView.splashDisappear();

    }

    public void showAnimation(boolean flag){
        isShowSplash = flag;
    }
}
