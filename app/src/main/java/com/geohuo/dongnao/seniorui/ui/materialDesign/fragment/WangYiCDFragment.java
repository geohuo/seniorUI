package com.geohuo.dongnao.seniorui.ui.materialDesign.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geohuo.dongnao.seniorui.R;

import java.util.ArrayList;

public class WangYiCDFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<String> titles;
    ArrayList<Fragment> fragments;
    FragmentPagerAdapter adapter;
    TextView tv;

    public WangYiCDFragment() {

    }

    public static WangYiCDFragment newInstance(String param1, String param2) {
        WangYiCDFragment fragment = new WangYiCDFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wang_yi_cd, container, false);
        tv = (TextView) view.findViewById(R.id.tv_bg);
        initTab(view);
        return view;
    }

    private void initTab(View v) {
        if (mParam2 == "") {
            tv.setVisibility(View.VISIBLE);
            tv.setBackground(getResources().getDrawable(R.mipmap.wy_cd));
            return;
        }
        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        viewPager = (ViewPager) v.findViewById(R.id.viewpager);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        titles.add("个性推荐");
        titles.add("歌单");
        titles.add("主播电台");
        titles.add("排行榜");

        fragments.add(WangYiCDDetailFragment.newInstance("1" , ""));
        fragments.add(WangYiCDDetailFragment.newInstance("2", ""));
        fragments.add(WangYiCDDetailFragment.newInstance("3" , ""));
        fragments.add(WangYiCDDetailFragment.newInstance("4" , ""));

        adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(adapter);
        viewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        viewPager.setOffscreenPageLimit(2);
        tabLayout.setupWithViewPager(viewPager);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles.get(position);
        }
    }


}
