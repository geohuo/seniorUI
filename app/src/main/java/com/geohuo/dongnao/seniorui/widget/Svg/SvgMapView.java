package com.geohuo.dongnao.seniorui.widget.Svg;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.view.GestureDetectorCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.geohuo.dongnao.seniorui.R;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by geohuo on 2017/6/1.
 */

public class SvgMapView extends View {
    public static final int DRAW_VIEW = 1;
    private Paint mPaint;
    private AreaItem selectItem = null;
    private ArrayList<AreaItem> itemList = new ArrayList<>();
    private Context mContext;
    private int[] colors = {0xFFFF1493, 0xFFD1EEEE, 0xFFA3A3A3, 0xFF7CCD7C};
    private float scale = 1.3f;
    private int minWith;
    private int minHeight;
    private Canvas mCanvas;
    private int res = R.raw.chinahigh;
    Thread th;

    public SvgMapView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public SvgMapView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();

    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        th = new Thread(new MyThread());
        th.start();
    }

//    @Override
//    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
//        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
//        int heightMode = MeasureSpec.getMode(widthMeasureSpec);
//        int width = MeasureSpec.getSize(widthMeasureSpec);
//        int height = MeasureSpec.getSize(widthMeasureSpec);
//
//        minWith = width;
//        minHeight = height;
//
//        switch (widthMode) {
//            // 精确值
//            case MeasureSpec.EXACTLY:
//                width = ( width > minWith ?width : minWith);
//                break;
//            // 最大值
//            case MeasureSpec.AT_MOST:
//                width = ( width > minWith ?width : minWith);
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                width = ( width > minWith ?width : minWith);
//                break;
//
//        }
//
//        switch (heightMode) {
//            // 精确值
//            case MeasureSpec.EXACTLY:
//                height = ( height > minHeight ?height : minHeight);
//                break;
//            // 最大值
//            case MeasureSpec.AT_MOST:
//                height = ( height > minHeight ?height : minHeight);
//                break;
//            case MeasureSpec.UNSPECIFIED:
//                height = ( height > minHeight ?height : minHeight);
//                break;
//
//        }
//
//        setMeasuredDimension(width,height);
//
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mCanvas = canvas;
        canvas.save();
        canvas.scale(scale, scale);
        for (AreaItem item : itemList) {
            if (item != selectItem) {
                item.draw(canvas, mPaint, false);
            } else if (selectItem != null) {
                item.draw(canvas, mPaint, true);
            }
        }

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        return compat.onTouchEvent(event);
    }
//
//    Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            AreaItem item = new AreaItem();
//            itemList.clear();
//            InputStream is = mContext.getResources().openRawResource(res);
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //取得DocumentBuilderFactory实例
//            DocumentBuilder builder = null; //从factory获取DocumentBuilder实例
//            try {
//                builder = factory.newDocumentBuilder();
//                Document doc = builder.parse(is);
//                Element rootElement = doc.getDocumentElement();
//                NodeList items = rootElement.getElementsByTagName("path");
//                for (int i = 0; i < items.getLength(); i++) {
//                    Element element = (Element) items.item(i);
//                    String pathData = element.getAttribute("android:pathData");
//                    //Log.i("geohuo","----->"+pathData);
//                    Path path = PathParser.createPathFromPathData(pathData);
//                    item.setPath(path);
//                    itemList.add(item);
//                    item = new AreaItem();
//                }
//                handler.sendEmptyMessage(DRAW_VIEW);
//                Log.i("geohuo", "----->" + itemList.size());
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//    });


    class MyThread implements Runnable {

        @Override
        public void run() {
            AreaItem item = new AreaItem();
            itemList.clear();
            InputStream is = mContext.getResources().openRawResource(res);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  //取得DocumentBuilderFactory实例
            DocumentBuilder builder = null; //从factory获取DocumentBuilder实例
            try {
                builder = factory.newDocumentBuilder();
                Document doc = builder.parse(is);
                Element rootElement = doc.getDocumentElement();
                NodeList items = rootElement.getElementsByTagName("path");
                for (int i = 0; i < items.getLength(); i++) {
                    Element element = (Element) items.item(i);
                    String pathData = element.getAttribute("android:pathData");
                    //Log.i("geohuo","----->"+pathData);
                    Path path = PathParser.createPathFromPathData(pathData);
                    item.setPath(path);
                    itemList.add(item);
                    item = new AreaItem();
                }
                handler.sendEmptyMessage(DRAW_VIEW);
                Log.i("geohuo", "----->" + itemList.size());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == DRAW_VIEW) {
                if (itemList.size() != 0) {
                    int i = 0;
                    for (AreaItem item : itemList) {
                        item.setColor(colors[i % 4]);
                        i++;
                    }
                    postInvalidate();
                }
            }
        }
    };

    private GestureDetectorCompat compat = new GestureDetectorCompat(mContext, new GestureDetector.SimpleOnGestureListener() {
        @Override
        public boolean onDown(MotionEvent e) {
            handTouchEvent(e.getX(), e.getY());
            return super.onDown(e);
        }
    });

    private boolean handTouchEvent(float x, float y) {
        for (AreaItem item : itemList) {
            if (item.isInTouch(x / scale, y / scale)) {
                selectItem = item;
                postInvalidate();
                break;
            }

        }
        return false;
    }

    public void setRes(int raw){
        res = raw;
        th = new Thread(new MyThread());
        th.start();
    }





}
