package com.geohuo.dongnao.seniorui.ui.materialDesign.fragment;

import android.app.Activity;
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
import com.geohuo.dongnao.seniorui.widget.CustomViewPager;

import java.util.ArrayList;

public class TestFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    TabLayout tabLayout;
    CustomViewPager viewPager;
    ArrayList<String> titles;
    ArrayList<Fragment> fragments;
    FragmentPagerAdapter adapter;
    TextView tv;
    Activity mActivity;

    public TestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mActivity = activity;

    }

    public Activity getHoldActivity() {
        return mActivity;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TestFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TestFragment newInstance(String param1, String param2) {
        TestFragment fragment = new TestFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_test, container, false);
        tv = (TextView) view.findViewById(R.id.tv_bg);
        initTab(view);
        return view;
    }

    private void initTab(View v) {

        tabLayout = (TabLayout) v.findViewById(R.id.tablayout);
        viewPager = (CustomViewPager) v.findViewById(R.id.viewpager);
        titles = new ArrayList<>();
        fragments = new ArrayList<>();
        titles.add("个性推荐");
        titles.add("歌单");
        titles.add("主播电台");
        titles.add("排行榜");

        fragments.add(WangYiCDDetailFragment.newInstance("1" , ""));
        fragments.add(WangYiCDDetailFragment.newInstance("2" , ""));
        fragments.add(WangYiCDDetailFragment.newInstance("3" , ""));
        fragments.add(WangYiCDDetailFragment.newInstance("4" , ""));

        adapter = new MyAdapter(getChildFragmentManager());
        viewPager.setOverScrollMode(ViewPager.OVER_SCROLL_NEVER);
        viewPager.setAdapter(adapter);
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
