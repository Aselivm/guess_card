package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.representaion.PictureRepresentation;

public class MainPicture {

    public static void main(String[] args) {
        Game game = new Game(new PictureRepresentation());
        game.start();
    }
}
