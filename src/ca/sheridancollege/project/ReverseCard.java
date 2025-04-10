package ca.sheridancollege.project;

public class ReverseCard extends Card {
    public ReverseCard(String color) {
        super(color, "REVERSE");
    }

    @Override
    public void applyEffect(UnoGame game) {
        game.reverseOrder();
    }

    @Override
    public String toString() {
        return getColor() + " REVERSE";
    }
}
