package ca.sheridancollege.project;

import java.util.*;

public class UnoGame extends Game {
    private GroupOfCards deck;
    private List<Card> discardPile;
    private int currentPlayerIndex = 0;
    private boolean isClockwise = true;

    // Stores the currently active color override after a wild card
    public static String currentColorOverride = null;

    public UnoGame(String name, ArrayList<Player> players) {
        super(name);
        setPlayers(players);
        this.deck = new GroupOfCards();
        this.discardPile = new ArrayList<>();

        deck.initializeDeck();
        deck.shuffle();
        dealCards();
        discardPile.add(deck.drawCard());
    }

    private void dealCards() {
        for (Player player : getPlayers()) {
            for (int i = 0; i < 7; i++) {
                player.getHand().add(deck.drawCard());
            }
        }
    }

    @Override
    public void play() {
        boolean roundOver = false;

        while (!roundOver) {
            Player currentPlayer = getPlayers().get(currentPlayerIndex);
            System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.");

            Card topCard = discardPile.get(discardPile.size() - 1);

            // If there's a color override (from a Wild), show that instead
            if (UnoGame.currentColorOverride != null) {
                System.out.println("Top color (from wild): " + UnoGame.currentColorOverride);
            }

            Card played = currentPlayer.playTurn(topCard, deck);

            if (played != null) {
                discardPile.add(played);
                played.applyEffect(this);

                // Reset override after a valid card is played
                UnoGame.currentColorOverride = null;
            } else {
                System.out.println(currentPlayer.getName() + " had to draw a card.");
                advanceTurn();
            }

            if (currentPlayer.hasWon()) {
                System.out.println("\n" + currentPlayer.getName() + " has won the round!");
                declareWinner();
                roundOver = true;
            }
        }
    }

    @Override
    public void declareWinner() {
        Player winner = getPlayers().get(currentPlayerIndex);
        System.out.println("\n>>> Winner: " + winner.getName());
    }

    public void advanceTurn() {
        if (isClockwise) {
            currentPlayerIndex = (currentPlayerIndex + 1) % getPlayers().size();
        } else {
            currentPlayerIndex = (currentPlayerIndex - 1 + getPlayers().size()) % getPlayers().size();
        }
    }

    public void skipNextPlayer() {
        System.out.println("Next player's turn is skipped.");
        advanceTurn();
        advanceTurn();
    }

    public void reverseOrder() {
        isClockwise = !isClockwise;
        System.out.println("Play direction reversed.");
        advanceTurn();
    }

    public void drawCardsForNextPlayer(int count) {
        int nextIndex = isClockwise ? (currentPlayerIndex + 1) % getPlayers().size()
                                    : (currentPlayerIndex - 1 + getPlayers().size()) % getPlayers().size();
        Player nextPlayer = getPlayers().get(nextIndex);
        System.out.println(nextPlayer.getName() + " draws " + count + " cards.");
        for (int i = 0; i < count; i++) {
            nextPlayer.getHand().add(deck.drawCard());
        }
    }

    public void promptPlayerToChooseColor() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a color (RED, BLUE, GREEN, YELLOW): ");
        String color = scanner.nextLine().toUpperCase();
        UnoGame.currentColorOverride = color;
        System.out.println("Color set to: " + color);
    }
}
