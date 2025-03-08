package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.dialog.GuessRankDialog;
import org.primshits.stepan.dialog.util.GamePrompt;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessRankGame extends CardGame<Rank> {

    public GuessRankGame(CardRepresentation representation) {
        super(representation, new GuessRankDialog(buildGamePrompt()));
    }

    private static GamePrompt buildGamePrompt() {
        return new GamePrompt(
                "Угадайте номинал(rank) карты ('2', '3', ..., '10', 'J', 'Q', 'K', 'A')",
                "Ошибка: попробуйте снова."
        );
    }

    @Override
    protected void showGameTitle() {
        System.out.println("ИГРА: УГАДАЙ НОМИНАЛ(Rank) КАРТЫ");
        System.out.println("--------------------------------\n");
    }

    @Override
    protected boolean isUserWon(Card card, Rank guess) {
        return card.rank().equals(guess);
    }
}
