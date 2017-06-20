package com.geohuo.dongnao.seniorui.viewPager.transforms;

import android.animation.TimeInterpolator;
import android.support.v4.view.ViewPager;
import android.view.View;

import static java.lang.Math.pow;

/**
 * Created by geohuo on 2017/6/20.
 */

public class Transformers {

    // 立体3d翻转效果
    public static class StereoPagerTransformer implements ViewPager.PageTransformer {

        private static final float MAX_ROTATE_Y = 90;

        private final TimeInterpolator sInterpolator = new TimeInterpolator() {
            @Override
            public float getInterpolation(float input) {
                if (input < 0.7) {
                    return input * (float) pow(0.7, 3) * MAX_ROTATE_Y;
                } else {
                    return (float) pow(input, 4) * MAX_ROTATE_Y;
                }
            }
        };


        public void transformPage(View view, float position) {
            if (position == 0 || position == 1 || position == -1)
                view.clearAnimation();
            view.setPivotY(view.getHeight() / 2);
            if (position < -1) { // [-Infinity,-1)
// This page is way off-screen to the left.
                view.setPivotX(0);
                view.setRotationY(90);
            } else if (position <= 0) { // [-1,0]
                view.setPivotX(view.getWidth());
                view.setRotationY(-sInterpolator.getInterpolation(-position));
            } else if (position <= 1) { // (0,1]
                view.setPivotX(0);
                view.setRotationY(sInterpolator.getInterpolation(position));
            } else { // (1,+Infinity]
// This page is way off-screen to the right.
                view.setPivotX(0);
                view.setRotationY(90);
            }
        }
    }

    public static class Transformer implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position == 0 || position == 1 || position == -1)
                view.clearAnimation();
            if (position < 1 && position > -1) {
                view.setScaleX(1 - Math.abs(position));
                view.setScaleY(1 - Math.abs(position));
            } else {
                view.clearAnimation();
            }

            //效果1
//			view.setScaleX(1-Math.abs(position));
//			view.setScaleY(1-Math.abs(position));
            //效果2
//			view.setScaleX(Math.max(0.9f,1-Math.abs(position)));
//			view.setScaleY(Math.max(0.9f,1-Math.abs(position)));
            //效果3 3D翻转
//			view.setPivotX(position<0f?view.getWidth():0f);//左边页面：0~-1；右边的页面：1~0
//			view.setPivotY(view.getHeight()*0.5f);
//			view.setRotationY(position*45f);//0~90度
            //效果4 3D内翻转
//			view.setPivotX(position<0f?view.getWidth():0f);//左边页面：0~-1；右边的页面：1~0
//			view.setPivotY(view.getHeight()*0.5f);
//			view.setRotationY(-position*45f);//0~90度

//            view.setPivotX(view.getWidth() * 0.5f);//左边页面：0~-1；右边的页面：1~0
//            view.setPivotY(view.getHeight() * 0.5f);
//            view.setRotationY(-position * 45f);//0~90度


        }
    }

    public static class Transformer1 implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position == 0 || position == 1 || position == -1)
                view.clearAnimation();
            if (position < 1 && position > -1) {
                view.setScaleX(Math.max(0.9f, 1 - Math.abs(position)));
                view.setScaleY(Math.max(0.9f, 1 - Math.abs(position)));
            } else {
                view.clearAnimation();
            }
        }
    }

    public static class Transformer2 implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position == 0 || position == 1 || position == -1)
                view.clearAnimation();
            if (position < 1 && position > -1) {
                view.setPivotX(view.getWidth() * 0.5f);//左边页面：0~-1；右边的页面：1~0
                view.setPivotY(view.getHeight() * 0.5f);
                view.setRotationY(-position * 45f);//0~90度
            } else {
                view.clearAnimation();
            }
        }
    }


    public static class Transformer3 implements ViewPager.PageTransformer {

        @Override
        public void transformPage(View view, float position) {
            if (position == 0 || position == 1 || position == -1)
                view.clearAnimation();
            if (position < 1 && position > -1) {
                view.setPivotX(view.getWidth() * 0.5f);//左边页面：0~-1；右边的页面：1~0
                view.setPivotY(view.getHeight() * 0.5f);
                view.setRotationY(-position * 45f);//0~90度
            } else {
                view.clearAnimation();
            }
        }
    }
}
