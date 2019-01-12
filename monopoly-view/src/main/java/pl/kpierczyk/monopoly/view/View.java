package pl.kpierczyk.monopoly.view;
import pl.kpierczyk.monopoly.model.*;
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
        this.setSize(this.model.getSettings().getResolution()[0], this.model.getSettings().getResolution()[1]);
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
            case intro:
            
            break;
            case mainMenu:

            break;
            case inGame:

            break;
        }

        return true;
    }

    public boolean serveBeggining(){
        String begginingMovie = this.model.getIntroController().getIntroMoviePath();

        return true;
    }
}