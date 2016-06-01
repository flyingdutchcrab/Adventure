package Classwork.FinalExamProject.Testers;

import Classwork.FinalExamProject.*;

/**
 * Created by andrewbrook on 5/4/16.
 */
import java.awt.*;
import javax.swing.*;

public class ImageTest extends JFrame
{
    private ImageIcon image1;
    private JLabel label1;

    public ImageTest()
    {
        setLayout(new FlowLayout());

        image1 = new ImageIcon(getClass().getResource("cage.jpg"));
        label1 = new JLabel(image1);
        add(label1);

    }

    public static void main (String args[])
    {
        ImageTest gui = new ImageTest();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setVisible(true);
        gui.pack();

    }



}
