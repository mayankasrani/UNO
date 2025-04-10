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

    public abstract void applyEffect(UnoGame game);

    public boolean isPlayableOn(Card topCard) {
        return this.color.equals(topCard.color) || this.type.equals(topCard.type) || this.color.equals("BLACK");
    }

    @Override
    public String toString() {
        return color + " " + type;
    }
}
