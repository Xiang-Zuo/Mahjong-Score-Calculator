package com.mahjong_winpoint_calculator;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.WindowManager;

import androidx.appcompat.widget.AppCompatImageView;

public class DrawImageView extends AppCompatImageView {

    private int width, height;
    // draw rect when camera view
    public DrawImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        width = wm.getDefaultDisplay().getWidth();
        height = wm.getDefaultDisplay().getHeight();
    }

    Paint paint = new Paint();

    {
        paint.setAntiAlias(true);
        paint.setColor(Color.RED);
        paint.setStyle(Style.STROKE);
        paint.setStrokeWidth(5f);//设置线宽
        paint.setAlpha(100);
    }

    ;

    @Override
    protected void onDraw(Canvas canvas) {
        // TODO Auto-generated method stub
        super.onDraw(canvas);
       // canvas.drawRect(new Rect(340, 500, 1850, 640), paint);//绘制矩形
        Log.i("Width and Height", width + "*" + height);

        int widthStart = (width) / 2;
        int heightStart = (height) / 2;

        canvas.drawRect(new Rect(widthStart - 160, heightStart - 354, widthStart + 160, heightStart - 212), paint);//绘制矩形
        canvas.drawRect(new Rect(widthStart - 160, heightStart - 212, widthStart + 160, heightStart - 70), paint);//绘制矩形
        canvas.drawRect(new Rect(widthStart - 160, heightStart - 70, widthStart + 160, heightStart + 72), paint);//绘制矩形
        canvas.drawRect(new Rect(widthStart - 160, heightStart + 72, widthStart + 160, heightStart + 214), paint);//绘制矩形
        canvas.drawRect(new Rect(widthStart - 107, heightStart + 214, widthStart + 107, heightStart + 356), paint);//绘制矩形
    }

}