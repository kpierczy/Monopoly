package pl.kpierczyk.monopoly.controller.subcontrollers.gameController.partialControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;



/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class InstructionController implements ActionListener{

    Controller controller;

    public InstructionController(Controller controller){
        this.controller = controller;

        this.controller.getView().getGameView().getInstructionView().getBackButton().addActionListener(this);
        this.controller.getView().getGameView().getInstructionView().getLeftButton().addActionListener(this);
        this.controller.getView().getGameView().getInstructionView().getRightButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();

        if(buttonSource == this.controller.getView().getGameView().getInstructionView().getBackButton()){
                this.controller.getView().getGameView().getInstructionView().backToMainMenu();
                this.controller.getGameController().getGameMenuController().closeChild();
        }
        else if(buttonSource == this.controller.getView().getGameView().getInstructionView().getLeftButton()){
            if(this.controller.getModel().getMainMenuModel().getInstructionModel().previousPage()){
                this.controller.getView().getGameView().getInstructionView().previousPage();
            }
        }
        else if(buttonSource == this.controller.getView().getGameView().getInstructionView().getRightButton()){
            if(this.controller.getModel().getMainMenuModel().getInstructionModel().nextPage()){
                this.controller.getView().getGameView().getInstructionView().nextPage();
            }
        }
    }
}