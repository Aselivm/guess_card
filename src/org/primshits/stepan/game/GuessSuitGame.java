package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.dialog.GuessSuitDialog;
import org.primshits.stepan.dialog.util.GamePrompt;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessSuitGame extends CardGame<Suit> {

    public GuessSuitGame(CardRepresentation representation) {
        super(representation, new GuessSuitDialog(buildGamePrompt()));
    }

    private static GamePrompt buildGamePrompt() {
        return new GamePrompt(
                "Угадайте масть(suit) карты ('h' - hearts, 'd' - diamonds, 'c' - clubs, 's' - spades)",
                "Ошибка: попробуйте снова."
        );
    }

    @Override
    protected void showGameTitle() {
        System.out.println("ИГРА: УГАДАЙ МАСТЬ(Suit) КАРТЫ");
        System.out.println("------------------------------\n");
    }

    @Override
    protected boolean isUserWon(Card card, Suit guess) {
        return card.suit().equals(guess);
    }
}
