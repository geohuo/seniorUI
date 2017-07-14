package com.geohuo.dongnao.seniorui.ui.materialDesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.geohuo.dongnao.seniorui.R;

public class AppBarLayoutActivity extends AppCompatActivity {

    private static final String TAG = "AppBarLayoutActivity";
    LinearLayout scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "hello", Snackbar.LENGTH_SHORT).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AppBarLayoutActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.BLUE).show();
            }
        });

        scrollView = (LinearLayout) findViewById(R.id.ll_content);
        TextView tv;
        for (int i = 0; i < 20; i++) {
            tv = new TextView(this);
            tv.setText("hello world");
            tv.setTextSize(18);
            tv.setPadding(10,10,10,10);

            LinearLayout.LayoutParams params =
                    new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            scrollView.addView(tv,params);
        }



    }
}
