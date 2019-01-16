package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import pl.kpierczyk.monopoly.controller.Controller;


/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class TitlesController implements ActionListener{

    Controller controller;

    public TitlesController(Controller controller){
        this.controller = controller;
        this.controller.getView().getMainMenuView().getTitlesView().getBackButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(this.controller.getModel().getMainMenuModel().getTitlesModel().backToMainMenu()){
            this.controller.getView().getMainMenuView().getTitlesView().backToMainMenu();
            this.controller.getMainMenuController().closeChild();
        }
    }
}