package org.primshits.stepan.renderer;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.representaion.CardRepresentation;

public class CardRenderer {

    private final CardRepresentation cardRepresentation;

    public CardRenderer(CardRepresentation cardRepresentation) {
        this.cardRepresentation = cardRepresentation;
    }

    public void render(Card card) {
        System.out.println(cardRepresentation.getRepresentation(card));
    }
}
