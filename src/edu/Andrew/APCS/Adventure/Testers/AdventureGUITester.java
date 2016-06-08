package edu.Andrew.APCS.Adventure.Testers;

/**
 * Adventure
 *
 * AdventureGUITester
 *
 * Test the GUI
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AdventureGUITester extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("AdventureGUI.fxml"));
        primaryStage.setScene(new Scene(root, 600, 600));
        primaryStage.setTitle("Adventure");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}



