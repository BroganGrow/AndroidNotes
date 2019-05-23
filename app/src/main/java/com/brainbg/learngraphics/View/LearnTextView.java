package com.brainbg.learngraphics.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnTextView extends View {
    private static final String TAG = LearnTextView.class.getSimpleName();
    private Paint mPaint;
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


        mPaint.setColor(getResources().getColor(R.color.BrainbgColor));
        mPaint.setAntiAlias(true);//启用抗锯齿，但渲染速度会变慢

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
        canvas.drawText("吾虽浪迹天涯，却未迷失本心", 50, 300 + paddingTop, mPaint);
        drawRightDescr(canvas, 300 + paddingTop, "左对齐，填充");


        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("且随疾风前行，身后亦须留心", 360, 500 + paddingTop, mPaint);
        drawRightDescr(canvas, 500 + paddingTop, "居中对齐，描边");

        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.RIGHT);
        canvas.drawText("荣耀存于心，而非留于形", 580, 700 + paddingTop, mPaint);
        drawRightDescr(canvas, 700 + paddingTop, "右对齐，填充且描边");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(13);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setFakeBoldText(true);//粗体
        mPaint.setUnderlineText(true);//下划线
        mPaint.setStrikeThruText(true);//删除线
        canvas.drawText("汝欲赴死,易如反掌", 50, 900 + paddingTop, mPaint);
        drawRightDescr(canvas, 900 + paddingTop, "粗体、下划线、删除线");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSkewX((float) -0.25);
        canvas.drawText("荣耀存于心，而非留于形", 50, 1100 + paddingTop, mPaint);
        drawRightDescr(canvas, 1100 + paddingTop, "右斜：-0.25");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSkewX((float) 0.25);
        canvas.drawText("荣耀存于心，而非留于形", 50, 1300 + paddingTop, mPaint);
        drawRightDescr(canvas, 1300 + paddingTop, "左斜：0.25");


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setFakeBoldText(true);//粗体
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextScaleX(1);
        canvas.drawText("荣耀存于心", 50, 1500 + paddingTop, mPaint);
        drawRightDescr(canvas, 1500 + paddingTop, "水平拉伸2倍");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(getResources().getColor(R.color.colorAccent));
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextScaleX(2);
        canvas.drawText("荣耀存于心", 50, 1500 + paddingTop, mPaint);
        drawRightDescr(canvas, 1500 + paddingTop, "水平拉伸2倍");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);
        float[] pos = {50, 1700, 150, 1730, 250, 1760, 350, 1790};
        canvas.drawPosText("荣耀存于", pos, mPaint);
        drawRightDescr(canvas, 1700 + paddingTop, "指定文字位置");


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        Path circlePath = new Path();
        circlePath.addCircle(250, 2000, 100, Path.Direction.CW);
        canvas.drawPath(circlePath, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawTextOnPath("吾虽浪迹天涯，却未迷", circlePath, 0, 0, mPaint);
        drawRightDescr(canvas, 2000 + paddingTop, "沿路径绘,顺时针");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        Path circlePathx = new Path();
        circlePathx.addCircle(580, 2000, 100, Path.Direction.CW);
        canvas.drawPath(circlePathx, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawTextOnPath("吾虽浪迹天涯，却未迷", circlePathx, 150, 0, mPaint);
        drawRightDescr(canvas, 2000 + paddingTop, "沿路径绘,顺时针");


        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        Path circlePath1 = new Path();
        circlePath1.addCircle(250, 2400, 100, Path.Direction.CCW);
        canvas.drawPath(circlePath1, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawTextOnPath("风萧萧兮 ", circlePath1, 0, 0, mPaint);
        drawRightDescr(canvas, 2400 + paddingTop, "沿路径绘,逆时针");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(3);
        mPaint.setTextSize(dp2px(16));
        Path circlePath1x = new Path();
        circlePath1x.addCircle(580, 2400, 100, Path.Direction.CW);
        canvas.drawPath(circlePath1x, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawTextOnPath("吾虽浪迹天涯 ", circlePath1x, 0, 0, mPaint);
        drawRightDescr(canvas, 2400 + paddingTop, "沿路径绘,逆时针");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setTextSize(dp2px(16));
        mPaint.setTextAlign(Paint.Align.LEFT);

        String name = "繁体";
        Typeface font = Typeface.create(name, Typeface.NORMAL);
        mPaint.setTypeface(font);

        canvas.drawText("吾虽浪迹天涯，却未迷失本心", 50, 2600 + paddingTop, mPaint);
        drawRightDescr(canvas, 2600 + paddingTop, "左对齐，填充");
    }

    /**
     * 靠右描述
     *
     * @param canvas
     * @param y
     * @param descr
     */
    private void drawRightDescr(Canvas canvas, float y, String descr) {
        //重置属性
        mPaint.setUnderlineText(false);//下划线
        mPaint.setStrikeThruText(false);//删除线
        mPaint.setTextSkewX((float) 0);//倾斜度
        mPaint.setFakeBoldText(true);//粗体
        mPaint.setTextScaleX(1);//水平拉伸
        mPaint.setColor(getResources().getColor(R.color.BrainbgColor));//颜色
        mPaint.setStyle(Paint.Style.FILL);//填充
        mPaint.setTextAlign(Paint.Align.RIGHT);//靠右
        mPaint.setTextSize(sp2px((float) 12));//字体大小
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
