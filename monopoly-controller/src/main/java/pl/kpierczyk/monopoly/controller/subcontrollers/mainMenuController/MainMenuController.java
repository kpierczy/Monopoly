package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.InstructionController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.LoadingController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.SettingsController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.TitlesController;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.InstructionModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.SettingsModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.TitlesModel;
import pl.kpierczyk.monopoly.view.subviews.gameView.partialViews.InstructionView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.MainMenuView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews.SettingsView;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.partialViews.TitlesView;




//<--- TO DO ---> 
// create base class MenuController for MainMenuController and InGameMenuController
// at least InGameController can extend MainMenucontroller with overloaded method quit()

/**
 * Class representing main-menu controller resposible for managing
 * all interactions between main menu interface and the user.
 * Manages subcontrollers to serve all submenus interacting with user
 * like settings menu, instruction and titles.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Controller
 * @see     SettingsController
 * @see     InstructionController
 * @see     TitlesController
 */
public class MainMenuController{

    /** Reference to the parent-controller.*/
    private final Controller controller;

    /** Subcontrollers responsible for specified elements of main-menu.*/
    private SettingsController settingsController;
    private InstructionController instructionController;
    private TitlesController titlesController;

    /** Specialized Listener responsible for interpreting user's actions for the MainMenuController*/
    private MainMenuListener mainMenuListener;


    /**
     * Default constructor initializing MainMenuListener that establish
     * connection between MainMenuView and MainMenuController.
     * Adds MainMenuListener to listeners lists of all buttons in the
     * MainMenuView.
     * 
     * @param   controller
     * @see     MainMenuController
     */
    public MainMenuController(Controller controller){
        
        /** Preserves reference to parent-controller.*/
        this.controller = controller;

        /** Initializing MainMenuListener*/
        this.mainMenuListener = new MainMenuListener(this.controller);

        /** Assigning MainMenuListener to the listener's lists of all buttons in main menu.*/
        for(int i = 0; i < this.controller.getView().getMainMenuView().getMainMenuButtonsNumber(); i++){
            this.controller.getView().getMainMenuView().
                getMainMenuButton(i).addActionListener(this.mainMenuListener);
        }
    }


    /**
     * Returns LoadingController responsible for interaction
     * with user during browsing list of saved games.
     * 
     * @return  reference to LoadingController
     * @see     LoadingController
     */
    public LoadingController getLoadingController() {
        return null;
    }

    /**
     * Returns SettingsController responsible for interaction
     * with user during browsing list of settings in the main-menu.
     * 
     * @return  reference to SettingsController
     * @see     SettingsController
     */
    public SettingsController getSettingsController() {
        return settingsController;
    }


    /**
     * Returns InstructionController responsible for interaction
     * with user during browsing instruction in the main-menu.
     * 
     * @return  reference to InstructionController
     * @see     InstructionController
     */
    
    public InstructionController getInstructionController() {
        return instructionController;
    }


    /**
     * Returns TitlesController responsible for interaction
     * with user during watching titles in the main-menu.
     * 
     * @return  reference to TitlesController
     * @see     TitlesController
     */
    
    public TitlesController getTitlesController() {
        return titlesController;
    }







    /*****************************************/
    /*              Utilities                */
    /*****************************************/
   

    /**
     * Checks if player stays in the main menu. If so, information to the
     * MainMenuView is sent, to display dialog input to get number of players
     * from the player. if number of players is valid, parent-controller
     * is informed about attempt of beggining new game.
     * 
     * @see MainMenuView
     */
    public void runNewGame(){
        if(this.mainMenuListener != null){

            /** Get number of players from input dialog*/
            int playersNumber = 
                this.controller.getView().getMainMenuView().runNewGame(
                    this.controller.getModel().getSettings());

            /** Check if number of players is valid.*/
            if(playersNumber >= 2 && playersNumber <= 6){
                this.controller.runNewGame(playersNumber);
            }
        }
    }


    /**
     * In future, will be initializing new loading list controller
     * managin interaction with list of saves and giving possibility
     * to load one of them
     */
    public void openLoadingMenu(){
        
    }


    /**
     * If called when MainMenuListener exists, informs Model about
     * opening settings tab in main menu. If model is possible to 
     * change state, View is informed about needed changes.
     * 
     * @see SettingsModel
     * @see SettingsView
     */
    public void openSettingsMenu(){
        /** Check if mainMenuListener is alive.*/
        if(this.mainMenuListener != null){
            
            /** Try to change model's state*/
            if(this.controller.getModel().getMainMenuModel().openSettings()){

                /** Inform View about needed change.*/
                this.controller.getView().getMainMenuView().openSettingsMenu();
            
                /** Crate new SettingsController to manage interaction with settings tab.*/
                this.mainMenuListener = null;
                this.settingsController =
                    new SettingsController(this.controller);
            }
        }
    }


    /** 
     * If called when MainMenuListener exists, informs Model about an
     * attempt of opening instruction in main menu view. If Model is 
     * able to change it's state, View is informed about need of drawing
     * new panel.
     * 
     * @see InstructionModel
     * @see InstructionView
    */
    public void openInstruction(){
        
        /** Check if MainMenuListener is alive.*/
        if(this.mainMenuListener != null){

                /** Try to change Model's state.*/
                if(this.controller.getModel().getMainMenuModel().openInstruction()){

                /** Inform view about required changes.*/
                this.controller.getView().getMainMenuView().openInstruction();
            
                /** Crate new InstructionController to manage interaction with instruction tab.*/
                this.mainMenuListener = null;
                this.instructionController =
                    new InstructionController(this.controller);
            }
        }
    }


    /**
     * If called when MainMenuListener exists, informs Model about an
     * attempt of opening titles in main menu view. If Model is able
     * to change it's state, View is informed about need of drawing
     * a new panel.
     * 
     * @see TitlesModel
     * @see TitlesView
     */
    public void openTitles(){
        
        /** Check if MainMenuListener is alive.*/
        if(this.mainMenuListener != null){
            
            /** Try to change Model's state.*/
            if(this.controller.getModel().getMainMenuModel().openTitles()){
                
                /** Inform view about required changes.*/
                this.controller.getView().getMainMenuView().openTitles();


                /** Crate new InstructionController to manage interaction with instruction tab.*/
                this.mainMenuListener = null;
                this.titlesController =
                    new TitlesController(this.controller);
            }
        }
    }


    /** 
     * If any of MainMenuController's children is opened (e.g
     * settings, titles etc.) it is closed, and new MainMenuListener
     * is created and added to the list of MainMenuView button's
     * listeners lists.
    */
    public void closeChild(){

        /** Check if any of children is running.*/
        if(this.mainMenuListener == null){

            /** Kill ale children.*/
            /**this.loadingController = null;*/
            this.settingsController = null;
            this.instructionController = null;
            this.titlesController = null;

            /** Create new MainMenuListener.*/
            this.mainMenuListener =
                new MainMenuListener(this.controller);

            /** Add listener to MainMenuView buttons's listeners lists.*/
            for(int i = 0; i < this.controller.getView().getMainMenuView().getMainMenuButtonsNumber(); i++){
                this.controller.getView().getMainMenuView().getMainMenuButton(i).addActionListener(
                    this.mainMenuListener);
            }
        }
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
class MainMenuListener implements ActionListener{

    /** Reference to the grandparent-controller.*/
    private final Controller controller;


    /**
     * Default constructor saving reference to the main
     * Controller.
     * 
     * @param controller
     */
    public MainMenuListener(Controller controller){
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


        /** If "New game" button pressed.*/
        if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(0)){
            this.controller.getMainMenuController().runNewGame();
        }
        /** If "Load game" button pressed.*/
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(1)){
            
        }
        /** If "Settings" button pressed*/
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(2)){
            this.controller.getMainMenuController().openSettingsMenu();
        }
        /** If "Instruction" buttons pressed*/
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(3)){
            this.controller.getMainMenuController().openInstruction();
        }
        /** If "Titles" buttons pressed*/
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(4)){
            this.controller.getMainMenuController().openTitles();
        }
        /** If "Quit" buttons pressed*/
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(5)){
         this.controller.quitApp();   
        }
    }
}