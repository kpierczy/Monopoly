package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

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

public class InstructionController implements ActionListener{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Controller controller;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public InstructionController(Controller controller){
        this.controller = controller;

        this.controller.getView().getMainMenuView().getInstructionView().getBackButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getInstructionView().getLeftButton().addActionListener(this);
        this.controller.getView().getMainMenuView().getInstructionView().getRightButton().addActionListener(this);
    }


    /*****************************************/
    /* Listener's methods */
    /*****************************************/

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