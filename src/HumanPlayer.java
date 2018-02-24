/**
 * Extends abstract class Player, and contains the specific code for choosing
 * a tile
 *
 * @author AndrewSommer
 * @version 1.0.0 06 February 2018
 */
public class HumanPlayer extends Player {

    /**
     * Species the location {row,col} of the tile wanted to mark
     */
    private int[] nextMove = new int[2];

    /**
     * Constructor for HumanPlayer
     *
     * @param userSymbol the symbol the user will use to mark to the board
     */
    public HumanPlayer(Symbol userSymbol) {
        super(userSymbol);
    }

    /**
     * Returns the location of the tile wanted to mark
     *
     * @return
     */
    @Override
    public int[] chooseTile() {
        spacesAvailable[nextMove[0]][nextMove[1]] = false;
        return nextMove;
    }

    /**
     * Sets the location of the next move based on a mouseclick event from the view
     *
     * @param row the row index to place the symbol
     * @param col the column index to place the symbol
     */
    public void getNextMove(int row, int col) {
        nextMove[0] = row;
        nextMove[1] = col;
    }

}
