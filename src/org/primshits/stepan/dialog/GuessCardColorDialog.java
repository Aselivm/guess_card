package org.primshits.stepan.dialog;

import org.primshits.stepan.dialog.util.GamePrompt;

import java.util.Scanner;

public class GuessCardColorDialog implements Dialog<String> {

    private final GamePrompt gamePrompt;
    private final String[] validInputRegex;

    public GuessCardColorDialog(GamePrompt gamePrompt, String... validInputRegex) {
        this.gamePrompt = gamePrompt;
        this.validInputRegex = validInputRegex;
    }

    @Override
    public String input() {
        while (true) {
            System.out.println(gamePrompt.turn());
            String input = userInput();
            if (isValid(input)) {
                return input;
            } else {
                System.out.println(gamePrompt.error());
            }
        }
    }

    private String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private boolean isValid(String input) {
        for(String regex : validInputRegex) {
            if (input.matches(regex)) {
                return true;
            }
        }
        return false;
    }
}
