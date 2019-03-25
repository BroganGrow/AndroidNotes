package com.brainbg.learngraphics.View;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnCanvasView extends View {
    private static final String TAG = LearnCanvasView.class.getSimpleName();
    private Paint mPaint;
    private int mWidth;
    private int mHeight;
    int paddingLeft;
    int paddingTop;
    int paddingRight;
    int paddingBottom;
    private Rect rect;
    private RectF rectF;

    public LearnCanvasView(Context context) {
        this(context, null);
    }

    public LearnCanvasView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LearnCanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
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

    private void init() {
        mPaint = new Paint();
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.CYAN);
        mPaint.setColor(getResources().getColor(R.color.BrainbgColor));
        mPaint.setAntiAlias(true);//抗锯齿

        //onDraw（）调用非常频繁，避免在其内分配对象,
        rect = new Rect();
        rectF = new RectF();
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
        //------------------------矩形---------------------------
        drawCenterDescr(canvas, 100 + paddingTop, "矩形");

        //直接四点绘制
        canvas.drawRect(paddingLeft, paddingTop + 200, 500, 400, mPaint);
        drawRightDescr(canvas, 300 + paddingTop, "直接四点绘制");

        //Rect绘制
        rect.left = paddingLeft;
        rect.top = paddingTop + 400;
        rect.right = 500;
        rect.bottom = 600;
        canvas.drawRect(rect, mPaint);
        drawRightDescr(canvas, 500 + paddingTop, "Rect绘制");

        //Rect绘制
        rectF.left = paddingLeft;
        rectF.top = paddingTop + 600;
        rectF.right = 500;
        rectF.bottom = 800;
        canvas.drawRect(rectF, mPaint);
        drawRightDescr(canvas, 700 + paddingTop, "RectF绘制");

        //------------------------弧形---------------------------
        drawCenterDescr(canvas, 900 + paddingTop, "弧形");
        //
        rectF.left = paddingLeft;
        rectF.top = paddingTop + 1000;
        rectF.right = 500;
        rectF.bottom = 1200;
        canvas.drawArc(rectF, 0, 270, true, mPaint);
        drawRightDescr(canvas, 1100 + paddingTop, "useCenter:true");

        //
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        rectF.left = paddingLeft;
        rectF.top = paddingTop + 1200;
        rectF.right = 500;
        rectF.bottom = 1400;
        canvas.drawArc(rectF, 0, 270, true, mPaint);
        drawRightDescr(canvas, 1300 + paddingTop, "useCenter:true");
        //
        mPaint.setStyle(Paint.Style.FILL);
        rectF.left = paddingLeft;
        rectF.top = paddingTop + 1400;
        rectF.right = 500;
        rectF.bottom = 1600;
        canvas.drawArc(rectF, 0, 120, false, mPaint);
        drawRightDescr(canvas, 1500 + paddingTop, "useCenter:false");

        //
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        rectF.left = paddingLeft;
        rectF.top = paddingTop + 1600;
        rectF.right = 500;
        rectF.bottom = 1800;
        canvas.drawArc(rectF, 0, 120, false, mPaint);
        drawRightDescr(canvas, 1700 + paddingTop, "useCenter:false");

        //------------------------圆形---------------------------
        drawCenterDescr(canvas, 1900 + paddingTop, "圆形");

        canvas.drawCircle(paddingLeft + 250, 2100, 90, mPaint);
        drawRightDescr(canvas, 2100 + paddingTop, "圆形");

        //------------------------直线/多线---------------------------
        drawCenterDescr(canvas, 2300 + paddingTop, "直线/多线");
        //直线
        canvas.drawLine(paddingLeft + 50, paddingTop + 2500, 500, paddingTop + 2500, mPaint);
        drawRightDescr(canvas, 2500 + paddingTop, "直线");
        //斜直线
        canvas.drawLine(paddingLeft + 50, paddingTop + 2650, 500, paddingTop + 2750, mPaint);
        drawRightDescr(canvas, 2700 + paddingTop, "斜直线");
        //多条直线｛x1,y1,x2,y2,x3,y3,……｝，每2个元素为一点，每4个元素为一条直线
        float pts[] = {40, 2900, 140, 2900,
                150, 2900, 250, 2900,
                260, 2900, 360, 2900,
                370, 2900, 470, 2900};
        canvas.drawLines(pts, mPaint);
        drawRightDescr(canvas, 2900 + paddingTop, "直接绘制多条直线");

        float pts1[] = {40, 3100, 140, 3100,
                150, 3100, 250, 3100,
                260, 3100, 360, 3100,
                370, 3100, 470, 3100};
        canvas.drawLines(pts1, 4, 10, mPaint);
        drawRightDescr(canvas, 3100 + paddingTop, "选择性绘制多条直线");

        //------------------------点/多点---------------------------
        drawCenterDescr(canvas, 3300 + paddingTop, "点/多点");
        //单点
        mPaint.setStrokeWidth(15);
        canvas.drawPoint(250,3500,mPaint);
        drawRightDescr(canvas, 3500 + paddingTop, "点");
        //直接绘制多个点
        mPaint.setStrokeWidth(15);
        float pts3[] = {100, 3700,
                200, 3720,
                300, 3740,
                400, 3760,
                500, 3780};
        canvas.drawPoints(pts3,mPaint);
        drawRightDescr(canvas, 3700 + paddingTop, "直接绘制多个点");
        //选择性绘制多个点
        mPaint.setStrokeWidth(15);
        float pts4[] = {100, 3950,
                200, 3950,
                300, 3900,
                400, 3900,
                500, 3950};
        canvas.drawPoints(pts4,2,8,mPaint);
        drawRightDescr(canvas, 3900 + paddingTop, "选择性绘制多个点");

        //------------------------点/多点---------------------------
        drawCenterDescr(canvas, 4100 + paddingTop, "点/多点");
        
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
