package com.geohuo.dongnao.seniorui.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.geohuo.dongnao.seniorui.R;

public class SnackbarActivity extends AppCompatActivity {

    TextInputLayout tl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
    }

    public void showSnackbar(View view){
        Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).show();
    }
    public void showSnackbarWithAction(View view){
        Snackbar.make(view,"hello",Snackbar.LENGTH_SHORT).setAction("ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SnackbarActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        }).setActionTextColor(Color.BLUE).show();
    }
}

/*
*   @NonNull
    public static Snackbar make(@NonNull View view, @NonNull CharSequence text,
            @Duration int duration) {
            //查找跟布局
        final ViewGroup parent = findSuitableParent(view);
        final LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        final SnackbarContentLayout content =
                (SnackbarContentLayout) inflater.inflate(
                        R.layout.design_layout_snackbar_include, parent, false);
        final Snackbar snackbar = new Snackbar(parent, content, content);
        snackbar.setText(text);
        snackbar.setDuration(duration);
        return snackbar;
    }
* */
