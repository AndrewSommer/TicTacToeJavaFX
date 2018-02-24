import java.util.Random;

/**
 * Extends abstract class Player, and contains the specific code for choosing
 * a tile
 *
 * @author AndrewSommer
 * @version 1.0.0 06 February 2018
 */
public class ComputerPlayer extends Player {

    /**
     * Species the location {row,col} of the tile wanted to mark
     */
    private int[] nextMove = new int[2];

    /**
     * Constructor for the class
     *
     * @param userSymbol the symbol the user will be marking the board with
     */
    public ComputerPlayer(Symbol userSymbol) {
        super(userSymbol);
    }

    /**
     * specific code for the computer to randomly choose an empty tile
     * and return its location
     *
     * @return
     */
    @Override
    public int[] chooseTile() {
        boolean spaceFound = false;
        Random random = new Random();
        while (!spaceFound) {
            nextMove[0] = random.nextInt(3);
            nextMove[1] = random.nextInt(3);
            if (spacesAvailable[nextMove[0]][nextMove[1]]) {
                spaceFound = true;
            }
        }
        spacesAvailable[nextMove[0]][nextMove[1]] = false;
        return nextMove;
    }
}
