package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.representaion.CardRepresentation;

public class GuessSuitGame extends Game {
    public GuessSuitGame(CardRepresentation representation) {
        super(representation);
    }

    @Override
    protected void showGameTitle() {

    }

    @Override
    protected void showCurrentStats() {

    }

    @Override
    protected String getUserGuess() {
        return "";
    }

    @Override
    protected void showResult(Card card, String guess) {

    }
}
