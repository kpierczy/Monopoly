package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.InstructionController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.LoadingController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.SettingsController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.TitlesController;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.MainMenuView;




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
     * @return reference to LoadingController
     * @see LoadingController
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
   

    //<--- HERE END -->

    /**
     * 
     */
    public void runNewGame(){
        if(this.mainMenuListener != null){

            int playersNumber = 
                this.controller.getView().getMainMenuView().runNewGame(this.controller.getModel().getSettings());

            if(playersNumber >= 2 && playersNumber <= 6){
                this.controller.runNewGame(playersNumber);
            }
        }
    }

    public void openLoadingMenu(){
        
    }

    public void openSettingsMenu(){
        if(this.mainMenuListener != null){
            if(this.controller.getModel().getMainMenuModel().openSettings()){
                this.controller.getView().getMainMenuView().openSettingsMenu();
            
                this.mainMenuListener = null;
                this.settingsController =
                    new SettingsController(this.controller);
            }
        }
    }

    public void openInstruction(){
        if(this.mainMenuListener != null){
                if(this.controller.getModel().getMainMenuModel().openInstruction()){
                this.controller.getView().getMainMenuView().openInstruction();
            
                this.mainMenuListener = null;
                this.instructionController =
                    new InstructionController(this.controller);
            }
        }
    }

    public void openTitles(){
        if(this.mainMenuListener != null){
            if(this.controller.getModel().getMainMenuModel().openTitles()){
                this.controller.getView().getMainMenuView().openTitles();

                this.mainMenuListener = null;
                this.titlesController =
                    new TitlesController(this.controller);
            }
        }
    }

    public void closeChild(){
        if(this.mainMenuListener == null){

            //this.loadingController = null;
            //this.settingsController = null;
            this.instructionController = null;
            this.titlesController = null;

            this.mainMenuListener =
                new MainMenuListener(this.controller);
            MainMenuView mainMenuView =
                this.controller.getView().getMainMenuView();

            for(int i = 0; i < mainMenuView.getMainMenuButtonsNumber(); i++){
                mainMenuView.getMainMenuButton(i).addActionListener(this.mainMenuListener);
            }
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

class MainMenuListener implements ActionListener{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Controller controller;




    /*****************************************/
    /*             Constructor               */
    /*****************************************/


    public MainMenuListener(Controller controller){
        this.controller = controller;
    }





    /*****************************************/
    /* Listener's methods */
    /*****************************************/


    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();


        //New game
        if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(0)){
            this.controller.getMainMenuController().runNewGame();
        }
        //Load game
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(1)){
            
        }
        //Settings
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(2)){
            this.controller.getMainMenuController().openSettingsMenu();
        }
        //Instruction
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(3)){
            this.controller.getMainMenuController().openInstruction();
        }
        //Titles
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(4)){
            this.controller.getMainMenuController().openTitles();
        }
        //Quit app
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(5)){
         this.controller.quitApp();   
        }
    }
}