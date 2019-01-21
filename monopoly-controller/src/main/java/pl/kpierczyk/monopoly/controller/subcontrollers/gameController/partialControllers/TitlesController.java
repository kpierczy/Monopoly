package pl.kpierczyk.monopoly.controller.subcontrollers.gameController.partialControllers;

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
        this.controller.getView().getGameView().getTitlesView().getBackButton().addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        this.controller.getView().getGameView().getTitlesView().backToMainMenu();
        this.controller.getGameController().getGameMenuController().closeChild();;
    }
}