package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.representaion.TextRepresentation;

public class MainText {

    public static void main(String[] args) {
        Game game = new Game(new TextRepresentation());
        game.start();
    }
}