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

    Model model;

    /* Main Menu sceneries */

    IntroPanel introPanel;
    // MainMenuPanel mainMenuPanel;
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


        /* Checking window's size */
        if (!model.getSettings().isFullscreen()) {
            this.setSize(model.getSettings().getResolution()[0],
                         model.getSettings().getResolution()[1]);

            this.introPanel = new IntroPanel(model.getSettings().getResolution(),
                                             model.getIntroController().getIntroPosterPath());
        } 
        else {
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
            Integer paneSize[] = new Integer[] {this.getSize().width, this.getSize().height};
            this.introPanel = new IntroPanel(paneSize, model.getIntroController().getIntroPosterPath());
        }
        this.setResizable(false);
        
        this.getContentPane().add(this.introPanel);      
        this.setVisible(true);        
    }






    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public IntroPanel getIntroPanel() {
        return introPanel;
    }
    /*
     * public MainMenuPanel getMainMenuPanel() { return mainMenuPanel; } public
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

    }
}