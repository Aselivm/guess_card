package org.primshits.stepan.representaion;


import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.representaion.util.CardTemplate;

public class PictureRepresentation extends CardRepresentation {

    private static final String RED_COLOR = "\u001B[31m";
    private static final String BLACK_COLOR = "\u001B[30m";
    private static final String RESET_COLOR = "\u001B[0m";

    private final CardTemplate cardTemplate = new CardTemplate();

    @Override
    public String getRepresentation(Card card) {
        String colorCode = isRedSuit(card.suit()) ? RED_COLOR : BLACK_COLOR;
        String suitSymbol = getSuitSymbol(card.suit());
        String[] template = cardTemplate.getTemplate(card.rank());

        StringBuilder result = new StringBuilder();
        result.append(colorCode);
        for (String line : template) {
            line = line.replace("$", suitSymbol);
            result.append(line).append("\n");
        }
        result.append(RESET_COLOR);

        return result.toString();
    }

    private boolean isRedSuit(Suit suit) {
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }
}
