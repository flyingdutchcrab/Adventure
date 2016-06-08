package edu.Andrew.APCS.Adventure.Testers;

/**
 * Adventure
 *
 * ImageTest
 *
 * Test the images
 */
import java.awt.*;
import javax.swing.*;

public class ImageTest extends JFrame
{
    private ImageIcon image1;
    private JLabel label1;

    private ImageTest()
    {
        setLayout(new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("cage.jpg"));
        label1 = new JLabel(image1);
        add(label1);

    }

    public static void main (String args[])
    {
        ImageTest gui = new ImageTest();
        gui.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();

    }



}
