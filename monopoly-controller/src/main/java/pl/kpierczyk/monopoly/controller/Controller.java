package pl.kpierczyk.monopoly.controller;

import pl.kpierczyk.monopoly.controller.subcontrollers.introController.IntroController;
import pl.kpierczyk.monopoly.controller.subcontrollers.gameController.GameController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.MainMenuController;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.model.Model.AppState;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.MainMenuModel.MainMenuState;
import pl.kpierczyk.monopoly.view.*;



/**
 * Class representing MVC pattern's Controller establishing
 * resposibility of interface. It connects all elements of
 * View to appropriate Model's function calls. Controller
 * structure is divaded analogously to structur of other
 * MVC branches.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     View
 */
public class Controller{

    /** References to Model and View*/
    private Model model;
    private View view;

    /** Branches servicing three main phases os the game.*/
    private IntroController introductionController;
    private MainMenuController mainMenuController;
    private GameController gameController;



    /**
     * Default Controller's constructor asigning references
     * to the Model and View. It initializes game phase controll
     * basing on Model state - main menu, or intro.
     * 
     * @param model
     * @param view
     */
    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        /** Initialize intro controll.*/
        if(this.model.getState() == AppState.intro)
            this.introductionController = new IntroController(this);
        /** Initialize main menu controll.*/
        else if(this.model.getState() == AppState.mainMenu)
            this.mainMenuController = new MainMenuController(this);
    }



    /**
     * Returns reference to the model.
     * 
     * @return reference to the model
     */
    public Model getModel() {
        return this.model;
    }

    /**
     * Returns reference to the view.
     * 
     * @return reference to the view
     */
    public View getView() {
        return this.view;
    }
    
    /**
     * Returns reference to the intro controller,
     * managing skipping intro and disabling it after
     * specified time.
     * 
     * @return  reference to the introController
     * @see     IntroductionController
     */
    public IntroController getIntroductionController() {
        return introductionController;
    }

    /**
     * Returns reference to the main menu controller, which
     * manages interaction between programm and user during
     * staying in main menu. Institutes subcontrollers
     * managing all submenus like settings, instruction and titles.
     * 
     * @return  reference to MainMenuController
     * @see     MainMenuController
     */
    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }

    /**
     * Returns reference to the game controller, which
     * manages interaction between programm and user during
     * the game. Institutes subcontrollers managing all
     * situations that occurs during the gameplay.
     * 
     * @return  reference to GameController
     * @see     GameController
     */
    public GameController getGameController() {
        return gameController;
    }






    

    /*****************************************/
    /*              Utilities                */
    /*****************************************/


    /**
     * Finishes intro changing calling model's and view's
     * state change. Constructs main menu controller.
     * If programm is not in the introduction phase
     * method does nothing.
     * 
     */
    public synchronized void finishIntro(){

        /** Try to inform model about attempt of finishing intro.*/
        if(model.finishIntro()){
            //** Inform view about finished intro.*/
            view.finishIntro();

            /** Create MainMenuController to manage main menu interactions.*/
            this.introductionController = null;
            this.mainMenuController =
                new MainMenuController(this);
        }
    }

    /**
     * Initializes new game with a specified number of players.
     * Informs model and view about need of changes and creates
     * new GameController to manage in-game interaction.
     * 
     * @param playersNumber
     */
    public void runNewGame(int playersNumber){

        /** Inform model and view about starting game.*/
        model.runNewGame(playersNumber);
        view.runNewGame();

        /** Create GameController to manage in-game interactions.*/
        this.mainMenuController = null;
        this.gameController = 
            new GameController(this);
    }

    /**
     * Initializes new game reestablishing state saved in the  with a specified number of players.
     * Informs model and view about need of changes and creates
     * new GameController to manage in-game interaction.
     * 
     * @param playersNumber
     */
    public void loadGame(){

        /** Check if game state is appropriate*/
        if(model.getMainMenuModel().getLoadingModel() != null){

            /** Load informations about game conditions from actual selected save.*/
            model.getMainMenuModel().getLoadingModel().loadActualSave();

            /** Inform view about beggining game.*/
            view.runNewGame();

            /** Create GameController to manage in-game interactions.*/
            this.mainMenuController = null;
            this.gameController = 
                new GameController(this);
        }
    }


    /**
     * If possible finishes game and back wholl programm
     * to the main menu. Creates MainMenuController
     * to manage main menu interactions.
    */
    public void quitGame(){

        /** Check if player is in game.*/
        if(model.quitGame()){

            /** Inform view about quitting*/
            view.quitGame();

            /** Create MainMenuController to manage main menu interactions.*/
            this.gameController = null;
            this.mainMenuController =
                new MainMenuController(this);
        }
    }


    /**
     * Informs model and view about programm's quitting.
     * Finishes programm with specified system code.
     */
    public void quitApp() {
        this.model = null;
        this.view.quitApp();;
        System.exit(0);
    }
}
