package com.geohuo.dongnao.seniorui.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.geohuo.dongnao.seniorui.R;

public class LoadingActivity extends BaseActivity {

    @Override
    public void initBeforeOnCreate() {
        showAnimation(true);
    }

    @Override
    public int bindLayout() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView(Bundle savedInstanceState) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                endAnimator();
            }
        },3000);

    }

    public void start(View v) {
        startAnimator();
        v.postDelayed(new Runnable() {
            @Override
            public void run() {
                endAnimator();
            }
        }, 3000);
    }

    private Handler handler = new Handler();

}
