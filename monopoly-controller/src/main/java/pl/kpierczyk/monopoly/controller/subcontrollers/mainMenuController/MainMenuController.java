package pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import pl.kpierczyk.monopoly.controller.Controller;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.InstructionController;
import pl.kpierczyk.monopoly.controller.subcontrollers.mainMenuController.partialControllers.TitlesController;
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

//<--- TO DO ---> 
// create base class MenuController for MainMenuController and InGameMenuController
// at least InGameController can extend MainMenucontroller with overloaded method quit()

public class MainMenuController{


    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    private Controller controller;

    /*Main menu listener*/
    private MainMenuListener mainMenuListener;

    /*Submenu's listeners*/

    //private LoadingController loadigController;
    //private SettingsController settingsController;
    private InstructionController instructionController;
    private TitlesController titlesController;


    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public MainMenuController(Controller controller){
        this.controller = controller;

        /*Initializing mainMenuListener*/
        this.mainMenuListener = new MainMenuListener(this.controller);
        MainMenuView mainMenuView = this.controller.getView().getMainMenuView();

        for(int i = 0; i < mainMenuView.getMainMenuButtonsNumber(); i++){
            mainMenuView.getMainMenuButton(i).addActionListener(this.mainMenuListener);
        }
    }






    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    //public LoadingController getLoadingController() {
    //    return loadingController;
    //}

    //public SettingsController getSettingsController() {
    //    return settingsController;
    //}

    public InstructionController getInstructionController() {
        return instructionController;
    }

    public TitlesController getTitlesController() {
        return titlesController;
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
        if(this.mainMenuListener != null){
                if(this.controller.getModel().getMainMenuModel().openInstruction()){
                this.controller.getView().getMainMenuView().openInstruction();
            
                this.mainMenuListener = null;
                this.instructionController =
                    new InstructionController(this.controller);
            }
        }
    }

    public void openTitles(){
        if(this.mainMenuListener != null){
            if(this.controller.getModel().getMainMenuModel().openTitles()){
                this.controller.getView().getMainMenuView().openTitles();

                this.mainMenuListener = null;
                this.titlesController =
                    new TitlesController(this.controller);
            }
        }
    }

    public void closeChild(){
        if(this.mainMenuListener == null){

            //this.loadingController = null;
            //this.settingsController = null;
            this.instructionController = null;
            this.titlesController = null;

            this.mainMenuListener =
                new MainMenuListener(this.controller);
            MainMenuView mainMenuView =
                this.controller.getView().getMainMenuView();

            for(int i = 0; i < mainMenuView.getMainMenuButtonsNumber(); i++){
                mainMenuView.getMainMenuButton(i).addActionListener(this.mainMenuListener);
            }
        }
    }
}













//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

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
        JButton buttonSource = (JButton) e.getSource();


        //New game
        if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(0)){

        }
        //Load game
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(1)){
            
        }
        //Settings
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(2)){
            
        }
        //Instruction
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(3)){
            this.controller.getMainMenuController().openInstruction();
        }
        //Titles
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(4)){
            this.controller.getMainMenuController().openTitles();
        }
        //Quit app
        else if(buttonSource == this.controller.getView().getMainMenuView().getMainMenuButton(5)){
         this.controller.quitApp();   
        }
    }
}