package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.game.GuessColorGame;
import org.primshits.stepan.representaion.PictureRepresentation;

public class MainColorPicture {

    public static void main(String[] args) {
        Game game = new GuessColorGame(new PictureRepresentation());
        game.start();
    }
}
