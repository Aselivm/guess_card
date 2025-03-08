package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Color;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.dialog.GuessColorDialog;
import org.primshits.stepan.dialog.util.GamePrompt;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessColorGame extends CardGame<Color> {

    public GuessColorGame(CardRepresentation representation) {
        super(representation, new GuessColorDialog(buildGamePrompt()));
    }

    private static GamePrompt buildGamePrompt() {
        return new GamePrompt(
                "Угадайте цвет карты ('b' - черная, 'r' - красная)",
                "Ошибка: попробуйте снова."
        );
    }

    @Override
    protected void showGameTitle() {
        System.out.println("ИГРА: УГАДАЙ ЦВЕТ КАРТЫ");
        System.out.println("-----------------------\n");
    }

    @Override
    protected boolean isUserWon(Card card, Color guess) {
        return (isCardRed(card) && guess.equals(Color.RED)) ||
                (isCardBlack(card) && guess.equals(Color.BLACK));
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
