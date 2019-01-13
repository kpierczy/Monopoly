package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.kpierczyk.monopoly.controller.Controller;








//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class TitlesController implements ActionListener{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Controller controller;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public TitlesController(Controller controller){
        this.controller = controller;
        this.controller.getView().getMainMenuView().getTitlesView().getBackButton().addActionListener(this);
    }


    /*****************************************/
    /* Listener's methods */
    /*****************************************/

    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.getModel().getMainMenuModel().getTitlesModel().backToMainMenu();
        this.controller.getView().getMainMenuView().getTitlesView().backToMainMenu();
        this.controller.getMainMenuController().closeChild();
    }
}