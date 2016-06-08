package edu.Andrew.APCS.Adventure;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * Created by andrewbrook on 5/9/16.
 */
public class Controller
{
    @FXML
    private Button north;
    private Button east;
    private Button south;
    private Button west;

    private Button inventory;
    private Button map;
    public Player p = new Player();
    public Adventure adv = new Adventure();
    public Location l = new Location();
    @FXML private TextArea text;
    @FXML private TextField inputText;
    @FXML private ImageView imagePane;

    @FXML protected void handleNorthButtonPressed(ActionEvent event)
    {
        adv.makeMove("N");
    }

    @FXML protected void handleEastButtonPressed(ActionEvent event)
    {
        adv.makeMove("E");
    }

    @FXML protected void handleSouthButtonPressed(ActionEvent event)
    {
        adv.makeMove("S");
    }

    @FXML protected void handleWestButtonPressed(ActionEvent event)
    {
        adv.makeMove("W");
    }

    @FXML protected void handleInvButtonPressed(ActionEvent event)
    {
        text.appendText(p.printInventory());
    }

    @FXML protected void setImagePane()
    {
        imagePane.setImage(p.getCurrentLoc().getImage());
    }


    public void eButtonClicked()
    {
        System.out.println("E");
    }

    public void sButtonClicked()
    {
        System.out.println("S");
    }

    public void wButtonClicked()
    {
        System.out.println("W");
    }
}
