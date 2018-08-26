package com.mudrita.cmpe277.heartratemonitor;

import android.view.View;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;


/**
 * Created by mudrita on 3/30/18.
 */

public class HeartBeatView extends View {

    private static final Matrix matrix = new Matrix();
    private static final Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    private static Bitmap greenBitmap = null;
    private static Bitmap redBitmap = null;

    private static int parentWidth = 0;
    private static int parentHeight = 0;

    public HeartBeatView(Context context, AttributeSet attr) {
        super(context, attr);

//
//        Bitmap bitmap = BitmapFactory.decodeFile(objElement, options);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;


        greenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green_icon);
        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);

//        greenBitmap = BitmapFactory.decodeFile(R.drawable.green_icon, options);
//        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);
    }

    public HeartBeatView(Context context) {
        super(context);

        greenBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.green_icon);
        redBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.red_icon);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        parentWidth = MeasureSpec.getSize(widthMeasureSpec);
        parentHeight = MeasureSpec.getSize(heightMeasureSpec);
        setMeasuredDimension(parentWidth, parentHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (canvas == null) throw new NullPointerException();

        Bitmap bitmap = null;

//        Bitmap bitmap = BitmapFactory.decodeFile(objElement, options);
//        BitmapFactory.Options options = new BitmapFactory.Options();
//        options.inPreferredConfig = Bitmap.Config.ARGB_8888;

        if (HeartRateMonitor.getCurrent() == HeartRateMonitor.TYPE.GREEN) bitmap = greenBitmap;
            else bitmap = redBitmap;

        int bitmapX = bitmap.getWidth() / 2;
        int bitmapY = bitmap.getHeight() / 2;

        int parentX = parentWidth / 2;
        int parentY = parentHeight / 2;

        int centerX = parentX - bitmapX;
        int centerY = parentY - bitmapY;

        matrix.reset();
        matrix.postTranslate(centerX, centerY);
        canvas.drawBitmap(bitmap, matrix, paint);
    }
}
