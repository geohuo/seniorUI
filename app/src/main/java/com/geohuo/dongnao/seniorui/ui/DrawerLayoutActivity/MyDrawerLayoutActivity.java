package com.geohuo.dongnao.seniorui.ui.DrawerLayoutActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.geohuo.dongnao.seniorui.R;

/**
 * Created by geohuo on 2017/7/2.
 */

public class MyDrawerLayoutActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_drawer_layout);
    }

    public void onClick(View view){
        Toast.makeText(this, "click", Toast.LENGTH_SHORT).show();
    }
}
