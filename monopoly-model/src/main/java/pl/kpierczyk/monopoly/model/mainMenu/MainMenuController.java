package pl.kpierczyk.monopoly.model.mainMenu;
import pl.kpierczyk.monopoly.model.mainMenu.controllers.*;

public class MainMenuController extends MenuController{
    
    enum State{
        _default,
        loadingMenu,
        options,
        titles,
        instruction
    }

    /*****************************************/
    /*        Invisible Class Fields         */
    /*****************************************/

    private State menuState;

    private LoadingListController loadingListController;
    private final OptionsController optionsController;
    private final TitlesController titlesControlleler;
    private final InstructionController instructionController;


    /*****************************************/
    /*              Constructor              */
    /*****************************************/
    
    public MainMenuController(String sourcesHome_t,String textPath_t, int fieldsNumber){
        super(textPath_t, fieldsNumber);
        menuState = State._default;
        
        getMenuField(1).setActive(false);
        getMenuField(2).setActive(false);
        getMenuField(3).setActive(false);
        getMenuField(4).setActive(false);

        loadingListController = new LoadingListController();
        optionsController = new OptionsController();
        titlesControlleler = new TitlesController();
        instructionController = new InstructionController(sourcesHome_t);
    }
}