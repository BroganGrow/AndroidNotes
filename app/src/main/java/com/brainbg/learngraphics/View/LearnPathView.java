package com.brainbg.learngraphics.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnPathView extends View {
    private static final String TAG = LearnPathView.class.getSimpleName();
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    int paddingLeft;
    int paddingTop;

    int paddingRight;
    int paddingBottom;

    public LearnPathView(Context context) {
        this(context, null);
    }

    public LearnPathView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LearnPathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.CYAN);
        mPaint.setColor(getResources().getColor(R.color.BrainbgColor));
        mPaint.setAntiAlias(true);//抗锯齿
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取宽的测量模式和大小
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        //获取高的测量模式和大小
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        // 设置wrap_content的默认宽 / 高值
        int mWidth = 5000;
        int mHeight = 5000;

        if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            // 宽高都为wrap_content
            initGlobalMeasure(mWidth, mHeight);
            Log.i(TAG, "宽高都为wrap_content");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT && getLayoutParams().height == ViewGroup.LayoutParams.MATCH_PARENT) {
            // 宽高都为match_parent
            initGlobalMeasure(widthSize, heightSize);
            Log.i(TAG, "宽高都为match_parent");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT && getLayoutParams().height == ViewGroup.LayoutParams.MATCH_PARENT) {
            // 宽wrap_content，高match_parent
            initGlobalMeasure(mWidth, heightSize);
            Log.i(TAG, "宽wrap_content，高match_parent");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT && getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            // 宽match_parent，高wrap_content
            initGlobalMeasure(widthSize, mHeight);
            Log.i(TAG, "宽match_parent，高wrap_content");
        }


    }

    private void initGlobalMeasure(int mWidth, int mHeight) {
        this.mWidth = mWidth;
        this.mHeight = mHeight;
        setMeasuredDimension(mWidth, mHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //padding值
        paddingLeft = getPaddingLeft();
        paddingTop = getPaddingTop();
        paddingRight = getPaddingRight();
        paddingBottom = getPaddingBottom();
        //宽高
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;
        //------------------------矩形路径---------------------------
        drawCenterDescr(canvas, 100 + paddingTop, "矩形路径");

        Path pathRect1 = new Path();
        RectF rectFRect1 = new RectF(50, 200 + paddingTop, 500, 400);
        pathRect1.addRect(rectFRect1, Path.Direction.CCW);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathRect1, mPaint);
        drawRightDescr(canvas, 300 + paddingTop, "addRect");

//        Path pathRect2 = new Path();
//        RectF rectFRect2 = new RectF(50, 400 + paddingTop, 500, 600);
//        pathRect2.addRect(rectFRect2, Path.Direction.CW);
//        mPaint.setStyle(Paint.Style.STROKE);
//        mPaint.setStrokeWidth(5);
//        canvas.drawPath(pathRect2, mPaint);
//        drawRightDescr(canvas, 500 + paddingTop, "逆时针,矩形路径");

//        String poem="世事一场大梦，人生几度秋凉";
//        mPaint.setTextSize(sp2px((float) 14));
//        mPaint.setColor(Color.RED);
//        canvas.drawTextOnPath(poem,pathRect1,0,10,mPaint);
//        canvas.drawTextOnPath(poem,pathRect2,0,10,mPaint);

        //------------------------椭圆路径---------------------------
        drawCenterDescr(canvas, 500 + paddingTop, "椭圆路径");

        Path pathOval = new Path();
        RectF rectFOval1 = new RectF(50, 600 + paddingTop, 500, 800);
        pathOval.addOval(rectFOval1, Path.Direction.CW);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathOval, mPaint);
        drawRightDescr(canvas, 700 + paddingTop, "addOval");
        //------------------------圆角矩形路径---------------------------
        drawCenterDescr(canvas, 900 + paddingTop, "圆角矩形路径");

        Path pathRoundRect1 = new Path();
        RectF rectFRoundRect = new RectF(50, 1000 + paddingTop, 500, 1200);
        pathRoundRect1.addRoundRect(rectFRoundRect,50,50,Path.Direction.CW);

        //统一圆角
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathRoundRect1, mPaint);
        drawRightDescr(canvas, 1100 + paddingTop, "统一四角,addRoundRect");

        //四角自定义
        Path pathRoundRect2 = new Path();
        RectF rectFRoundRect2 = new RectF(50, 1200 + paddingTop, 500, 1400);
        float[] radii={0,0,50,50,0,0,50,50};
        pathRoundRect2.addRoundRect(rectFRoundRect2,radii,Path.Direction.CW);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathRoundRect2, mPaint);
        drawRightDescr(canvas, 1300 + paddingTop, "四角自定义,addRoundRect");

        //------------------------圆形路径---------------------------
        drawCenterDescr(canvas, 1500 + paddingTop, "圆形路径");

        Path pathCircle = new Path();
        pathCircle.addCircle(250,1700,100,Path.Direction.CW);

        //统一圆角
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathCircle, mPaint);
        drawRightDescr(canvas, 1700 + paddingTop, "addCircle");

        //------------------------弧形路径---------------------------
        drawCenterDescr(canvas, 1900 + paddingTop, "弧形路径");

        Path pathArc = new Path();
        RectF rectFArc = new RectF(50,2000+paddingTop,500,2200);
        pathArc.addArc(rectFArc,0,120);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathArc, mPaint);
        drawRightDescr(canvas, 2100 + paddingTop, "addArc");

        //------------------------直线路径---------------------------
        drawCenterDescr(canvas, 2300 + paddingTop, "直线路径");

        //不闭合
        Path pathLines1 = new Path();
        pathLines1.moveTo(250,2400+paddingTop);
        pathLines1.lineTo(50,2600);
        pathLines1.lineTo(450,2600);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathLines1,mPaint);
        drawRightDescr(canvas, 2500 + paddingTop, "直线路径，不闭合");

        //闭合
        Path pathLines2 = new Path();
        pathLines2.moveTo(250,2600+paddingTop);
        pathLines2.lineTo(50,2800);
        pathLines2.lineTo(450,2800);
        pathLines2.close();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathLines2,mPaint);
        drawRightDescr(canvas, 2700 + paddingTop, "直线路径，闭合");

        //闭合
        Path pathLines3 = new Path();
        pathLines3.moveTo(250,2800+paddingTop);
        pathLines3.lineTo(100,3000);
        pathLines3.lineTo(400,2900);
        pathLines3.lineTo(100,2900);
        pathLines3.lineTo(100,2900);
        pathLines3.lineTo(400,3000);


        pathLines3.close();

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        canvas.drawPath(pathLines3,mPaint);
        drawRightDescr(canvas, 2900 + paddingTop, "五角星，闭合");
    }

    /**
     * 靠右描述
     *
     * @param canvas
     * @param y
     * @param descr
     */
    private void drawRightDescr(Canvas canvas, float y, String descr) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(sp2px((float) 12));
        mPaint.setFakeBoldText(true);
        canvas.drawText(descr, mWidth - paddingRight, y, mPaint);
    }

    /**
     * 中间描述
     *
     * @param canvas
     * @param y
     * @param descr
     */
    private void drawCenterDescr(Canvas canvas, float y, String descr) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setFakeBoldText(true);
        mPaint.setTextSize(sp2px((float) 16));
        canvas.drawText(descr, mWidth / 2, y, mPaint);
    }


    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dp(final float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int sp2px(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    public static int px2sp(final float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

}
