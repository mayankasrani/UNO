package ca.sheridancollege.project;

public class SkipCard extends Card {
    public SkipCard(String color) {
        super(color, "SKIP");
    }

    @Override
    public void applyEffect(UnoGame game) {
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return getColor() + " SKIP";
    }
}
