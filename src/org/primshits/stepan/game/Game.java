package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.dialog.Dialog;
import org.primshits.stepan.dialog.GuessCardColorDialog;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.CardRepresentation;
import org.primshits.stepan.dialog.GamePrompt;

public class Game {
    private static final String RED_GUESS = "r";
    private static final String BLACK_GUESS = "b";

    private final CardRenderer cardRenderer;
    private final Deck deck = new Deck();
    private int guessCounter;

    public Game(CardRepresentation representation) {
        this.cardRenderer = new CardRenderer(representation);
        guessCounter = 0;
    }

    public void start() {
        deck.shuffle();

        GamePrompt gamePrompt = new GamePrompt(
                "ИГРА УГАДАЙ КАРТУ",
                "Угадайте карту ('b' - черная, 'r' - красная)",
                "Ошибка: попробуйте снова."
        );

        Dialog<String> dialog = new GuessCardColorDialog(gamePrompt, "[rb]");

        while (deck.size() > 0) {
            showCurrentStats();
            String guess = dialog.input();

            Card card = deck.takeTopCard();
            cardRenderer.render(card);

            if (isUserWon(card, guess)) {
                guessCounter++;
                showWin();
            } else {
                showLose();
            }
        }
    }

    private void showCurrentStats() {
        System.out.println("Карт в колоде:" + deck.size());
        System.out.println("Угадано:" + guessCounter);
    }

    private boolean isUserWon(Card card, String guess) {
        return (isCardRed(card) && RED_GUESS.equals(guess)) || (isCardBlack(card) && BLACK_GUESS.equals(guess));
    }

    private boolean isCardRed(Card card) {
        Suit suit = card.suit();
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }

    private boolean isCardBlack(Card card) {
        Suit suit = card.suit();
        return suit == Suit.SPADES || suit == Suit.CLUBS;
    }

    private static void showWin() {
        System.out.println("ВЫ УГАДАЛИ!");
    }

    private void showLose() {
        System.out.println("Вы не угадали.");
    }
}
