package com.sidi.cardgames.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.media.Image;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.sidi.cardgames.R;
import com.sidi.cardgames.card.Card;
import com.sidi.cardgames.card.Suit;
import com.sidi.cardgames.card.Value;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 27/12/2017.
 */
public class CardBitmapManager {

//    private final Map<Card, Bitmap> mCardBitmapMap;
    private final Map<Card, Integer> mCardResIdMap;

    public CardBitmapManager(Resources resources) {
//        mCardBitmapMap = initMap(resources);
        mCardResIdMap = initMap();
    }

    private Map<Card, Integer> initMap() {
        Map<Card, Integer> map = new HashMap<Card, Integer>();

        map.put(new Card(Suit.Club, Value.Ace), R.drawable.c01);
        map.put(new Card(Suit.Club, Value.Two), R.drawable.c02);
        map.put(new Card(Suit.Club, Value.Three), R.drawable.c03);
        map.put(new Card(Suit.Club, Value.Four), R.drawable.c04);
        map.put(new Card(Suit.Club, Value.Five), R.drawable.c05);
        map.put(new Card(Suit.Club, Value.Six), R.drawable.c06);
        map.put(new Card(Suit.Club, Value.Seven), R.drawable.c07);
        map.put(new Card(Suit.Club, Value.Eight), R.drawable.c08);
        map.put(new Card(Suit.Club, Value.Nine), R.drawable.c09);
        map.put(new Card(Suit.Club, Value.Ten), R.drawable.c10);
        map.put(new Card(Suit.Club, Value.Jack), R.drawable.c11);
        map.put(new Card(Suit.Club, Value.Queen), R.drawable.c12);
        map.put(new Card(Suit.Club, Value.King), R.drawable.c13);

        map.put(new Card(Suit.Diamond, Value.Ace), R.drawable.d01);
        map.put(new Card(Suit.Diamond, Value.Two), R.drawable.d02);
        map.put(new Card(Suit.Diamond, Value.Three), R.drawable.d03);
        map.put(new Card(Suit.Diamond, Value.Four), R.drawable.d04);
        map.put(new Card(Suit.Diamond, Value.Five), R.drawable.d05);
        map.put(new Card(Suit.Diamond, Value.Six), R.drawable.d06);
        map.put(new Card(Suit.Diamond, Value.Seven), R.drawable.d07);
        map.put(new Card(Suit.Diamond, Value.Eight), R.drawable.d08);
        map.put(new Card(Suit.Diamond, Value.Nine), R.drawable.d09);
        map.put(new Card(Suit.Diamond, Value.Ten), R.drawable.d10);
        map.put(new Card(Suit.Diamond, Value.Jack), R.drawable.d11);
        map.put(new Card(Suit.Diamond, Value.Queen), R.drawable.d12);
        map.put(new Card(Suit.Diamond, Value.King), R.drawable.d13);

        map.put(new Card(Suit.Heart, Value.Ace), R.drawable.h01);
        map.put(new Card(Suit.Heart, Value.Two), R.drawable.h02);
        map.put(new Card(Suit.Heart, Value.Three), R.drawable.h03);
        map.put(new Card(Suit.Heart, Value.Four), R.drawable.h04);
        map.put(new Card(Suit.Heart, Value.Five), R.drawable.h05);
        map.put(new Card(Suit.Heart, Value.Six), R.drawable.h06);
        map.put(new Card(Suit.Heart, Value.Seven), R.drawable.h07);
        map.put(new Card(Suit.Heart, Value.Eight), R.drawable.h08);
        map.put(new Card(Suit.Heart, Value.Nine), R.drawable.h09);
        map.put(new Card(Suit.Heart, Value.Ten), R.drawable.h10);
        map.put(new Card(Suit.Heart, Value.Jack), R.drawable.h11);
        map.put(new Card(Suit.Heart, Value.Queen),  R.drawable.h12);
        map.put(new Card(Suit.Heart, Value.King), R.drawable.h13);

        map.put(new Card(Suit.Spade, Value.Ace), R.drawable.s01);
        map.put(new Card(Suit.Spade, Value.Two), R.drawable.s02);
        map.put(new Card(Suit.Spade, Value.Three), R.drawable.s03);
        map.put(new Card(Suit.Spade, Value.Four), R.drawable.s04);
        map.put(new Card(Suit.Spade, Value.Five), R.drawable.s05);
        map.put(new Card(Suit.Spade, Value.Six), R.drawable.s06);
        map.put(new Card(Suit.Spade, Value.Seven), R.drawable.s07);
        map.put(new Card(Suit.Spade, Value.Eight), R.drawable.s08);
        map.put(new Card(Suit.Spade, Value.Nine), R.drawable.s09);
        map.put(new Card(Suit.Spade, Value.Ten), R.drawable.s10);
        map.put(new Card(Suit.Spade, Value.Jack), R.drawable.s11);
        map.put(new Card(Suit.Spade, Value.Queen), R.drawable.s12);
        map.put(new Card(Suit.Spade, Value.King), R.drawable.s13);

        return map;
    }

//    private static Map<Card, Bitmap> initMap(Resources resources) {
//        Map<Card, Bitmap> map = new HashMap<Card, Bitmap>();

//        map.put(new Card(Suit.Club, Value.Ace), BitmapFactory.decodeResource(resources, R.drawable.c01));
//        map.put(new Card(Suit.Club, Value.Two), BitmapFactory.decodeResource(resources, R.drawable.c02));
//        map.put(new Card(Suit.Club, Value.Three), BitmapFactory.decodeResource(resources, R.drawable.c03));
//        map.put(new Card(Suit.Club, Value.Four), BitmapFactory.decodeResource(resources, R.drawable.c04));
//        map.put(new Card(Suit.Club, Value.Five), BitmapFactory.decodeResource(resources, R.drawable.c05));
//        map.put(new Card(Suit.Club, Value.Six), BitmapFactory.decodeResource(resources, R.drawable.c06));
//        map.put(new Card(Suit.Club, Value.Seven), BitmapFactory.decodeResource(resources, R.drawable.c07));
//        map.put(new Card(Suit.Club, Value.Eight), BitmapFactory.decodeResource(resources, R.drawable.c08));
//        map.put(new Card(Suit.Club, Value.Nine), BitmapFactory.decodeResource(resources, R.drawable.c09));
//        map.put(new Card(Suit.Club, Value.Ten), BitmapFactory.decodeResource(resources, R.drawable.c10));
//        map.put(new Card(Suit.Club, Value.Jack), BitmapFactory.decodeResource(resources, R.drawable.c11));
//        map.put(new Card(Suit.Club, Value.Queen), BitmapFactory.decodeResource(resources, R.drawable.c12));
//        map.put(new Card(Suit.Club, Value.King), BitmapFactory.decodeResource(resources, R.drawable.c13));
//
//        map.put(new Card(Suit.Diamond, Value.Ace), BitmapFactory.decodeResource(resources, R.drawable.d01));
//        map.put(new Card(Suit.Diamond, Value.Two), BitmapFactory.decodeResource(resources, R.drawable.d02));
//        map.put(new Card(Suit.Diamond, Value.Three), BitmapFactory.decodeResource(resources, R.drawable.d03));
//        map.put(new Card(Suit.Diamond, Value.Four), BitmapFactory.decodeResource(resources, R.drawable.d04));
//        map.put(new Card(Suit.Diamond, Value.Five), BitmapFactory.decodeResource(resources, R.drawable.d05));
//        map.put(new Card(Suit.Diamond, Value.Six), BitmapFactory.decodeResource(resources, R.drawable.d06));
//        map.put(new Card(Suit.Diamond, Value.Seven), BitmapFactory.decodeResource(resources, R.drawable.d07));
//        map.put(new Card(Suit.Diamond, Value.Eight), BitmapFactory.decodeResource(resources, R.drawable.d08));
//        map.put(new Card(Suit.Diamond, Value.Nine), BitmapFactory.decodeResource(resources, R.drawable.d09));
//        map.put(new Card(Suit.Diamond, Value.Ten), BitmapFactory.decodeResource(resources, R.drawable.d10));
//        map.put(new Card(Suit.Diamond, Value.Jack), BitmapFactory.decodeResource(resources, R.drawable.d11));
//        map.put(new Card(Suit.Diamond, Value.Queen), BitmapFactory.decodeResource(resources, R.drawable.d12));
//        map.put(new Card(Suit.Diamond, Value.King), BitmapFactory.decodeResource(resources, R.drawable.d13));
//
//        map.put(new Card(Suit.Heart, Value.Ace), BitmapFactory.decodeResource(resources, R.drawable.h01));
//        map.put(new Card(Suit.Heart, Value.Two), BitmapFactory.decodeResource(resources, R.drawable.h02));
//        map.put(new Card(Suit.Heart, Value.Three), BitmapFactory.decodeResource(resources, R.drawable.h03));
//        map.put(new Card(Suit.Heart, Value.Four), BitmapFactory.decodeResource(resources, R.drawable.h04));
//        map.put(new Card(Suit.Heart, Value.Five), BitmapFactory.decodeResource(resources, R.drawable.h05));
//        map.put(new Card(Suit.Heart, Value.Six), BitmapFactory.decodeResource(resources, R.drawable.h06));
//        map.put(new Card(Suit.Heart, Value.Seven), BitmapFactory.decodeResource(resources, R.drawable.h07));
//        map.put(new Card(Suit.Heart, Value.Eight), BitmapFactory.decodeResource(resources, R.drawable.h08));
//        map.put(new Card(Suit.Heart, Value.Nine), BitmapFactory.decodeResource(resources, R.drawable.h09));
//        map.put(new Card(Suit.Heart, Value.Ten), BitmapFactory.decodeResource(resources, R.drawable.h10));
//        map.put(new Card(Suit.Heart, Value.Jack), BitmapFactory.decodeResource(resources, R.drawable.h11));
//        map.put(new Card(Suit.Heart, Value.Queen), BitmapFactory.decodeResource(resources, R.drawable.h12));
//        map.put(new Card(Suit.Heart, Value.King), BitmapFactory.decodeResource(resources, R.drawable.h13));
//
//        map.put(new Card(Suit.Spade, Value.Ace), BitmapFactory.decodeResource(resources, R.drawable.s01));
//        map.put(new Card(Suit.Spade, Value.Two), BitmapFactory.decodeResource(resources, R.drawable.s02));
//        map.put(new Card(Suit.Spade, Value.Three), BitmapFactory.decodeResource(resources, R.drawable.s03));
//        map.put(new Card(Suit.Spade, Value.Four), BitmapFactory.decodeResource(resources, R.drawable.s04));
//        map.put(new Card(Suit.Spade, Value.Five), BitmapFactory.decodeResource(resources, R.drawable.s05));
//        map.put(new Card(Suit.Spade, Value.Six), BitmapFactory.decodeResource(resources, R.drawable.s06));
//        map.put(new Card(Suit.Spade, Value.Seven), BitmapFactory.decodeResource(resources, R.drawable.s07));
//        map.put(new Card(Suit.Spade, Value.Eight), BitmapFactory.decodeResource(resources, R.drawable.s08));
//        map.put(new Card(Suit.Spade, Value.Nine), BitmapFactory.decodeResource(resources, R.drawable.s09));
//        map.put(new Card(Suit.Spade, Value.Ten), BitmapFactory.decodeResource(resources, R.drawable.s10));
//        map.put(new Card(Suit.Spade, Value.Jack), BitmapFactory.decodeResource(resources, R.drawable.s11));
//        map.put(new Card(Suit.Spade, Value.Queen), BitmapFactory.decodeResource(resources, R.drawable.s12));
//        map.put(new Card(Suit.Spade, Value.King), BitmapFactory.decodeResource(resources, R.drawable.s13));

//        return map;
//    }

//    public Bitmap getBitmap(Card card) {
////        if (mCardBitmapMap.containsKey(card)) {
////            return mCardBitmapMap.get(card);
////        } else {
////            return null;
////        }
//        int resID = -1;
//        if (!card.isFaceUp()) {
//            resID = R.drawable.empty;
//        } else if (mCardResIdMap.containsKey(card)) {
//            resID = mCardResIdMap.get(card);
//        } else {
//            return null;
//        }
////            BitmapTarget target = new BitmapTarget(100, 300);
////            Glide.with(context).load(resID).asBitmap().into(target);
////            while (!target.isReady());
////            return target.getBitmap();
//
//        Glide.with(mContext)
//                .load(resID)
//                .asBitmap()
//                .into(new SimpleTarget<Bitmap>(100, 300) {
//                    @Override
//                    public void onResourceReady(Bitmap bitmap, GlideAnimation anim) {
//                        // Do something with bitmap here.
//                        int i = 1;
//                    }
//                });
//        return null;
//
//    }

    public void setBitmap(Card card, ImageView imageView) {
        if (!card.isFaceUp()) {
            setAsCardBack(imageView);
        } else if (mCardResIdMap.containsKey(card)) {
            int resID = mCardResIdMap.get(card);
            Glide.with(imageView.getContext()).load(resID).into(imageView);
        }
    }

    public void setAsEmptyCard(ImageView imageView) {
        Glide.with(imageView.getContext()).load(R.drawable.empty).into(imageView);
    }

    public void setAsCardBack(ImageView imageView) {
        Glide.with(imageView.getContext()).load(R.drawable.card_back_05).into(imageView);
    }

//    private class BitmapTarget extends SimpleTarget<Bitmap> {
//
//        private Bitmap mBitmap;
//        private boolean mReady;
//
//        public BitmapTarget(int width, int height) {
//            super(width, height);
//            mBitmap = null;
//            mReady = false;
//        }
//
//        @Override
//        public void onResourceReady(Bitmap resource, GlideAnimation<? super Bitmap> glideAnimation) {
//            mBitmap = resource;
//            mReady = true;
//        }
//
//        public boolean isReady() {
//            return mReady;
//        }
//
//        public Bitmap getBitmap() {
//            return mBitmap;
//        }
//    }

}
