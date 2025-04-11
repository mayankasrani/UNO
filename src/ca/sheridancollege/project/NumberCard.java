package ca.sheridancollege.project;

public class NumberCard extends Card {
    private int number;

    public NumberCard(String color, int number) {
        super(color, "NUMBER");
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public void applyEffect(UnoGame game) {
        // No special effect, just advance the turn
        game.advanceTurn();
    }

    @Override
    public String toString() {
        return getColor() + " " + number; // e.g., RED 5
    }
}
