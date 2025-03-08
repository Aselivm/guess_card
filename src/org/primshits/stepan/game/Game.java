package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.CardRepresentation;

public abstract class Game {

    private final CardRenderer cardRenderer;
    private final Deck deck = new Deck();

    private int successfulGuessCounter;

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
            if (isUserWon(card, guess)) {
                successfulGuessCounter++;
                showWin();
            } else {
                showLose();
            }
        }
    }

    abstract protected void showGameTitle();

    abstract protected String getUserGuess();

    abstract protected boolean isUserWon(Card card, String guess);

    private void showCurrentStats() {
        System.out.println("Карт в колоде:" + deck.size());
        System.out.println("Угадано:" + successfulGuessCounter);
        System.out.println("______________\n");
    }

    private void showWin() {
        System.out.println("ВЫ УГАДАЛИ!\n");
    }

    private void showLose() {
        System.out.println("Вы не угадали.\n");
    }
}
