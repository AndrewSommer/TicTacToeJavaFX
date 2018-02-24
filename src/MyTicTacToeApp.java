import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * This class contains only the main method and the start method to display
 * the GUI for MyTicTacToeApp
 *
 * @author Andrew Sommer
 * @version 1.0.0 06 February 2018
 */
public class MyTicTacToeApp extends Application {

    public static void main(String[] args) {
    launch(args);
    }
    public void start(Stage primaryStage) {
        try {
            Parent root =
                    FXMLLoader.load(getClass().getResource("TicTacToeView.fxml"));
            Scene scene = new Scene(root);
            primaryStage.setTitle("TicTacToe");
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setMinWidth(400);
            primaryStage.setMinHeight(420);
            primaryStage.setMaxWidth(400);
            primaryStage.setMaxHeight(420);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
