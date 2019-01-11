package pl.kpierczyk.monopoly.view;
import pl.kpierczyk.monopoly.model.*;
import java.awt.*;
import javax.swing.*;





//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class View{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Model model;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public View(Model model){
        this.model = model;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/


    /*****************************************/
    /*              Utilities                */
    /*****************************************/


    public boolean udate(){
        switch(model.getState()){
            case beggining:
            
            break;
            case mainMenu:

            break;
            case inGame:

            break;
            case quitting:

            break;
        }

        return true;
    }

    public boolean serveBeggining(){
        String begginingMovie = this.model.getBegginingMoviePath();

        return true;
    }
}