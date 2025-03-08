package org.primshits.stepan.game;

import org.primshits.stepan.card.Card;
import org.primshits.stepan.card.Suit;
import org.primshits.stepan.deck.Deck;
import org.primshits.stepan.dialog.Dialog;
import org.primshits.stepan.dialog.GuessCardColorDialog;
import org.primshits.stepan.renderer.CardRenderer;
import org.primshits.stepan.representaion.CardRepresentation;
import org.primshits.stepan.dialog.GamePrompt;

public class Game {
    private static final String RED_GUESS_REGEX = "[rR]";
    private static final String BLACK_GUESS_REGEX = "[bB]";

    private final CardRenderer cardRenderer;
    private final Deck deck = new Deck();

    private Dialog<String> dialog;
    private int guessCounter;

    public Game(CardRepresentation representation) {
        this.cardRenderer = new CardRenderer(representation);
        guessCounter = 0;
    }

    public void start() {
        initGame();
        showGameTitle();
        while (deck.size() > 0) {
            showCurrentStats();

            String guess = dialog.input();
            Card card = deck.takeTopCard();

            showCard(card);
            showResult(card, guess);
        }
    }

    private void showGameTitle() {
        System.out.println("ИГРА УГАДАЙ КАРТУ");
        System.out.println("-----------------\n");
    }

    private void initGame() {
        deck.shuffle();
        GamePrompt gamePrompt = new GamePrompt(
                "Угадайте карту ('b' - черная, 'r' - красная)",
                "Ошибка: попробуйте снова."
        );
        dialog = new GuessCardColorDialog(gamePrompt, RED_GUESS_REGEX, BLACK_GUESS_REGEX);
    }

    private void showCurrentStats() {
        System.out.println("Карт в колоде:" + deck.size());
        System.out.println("Угадано:" + guessCounter);
        System.out.println("______________\n");
    }

    private void showCard(Card card) {
        cardRenderer.render(card);
    }

    private void showResult(Card card, String guess) {
        if (isUserWon(card, guess)) {
            guessCounter++;
            showWin();
        } else {
            showLose();
        }
    }

    private boolean isUserWon(Card card, String guess) {
        return (isCardRed(card) && guess.matches(RED_GUESS_REGEX)) ||
                (isCardBlack(card) && guess.matches(BLACK_GUESS_REGEX));
    }

    private boolean isCardRed(Card card) {
        Suit suit = card.suit();
        return suit == Suit.HEARTS || suit == Suit.DIAMONDS;
    }

    private boolean isCardBlack(Card card) {
        Suit suit = card.suit();
        return suit == Suit.SPADES || suit == Suit.CLUBS;
    }

    private static void showWin() {
        System.out.println("ВЫ УГАДАЛИ!\n");
    }

    private void showLose() {
        System.out.println("Вы не угадали.\n");
    }
}
