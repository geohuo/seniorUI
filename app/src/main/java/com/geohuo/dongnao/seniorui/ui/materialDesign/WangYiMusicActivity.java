package com.geohuo.dongnao.seniorui.ui.materialDesign;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.ui.materialDesign.fragment.WangYiCDFragment;
import com.geohuo.dongnao.seniorui.ui.materialDesign.fragment.WangYiFriendFragment;
import com.geohuo.dongnao.seniorui.ui.materialDesign.fragment.WangYiMusicFragment;
import com.geohuo.dongnao.seniorui.widget.BottomTabView;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class WangYiMusicActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    ViewPager viewPager;

   // TabLayout tabLayout;
    DrawerLayout drawerLayout;
    ArrayList<Fragment> fragments;

    BottomTabView bottomTabView;
    FragmentPagerAdapter adapter;
    ArrayList<BottomTabView.TabItemView> tabItemViews = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wnag_yi_music);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        bottomTabView = (BottomTabView) findViewById(R.id.btview);

        toolbar.setTitle("");
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,R.string.open, R.string.close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);

        // 控件的菜单监听
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        initTab();


    }

    private void initTab() {

        fragments = new ArrayList<>();
        fragments.add(new WangYiMusicFragment());
        fragments.add(WangYiCDFragment.newInstance("","1"));
        fragments.add(new WangYiFriendFragment());

        adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewPager.setAdapter(adapter);
        viewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        tabItemViews.add(new BottomTabView.TabItemView(this, "", R.color.colorPrimary, R.color.colorAccent, R.mipmap.tb_music_normal, R.mipmap.tb_music_select));
        tabItemViews.add(new BottomTabView.TabItemView(this, "", R.color.colorPrimary, R.color.colorAccent, R.mipmap.tb_list_normal, R.mipmap.tb_list_select));
        tabItemViews.add(new BottomTabView.TabItemView(this, "", R.color.colorPrimary, R.color.colorAccent, R.mipmap.tb_friends_normal, R.mipmap.tb_friends_select));
        bottomTabView.setTabItemViews(tabItemViews);
        bottomTabView.setUpWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.wangyi_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.action_search){
            Toast.makeText(this, "menu click", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    //反射形式显示menu的图标
    @Override
    protected boolean onPrepareOptionsPanel(View view, Menu menu) {
        if (menu != null) {
            if (menu.getClass().getSimpleName().equals("MenuBuilder")) {
                try{
                    Method m = menu.getClass().getDeclaredMethod("setOptionalIconsVisible", Boolean.TYPE);
                    m.setAccessible(true);
                    m.invoke(menu, true);
                } catch (Exception e) {
                    Log.e(getClass().getSimpleName(), "onMenuOpened...unable to set icons for overflow menu", e);
                }
            }
        }
        return super.onPrepareOptionsPanel(view, menu);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send1) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
