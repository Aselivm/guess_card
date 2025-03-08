package org.primshits.stepan;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.PictureRepresentation;

public class Main {
    public static void main(String[] args) {
        CardRenderer cardRenderer = new CardRenderer(new PictureRepresentation());
        cardRenderer.render(new Card(Suit.CLUBS, Rank.THREE));

        Deck deck = new Deck();
        int size = deck.getCards().size();
        System.out.println(size);
    }
}