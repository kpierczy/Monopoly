package pl.kpierczyk.monopoly.controller.subcontrollers.gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.MainMenuController;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.MainMenuView;

/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class GameController{

    /** Reference to the parent-controller.*/
    private final Controller controller;

    /** Subcontrollers responsible for specified elements of main-menu.*/
    private GameMenuController gameMenuController;

    /** Specialized Listener responsible for interpreting user's actions for the MainMenuController*/
    private GameInterfaceListener gameInterfaceListener;

    public GameController(Controller controller){
        this.controller = controller;
        this.gameInterfaceListener = 
            new GameInterfaceListener(controller);

        /** Set listeners to all buttons in the in-game gui.*/
        this.controller.getView().getGameView().getMenuButton().addActionListener(gameInterfaceListener);
        this.controller.getView().getGameView().getRollEnd().addActionListener(gameInterfaceListener);
        this.controller.getView().getGameView().getBankruptButton().addActionListener(gameInterfaceListener);
        for(int i = 0; i < this.controller.getView().getGameView().getPlayersButtons().size(); i++){
            this.controller.getView().getGameView().getPlayersButtons().get(i).addActionListener(gameInterfaceListener);
        }
    }


    /**
     * @return the gameMenuController
     */
    public GameMenuController getGameMenuController() {
        return gameMenuController;
    }



    /**
     * 
     */
    public void openMenuPanel(){
        this.controller.getView().getGameView().openMenuPanel();
        this.gameMenuController = 
            new GameMenuController(controller);
        this.gameInterfaceListener = null;
    }


    /**
     * 
     */
    public void closeMenu(){
        this.controller.getView().getGameView().closeMenu();
        this.gameMenuController = null;
        this.gameInterfaceListener = 
            new GameInterfaceListener(controller);
    }


    public void rollDices(){
        this.controller.getModel().getGameModel().rollDices();
        this.controller.getView().getGameView().updateCounters();
        boolean wantToBuy = false;
        if(controller.getModel().getGameModel().isBuyable()){
            wantToBuy =
                this.controller.getView().getGameView().askIfBuy();
        }
        this.controller.getModel().getGameModel().causeFieldEffect(wantToBuy);
        this.controller.getView().getGameView().updateButtons();
    }


    public void finishTurn(){
        if(this.controller.getModel().getGameModel().endTurn()){
            this.controller.getView().getGameView().updateButtons();
        }
    }
}









/**
 * Utility class establishing listener for all buttons visible in
 * the in-game panel. Checks source of the action and calls appropriate
 * GameController's method to handle action.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     MainMenuController
 * @see     MainMenuView
 */
class GameInterfaceListener implements ActionListener{
    
    /** Reference to the grandparent-controller.*/
    private final Controller controller;

    /**
     * Default constructor saving reference to the main
     * Controller.
     * 
     * @param controller
     */
    public GameInterfaceListener(Controller controller){
        this.controller = controller;
    }



    /**
     * Ovverided listener's method picking up actions performed
     * by user in the main menu and calling appropriate MainMenuController's
     * method to handle actions.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /** Save refference to the action's source.*/
        JButton buttonSource = (JButton) e.getSource();


        /** If "Menu" button pressed.*/
        if(buttonSource == this.controller.getView().getGameView().getMenuButton()){
            this.controller.getGameController().openMenuPanel();
        }
        /** If roll/finish turn button pressed.*/
        else if(buttonSource == this.controller.getView().getGameView().getRollEnd()){
            if(this.controller.getModel().getGameModel().isHasPlayerRolled()){
                this.controller.getGameController().finishTurn();;
            }
            else{
                this.controller.getGameController().rollDices();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getBankruptButton()){
            
        }
        else if(this.controller.getView().getGameView().getPlayersButtons().indexOf(buttonSource) != -1){
            
        }

        
    }
}