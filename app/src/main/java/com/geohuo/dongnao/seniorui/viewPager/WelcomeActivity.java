package com.geohuo.dongnao.seniorui.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.viewPager.transforms.Transformers;
import com.geohuo.dongnao.seniorui.widget.CommonPopupWindow;
import com.geohuo.dongnao.seniorui.widget.MToolbar;

import java.util.ArrayList;

/**
 * Created by geohuo on 2017/6/19.
 */

public class WelcomeActivity extends AppCompatActivity {
    ViewPager viewPager;
    ArrayList<Fragment> fragments;
    MToolbar toolbar;
    private CommonPopupWindow popupWindow;
    ViewPager.PageTransformer transformer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        transformer = new Transformers.Transformer();
        initViewPage();
        initToolbar();
    }

    private void initToolbar() {
        toolbar = (MToolbar) findViewById(R.id.toolbar);
        toolbar.setToolBarClickListener(new MToolbar.OnToolBarClickListener() {
            @Override
            public void onLeftClick() {
                finish();
            }

            @Override
            public void onRightClick() {
                //showPop(toolbar);
                showAll();
            }
        });
    }

    //全屏弹出
    public void showAll() {
        if (popupWindow != null && popupWindow.isShowing()) return;
        View upView = LayoutInflater.from(this).inflate(R.layout.layout_pop_window, null);
        //测量View的宽高
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        upView.measure(w, h);
        popupWindow = new CommonPopupWindow.Builder(this)
                .setView(R.layout.layout_pop_window)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, upView.getMeasuredHeight())
                .setBackGroundLevel(0.5f)//取值范围0.0f-1.0f 值越小越暗
                .setAnimationStyle(R.style.AnimUp)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {
                        initPopClick(view, layoutResId);
                    }
                })
                .create();
        popupWindow.showAtLocation(findViewById(android.R.id.content), Gravity.BOTTOM, 0, 0);
    }

    private void showPop(View view) {
        if (popupWindow != null && popupWindow.isShowing()) return;
        popupWindow = new CommonPopupWindow.Builder(this)
                .setView(R.layout.layout_pop_window)
                .setWidthAndHeight(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                .setAnimationStyle(R.style.AnimDown)
                .setViewOnclickListener(new CommonPopupWindow.ViewInterface() {
                    @Override
                    public void getChildView(View view, int layoutResId) {

                        initPopClick(view, layoutResId);
                    }
                })
                .setOutsideTouchable(true)
                .create();
        popupWindow.showAsDropDown(view);
    }

    private void initViewPage() {
        viewPager = (ViewPager) findViewById(R.id.vp_guide);
        fragments = new ArrayList<>();
        fragments.add(new GuideFragment());
        fragments.add(new Guide2Fragment());
        fragments.add(new Guide3fragment());
        fragments.add(new Guide4Fragment());
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragments));
        viewPager.setPageTransformer(true, transformer);
        //viewPager.setPageTransformer();
    }

    private void initPopClick(View view, int layoutResId) {
        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick0();
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick2();
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick3();
                popupWindow.dismiss();
            }
        });
        view.findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick4();
                popupWindow.dismiss();
            }
        });
    }

    private void onClick0() {
        transformer = new Transformers.StereoPagerTransformer();
        viewPager.setPageTransformer(true, transformer);

    }

    private void onClick2() {
        transformer = new Transformers.Transformer();
        viewPager.setPageTransformer(true, transformer);
    }

    private void onClick3() {

        transformer = new Transformers.Transformer1();
        viewPager.setPageTransformer(true, transformer);
    }

    private void onClick4() {

        transformer = new Transformers.Transformer2();
        viewPager.setPageTransformer(true, transformer);
    }
}
