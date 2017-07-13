package com.geohuo.dongnao.seniorui.ui.materialDesign.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.geohuo.dongnao.seniorui.R;


public class WangYiCDDetailFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    TextView tv;


    public WangYiCDDetailFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WangYiCDDetailFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WangYiCDDetailFragment newInstance(String param1, String param2) {
        WangYiCDDetailFragment fragment = new WangYiCDDetailFragment();
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
        View view = inflater.inflate(R.layout.fragment_wang_yi_cddetail, container, false);
        tv = (TextView) view.findViewById(R.id.tv_bg);
        switch (mParam1){
            case "1":
                tv.setBackground(getResources().getDrawable(R.mipmap.wy_tb1));
                break;
            case "2":
                tv.setBackground(getResources().getDrawable(R.mipmap.wy_tab2));
                break;
            case "3":
                tv.setBackground(getResources().getDrawable(R.mipmap.wy_tab3));
                break;
            case "4":
                tv.setBackground(getResources().getDrawable(R.mipmap.wy_tab4));
                break;
            case "5":
                break;
        }
        return view;
    }

}
