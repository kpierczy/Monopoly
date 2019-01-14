package pl.kpierczyk.monopoly.view;

import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.model.Model.AppState;
import pl.kpierczyk.monopoly.view.subviews.IntroView;
import pl.kpierczyk.monopoly.view.subviews.gameView.GameView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.MainMenuView;

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

    private IntroView introView;
    private MainMenuView mainMenuView;
    private GameView gameView;

    
    
    
    
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

        /*Setting windows features*/
        this.setLocation(0, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        /*Initializing intro view*/
        
        if(this.model.getState() == AppState.intro){
            this.introView = new IntroView(this);
            this.getContentPane().add(this.introView, BorderLayout.CENTER);
        }
        else if(this.model.getState() == AppState.mainMenu){
            this.mainMenuView = new MainMenuView(this);
            this.getContentPane().add(this.mainMenuView, BorderLayout.CENTER);        
        }
        
        
            this.pack();
        this.setVisible(true);        
    }






    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public Model getModel() {
        return model;
    }

    public IntroView getintroView() {
        return introView;
    }
    public MainMenuView getMainMenuView() {
        return mainMenuView;
    }
    public GameView getGameView(){
        return gameView;
    }




    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void finishIntro(){
        if(this.introView != null){
            this.getContentPane().remove(this.introView);
            this.introView = null;

            this.mainMenuView =
                new MainMenuView( this);
            this.getContentPane().add(mainMenuView);
            
            this.revalidate();
            this.repaint();
        }
    }

    public void runNewGame(){
        loadGame();
    }

    public void loadGame(){
        if(this.mainMenuView != null){
            this.getContentPane().remove(this.mainMenuView);
            this.mainMenuView = null;

            //Drawing game panel
        }  
    }

    public void quitGame() {
        if(this.gameView != null){
            this.getContentPane().remove(this.gameView);
            this.gameView = null;

            this.mainMenuView =
                new MainMenuView(this);
            this.getContentPane().add(mainMenuView);
            
            this.revalidate();
            this.repaint();
        }  
    }

    public void quitApp() {
        this.mainMenuView = null;
        this.gameView = null;
        this.dispose();
    }
}