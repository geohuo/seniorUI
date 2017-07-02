package com.geohuo.dongnao.seniorui.ui.recyclerView;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.widget.MToolbar;

/**
 * Created by geohuo on 2017/6/27.
 */

public abstract class BaseRecyclerViewActivity extends AppCompatActivity {
    public RecyclerView mRecyclerView;
    MToolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        mRecyclerView = (RecyclerView) findViewById(R.id.recycler);
        toolbar = (MToolbar) findViewById(R.id.toolbar);
        initView();
    }

    protected abstract void initView();


    public void setLayoutManage(RecyclerView.LayoutManager layoutManager){
        mRecyclerView.setLayoutManager(layoutManager);
    }

    public RecyclerView getRecyclerView(){
        return mRecyclerView;
    }

    public void setMyTitle(String name){
        toolbar.setMyTitle(name);
    }

    public void setToolbarListener(MToolbar.OnToolBarClickListener l){
        toolbar.setToolBarClickListener(l);
    }


}
