package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.dialog.Dialog;
import org.primshits.stepan.dialog.GuessCardColorDialog;
import org.primshits.stepan.dialog.util.GamePrompt;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessColorGame extends Game {

    private static final String RED_GUESS_REGEX = "[rR]";
    private static final String BLACK_GUESS_REGEX = "[bB]";

    private final Dialog<String> dialog;

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
        System.out.println("ИГРА: УГАДАЙ ЦВЕТ КАРТЫ");
        System.out.println("---------------\n");
    }

    @Override
    protected String getUserGuess() {
        return dialog.input();
    }

    @Override
    protected boolean isUserWon(Card card, String guess) {
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
}
