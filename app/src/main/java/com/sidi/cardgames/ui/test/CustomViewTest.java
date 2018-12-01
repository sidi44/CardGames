package com.sidi.cardgames.ui.test;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.sidi.cardgames.R;
import com.sidi.cardgames.card.Card;
import com.sidi.cardgames.card.CardColumn;
import com.sidi.cardgames.ui.CardBitmapManager;

/**
 * Created by Simon on 27/12/2017.
 */
public class CustomViewTest extends View {

    private int mMaxCards;
    private float mOverlap;
    private float mCardHeight;

    private CardColumn mColumn;

    private CardBitmapManager mBitmapManager;
    private RectF mBounds;
    private Paint mPaint;

    public CustomViewTest(Context context, AttributeSet attrs) {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.CustomViewTest,
                0,
                0);

        try {
            mMaxCards = a.getInteger(R.styleable.CustomViewTest_maxCards, 19);
            mOverlap = a.getFloat(R.styleable.CustomViewTest_cardOverlap, 0.2f);
        } finally {
            a.recycle();
        }

        //mBitmapManager = new CardBitmapManager(getResources());
        mBounds = new RectF();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    public void setBitmapManager(CardBitmapManager bitmapManager) {
        mBitmapManager = bitmapManager;
    }

    public int getMaxCards() {
        return mMaxCards;
    }

    public void setMaxCards(int maxCards) {
        mMaxCards = maxCards;
        invalidate();
        requestLayout();
    }

    public void setColumn(CardColumn column) {
        mColumn = column;
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float xPad = (float) (getPaddingLeft() + getPaddingRight());
        float yPad = (float) (getPaddingTop() + getPaddingBottom());

        float ww = (float) (w - xPad);
        float hh = (float) (h - yPad);

        mBounds = new RectF(0.0f,0.0f, ww, hh);
        mBounds.offsetTo(getPaddingLeft(), getPaddingTop());

        float divisor = 1f + (1 - mOverlap) * (mMaxCards - 1);
        mCardHeight = mBounds.height() / divisor;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        CardBitmapManager test = new CardBitmapManager(getResources());
        for (int i = mColumn.size() - 1; i >=0 ; --i) {
            Card card = mColumn.peek(i);
//            Bitmap bm = test.getBitmap(card);
//            RectF pos = getCardPosition((mColumn.size() - 1) - i);
//            if (bm != null) {
//                canvas.drawBitmap(bm, null, pos, mPaint);
//            }
        }

    }

    private RectF getCardPosition(int index) {

        float top = mBounds.top + (index * mCardHeight * mOverlap);
        float bottom = top + mCardHeight;
        float left = mBounds.left;
        float right = mBounds.right;
        RectF rect = new RectF(left, top, right, bottom);

        return rect;
    }
}
