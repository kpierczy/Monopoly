package pl.kpierczyk.monopoly.view;
import pl.kpierczyk.monopoly.model.*;
import java.awt.event.*;
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

public class View extends JFrame{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Model model;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public View(Model model){
        super("Monopoly the boardgame");
        this.model = model;

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
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
        }

        return true;
    }

    public boolean serveBeggining(){
        String begginingMovie = this.model.getBegginingMoviePath();

        return true;
    }
}