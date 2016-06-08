package edu.Andrew.APCS.Adventure.Testers;

/**
 * Adventure
 *
 * TextAreaTest
 *
 * Testing the Text Area
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.OutputStream;
import java.io.IOException;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextAreaBuilder;
import java.io.PrintStream;


public class TextAreaTest extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        TextArea ta = TextAreaBuilder.create().prefWidth(800).prefHeight(600).wrapText(true).build();
        Console console = new Console(ta);
        PrintStream ps = new PrintStream(console, true);
        System.setOut(ps);
        System.setErr(ps);
        Scene app = new Scene(ta);

        primaryStage.setScene(app);
        primaryStage.show();

        for (char c : "some text".toCharArray()) {
            console.write(c);
        }
        ps.close();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Console extends OutputStream {

        private TextArea output;

        private Console(TextArea ta) {
            this.output = ta;
        }

        @Override
        public void write(int i) throws IOException {
            output.appendText(String.valueOf((char) i));
        }
    }

}
