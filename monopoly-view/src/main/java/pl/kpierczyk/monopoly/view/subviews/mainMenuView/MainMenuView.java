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
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import pl.kpierczyk.monopoly.model.utilities.settings.Settings;
import pl.kpierczyk.monopoly.view.View;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews.InstructionView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews.SettingsView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews.TitlesView;


//<--- TO DO --->
// Create base class MenuModel for MainMenuView and InGameMenuView
// At least InGameView can extend MainMenuView with overloaded method quit()

/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class MainMenuView extends JPanel {

    private View view;


    /*Main Menu elements*/

    private Image backgroundImage;
    private MainMenuPanel mainMenuPanel;


    /*Submenus views (panels)*/

    //private LoadingView loadingView;
    private SettingsView settingsView;
    private InstructionView instructionView;
    private TitlesView titlesView;

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


    //public LoadingView getLoadingView() {
    //    return loadingView;
    //}

    public SettingsView getSettingsView() {
        return settingsView;
    }

    public InstructionView getInstructionView() {
        return instructionView;
    }

    public TitlesView getTitlesView() {
        return titlesView;
    }
    

    /*****************************************/
    /* Utilities */
    /*****************************************/

    /*Graphical utilities*/
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, this);
    }


    /*Logical utilities*/
    public int runNewGame(Settings settings){
        if(this.mainMenuPanel != null){
            
            String playersNumber = "";

            if(settings.getLanguage() == "en"){
                playersNumber = 
                    JOptionPane.showInputDialog(this.view, "Please enter number of players (from 2 to 6):");
            }
            else if(settings.getLanguage() == "pl"){
            playersNumber = 
                    JOptionPane.showInputDialog(this.view, "Wproawdź liczbę graczy (od 2 do 6):");
            }

            return Integer.parseInt(playersNumber);
        }
        else return -1;
    }

    public void openLoadingMenu(){
        if(this.mainMenuPanel != null){
            //this.remove(this.mainMenuPanel);
            //this.mainMenuPanel = null;
            
            //this.loadingView =
            //    new LoadingView(this.view);
            //this.add(this.loadingView);

            //this.view.revalidate();
            //this.view.repaint();
        }
    }

    public void openSettingsMenu(){
        if(this.mainMenuPanel != null){
            this.remove(this.mainMenuPanel);
            this.mainMenuPanel = null;
                    
            this.settingsView =
                new SettingsView(this.view);
            this.add(this.settingsView);

            this.view.revalidate();
            this.view.repaint();
        }
    }

    public void openInstruction(){
        if(this.mainMenuPanel != null){
            this.remove(this.mainMenuPanel);
            this.mainMenuPanel = null;
            
            this.instructionView =
                new InstructionView(this.view);
            this.add(this.instructionView);

            this.view.revalidate();
            this.view.repaint();
        }
    }

    public void openTitles(){
        if(this.mainMenuPanel != null){
            this.remove(this.mainMenuPanel);
            this.mainMenuPanel = null;

            this.titlesView =
                new TitlesView(this.view);
            this.add(this.titlesView);

            this.view.revalidate();
            this.view.repaint();
        }
    }

    public void closeChild(){
        if(this.mainMenuPanel == null){
            //if(this.loadingView != null){
            //    this.remove(this.loadingView);
            //    this.loadingView = null;
            //}

            if(this.settingsView != null){
                this.remove(this.settingsView);
                this.settingsView = null;
            }

            if(this.instructionView != null){
                this.remove(this.instructionView);
                this.instructionView = null;
            }

            if(this.titlesView != null){
                this.remove(this.titlesView);
                this.titlesView = null;
            }

            this.mainMenuPanel =
                new MainMenuPanel(this.view);
            this.add(this.mainMenuPanel);

            this.view.revalidate();
            this.view.repaint();
        }
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