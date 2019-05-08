package com.brainbg.learngraphics.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnTextView extends View {
    private static final String TAG = LearnTextView.class.getSimpleName();
    private Paint mPaint,mPaintx;
    private int mWidth;
    private int mHeight;
    int paddingLeft;
    int paddingTop;

    int paddingRight;
    int paddingBottom;

    public LearnTextView(Context context) {
        this(context, null);
    }

    public LearnTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LearnTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();
        mPaintx = new Paint();

        mPaint.setColor(getResources().getColor(R.color.BrainbgColor));
        mPaintx.setColor(getResources().getColor(R.color.BrainbgColor));
        mPaint.setAntiAlias(true);//启用抗锯齿，但渲染速度会变慢
        mPaintx.setAntiAlias(true);//启用抗锯齿，但渲染速度会变慢
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
        //------------------------文字填充线效果---------------------------
        drawCenterDescr(canvas, 100 + paddingTop, "文字效果");


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("吾虽浪迹天涯，却未迷失本心",50,300+ paddingTop,mPaint);
        drawRightDescr(canvas, 300 + paddingTop, "左对齐，填充");


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("且随疾风前行，身后亦须留心",360,500+ paddingTop,mPaint);
        drawRightDescr(canvas, 500 + paddingTop, "居中对齐，描边");

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("荣耀存于心，而非留于形",580,700+ paddingTop,mPaint);
        drawRightDescr(canvas, 700 + paddingTop, "右对齐，填充且描边");

        mPaintx.setStyle(Paint.Style.FILL);
        mPaintx.setStrokeWidth(13);
        mPaintx.setTextSize(dp2px(16));
        mPaintx.setTextAlign(Paint.Align.LEFT);
        mPaintx.setFakeBoldText(true);//粗体
        mPaintx.setUnderlineText(true);//下划线
        mPaintx.setStrikeThruText(true);//删除线
        canvas.drawText("汝欲赴死,易如反掌",50,900+ paddingTop,mPaintx);
        drawRightDescr(canvas, 900 + paddingTop, "粗体、下划线、删除线");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSkewX((float)-0.25);
        canvas.drawText("荣耀存于心，而非留于形",50,1100+ paddingTop,mPaint);
        drawRightDescr(canvas, 1100 + paddingTop, "右斜：-0.25");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSkewX((float)0.25);
        canvas.drawText("荣耀存于心，而非留于形",50,1300+ paddingTop,mPaint);
        drawRightDescr(canvas, 1300 + paddingTop, "左斜：0.25");
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
