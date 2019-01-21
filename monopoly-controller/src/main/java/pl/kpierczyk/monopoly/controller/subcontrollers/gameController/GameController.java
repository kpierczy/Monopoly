package pl.kpierczyk.monopoly.controller.subcontrollers.gameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;

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


        this.controller.getView().getGameView().getMenuButton().addActionListener(gameInterfaceListener);
    }


    /**
     * @return the gameMenuController
     */
    public GameMenuController getGameMenuController() {
        return gameMenuController;
    }



    public void openMenuPanel(){
        this.controller.getView().getGameView().openMenuPanel();
        this.gameMenuController = 
            new GameMenuController(controller);
        this.gameInterfaceListener = null;
    }


    public void closeMenu(){
        this.controller.getView().getGameView().closeMenu();
        this.gameMenuController = null;
        this.gameInterfaceListener = 
            new GameInterfaceListener(controller);
    }
}










/**
 * Utility class establishing listener for all buttons visible in
 * the main menu. Checks source of the action and calls appropriate
 * MainMenuController method to handle action.
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
        
    }
}