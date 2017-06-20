package com.geohuo.dongnao.seniorui.viewPager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geohuo.dongnao.seniorui.R;

/**
 * Created by geohuo on 2017/6/19.
 */

public class Guide2Fragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.guide_two, container, false);
        return view;
    }
}
