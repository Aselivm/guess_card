package org.primshits.stepan.representaion;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;

public abstract class CardRepresentation {

    public abstract String getRepresentation(Card card);

    protected String getSuitSymbol(Suit suit) {
        return switch (suit) {
            case HEARTS -> "♥";
            case DIAMONDS -> "♦";
            case CLUBS -> "♣";
            case SPADES -> "♠";
        };
    }

    protected String getRankSymbol(Rank rank) {
        return switch (rank) {
            case JACK -> "J";
            case QUEEN -> "Q";
            case KING -> "K";
            case ACE -> "A";
            default -> String.valueOf(rank.ordinal() + 2);
        };
    }
}
