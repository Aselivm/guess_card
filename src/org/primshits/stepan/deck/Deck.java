package org.primshits.stepan.deck;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {

    private final List<Card> cards;

    public Deck() {
        this.cards = createAllCards();
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public int size() {
        return cards.size();
    }

    public Card takeTopCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Колода пуста!");
        }

        return cards.remove(cards.size() - 1);
    }

    private List<Card> createAllCards() {
        List<Card> allCards = new ArrayList<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                allCards.add(new Card(suit, rank));
            }
        }
        return allCards;
    }
}
