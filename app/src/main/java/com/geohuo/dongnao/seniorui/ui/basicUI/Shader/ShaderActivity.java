package com.geohuo.dongnao.seniorui.ui.basicUI.Shader;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.geohuo.dongnao.seniorui.R;

public class ShaderActivity extends AppCompatActivity {

    ShaderView shaderView;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shader);
        shaderView = (ShaderView) findViewById(R.id.shader);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_shader,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.shader_bitmap:
                shaderView.setShowType(ShaderView.ShowType.BitmapShader);
                break;
            case R.id.shader_compose:
                shaderView.setShowType(ShaderView.ShowType.ComposeShader);
                break;
            case R.id.shader_drawStar:
                shaderView.setShowType(ShaderView.ShowType.drawStar);
                break;
            case R.id.shader_linearGradient:
                shaderView.setShowType(ShaderView.ShowType.LinearGradient);
                break;
            case R.id.shader_radialGradient:
                shaderView.setShowType(ShaderView.ShowType.RadialGradient);
                break;
            case R.id.shader_sweepGradient:
                shaderView.setShowType(ShaderView.ShowType.SweepGradient);
                break;
            case R.id.shader_ShapeDrawable:
                shaderView.setShowType(ShaderView.ShowType.ShapeDrawable);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
