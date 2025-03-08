package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessRankGame extends Game {
    public GuessRankGame(CardRepresentation representation) {
        super(representation);
    }

    @Override
    protected void showGameTitle() {
        System.out.println("ИГРА: УГАДАЙ НОМИНАЛ(Rank) КАРТЫ");
        System.out.println("---------------\n");
    }

    @Override
    protected String getUserGuess() {
        return "";
    }

    @Override
    protected boolean isUserWon(Card card, String guess) {
        return false;
    }
}
