package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GroupOfCards {
    private List<Card> cards;

    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }

    // Fill the deck with UNO cards
    public void initializeDeck() {
        String[] colors = {"RED", "BLUE", "GREEN", "YELLOW"};

        for (String color : colors) {
            cards.add(new NumberCard(color, 0));
            for (int i = 1; i <= 9; i++) {
                cards.add(new NumberCard(color, i));
                cards.add(new NumberCard(color, i));
            }

            // Add two of each action card per color
            cards.add(new SkipCard(color));
            cards.add(new SkipCard(color));
            cards.add(new ReverseCard(color));
            cards.add(new ReverseCard(color));
            cards.add(new DrawTwoCard(color));
            cards.add(new DrawTwoCard(color));
        }

        // Wild and Wild Draw Four cards (4 each)
        for (int i = 0; i < 4; i++) {
            cards.add(new WildCard());
            cards.add(new WildDrawFourCard());
        }
    }

    // Shuffle the deck
    public void shuffle() {
        Collections.shuffle(cards);
    }

    // Draw the top card
    public Card drawCard() {
        if (cards.isEmpty()) {
            System.out.println("Deck is empty. Cannot draw more cards.");
            return null;
        }
        return cards.remove(0);
    }

    public int size() {
        return cards.size();
    }
}
