package ca.sheridancollege.project;

public class DrawTwoCard extends Card {
    public DrawTwoCard(String color) {
        super(color, "DRAW_TWO");
    }

    @Override
    public void applyEffect(UnoGame game) {
        // Next player draws two cards and loses their turn
        game.drawCardsForNextPlayer(2);
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return getColor() + " DRAW TWO";
    }
}
