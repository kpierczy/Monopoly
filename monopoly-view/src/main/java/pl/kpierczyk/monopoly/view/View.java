package pl.kpierczyk.monopoly.view;

import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.panes.menu.*;
import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Dimension;






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
    
    
    
    





    /*****************************************/
    /* Constructor */
    /*****************************************/

    public View(Model model) {
        super("Monopoly the board game");
        
        this.model = model;

        /* Checking window's size */
        if (!model.getSettings().isFullscreen()) {
            this.setSize(new Dimension(model.getSettings().getResolution()[0],
                         model.getSettings().getResolution()[1]));
        } 
        else { 
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
            this.setUndecorated(true);
        }
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.introPane = new IntroPane(model);
        this.getContentPane().add(this.introPane, BorderLayout.CENTER);
        this.pack();
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
            this.getContentPane().remove(this.introPane);
            this.introPane = null;

            this.mainMenuPane = new MainMenuPane(this.model);
            this.getContentPane().add(mainMenuPane);
            this.revalidate();
            this.repaint();
        }
    }
}