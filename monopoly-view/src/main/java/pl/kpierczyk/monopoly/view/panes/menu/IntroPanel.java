package pl.kpierczyk.monopoly.view.panes.menu;

import java.io.File;

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

public class IntroPanel extends JPanel {


    /*****************************************/
    /* Constructor */
    /*****************************************/

    public IntroPanel(Integer resolution[], String introPosterPath) {
        super();
        this.setSize(resolution[0], resolution[1]);

        ImageIcon icon = new ImageIcon(introPosterPath);
        JLabel label = new JLabel();
        label.setIcon(icon);
        this.add(label);       
    }

}