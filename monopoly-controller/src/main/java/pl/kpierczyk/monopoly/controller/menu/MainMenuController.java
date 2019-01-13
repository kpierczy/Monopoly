package pl.kpierczyk.monopoly.controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.model.utilities.MenuField;









//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class MainMenuController implements ActionListener{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private Controller controller;

    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public MainMenuController(Controller controller){
        this.controller = controller;
        
        for(int i = 0; i < this.controller.getView().getMainMenuPane().getButtonsNumber(); i++){
            this.controller.getView().getMainMenuPane().getButton(i).addActionListener(this);
        }
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/


    /*****************************************/
    /*              Utilities                */
    /*****************************************/
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String buttonsName = ( (JButton) e.getSource()).getText();
        String possibleButtonsNames[] = this.controller.getModel().getMainMenuModel().getMainMenu().getMenuText();

        //New game
        if(buttonsName == possibleButtonsNames[0]){

        }
        //Load game
        else if(buttonsName == possibleButtonsNames[1]){
            
        }
        //Settings
        else if(buttonsName == possibleButtonsNames[2]){
            
        }
        //Instruction
        else if(buttonsName == possibleButtonsNames[3]){
            
        }
        //Titles
        else if(buttonsName == possibleButtonsNames[4]){
            
        }
        //Quit app
        else if(buttonsName == possibleButtonsNames[5]){
         this.controller.quitApp();   
        }
    }
}