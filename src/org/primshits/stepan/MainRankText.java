package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.game.GuessRankGame;
import org.primshits.stepan.representaion.TextRepresentation;

public class MainRankText {

    public static void main(String[] args) {
        Game game = new GuessRankGame((new TextRepresentation()));
        game.start();
    }
}
