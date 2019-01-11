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

        loadingController = null;
        optionsController = null;
        titlesControlleler = null;
        instructionController = null;
    }






    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public MainMenuState getState() {
        return state;
    }
    public void setState(MainMenuState state) {
        this.state = state;
    }


    public Menu getMainMenu() {
        return mainMenu;
    }
    public void setMainMenu(Menu mainMenu) {
        this.mainMenu = mainMenu;
    }


    public InstructionController getInstructionController() {
        return instructionController;
    }
    public LoadingController getLoadingController() {
        return loadingController;
    }
    public OptionsController getOptionsController() {
        return optionsController;
    }
    public TitlesController getTitlesControlleler() {
        return titlesControlleler;
    }





    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public void openLoadingList(String savesHome, String textPath){
        setState(MainMenuState.loading);
        this.loadingController = new LoadingController(savesHome, textPath);
    }

    public void openOptions(Settings settings, String textPath){
        setState(MainMenuState.options);
        this.optionsController = new OptionsController(settings, textPath);
    }

    public void openTitles(String titlesPath){
        setState(MainMenuState.titles);
        this.titlesControlleler = new TitlesController(titlesPath);
    }

    public void openInstruction(String instructionPath){
        setState(MainMenuState.instruction);
        this.instructionController = new InstructionController(instructionPath);
    }

    public void closeChild(){
        setState(MainMenuState._default);
        loadingController = null;
        optionsController = null;
        titlesControlleler = null;
        instructionController = null;
    }
}