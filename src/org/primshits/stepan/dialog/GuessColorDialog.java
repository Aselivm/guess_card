package org.primshits.stepan.dialog;

import org.primshits.stepan.card.Color;
import org.primshits.stepan.dialog.util.GamePrompt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessColorDialog implements Dialog<Color> {

    private static final Map<String, Color> COLORS = new HashMap<>();

    static {
        COLORS.put("R", Color.RED);
        COLORS.put("B", Color.BLACK);
    }

    private final GamePrompt gamePrompt;

    public GuessColorDialog(GamePrompt gamePrompt) {
        this.gamePrompt = gamePrompt;
    }

    @Override
    public Color input() {
        while (true) {
            System.out.println(gamePrompt.turn());
            String input = userInput();

            Color inputColor = COLORS.get(input.toUpperCase());
            if (inputColor == null) {
                System.out.println(gamePrompt.error());
            } else {
                return inputColor;
            }
        }
    }

    private String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
