package com.geohuo.dongnao.seniorui.ui.recyclerView;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.widget.ImageView;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.bean.SwipeCardBean;
import com.geohuo.dongnao.seniorui.ui.recyclerView.adaper.UniversalAdapter;
import com.geohuo.dongnao.seniorui.ui.recyclerView.adaper.ViewHolder;
import com.geohuo.dongnao.seniorui.ui.recyclerView.config.CardConfig;
import com.geohuo.dongnao.seniorui.ui.recyclerView.config.SwipeCardCallback;
import com.geohuo.dongnao.seniorui.ui.recyclerView.layoutManage.SwipeCardLayoutManager;
import com.geohuo.dongnao.seniorui.utils.glideUtils.GlideUtils;

import java.util.List;

/**
 * Created by geohuo on 2017/6/30.
 */

public class LayoutManageActivity extends BaseRecyclerViewActivity {

    private RecyclerView rv;
    private UniversalAdapter<SwipeCardBean> adapter;
    private List<SwipeCardBean> mData;
    SwipeCardLayoutManager layoutManager;

    @Override
    protected void initView() {
        setMyTitle("LayoutManage RecyclerView");
        rv = getRecyclerView();
        layoutManager = new SwipeCardLayoutManager();
        rv.setLayoutManager(layoutManager);

        mData = SwipeCardBean.initDatas();
        adapter = new UniversalAdapter<SwipeCardBean>(this, mData, R.layout.item_swipe_card) {
            @Override
            public void convert(ViewHolder var1, SwipeCardBean var2) {
                var1.setText(R.id.tvName, var2.getName());
                var1.setText(R.id.tvPrecent, var2.getPostition() + "/" + mData.size());
//                Glide.with(LayoutManageActivity.this)
//                        .load(var2.getUrl())
//                        .into((ImageView) var1.getView(R.id.iv));
                GlideUtils.loadImage( LayoutManageActivity.this, (ImageView) var1.getView(R.id.iv),var2.getUrl());
            }
        };
        rv.setAdapter(adapter);
        CardConfig.initConfig(this);

        SwipeCardCallback callback = new SwipeCardCallback(0,0, adapter,
                mData, rv);
        ItemTouchHelper helper = new ItemTouchHelper(callback);
        helper.attachToRecyclerView(rv);
    }
}
