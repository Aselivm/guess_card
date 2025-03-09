package org.primshits.stepan.deck;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;

import java.util.*;

public class Deck {

    private final Deque<Card> cards;

    public Deck() {
        this.cards = createAllCards();
    }

    public Deck(Collection<Card> cards) {
        this.cards = new ArrayDeque<>(cards);
    }

    public void shuffle() {
        List<Card> tempList = new ArrayList<>(cards);
        Collections.shuffle(tempList);
        cards.clear();
        cards.addAll(tempList);
    }

    public int size() {
        return cards.size();
    }

    public Card takeTopCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("Колода пуста!");
        }
        return cards.removeLast();
    }

    private Deque<Card> createAllCards() {
        Deque<Card> deck = new ArrayDeque<>(52);
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                deck.add(new Card(suit, rank));
            }
        }
        return deck;
    }
}
