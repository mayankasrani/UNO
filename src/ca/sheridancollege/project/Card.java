package ca.sheridancollege.project;

public abstract class Card {
    private String color;
    private String type;

    public Card(String color, String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    // Check whether this card can be played on the top card
    public boolean isPlayableOn(Card topCard) {
        String activeColor = UnoGame.currentColorOverride != null
                             ? UnoGame.currentColorOverride
                             : topCard.getColor();

        return this.color.equals(activeColor) || this.type.equals(topCard.type) || this.color.equals("BLACK");
    }

    public abstract void applyEffect(UnoGame game);

    @Override
    public String toString() {
        return color + " " + type;
    }
}
