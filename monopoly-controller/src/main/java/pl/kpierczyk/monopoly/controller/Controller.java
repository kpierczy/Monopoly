package pl.kpierczyk.monopoly.controller;

import pl.kpierczyk.monopoly.controller.menu.MainMenuController;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.model.mainMenuModel.MainMenuModel;
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

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        this.introductionController = new IntroController(this);
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

    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public synchronized void finishIntro(){
        model.finishIntro();
        view.finishIntro();
        this.introductionController = null;
        this.mainMenuController = new MainMenuController(this);
    }







    public void quitApp() {
        this.model = null;
        this.view.quitApp();;
        System.exit(0);
    }
}
