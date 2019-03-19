package com.brainbg.learngraphics.View;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.brainbg.learngraphics.R;

public class LearnPaintView extends View {
    private  static  final  String TAG=LearnPaintView.class.getSimpleName();
    private Paint mPaint;

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
            setMeasuredDimension(mWidth, mHeight);
            Log.i(TAG,"宽高都为wrap_content");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT && getLayoutParams().height == ViewGroup.LayoutParams.MATCH_PARENT) {
            // 宽高都为match_parent
            setMeasuredDimension(widthSize, heightSize);
            Log.i(TAG,"宽高都为match_parent");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.WRAP_CONTENT&&getLayoutParams().height == ViewGroup.LayoutParams.MATCH_PARENT) {
            // 宽wrap_content，高match_parent
            setMeasuredDimension(mWidth, heightSize);
            Log.i(TAG,"宽wrap_content，高match_parent");
        } else if (getLayoutParams().width == ViewGroup.LayoutParams.MATCH_PARENT&&getLayoutParams().height == ViewGroup.LayoutParams.WRAP_CONTENT) {
            // 宽match_parent，高wrap_content
            setMeasuredDimension(widthSize, mHeight);
            Log.i(TAG,"宽match_parent，高wrap_content");
        }


    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //padding值
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        //宽高
        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;

        //内部填充：Paint.Style.FILL
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawRect(paddingLeft, paddingTop, width, 200, mPaint);

        //描边：Paint.Style.STROKE
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);//描边宽度
        canvas.drawRect(paddingLeft, paddingTop + 200, width, 400, mPaint);

        //内部填充和描边：Paint.Style.FILL_AND_STROKE
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawRect(paddingLeft, paddingTop + 400, width, 600, mPaint);

        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.BUTT);
        canvas.drawRect(paddingLeft, paddingTop+600, width, 800, mPaint);
        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawRect(paddingLeft, paddingTop+800, width, 1000, mPaint);
        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawRect(paddingLeft, paddingTop+1000, width, 1200, mPaint);


        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeJoin(Paint.Join.BEVEL);
        canvas.drawRect(paddingLeft, paddingTop+1200, width, 1400, mPaint);
        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeJoin(Paint.Join.MITER);
        canvas.drawRect(paddingLeft, paddingTop+1400, width, 1600, mPaint);
        //画矩形,内部填充
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        canvas.drawRect(paddingLeft, paddingTop+1600, width, 1800, mPaint);

    }
}
