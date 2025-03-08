package org.primshits.stepan.dialog;

import org.primshits.stepan.card.Rank;
import org.primshits.stepan.dialog.util.GamePrompt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GuessRankDialog implements Dialog<Rank> {

    private static final Map<String, Rank> RANKS = new HashMap<>();

    static {
        RANKS.put("2", Rank.TWO);
        RANKS.put("3", Rank.THREE);
        RANKS.put("4", Rank.FOUR);
        RANKS.put("5", Rank.FIVE);
        RANKS.put("6", Rank.SIX);
        RANKS.put("7", Rank.SEVEN);
        RANKS.put("8", Rank.EIGHT);
        RANKS.put("9", Rank.NINE);
        RANKS.put("10", Rank.TEN);
        RANKS.put("J", Rank.JACK);
        RANKS.put("Q", Rank.QUEEN);
        RANKS.put("K", Rank.KING);
        RANKS.put("A", Rank.ACE);
    }

    private final GamePrompt gamePrompt;

    public GuessRankDialog(GamePrompt gamePrompt) {
        this.gamePrompt = gamePrompt;
    }

    @Override
    public Rank input() {
        while (true) {
            System.out.println(gamePrompt.turn());
            String input = userInput();

            Rank inputRank = RANKS.get(input.toUpperCase());
            if (inputRank == null) {
                System.out.println(gamePrompt.error());
            } else {
                return inputRank;
            }
        }
    }

    private String userInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
