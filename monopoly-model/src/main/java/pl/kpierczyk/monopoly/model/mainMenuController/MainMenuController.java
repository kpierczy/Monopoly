package pl.kpierczyk.monopoly.model.mainMenuController;
import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.settings.*;
import pl.kpierczyk.monopoly.model.mainMenuController.controllers.*;



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
    

    public enum MainMenuState{
        _default,
        loading,
        options,
        titles,
        instruction
    }





    /*****************************************/
    /*        Invisible Class Fields         */
    /*****************************************/
    
    private Menu mainMenu;

    private MainMenuState state;

    private LoadingController loadingController;
    private OptionsController optionsController;
    private TitlesController titlesControlleler;
    private InstructionController instructionController;





    /*****************************************/
    /*              Constructor              */
    /*****************************************/
    
    public MainMenuController(String textPath){
        mainMenu = new Menu(textPath, 6);
        state = MainMenuState._default;
    }






    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public MainMenuState getMenuState() {
        return state;
    }
    private void setMenuState(MainMenuState state) {
        this.state = state;
    }

    public Menu getMainMenu() {
        return mainMenu;
    }
    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }





    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public void openLoadingList(String savesHome, String textPath){
        setMenuState(MainMenuState.loading);
        loadingController = new LoadingController(savesHome, textPath);
    }

    public void openOptions(Settings settings, String textPath){
        setMenuState(MainMenuState.options);
        optionsController = new OptionsController(settings, textPath);
    }

    public void openTitles(String titlesPath){
        setMenuState(MainMenuState.titles);
        titlesControlleler = new TitlesController(titlesPath);
    }

    public void openInstruction(String instructionPath){
        setMenuState(MainMenuState.instruction);
        instructionController = new InstructionController(instructionPath);
    }

    public void closeChild(){
        setMenuState(MainMenuState._default);
        loadingController = null;
        optionsController = null;
        titlesControlleler = null;
        instructionController = null;
    }
}