package pl.kpierczyk.monopoly.controller;

import pl.kpierczyk.monopoly.controller.subcontrollers.IntroController;
import pl.kpierczyk.monopoly.controller.subcontrollers.gameController.GameController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.MainMenuController;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.model.Model.AppState;
import pl.kpierczyk.monopoly.view.*;






//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class Controller{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private Model model;
    private View view;

    private IntroController introductionController;
    private MainMenuController mainMenuController;
    private GameController gameController;




    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        if(this.model.getState() == AppState.intro)
            this.introductionController = new IntroController(this);
        else if(this.model.getState() == AppState.mainMenu)
            this.mainMenuController = new MainMenuController(this);
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public Model getModel() {
        return this.model;
    }
    public View getView() {
        return this.view;
    }
    
    public IntroController getIntroductionController() {
        return introductionController;
    }
    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }
    public GameController getGameController() {
        return gameController;
    }




    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public synchronized void finishIntro(){
        if(model.finishIntro()){
            view.finishIntro();

            this.introductionController = null;
            this.mainMenuController =
                new MainMenuController(this);
        }
    }

    public void runNewGame(){
        model.runNewGame();
        view.runNewGame();

        this.mainMenuController = null;
        this.gameController = 
            new GameController(this);
    }

    public void loadGame(){
        model.getMainMenuModel().getLoadingModel().loadActualSave();
        view.runNewGame();

        this.mainMenuController = null;
        this.gameController = 
            new GameController(this);
    }

    public void quitGame() {
        model.quitGame();
        view.quitGame();

        this.gameController = null;
        this.mainMenuController =
            new MainMenuController(this);
    }

    public void quitApp() {
        this.model = null;
        this.view.quitApp();;
        System.exit(0);
    }
}
