package com.sidi.cardgames.patience.view;

import android.content.res.Resources;
import android.widget.ImageView;

import com.sidi.cardgames.R;
import com.sidi.cardgames.card.Card;
import com.sidi.cardgames.card.CardColumn;
import com.sidi.cardgames.card.FoundationPile;
import com.sidi.cardgames.card.Suit;
import com.sidi.cardgames.framework.Game;
import com.sidi.cardgames.framework.GameView;
import com.sidi.cardgames.patience.model.PatienceGame;
import com.sidi.cardgames.patience.model.PatienceGameState;
import com.sidi.cardgames.patience.move.PatienceMove;
import com.sidi.cardgames.ui.CardBitmapManager;
import com.sidi.cardgames.ui.CardColumnLayout;
import com.sidi.cardgames.ui.ResourceHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 29/12/2017.
 */
public class PatienceGameView extends GameView {

    private PatienceGame mGame;
    private CardBitmapManager mBitmapManager;

    private List<CardColumnLayout> mColumnLayouts;
    private ImageView mDeckView;
    private ImageView mSideDeckView;
    private List<ImageView> mFoundationPileViews;

    public PatienceGameView(PatienceGame game, ResourceHandler handler) {
        super(game);

        mGame = game;
        mBitmapManager = new CardBitmapManager(handler.getResources());

        mColumnLayouts = new ArrayList<CardColumnLayout>();
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn1));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn2));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn3));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn4));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn5));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn6));
        mColumnLayouts.add((CardColumnLayout) handler.findViewById(R.id.llColumn7));

        mDeckView = (ImageView) handler.findViewById(R.id.ivDeck);
        mSideDeckView = (ImageView) handler.findViewById(R.id.ivSideDeck);

        mFoundationPileViews = new ArrayList<ImageView>();

        List<FoundationPile> piles = game.getGameState().getFoundationPiles();
        for (int i = 0; i < piles.size(); ++i) {
            FoundationPile pile = piles.get(i);
            Suit suit = pile.getSuit();
            ImageView pileView = null;
            switch (suit) {
                case Club:
                    pileView = (ImageView) handler.findViewById(R.id.ivClubs);
                    break;
                case Diamond:
                    pileView = (ImageView) handler.findViewById(R.id.ivDiamonds);
                    break;
                case Heart:
                    pileView = (ImageView) handler.findViewById(R.id.ivHearts);
                    break;
                case Spade:
                    pileView = (ImageView) handler.findViewById(R.id.ivSpades);
                    break;
            }

            Integer tag = i;
            pileView.setTag(R.id.pileID, tag);
            mFoundationPileViews.add(pileView);
        }

        List<CardColumn> columns = game.getGameState().getCardColumns();
        if (columns.size() != mColumnLayouts.size()) {
            try {
                throw new Exception("Unexpected number of card columns.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < mColumnLayouts.size(); ++i) {
            CardColumnLayout layout = mColumnLayouts.get(i);
            layout.setCardColumn(columns.get(i), i);
            layout.setCardBitmapManager(mBitmapManager);
        }

    }

    @Override
    protected void updateView() {

        for (CardColumnLayout columnLayout : mColumnLayouts) {
            columnLayout.update();
        }

        PatienceGameState state = mGame.getGameState();
        if (state.getDeck().isEmpty()) {
            mBitmapManager.setAsEmptyCard(mDeckView);
        } else {
            mBitmapManager.setAsCardBack(mDeckView);
        }

        List<Card> sideDeck = state.getSideDeck();
        if (sideDeck.isEmpty()) {
            mBitmapManager.setAsEmptyCard(mSideDeckView);
        } else {
            Card topCard = sideDeck.get(sideDeck.size() - 1);
            mBitmapManager.setBitmap(topCard, mSideDeckView);
        }

        List<FoundationPile> piles = state.getFoundationPiles();
        for (int i = 0; i < piles.size(); ++i) {
            FoundationPile pile = piles.get(i);
            ImageView pileView = mFoundationPileViews.get(i);
            if (pile.empty()) {
                mBitmapManager.setAsEmptyCard(pileView);
            } else {
                Card card = pile.getTopCard();
                mBitmapManager.setBitmap(card, pileView);
            }
        }
    }
}
