package com.sidi.cardgames.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sidi.cardgames.R;
import com.sidi.cardgames.framework.GameController;
import com.sidi.cardgames.framework.Move;
import com.sidi.cardgames.patience.model.PatienceGame;
import com.sidi.cardgames.patience.move.AdvanceDeckMove;
import com.sidi.cardgames.patience.move.ColumnToColumnMove;
import com.sidi.cardgames.patience.move.ColumnToFoundationPileMove;
import com.sidi.cardgames.patience.move.DeckToColumnMove;
import com.sidi.cardgames.patience.move.DeckToFoundationPileMove;
import com.sidi.cardgames.patience.view.PatienceGameView;
import com.sidi.cardgames.ui.CardColumnLayout;
import com.sidi.cardgames.ui.ResourceHandler;

public class PatienceActivity extends AppCompatActivity implements ResourceHandler {

    private GameController mGameController;

    private MoveStartData mMoveStartData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patience);

        PatienceGame game = new PatienceGame();
        PatienceGameView view = new PatienceGameView(game, this);
        mGameController = new GameController(game, view);

        mMoveStartData = null;
    }

    protected void onStart() {
        super.onStart();

        mGameController.startGame();
    }

    public void changeCard(View view) {
        ImageView imageView = (ImageView) view;
        imageView.setImageResource(R.drawable.s01);

        final CardColumnLayout layoutTest = (CardColumnLayout) findViewById(R.id.llColumn2);
        layoutTest.update();
    }

    public void deckClicked(View view) {
        Move move = new AdvanceDeckMove();
        mGameController.nextMove(move);
        mMoveStartData = null;
    }

    public void sideDeckClicked(View view) {
        mMoveStartData = new MoveStartData();
    }

    public void columnCardClicked(View view) {

        Integer columnIndex = (Integer) view.getTag(R.id.columnID);
        Integer numCards = (Integer) view.getTag(R.id.columnCardCount);

        if (mMoveStartData == null) {
                mMoveStartData = new MoveStartData(columnIndex, numCards);
        } else {
            Move move = null;
            MoveStartType moveType = mMoveStartData.getMoveStartType();
            switch (moveType) {
                case COLUMN:
                    move = new ColumnToColumnMove(mMoveStartData.getColumnIndex(), columnIndex, mMoveStartData.getCardIndex());
                    break;
                case SIDE_DECK:
                    move = new DeckToColumnMove(columnIndex);
                    break;
            }

            mGameController.nextMove(move);
            mMoveStartData = null;
        }

    }

    public void foundationPileClicked(View view) {

        if (mMoveStartData != null) {
            Integer pileIndex = (Integer) view.getTag(R.id.pileID);

            Move move = null;
            MoveStartType moveType = mMoveStartData.getMoveStartType();
            switch (moveType) {
                case COLUMN:
                    move = new ColumnToFoundationPileMove(mMoveStartData.getColumnIndex(), pileIndex);
                    break;
                case SIDE_DECK:
                    move = new DeckToFoundationPileMove(pileIndex);
                    break;
            }
            mGameController.nextMove(move);
            mMoveStartData = null;
        }
    }

    public void columnClicked(View view) {

        if (view instanceof CardColumnLayout) {
            CardColumnLayout column = (CardColumnLayout) view;
            int columnIndex = column.getColumnIndex();

            if (mMoveStartData != null) {
                Move move = null;
                MoveStartType moveType = mMoveStartData.getMoveStartType();
                switch (moveType) {
                    case COLUMN:
                        move = new ColumnToColumnMove(mMoveStartData.getColumnIndex(), columnIndex, mMoveStartData.getCardIndex());
                        break;
                    case SIDE_DECK:
                        move = new DeckToColumnMove(columnIndex);
                        break;
                }

                mGameController.nextMove(move);
                mMoveStartData = null;
            }
        }
    }

    private enum MoveStartType {
        COLUMN,
        SIDE_DECK
    }

    private class MoveStartData {

        private int mColumnIndex;
        private int mCardIndex;
        private MoveStartType mType;

        private MoveStartData(int columnIndex, int cardIndex) {
            mColumnIndex = columnIndex;
            mCardIndex = cardIndex;
            mType = MoveStartType.COLUMN;
        }

        private MoveStartData() {
            mType = MoveStartType.SIDE_DECK;
        }

        private int getColumnIndex() {
            return mColumnIndex;
        }

        private int getCardIndex() {
            return mCardIndex;
        }

        private MoveStartType getMoveStartType() {
            return mType;
        }

    };

}





//final CardColumnView columnView = (CardColumnView) findViewById(R.id.column1);
//        CardColumn test = new CardColumn();
//        test.dealCard(new Card(Suit.Heart, Value.King));
//        test.dealCard(new Card(Suit.Spade, Value.Queen));
//        test.dealCard(new Card(Suit.Diamond, Value.Jack));
//columnView.setColumn(test);
//columnView.setBitmapManager(mManager);

//        final CardColumnLayout layoutTest = (CardColumnLayout) findViewById(R.id.llColumn2);
//        layoutTest.setCardColumn(test);
//        layoutTest.update();