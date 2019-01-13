package pl.kpierczyk.monopoly.view;

import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.panes.menu.*;
import javax.swing.*;
import java.io.*;
//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class View extends JFrame {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private Model model;

    /* Main Menu sceneries */

    private IntroPane introPane;
    private MainMenuPane mainMenuPane;


    // LoadingGamePanel loadingGamePanel;
    // OptionsPanel optionsPanel;
    // InstructionPanel instructionPanel;
    // TitlesPanel titlesPanel;

    /* inGame sceneries */

    // MainGamePanel mainGamePanel;
    //
    //
    //
    //





    /*****************************************/
    /* Constructor */
    /*****************************************/

    public View(Model model) {
        super("Monopoly the board game");
        
        this.model = model;

        /* Checking window's size */
        if (!model.getSettings().isFullscreen()) {
            this.setSize(model.getSettings().getResolution()[0],
                         model.getSettings().getResolution()[1]);

            this.introPane = new IntroPane(model);
        } 
        else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
            Integer paneSize[] = new Integer[] {this.getSize().width, this.getSize().height};
            this.introPane = new IntroPane(model);
            this.introPane.setSize(paneSize[0], paneSize[1]);
        }
        this.setResizable(false);
        
        this.getContentPane().add(this.introPane);
        this.setVisible(true);        
    }






    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public IntroPane getIntroPane() {
        return introPane;
    }
    public MainMenuPane getMainMenuPane() {
        return mainMenuPane;
    }





    /*
     * LoadingGamePanel getLoadingGamePanel() { return loadingGamePanel; } public
     * OptionsPanel getOptionsPanel() { return optionsPanel; } public
     * InstructionPanel getInstructionPanel() { return instructionPanel; } public
     * TitlesPanel getTitlesPanel() { return titlesPanel; }
     * 
     * 
     * 
     * public MainGamePanel getMainGamePanel() { return mainGamePanel; }
     */





    
    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void finishIntro(){
        if(this.introPane != null){
            this.getContentPane().removeAll();
            this.introPane = null;

            this.mainMenuPane = new MainMenuPane(this.model);
            this.getContentPane().add(mainMenuPane);
            this.repaint();
        }
    }
}