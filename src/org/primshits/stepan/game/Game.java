package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.CardRepresentation;

public abstract class Game {

    private final CardRenderer cardRenderer;
    private final Deck deck = new Deck();

    public Game(CardRepresentation representation) {
        this.cardRenderer = new CardRenderer(representation);
    }

    public void start() {
        showGameTitle();

        deck.shuffle();
        while (deck.size() > 0) {
            showCurrentStats();

            String guess = getUserGuess();
            Card card = deck.takeTopCard();

            cardRenderer.render(card);
            showResult(card, guess);
        }
    }

    abstract protected void showGameTitle();

    abstract protected void showCurrentStats();

    abstract protected String getUserGuess();

    abstract protected void showResult(Card card, String guess);
}
