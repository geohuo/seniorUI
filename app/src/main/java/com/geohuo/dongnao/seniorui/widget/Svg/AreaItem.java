package com.geohuo.dongnao.seniorui.widget.Svg;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Region;

import static android.graphics.Color.BLACK;

/**
 * Created by geohuo on 2017/6/1.
 */

public class AreaItem {
    private int color = 0x473C8B;

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    private Path path;

    public AreaItem() {
    }



    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void draw(Canvas canvas, Paint paint ,boolean isSelect){
        if (isSelect){
            paint.clearShadowLayer();
            paint.setStrokeWidth(2);
            paint.setColor(BLACK);
            paint.setStyle(Paint.Style.FILL);
            paint.setShadowLayer(6,0,0,0xFFFFFFFF);
            canvas.drawPath(path,paint);

            paint.clearShadowLayer();
            paint.setColor(BLACK);
            paint.setStyle(Paint.Style.FILL);
            paint.setStrokeWidth(2);
            canvas.drawPath(path,paint);
        }else {
            paint.clearShadowLayer();
            paint.setStrokeWidth(1);
            paint.setColor(BLACK);
            paint.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path,paint);

            paint.setColor(color);
            paint.setStyle(Paint.Style.FILL);
            canvas.drawPath(path,paint);

        }
    }

    public boolean isInTouch(float x, float y) {
        RectF rectF = new RectF();
        path.computeBounds(rectF,true);
        Region region = new Region((int)(rectF.left),(int)(rectF.top),(int)(rectF.right),(int)(rectF.bottom));
        region.setPath(path,new Region((int)(rectF.left),(int)(rectF.top),(int)(rectF.right),(int)(rectF.bottom)));
        return region.contains((int)x,(int)y);
    }
}
