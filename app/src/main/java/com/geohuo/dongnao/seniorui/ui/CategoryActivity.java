package com.geohuo.dongnao.seniorui.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.ui.DrawerLayoutActivity.DrawerLayout1Activity;
import com.geohuo.dongnao.seniorui.ui.DrawerLayoutActivity.DrawerLayoutActivity;
import com.geohuo.dongnao.seniorui.ui.DrawerLayoutActivity.MyDrawerLayoutActivity;
import com.geohuo.dongnao.seniorui.ui.materialDesign.AppBarLayoutActivity;
import com.geohuo.dongnao.seniorui.ui.materialDesign.FabActivity;
import com.geohuo.dongnao.seniorui.ui.materialDesign.TablayoutActivity;
import com.geohuo.dongnao.seniorui.ui.materialDesign.TestActivity;
import com.geohuo.dongnao.seniorui.ui.materialDesign.WangYiMusicActivity;
import com.geohuo.dongnao.seniorui.ui.recyclerView.RecyclerCategoryActivity;
import com.geohuo.dongnao.seniorui.viewPager.WelcomeActivity;

/**
 * Created by geohuo on 2017/6/20.
 */

public class CategoryActivity extends AppCompatActivity {
    private ListView mListView;

    private LayoutInflater mInflater;


    private Class[] CLAZZES = new Class[]
            {
                    MainActivity.class,
                    WelcomeActivity.class,
                    SplashActivity.class,
                    RecyclerCategoryActivity.class,
                    MyDrawerLayoutActivity.class,
                    DrawerLayoutActivity.class,
                    DrawerLayout1Activity.class,
                    SvgActivity.class,
                    LoadingActivity.class,
                    SnackbarActivity.class,
                    ToolbarActivity.class,
                    TablayoutActivity.class,
                    WangYiMusicActivity.class,
                    TestActivity.class,
                    FabActivity.class,
                    AppBarLayoutActivity.class

            };

    private String[] titles =
            {"MainActivity", "启动引导页面", "广告页面",
                    "RecyclerView", "侧滑菜单1", "侧滑菜单2",
                    "侧滑菜单3", "Svg地图", "Loading页面",
                    "snackbar","ToolBar","TabLayout",
                    "网易云音乐首页","测试页面",
                    "Fab","AppBarLayout"
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        initListView();

    }

    private void initToolBar() {
    }

    private void initListView() {
        mInflater = LayoutInflater.from(this);

        mListView = (ListView) findViewById(R.id.id_listview);

        mListView.setAdapter(new ArrayAdapter<Class>(this, -1, CLAZZES) {
                                 @Override
                                 public View getView(int position, View convertView, ViewGroup parent) {
                                     String title = getItem(position).getSimpleName();

                                     if (convertView == null) {
                                         convertView = mInflater.inflate(R.layout.item_category, parent, false);
                                     }
                                     TextView tv = (TextView) convertView.findViewById(R.id.id_title);
                                     tv.setText(titles[position]);
                                     return convertView;
                                 }
                             }

        );

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CategoryActivity.this, CLAZZES[position]);
                //intent.putExtra(BaseContentActivity.TITLE, CLAZZES[position].getSimpleName());
                startActivity(intent);
            }
        });
    }
}
