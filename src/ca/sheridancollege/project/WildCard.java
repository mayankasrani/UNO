package ca.sheridancollege.project;

public class WildCard extends Card {
    public WildCard() {
        super("BLACK", "WILD");
    }

    @Override
    public void applyEffect(UnoGame game) {
        // Current player chooses the next color
        game.promptPlayerToChooseColor();
        game.advanceTurn();
    }

    @Override
    public String toString() {
        return "WILD CARD";
    }
}
