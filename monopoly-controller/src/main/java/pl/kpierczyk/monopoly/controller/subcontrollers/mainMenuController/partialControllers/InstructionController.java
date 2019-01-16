package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers;

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

        this.controller.getView().getMainMenuView().getInstructionView().getBackButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getInstructionView().getLeftButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getInstructionView().getRightButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton buttonSource = (JButton) e.getSource();

        if(buttonSource == this.controller.getView().getMainMenuView().getInstructionView().getBackButton()){
            if(this.controller.getModel().getMainMenuModel().getInstructionModel().backToMainMenu()){
                this.controller.getView().getMainMenuView().getInstructionView().backToMainMenu();
                this.controller.getMainMenuController().closeChild();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getInstructionView().getLeftButton()){
            if(this.controller.getModel().getMainMenuModel().getInstructionModel().previousPage()){
                this.controller.getView().getMainMenuView().getInstructionView().previousPage();
            }
        }
        else if(buttonSource == this.controller.getView().getMainMenuView().getInstructionView().getRightButton()){
            if(this.controller.getModel().getMainMenuModel().getInstructionModel().nextPage()){
                this.controller.getView().getMainMenuView().getInstructionView().nextPage();
            }
        }
    }
}