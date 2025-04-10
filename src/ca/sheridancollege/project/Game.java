/**
 * SYST 17796 Project Base code - Modified for UNO.
 * Students can modify and extend to implement their game.
 * Updated by: Mayank Asrani, Joann Monteiro, Brandon Lamarre
 * Date: April 2025
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The abstract Game class serves as a base for implementing the UNO game.
 * This class was extended by UnoGame to include complete game logic.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * @author Wildcard Developers - Modified April 2025
 */
public abstract class Game {

    private final String name; // the title of the game
    private ArrayList<Player> players; // the players of the game

    public Game(String name) {
        this.name = name;
        players = new ArrayList<>();
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

} // end class
