package org.primshits.stepan.dialog;

import org.primshits.stepan.card.Suit;
import org.primshits.stepan.dialog.util.GamePrompt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessSuitDialog implements Dialog<Suit> {

    private static final Map<String, Suit> SUITS = new HashMap<>();

    static {
        SUITS.put("H", Suit.HEARTS);
        SUITS.put("D", Suit.DIAMONDS);
        SUITS.put("C", Suit.CLUBS);
        SUITS.put("S", Suit.SPADES);
    }

    private final GamePrompt gamePrompt;

    public GuessSuitDialog(GamePrompt gamePrompt) {
        this.gamePrompt = gamePrompt;
    }

    @Override
    public Suit input() {
        while (true) {
            System.out.println(gamePrompt.turn());
            String input = userInput();

            Suit inputSuit = SUITS.get(input.toUpperCase());
            if (inputSuit == null) {
                System.out.println(gamePrompt.error());
            } else {
                return inputSuit;
            }
        }
    }

    private String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
