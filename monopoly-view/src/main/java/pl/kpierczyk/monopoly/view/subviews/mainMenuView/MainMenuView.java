package pl.kpierczyk.monopoly.view.subviews.mainMenuView;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
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

public class MainMenuView extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private Model model;

    private Image backgroundImage;
    private ButtonBox buttonBox;
    private int buttonsNumber;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuView(Model model) {
        super();
        this.model = model;
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(
                new Dimension(model.getSettings().getResolution()[0], model.getSettings().getResolution()[1]));

        try {
            backgroundImage = ImageIO.read(new File(model.getMainMenuModel().getBackgroundImagePath()));
        } catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image");
        }

        this.buttonBox = new ButtonBox(this.model);
        this.buttonsNumber = getButtons().length;
        this.add(this.buttonBox);
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public ButtonBox getButtonBox() {
        return buttonBox;
    }

    public int getButtonsNumber() {
        return buttonsNumber;
    }

    public JButton[] getButtons() {
        return this.buttonBox.getButtons();
    }

    public JButton getButton(int buttonNumber) {
        if (buttonNumber >= 0 && buttonNumber < this.buttonsNumber) {
            return getButtons()[buttonNumber];
        } else
            return null;
    }







    

    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }


    public void newGame(){

    }

    public void openLoadingMenu(){

    }

    public void openOptionsMenu(){

    }

    public void openInstruction(){

    }

    public void closeChild(){
        
    }
}




class ButtonBox extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private final int buttonWidth = 300;
    private final int buttonHeight = 75;
    private final Font font = new Font("Arial", Font.BOLD, 18);

    private JButton buttons[];




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public ButtonBox(Model model) {
        int buttonsNumber = model.getMainMenuModel().getMainMenu().getMenuFields().length;
        this.setPreferredSize(new Dimension(this.buttonWidth, buttonsNumber * this.buttonHeight));
        
        this.setLayout(new FlowLayout());
        FlowLayout layout = (FlowLayout) this.getLayout();
        layout.setVgap(0);

        this.buttons = new JButton[buttonsNumber];
        for (int i = 0; i < buttonsNumber; i++) {
            this.buttons[i] = new JButton(
                    model.getMainMenuModel().getMainMenu().getMenuField(i).getFieldText());
            this.buttons[i].setPreferredSize(new Dimension(this.buttonWidth, this.buttonHeight));
            this.buttons[i].setFont(font);
            this.add(this.buttons[i]);
        }

    }



    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public JButton[] getButtons() {
        return this.buttons;
    }
}