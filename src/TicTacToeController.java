import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

/**
 * The Controller for the TicTacToeView.fxml file
 *
 * @author AndrewSommer
 * @version 1.0.0 06 February 2018
 */
public class TicTacToeController {
    /**
     * The top left square of the tic-tac-toe board
     */
    @FXML
    private Label zeroZero;

    /**
     * The top middle square of the tic-tac-toe board
     */
    @FXML
    private Label zeroOne;

    /**
     * The top right square of the tic-tac-toe board
     */
    @FXML
    private Label zeroTwo;

    /**
     * The middle left square of the tic-tac-toe board
     */
    @FXML
    private Label oneZero;

    /**
     * The middle square of the tic-tac-toe board
     */
    @FXML
    private Label oneOne;

    /**
     * The middle right square of the tic-tac-toe board
     */
    @FXML
    private Label oneTwo;

    /**
     * The bottom left square of the tic-tac-toe board
     */
    @FXML
    private Label twoZero;

    /**
     * The bottom center square of the tic-tac-toe board
     */
    @FXML
    private Label twoOne;

    /**
     * The bottom right square of the tic-tac-toe board
     */
    @FXML
    private Label twoTwo;

    /**
     * Button to start a human vs. human game
     */
    @FXML
    private Button humVhumButton;

    /**
     * Button to start a human vs. computer game
     */
    @FXML
    private Button humVcompButton;

    /**
     * Button to start a computer vs. computer game
     */
    @FXML
    private Button compVcompButton;


    /**
     * Label to display information text to the user
     */
    @FXML
    private Label promptLabel;

    /**
     * The top left square of the tic-tac-toe board
     */
    @FXML
    private Button playAgainButton;

    /**
     * Array of the players in the game
     */
    private Player[] players = new Player[2];

    /**
     * A board object to hold the state of each square and game
     */
    private Board board = new Board();

    /**
     * Starts the game, and creates the players based on the user input
     *
     * @param event
     */
    @FXML
    private void startGame(ActionEvent event) {

        playAgainButton.setVisible(false);
        humVhumButton.setVisible(false);
        humVcompButton.setVisible(false);
        compVcompButton.setVisible(false);
        promptLabel.setVisible(true);

        if (event.getSource() == humVhumButton) {
            players[0] = new HumanPlayer(Symbol.CROSS);
            players[1] = new HumanPlayer(Symbol.NAUGHT);
        } else if (event.getSource() == humVcompButton) {
            players[0] = new HumanPlayer(Symbol.CROSS);
            players[1] = new ComputerPlayer(Symbol.NAUGHT);
        } else {
            players[0] = new ComputerPlayer(Symbol.CROSS);
            players[1] = new ComputerPlayer(Symbol.NAUGHT);
        }

        Label[][] buttonBoard = {{zeroZero, zeroOne, zeroTwo}, {oneZero, oneOne, oneTwo}, {twoZero, twoOne, twoTwo}};
        for (int row = 0; row < buttonBoard.length; row++) {
            for (int col = 0; col < buttonBoard[row].length; col++) {
                buttonBoard[row][col].setText(" ");
            }
        }
        board.clearBoard();
    }

    /**
     * Adds marks to the board, and checks to see if the mark ended the game
     */
    private void updateBoard() {
        int[] pos = players[Player.playerUp - 1].chooseTile();
        int row = pos[0];
        int col = pos[1];
        board.addMark(players[Player.playerUp - 1].getUserSymbol(), row, col);
        Label[][] buttonBoard = {{zeroZero, zeroOne, zeroTwo}, {oneZero, oneOne, oneTwo}, {twoZero, twoOne, twoTwo}};
        Label box = buttonBoard[row][col];
        box.setText(Character.toString(players[Player.playerUp - 1].getUserSymbol().getSymbol()));
        if (Player.playerUp == 1) {
            Player.playerUp++;
        } else {
            Player.playerUp--;
        }
        if (board.checkCurrentState() == BoardStatus.PLAYER1WON) {
            gameOver("Player 1 is the winner!");
        } else if (board.checkCurrentState() == BoardStatus.PLAYER2WON) {
            gameOver("Player 2 is the winner!");
        } else if (board.checkCurrentState() == BoardStatus.CATSGAME) {
            gameOver("Cats Game!");
        } else if (players[Player.playerUp - 1] instanceof ComputerPlayer) {
            promptLabel.setText("Click board anywhere for computer to go");
        }

    }

    /**
     * Is called whenever the tic-tac-board gui is clicked, and calls the methods for both human and computer
     * players to add their mark to the board
     *
     * @param event
     */
    @FXML
    private void boardClicked(MouseEvent event) {
        if (board.checkCurrentState().getStatus().equals("Game Not Started")
                || board.checkCurrentState().getStatus().equals("Game In Progress")) {
            Label[][] buttonBoard = {{zeroZero, zeroOne, zeroTwo}, {oneZero, oneOne, oneTwo}, {twoZero, twoOne, twoTwo}};
            if (players[Player.playerUp - 1] instanceof HumanPlayer) {
                for (int row = 0; row < buttonBoard.length; row++) {
                    for (int col = 0; col < buttonBoard[row].length; col++) {
                        if (event.getSource() == buttonBoard[row][col]) {
                            if (board.getMark(row, col) == Symbol.EMPTY) {
                                ((HumanPlayer) players[Player.playerUp - 1]).getNextMove(row, col);
                                updateBoard();
                            }
                        }
                    }
                }
            } else {
                updateBoard();
            }
        }
    }

    /**
     * Called when the game is over to change the gui
     *
     * @param winner
     */
    private void gameOver(String winner) {
        promptLabel.setVisible(false);
        humVcompButton.setVisible(true);
        humVhumButton.setVisible(true);
        compVcompButton.setVisible(true);
        playAgainButton.setVisible(false);

    }

    /**
     * Called when the GUI is initially set up, displays the buttons to start the game
     * and a blank board
     */
    public void initialize() {
        promptLabel.setVisible(false);
        humVcompButton.setVisible(true);
        humVhumButton.setVisible(true);
        compVcompButton.setVisible(true);
        playAgainButton.setVisible(false);
    }

}

