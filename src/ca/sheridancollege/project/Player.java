package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    private String name;
    private List<Card> hand;
    private boolean hasCalledUNO;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.hasCalledUNO = false;
    }

    public String getName() {
        return name;
    }

    public List<Card> getHand() {
        return hand;
    }

    public boolean hasWon() {
        return hand.isEmpty();
    }

    public void callUNO() {
        if (hand.size() == 1) {
            hasCalledUNO = true;
            System.out.println(name + " called UNO!");
        }
    }

    // Handles player decision: play a card or draw
    public Card playTurn(Card topCard, GroupOfCards deck) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Top card: " + topCard.toString());
        System.out.println("Your hand:");
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + ": " + hand.get(i));
        }

        System.out.print("Enter card number to play (-1 to draw): ");
        int choice = scanner.nextInt();

        if (choice >= 0 && choice < hand.size()) {
            Card chosen = hand.get(choice);

            if (chosen.isPlayableOn(topCard)) {
                hand.remove(choice);

                // Check for UNO condition
                if (hand.size() == 1) {
                    System.out.print("Do you want to call UNO? (yes/no): ");
                    String response = scanner.next().toLowerCase();
                    if (response.equals("yes")) {
                        callUNO();
                    } else {
                        System.out.println("You forgot to call UNO! Drawing 2 penalty cards.");
                        hand.add(deck.drawCard());
                        hand.add(deck.drawCard());
                    }
                }

                return chosen;
            } else {
                System.out.println("Invalid move. You must draw a card.");
            }
        }

        // If player chose to draw or picked an invalid card
        hand.add(deck.drawCard());
        return null;
    }
}
