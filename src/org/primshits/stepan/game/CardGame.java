package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.dialog.Dialog;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.CardRepresentation;

/**
 * @param <I> Тип данных, представляющий пользовательский ввод (input).
 */
public abstract class CardGame<I> implements Game {

    private final Deck deck;
    private final CardRenderer cardRenderer;
    private final Dialog<I> dialog;

    private int successfulGuessCounter;

    public CardGame(CardRepresentation representation, Dialog<I> dialog) {
        this.deck = new Deck();
        this.cardRenderer = new CardRenderer(representation);
        this.dialog = dialog;
    }

    @Override
    public void start() {
        showGameTitle();

        deck.shuffle();
        while (deck.size() > 0) {
            showCurrentStats();

            Card card = deck.takeTopCard();
            I userGuess = dialog.input();

            cardRenderer.render(card);
            if (isUserWon(card, userGuess)) {
                successfulGuessCounter++;
                showWin();
            } else {
                showLose();
            }
        }
    }

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

    abstract protected void showGameTitle();

    abstract protected boolean isUserWon(Card card, I guess);
}
