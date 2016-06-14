package edu.Andrew.APCS.Adventure;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Adventure
 *
 * RunAdventure
 *
 * Runs the adventure, is the main class
 */
public class RunAdventure extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        FXMLLoader loader = new FXMLLoader(
                getClass().getResource
                        (
                                "AdventureGUI.fxml"
                )
        );
        Parent root = loader.load();

        Scene scene = new Scene(root, 600, 600);
        scene.getStylesheets().add("/edu/Andrew/APCS/Adventure/AdventureStyleSheet.css");

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaVenture");
        primaryStage.show();


    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
