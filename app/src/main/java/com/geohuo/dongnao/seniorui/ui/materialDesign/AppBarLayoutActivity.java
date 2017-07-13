package com.geohuo.dongnao.seniorui.ui.materialDesign;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.geohuo.dongnao.seniorui.R;

public class AppBarLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bar_layout);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).setAction("ok", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(AppBarLayoutActivity.this, "click", Toast.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.BLUE).show();
            }
        });
    }
}
