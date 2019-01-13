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

import pl.kpierczyk.monopoly.view.View;

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

    private View view;


    /*Main Menu elements*/
    private Image backgroundImage;
    private MainMenuPanel mainMenuPanel;


    /*Submenus views (panels)*/







    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuView(View view) {
        super();
        this.view = view;

        /*Main menu's size and layout initialization*/
        this.setPreferredSize(new Dimension(this.view.getModel().getSettings().getResolution()[0],
                                            this.view.getModel().getSettings().getResolution()[1]));
        
        this.setLayout(new GridBagLayout());
               
        /*Main menu's bacground image initialization*/
        try {
            backgroundImage = 
                ImageIO.read(new File(this.view.getModel().getMainMenuModel().getBackgroundImagePath()));
        }
        catch (IOException ex) {
            System.out.println("Couldn't open mainMenu's background image from " + 
                                this.view.getModel().getMainMenuModel().getBackgroundImagePath());
        }

        /*Main menu buttons panel adding*/
        this.mainMenuPanel =
            new MainMenuPanel(this.view);
        this.add(this.mainMenuPanel);
    }




    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    /*Main menu elements methods*/

    public int getMainMenuButtonsNumber() {
        return getMainMenuButtons().length;
    }

    public JButton[] getMainMenuButtons() {
        return this.mainMenuPanel.getButtons();
    }

    public JButton getMainMenuButton(int buttonNumber) {
        if (buttonNumber >= 0 && buttonNumber < getMainMenuButtonsNumber()) {
            return getMainMenuButtons()[buttonNumber];
        } else
            return null;
    }


    /*Submenus elements methods*/
    


    






    

    /*****************************************/
    /* Utilities */
    /*****************************************/

    /*Graphical utilities*/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }


    /*Logical utilities*/
    public void newGame(){

    }

    public void openLoadingMenu(){

    }

    public void openOptionsMenu(){

    }

    public void openInstruction(){

    }

    public void openTitles(){

    }

    public void closeChild(){
        
    }
}

















//*******************************************//
//
//
//
//
//
//
//
//*******************************************//


class MainMenuPanel extends JPanel {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    View view;

    private final int buttonWidth = 300;
    private final int buttonHeight = 75;
    private final Font font = new Font("Arial", Font.BOLD, 18);

    private JButton buttons[];


    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuPanel(View view) {
        this.view = view;

        /*Getting number of buttons to create*/
        int buttonsNumber =
            this.view.getModel().getMainMenuModel().getMainMenu().getMenuFields().length;
        
        this.setPreferredSize(new Dimension(this.buttonWidth,
                                            this.buttonHeight * buttonsNumber));
        
        /*Setting MaineMenu's buttons layout*/
        this.setLayout(new FlowLayout());
        FlowLayout layout = 
            (FlowLayout) this.getLayout();
        layout.setVgap(0);

        /*Initializing buttons*/
        this.buttons = new JButton[buttonsNumber];
        for (int i = 0; i < buttonsNumber; i++) {
            this.buttons[i] = new JButton(
                this.view.getModel().getMainMenuModel().getMainMenu().getMenuField(i).getFieldText());
            this.buttons[i].setPreferredSize(new Dimension(this.buttonWidth,
                                                           this.buttonHeight));
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