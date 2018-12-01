package com.sidi.cardgames.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sidi.cardgames.R;
import com.sidi.cardgames.card.Card;
import com.sidi.cardgames.card.CardColumn;

/**
 * Created by Simon on 28/12/2017.
 */
public class CardColumnLayout extends LinearLayout {

    private CardColumn mColumn;
    private int mColumnIndex;
    private CardBitmapManager mCardBitmapManager;

    public CardColumnLayout(Context context, AttributeSet attrs) {
        super(context, attrs);

        mColumn = null;
        mColumnIndex = -1;
        mCardBitmapManager = null;
    }

    public void setCardColumn(CardColumn column, int index) {
        mColumn = column;
        mColumnIndex = index;
    }

    public void setCardBitmapManager(CardBitmapManager cardBitmapManager) {
        mCardBitmapManager = cardBitmapManager;
    }

    public void update() {

        if (mColumn == null || mCardBitmapManager == null) {
            return;
        }

        removeAllViews();

        LayoutInflater layoutInflater =
                (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        for (int i = 0; i < mColumn.size(); ++i) {

            if (i == 0) {
                layoutInflater.inflate(R.layout.view_top_card_column_card, this);
            } else {
                layoutInflater.inflate(R.layout.view_card_column_card, this);
            }

            // Get the view we just added
            View view = getChildAt(getChildCount() - 1);

            // Add some data so we know where it is when it's clicked on
            Integer columnIndex = mColumnIndex;
            Integer cardIndex = (mColumn.size() - i);
            view.setTag(R.id.columnID, columnIndex);
            view.setTag(R.id.columnCardCount, cardIndex);

//            if (i == 0) {
//                ViewGroup.LayoutParams params = view.getLayoutParams();
//                params.setMargins(params.leftMargin, 0, params.rightMargin, params.bottomMargin);
//            }


//            ImageView imageView = new ImageView(getContext());
//            LinearLayout.LayoutParams params =
//                    new LinearLayout.LayoutParams(
//                            ViewGroup.LayoutParams.MATCH_PARENT,
//                            ViewGroup.LayoutParams.WRAP_CONTENT
//                    );
//
//            float topDP = -40f;
//            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
//            float topPx = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topDP, displayMetrics);
//            if (i != 0) {
//                params.setMargins(0, (int) topPx, 0, 0);
//            }
//
//            imageView.setAdjustViewBounds(true);
//
//            addView(imageView, params);
        }

        int numViews = getChildCount();
        for (int i = numViews - 1; i >= 0; --i) {
            ImageView imageView = (ImageView) getChildAt(i);
            int cardNum = numViews - (i + 1);
            Card card = mColumn.peek(cardNum);
            if (card != null) {
                mCardBitmapManager.setBitmap(card, imageView);
            } else {
                imageView.setImageBitmap(null);
            }
        }

        invalidate();
        requestLayout();
    }

    public int getColumnIndex() {
        return mColumnIndex;
    }

}
