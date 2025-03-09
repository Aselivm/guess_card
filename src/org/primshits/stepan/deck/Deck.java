package org.primshits.stepan.deck;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Rank;
import org.primshits.stepan.card.Suit;

import java.util.*;
import java.util.stream.Collectors;

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
        return Arrays.stream(Suit.values())
                .flatMap(suit -> Arrays.stream(Rank.values())
                        .map(rank -> new Card(suit, rank)))
                .collect(Collectors.toCollection(ArrayDeque::new));
    }
}
