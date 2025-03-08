package org.primshits.stepan;

import org.primshits.stepan.game.Game;
import org.primshits.stepan.game.GuessSuitGame;
import org.primshits.stepan.representaion.PictureRepresentation;

public class MainSuitPicture {

    public static void main(String[] args) {
        Game game = new GuessSuitGame((new PictureRepresentation()));
        game.start();
    }
}
