package com.geohuo.dongnao.seniorui.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.geohuo.dongnao.seniorui.R;
import com.geohuo.dongnao.seniorui.utils.AppManager;


/**
 * Created by geohuo on 2017/2/23.
 */

public class MToolbar extends Toolbar {

    Drawable leftIcon, rightIcon ,rightIcon2;
    String title, leftText, rightText ,rightText2;
    boolean showRight, showLeft, showRight2;
    View mView;
    TextView tvLeft, tvCenter, tvRight;
    Context mContext;
    OnToolBarClickListener mListener;

    public MToolbar(Context context) {
        this(context, null, 0);
    }

    public MToolbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MToolbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.MToolbar);

        title = a.getString(R.styleable.MToolbar_mtitle);
        showRight = a.getBoolean(R.styleable.MToolbar_showRight, false);
        rightIcon = a.getDrawable(R.styleable.MToolbar_rightIcon);
        rightText = a.getString(R.styleable.MToolbar_rightText);

        leftIcon = a.getDrawable(R.styleable.MToolbar_leftIcon);
        showLeft = a.getBoolean(R.styleable.MToolbar_showLeft, true);
        leftText = a.getString(R.styleable.MToolbar_leftText);

        a.recycle();

        initView();
        initListener();
    }

    private void initListener() {

        mListener = new OnToolBarClickListener() {
            @Override
            public void onLeftClick() {
//                ((Activity) mContext).finish();
                AppManager.getAppManager().finishActivity(((Activity) mContext));
            }

            @Override
            public void onRightClick() {

            }
        };

        tvRight.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onRightClick();
            }
        });
        tvLeft.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onLeftClick();
            }
        });
    }

    private void initView() {
        if (mView == null) {
            mView = View.inflate(getContext(), R.layout.layout_toolbar, null);
            tvLeft = (TextView) mView.findViewById(R.id.tv_left);
            tvRight = (TextView) mView.findViewById(R.id.tv_right);
            tvCenter = (TextView) mView.findViewById(R.id.tv_center);
            tvCenter.setTextSize(20);
            addView(mView);

            if (!TextUtils.isEmpty(title)) {
                tvCenter.setText(title);
            }

            if (!showLeft){
                tvLeft.setVisibility(View.INVISIBLE);
            }
            if (!showRight){
                tvRight.setVisibility(View.INVISIBLE);
            }

            setLeftTextView(leftIcon,leftText);
            setRightTextView(rightIcon,rightText);

        }
    }

    public void setMyTitle(CharSequence character) {
        tvCenter.setText(character);
    }

    public void setRightTextView(Drawable icon,CharSequence charSequence) {
        setTextViewState(tvRight, icon, DrawableDirection.RIGHT, charSequence);
    }
    public void setRightTextView(int res,CharSequence charSequence) {
        Drawable icon = mContext.getResources().getDrawable(res);
        setTextViewState(tvRight, icon, DrawableDirection.RIGHT, charSequence);
    }

    public void setLeftTextView(Drawable icon,CharSequence charSequence) {
        setTextViewState(tvLeft, icon, DrawableDirection.LEFT, charSequence);
    }
    public void setLeftTextView(int res,CharSequence charSequence) {
        Drawable icon = mContext.getResources().getDrawable(res);
        setTextViewState(tvLeft, icon, DrawableDirection.LEFT, charSequence);
    }


    /**
     * 设置textView的状态 (图片,文字)
     *
     * @param textView
     * @param drawable     图标
     * @param direction    图标显示方位
     * @param charSequence 文字
     */
    private void setTextViewState(TextView textView, Drawable drawable, DrawableDirection direction, CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(View.VISIBLE);
            textView.setText(charSequence);
        }
        if (drawable != null) {
            textView.setVisibility(View.VISIBLE);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            switch (direction) {
                case LEFT:
                    textView.setCompoundDrawables(drawable, null, null, null);
                    break;
                case RIGHT:
                    textView.setCompoundDrawables(null, null, drawable, null);
                    break;
                case TOP:
                    break;
                case BOTTOM:
                    break;
            }
        }
    }

    public void setToolBarClickListener(OnToolBarClickListener listener) {
        mListener = listener;
    }

    public enum DrawableDirection {
        LEFT, RIGHT, TOP, BOTTOM
    }

    public interface OnToolBarClickListener {
        void onLeftClick();
        void onRightClick();
    }


}
