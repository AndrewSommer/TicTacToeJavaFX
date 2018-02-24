/**
 * Represents a Tic-Tac-Toe board and the actions needed to play a game on the board
 *
 * @author AndrewSommer
 * @version 1.0.0 06 February 2018
 */
public class Board {

    /**
     * A 2D array of Symbols to represent the board and marks placed
     */
    private Symbol[][] currentBoard = new Symbol[3][3];
    /**
     * The current status of the board
     */
    private BoardStatus boardStatus;

    /**
     * Clears the board of all marks
     */
    public final void clearBoard() {
        for (int rowCount = 0; rowCount < 3; rowCount++) {
            for (int colCount = 0; colCount < 3; colCount++) {
                currentBoard[rowCount][colCount] = Symbol.EMPTY;
                Player.spacesAvailable[rowCount][colCount] = true;
            }
        }
        boardStatus = BoardStatus.NOTSTARTED;
    }

    /**
     * Adds a mark to the board
     * @param symbol    Which symbol to add to the board
     * @param row   The row the mark should be added to
     * @param col   The column the mark should be added to
     */
    public final void addMark(Symbol symbol, int row, int col) {//Not necessary
        currentBoard[row][col] = symbol;
        boardStatus = BoardStatus.INPROGRESS;
    }

    /**
     * returns a mark at the location input
     * @param row the row wanted to check
     * @param col the column wanted to check
     * @return the symbol at the row and column specified
     */
    public final Symbol getMark(int row, int col) {
        return currentBoard[row][col];
    }

    /**
     * returns the current state of the board
     * @return BoardStatus of the current state of the board
     */
    public final BoardStatus checkCurrentState() {
        //Check for horizontal winner
        for (int row = 0; row < 3; row++) {
            if (getMark(row, 0) == Symbol.CROSS && getMark(row, 1) == Symbol.CROSS && getMark(row, 2) == Symbol.CROSS){
                return boardStatus = BoardStatus.PLAYER1WON;
            }else if(getMark(row, 0) == Symbol.NAUGHT && getMark(row, 1) == Symbol.NAUGHT && getMark(row, 2) == Symbol.NAUGHT){
                return boardStatus = BoardStatus.PLAYER2WON;
            }
        }
        //Check for vertical winner
        for(int col=0; col <3; col++){
            if (getMark(0, col) == Symbol.CROSS && getMark(1, col) == Symbol.CROSS && getMark(2, col) == Symbol.CROSS) {
                return boardStatus = BoardStatus.PLAYER1WON;
            }else if (getMark(0, col) == Symbol.NAUGHT && getMark(1, col) == Symbol.NAUGHT && getMark(2, col) == Symbol.NAUGHT) {
                return boardStatus = BoardStatus.PLAYER2WON;
            }
        }
        //Check for diagonal winner

        if (getMark(0, 0) == Symbol.CROSS && getMark(1, 1) == Symbol.CROSS && getMark(2, 2) == Symbol.CROSS) {
            return boardStatus = BoardStatus.PLAYER1WON;
        }
        if (getMark(0, 0) == Symbol.NAUGHT && getMark(1, 1) == Symbol.NAUGHT && getMark(2, 2) == Symbol.NAUGHT) {
            return boardStatus = BoardStatus.PLAYER1WON;
        }
        if (getMark(2, 0) == Symbol.CROSS && getMark(1, 1) == Symbol.CROSS && getMark(0, 2) == Symbol.CROSS) {
            return boardStatus = BoardStatus.PLAYER1WON;
        }
        if (getMark(2, 0) == Symbol.NAUGHT && getMark(1,1) == Symbol.NAUGHT && getMark(0,2) == Symbol.NAUGHT) {
            return boardStatus = BoardStatus.PLAYER1WON;
        }

        //Check for full board  (Cats Game)
        boolean emptyFound = false;
        for(int row=0; row<3; row++){
            for(int col=0; col<3; col++){
                if (getMark(row,col) == Symbol.EMPTY){
                    emptyFound = true;
                }
            }
        }
        if(!emptyFound){
            return boardStatus = BoardStatus.CATSGAME;
        }
        return boardStatus;
    }
}
