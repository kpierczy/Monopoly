package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.view.subviews.mainMenuView.MainMenuView;









//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class MainMenuController{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private Controller controller;

    /*Main menu listener*/
    MainMenuListener mainMenuListener;

    /*Submenu's listeners*/




    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public MainMenuController(Controller controller){
        this.controller = controller;

        /*Initializing mainMenuListener*/
        this.mainMenuListener = new MainMenuListener(this.controller);
        MainMenuView mainMenuView = this.controller.getView().getmainMenuView();

        for(int i = 0; i < mainMenuView.getMainMenuButtonsNumber(); i++){
            mainMenuView.getMainMenuButton(i).addActionListener(this.mainMenuListener);
        }
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/
   
    public void newGame(){

    }

    public void openLoadingMenu(){

    }

    public void openOptionsMenu(){

    }

    public void openInstruction(){

    }

    public void openTitles(){

    }

    public void closeChild(){
        
    }
}



class MainMenuListener implements ActionListener{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    Controller controller;




    /*****************************************/
    /*             Constructor               */
    /*****************************************/


    public MainMenuListener(Controller controller){
        this.controller = controller;
    }





    /*****************************************/
    /* Listener's methods */
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