package pl.kpierczyk.monopoly.view.panes.menu;

import pl.kpierczyk.monopoly.model.Model;
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

public class IntroPane extends JPanel {


    private JLabel label;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public IntroPane(Model model) {
        super();
        this.setSize(model.getSettings().getResolution()[0],
                     model.getSettings().getResolution()[1]);

        ImageIcon icon = 
            new ImageIcon(model.getIntroController().getIntroPosterPath());
        label = new JLabel();
        label.setIcon(icon);
        this.add(label);       
    }

}