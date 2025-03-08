package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.dialog.Dialog;
import org.primshits.stepan.dialog.GuessCardColorDialog;
import org.primshits.stepan.dialog.util.GamePrompt;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessColorGame extends Game {
    private static final String RED_GUESS_REGEX = "[rR]";
    private static final String BLACK_GUESS_REGEX = "[bB]";

    private final Deck deck = new Deck();
    private final Dialog<String> dialog;

    private int guessCounter;

    public GuessColorGame(CardRepresentation representation) {
        super(representation);
        GamePrompt gamePrompt = new GamePrompt(
                "Угадайте карту ('b' - черная, 'r' - красная)",
                "Ошибка: попробуйте снова."
        );
        this.dialog = new GuessCardColorDialog(gamePrompt, RED_GUESS_REGEX, BLACK_GUESS_REGEX);
    }

    @Override
    protected void showGameTitle() {
        System.out.println("ИГРА УГАДАЙ КАРТУ");
        System.out.println("-----------------\n");
    }

    @Override
    protected void showCurrentStats() {
        System.out.println("Карт в колоде:" + deck.size());
        System.out.println("Угадано:" + guessCounter);
        System.out.println("______________\n");
    }

    @Override
    protected String getUserGuess() {
        return dialog.input();
    }

    @Override
    protected void showResult(Card card, String guess) {
        if (isUserWon(card, guess)) {
            guessCounter++;
            showWin();
        } else {
            showLose();
        }
    }

    private boolean isUserWon(Card card, String guess) {
        return (isCardRed(card) && guess.matches(RED_GUESS_REGEX)) ||
                (isCardBlack(card) && guess.matches(BLACK_GUESS_REGEX));
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
        System.out.println("ВЫ УГАДАЛИ!\n");
    }

    private void showLose() {
        System.out.println("Вы не угадали.\n");
    }
}
