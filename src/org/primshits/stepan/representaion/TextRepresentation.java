package org.primshits.stepan.representaion;

import org.primshits.stepan.card.Card;

public class TextRepresentation extends CardRepresentation {

    @Override
    public String getRepresentation(Card card) {
        String rankSymbol = getRankSymbol(card.rank());
        String suitSymbol = getSuitSymbol(card.suit());

        return rankSymbol + suitSymbol;
    }
}
