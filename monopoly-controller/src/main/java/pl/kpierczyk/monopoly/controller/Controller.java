package pl.kpierczyk.monopoly.controller;

import pl.kpierczyk.monopoly.model.*;
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

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        
        this.introductionController = new IntroController(model, view);
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/


    /*****************************************/
    /*              Utilities                */
    /*****************************************/

}
