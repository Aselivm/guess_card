package org.primshits.stepan.representaion;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;

public class TextRepresentation extends CardRepresentation {

    @Override
    public String getRepresentation(Card card) {
        String rankSymbol = getRankSymbol(card.rank());
        String suitSymbol = getSuitSymbol(card.suit());

        return rankSymbol + suitSymbol;
    }
}
