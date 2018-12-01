package com.sidi.cardgames.ui.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.sidi.cardgames.R;

/**
 * Created by Simon on 27/12/2017.
 */
public class ViewTest extends View {

    private boolean mFill;
    private Paint mPaint;
    private RectF mBounds;
    private RectF mInnerBounds;

    public ViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.ViewTest,
                0,
                0);

        try {
            mFill = a.getBoolean(R.styleable.ViewTest_fill, false);
        } finally {
            a.recycle();
        }

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        if (mFill) {
            mPaint.setStyle(Paint.Style.FILL);
        }

        mBounds = new RectF();
        mInnerBounds = new RectF();
    }

    public boolean isFill() {
        return mFill;
    }

    public void setFill(boolean fill) {
        mFill = fill;
        invalidate();
        requestLayout();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float xpad = (float) (getPaddingLeft() + getPaddingRight());
        float ypad = (float) (getPaddingTop() + getPaddingBottom());

        float ww = (float) (w - xpad);
        float hh = (float) (h - ypad);

        mBounds = new RectF(0.0f,0.0f, ww, hh);
        mBounds.offsetTo(getPaddingLeft(), getPaddingTop());

        float innerLeft = ww / 4;
        float innerTop = hh / 4;
        float innerRight = innerLeft + ww / 2;
        float innerBottom = innerTop + hh / 2;
        mInnerBounds = new RectF(innerLeft, innerTop, innerRight, innerBottom );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int blue = 0xff0000ff;
        int red = 0xffff0000;
        mPaint.setColor(blue);
        canvas.drawRect(mBounds, mPaint);

        mPaint.setColor(red);
        canvas.drawRect(mInnerBounds, mPaint);
    }
}
