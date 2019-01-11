package pl.kpierczyk.monopoly.model.mainMenuController;
import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.mainMenuController.controllers.*;

public class MainMenuController{
    
    enum MainMenuState{
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

    private MainMenuState getMenuState() {
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

    public void openLoadingList(String savesHome){
        setMenuState(MainMenuState.loading);
        loadingController = new LoadingController(savesHome);
    }

    public void openOptions(){
        setMenuState(MainMenuState.options);
        optionsController = new OptionsController();
    }

    public void openTitles(){
        setMenuState(MainMenuState.titles);
        titlesControlleler = new TitlesController();
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