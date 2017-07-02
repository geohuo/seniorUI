package com.geohuo.dongnao.seniorui.ui.DrawerLayoutActivity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.geohuo.dongnao.seniorui.R;

public class DrawerLayoutActivity extends AppCompatActivity  implements DrawerLayout.DrawerListener{
    DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawe_layout);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        drawerLayout.addDrawerListener(this);
    }

    public void onClick(View view) {
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_OPEN, GravityCompat.END);
    }

    /**
     * drawerView   左菜单
     *  slideOffset    滑动百分比
     *  打开菜单
     * @param drawerView
     * @param slideOffset
     */
    @Override
    public void onDrawerSlide(View drawerView, float slideOffset) {
        Log.i("tuch", "  drawerView  " + drawerView + " slideOffset " + slideOffset);
    }

    /**
     *
     * @param drawerView
     */
    @Override
    public void onDrawerOpened(View drawerView) {
        //打开的状态
    }

    @Override
    public void onDrawerClosed(View drawerView) {
        //关闭 的状态
    }

    @Override
    public void onDrawerStateChanged(int newState) {
    }
}
