package ca.sheridancollege.project;

public class WildDrawFourCard extends Card {
    public WildDrawFourCard() {
        super("BLACK", "WILD_DRAW_FOUR");
    }

    @Override
    public void applyEffect(UnoGame game) {
        game.promptPlayerToChooseColor();
        game.drawCardsForNextPlayer(4);
        game.skipNextPlayer();
    }

    @Override
    public String toString() {
        return "WILD DRAW FOUR";
    }
}
