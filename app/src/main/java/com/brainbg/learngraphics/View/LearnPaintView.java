package com.brainbg.learngraphics.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnPaintView extends View {
    private static final String TAG = LearnPaintView.class.getSimpleName();
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    int paddingLeft;
    int paddingTop;

    int paddingRight;
    int paddingBottom;

    public LearnPaintView(Context context) {
        this(context, null);
    }

    public LearnPaintView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LearnPaintView(Context context, AttributeSet attrs, int defStyleAttr) {
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
        //------------------------Paint.Style 画笔风格---------------------------
        drawCenterDescr(canvas, 100 + paddingTop, "Paint.Style 画笔风格");

        //内部填充
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 200, 500, 400, mPaint);
        drawRightDescr(canvas, 300 + paddingTop, "Paint.Style.FILL");
        //描边
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(20);//描边宽度
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 400, 500, 600, mPaint);
        drawRightDescr(canvas, 500 + paddingTop, "Paint.Style.STROKE");
        //内部填充和描边
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 600, 500, 800, mPaint);
        drawRightDescr(canvas, 700 + paddingTop, "Paint.Style.FILL_AND_STROKE");

        //------------------------ 线帽---------------------------
        drawCenterDescr(canvas, 900 + paddingTop, "Paint.Cap 线帽");
        //无线帽
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        mPaint.setStrokeWidth(140);//线冒宽度
        canvas.drawLine(paddingLeft * 3, paddingTop + 1100, 470, paddingTop + 1100, mPaint);
        drawRightDescr(canvas, 1100 + paddingTop, "Paint.Cap.BUTT");
        //圆形线帽
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawLine(paddingLeft * 3, paddingTop + 1300, 470, paddingTop + 1300, mPaint);
        drawRightDescr(canvas, 1300 + paddingTop, "Paint.Cap.ROUND");
        //方形线帽
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawLine(paddingLeft * 3, paddingTop + 1500, 470, paddingTop + 1500, mPaint);
        drawRightDescr(canvas, 1500 + paddingTop, "Paint.Cap.SQUARE");

        //------------------------节点---------------------------
        drawCenterDescr(canvas, 1700 + paddingTop, "Paint.Join 节点");

        //Paint.Join.BEVEL
        Path path1 = new Path();
        path1.moveTo(paddingLeft*2, 1900);
        path1.lineTo(500, 1900);
        path1.lineTo(200, 2000);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawPath(path1, mPaint);
        drawRightDescr(canvas, 1900 + paddingTop, "路径,Paint.Join.BEVEL");

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        mPaint.setStrokeWidth(30);//描边宽度
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 2000, 500, 2200, mPaint);
        drawRightDescr(canvas, 2100 + paddingTop, "矩形,Paint.Join.BEVEL");

        //Paint.Join.MITER
        Path path2 = new Path();
        path2.moveTo(paddingLeft*2, 2300);
        path2.lineTo(500, 2300);
        path2.lineTo(200, 2400);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawPath(path2, mPaint);
        drawRightDescr(canvas, 2300 + paddingTop*2, "路径,Paint.Join.MITER");

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        mPaint.setStrokeWidth(30);//描边宽度
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 2400, 500, 2600, mPaint);
        drawRightDescr(canvas, 2500 + paddingTop, "矩形,Paint.Join.MITER");

        //Paint.Join.ROUND
        Path path3 = new Path();
        path3.moveTo(paddingLeft*2, 2700);
        path3.lineTo(500, 2700);
        path3.lineTo(200, 2800);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(30);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawPath(path3, mPaint);
        drawRightDescr(canvas, 2700 + paddingTop*2, "路径,Paint.Join.ROUND");

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeWidth(30);//描边宽度
        canvas.drawRect(paddingLeft*2, paddingTop*2 + 2800, 500, 3000, mPaint);
        drawRightDescr(canvas, 2900 + paddingTop, "矩形,Paint.Join.ROUND");

        //------------------------对齐方式---------------------------
        drawCenterDescr(canvas, 3100 + paddingTop, "Paint.Align 对齐方式");

        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setFakeBoldText(true);

        mPaint.setTextAlign(Paint.Align.LEFT);
        mPaint.setTextSize(sp2px((float) 12));
        canvas.drawText("左对齐", paddingRight, 3300, mPaint);

        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setTextSize(sp2px((float) 12));
        canvas.drawText("中间对齐", mWidth/2, 3300, mPaint);

        mPaint.setTextAlign(Paint.Align.RIGHT);
        mPaint.setTextSize(sp2px((float) 12));
        canvas.drawText("右对齐", mWidth-paddingRight, 3300, mPaint);

        //------------------------对齐方式---------------------------

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
