package ca.sheridancollege.project;

public class SkipCard extends Card {
    public SkipCard(String color) {
        super(color, "SKIP");
    }

    @Override
    public void applyEffect(UnoGame game) {
        // Skip the next player's turn
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return getColor() + " SKIP";
    }
}
