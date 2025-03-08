package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.game.GuessSuitGame;
import org.primshits.stepan.representaion.TextRepresentation;

public class MainSuitText {

    public static void main(String[] args) {
        Game game = new GuessSuitGame((new TextRepresentation()));
        game.start();
    }
}
