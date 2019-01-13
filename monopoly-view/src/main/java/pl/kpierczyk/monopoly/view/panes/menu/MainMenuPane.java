package pl.kpierczyk.monopoly.view.panes.menu;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import pl.kpierczyk.monopoly.model.Model;

//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class MainMenuPane extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private Model model;

    private Image backgroundImage;
    private ButtonBox buttonBox;



    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuPane(Model model) {
        super();
        this.model = model;
        this.setSize(model.getSettings().getResolution()[0], model.getSettings().getResolution()[1]);
        FlowLayout flowLayout= new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        this.setLayout(flowLayout);

        try {
            backgroundImage = ImageIO.read(new File(model.getMainMenuController().getBackgroundImagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image");
        }

        this.buttonBox = new ButtonBox(this.model);
        this.add(this.buttonBox);
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public ButtonBox getButtonBox() {
        return buttonBox;
    }

    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }
}

class ButtonBox extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    Model model;

    final int buttonWidth = 400;
    final int buttonHeight = 100;
    final int buttonsNumber = 6;

    private JButton buttons[];

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public ButtonBox(Model model) {
        this.model = model;
        this.setSize(this.buttonWidth, this.buttonsNumber * this.buttonHeight);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.buttons = new JButton[this.buttonsNumber];

        for (int i = 0; i < this.buttonsNumber; i++) {
            this.buttons[i] = new JButton(
                    this.model.getMainMenuController().getMainMenu().getMenuField(i).getFieldText());
            this.buttons[i].setSize(this.buttonWidth, this.buttonHeight);
            this.buttons[i].setAlignmentX(Component.CENTER_ALIGNMENT);
            this.add(this.buttons[i]);
        }

    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public JButton[] getButtons() {
        return buttons;
    }

    public JButton getButtons(int buttonNumber) {
        if (buttonNumber >= 0 && buttonNumber < 6) {
            return this.buttons[buttonNumber];
        } else
            return null;
    }

}