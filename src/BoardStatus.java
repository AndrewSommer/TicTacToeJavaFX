/**
 * enum to specify all possible statuses a game can be
 *
 * @author AndrewSommer
 * @version 1.0.0 06 February 2018
 */
public enum BoardStatus {
    NOTSTARTED("Game Not Started"),
    INPROGRESS("Game In Progress"),
    PLAYER1WON("Player 1 Is The Winner"),
    PLAYER2WON("Player 2 Is The Winner"),
    CATSGAME("Cats Game");


    /**
     * Status of the board as a string
     */
    private final String status;

    /**
     * Constructor for the BoardStatus class
     *
     * @param status
     */
    BoardStatus(String status) {
        this.status = status;
    }

    /**
     * Returns the status of the board
     *
     * @return
     */
    public String getStatus() {
        return status;
    }
}
