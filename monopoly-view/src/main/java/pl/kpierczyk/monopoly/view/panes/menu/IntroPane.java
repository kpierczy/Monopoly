package pl.kpierczyk.monopoly.view.panes.menu;

import pl.kpierczyk.monopoly.model.Model;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class IntroPane extends JPanel {

    private Image backgroundImage;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public IntroPane(Model model) {
        super();
        this.setPreferredSize(
                new Dimension(model.getSettings().getResolution()[0], model.getSettings().getResolution()[1]));

        try {
            backgroundImage = ImageIO.read(new File(model.getMainMenuController().getBackgroundImagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image");
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}