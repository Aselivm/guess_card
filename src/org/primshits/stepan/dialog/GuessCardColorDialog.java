package org.primshits.stepan.dialog;

import java.util.Scanner;

public class GuessCardColorDialog implements Dialog<String> {

    private final GamePrompt gamePrompt;
    private final String validInputRegex;

    public GuessCardColorDialog(GamePrompt gamePrompt, String validInputRegex) {
        this.gamePrompt = gamePrompt;
        this.validInputRegex = validInputRegex;
    }

    @Override
    public String input() {
        System.out.println(gamePrompt.title());
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
        return input.matches(validInputRegex);
    }
}
