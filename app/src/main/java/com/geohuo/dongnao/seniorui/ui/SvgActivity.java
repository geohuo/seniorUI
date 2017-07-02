package com.geohuo.dongnao.seniorui.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.widget.Svg.SvgMapView;

public class SvgActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    SvgMapView mapView;
    int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg);

        mapView = (SvgMapView) findViewById(R.id.mapview);
        // Example of a call to a native method
        TextView tv = (TextView) findViewById(R.id.sample_text);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i%2 == 1){
                    mapView.setRes(R.raw.chinahigh);
                }else {
                    mapView.setRes(R.raw.taiwanhigh);
                }
                i++;

            }
        });
    }

}
