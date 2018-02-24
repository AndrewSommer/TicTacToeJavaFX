/**
 * Abstract class to for human and computer players to extend
 *
 * @author AndrewSommer
 * @version 1.0.0 06 November 2017
 */
public abstract class Player {

    /**
     * Specifies which player is up next
     */
    public static int playerUp = 1;
    /**
     * Used for players to choose only empty spaces
     */
    static boolean[][] spacesAvailable = new boolean[3][3];
    /**
     * Used to distinguish different players marks
     */
    private Symbol userSymbol;

    /**
     * Constructor
     * @param userSymbol
     */
    public Player(Symbol userSymbol) {
        this.userSymbol = userSymbol;
    }

    /**
     * Returns the symbol of the player called upon
     *
     * @return the symbol of the player called upon
     */
    public Symbol getUserSymbol() {
        return userSymbol;
    }

    /**
     * Abstract method which each player overrides with their own tile
     * choosing specific code
     * @return location of the tile wanted to mark
     */
    public abstract int[] chooseTile();

}
