package pl.kpierczyk.monopoly.model;

import pl.kpierczyk.monopoly.model.submodels.IntroModel;
import pl.kpierczyk.monopoly.model.submodels.gameModel.GameModel;
import pl.kpierczyk.monopoly.model.submodels.gameModel.GameSaveInfo;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.MainMenuModel;
import pl.kpierczyk.monopoly.model.utilities.Util;
import pl.kpierczyk.monopoly.model.utilities.settings.*;







//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class Model {

    public enum AppState {
        intro, mainMenu, inGame
    }





    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private AppState state; // state of the whole app

    final private Settings settings;
    
    private IntroModel introModel;
    private MainMenuModel mainMenuModel; // Model responsible for main menu
    private GameModel gameModel; // Model responsible for in-game simulation






    /*****************************************/
    /* Constructor */
    /*****************************************/

    public Model() {

        /* initializing app's state */
        this.state = AppState.intro;

        /* initializing settings */
        this.settings = new Settings();
        this.settings.readFromFile("/config.txt");



        /* initializing introModel */
        String relativeIntroPosterPath = "/lang/" +
                                         settings.getLanguage() +
                                         "/img/intro/introPoster_" +
                                         settings.getResolutionSetting().toString() +
                                         ".png";

        String introPosterPath = Util.convert(getClass().getResource(relativeIntroPosterPath).getPath());
        introModel = new IntroModel(introPosterPath);

        /* initializing mainMenuModel */
        this.mainMenuModel = new MainMenuModel(this);

        /* initializing mainMenuModel */
        gameModel = new GameModel(this);

    }





    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public AppState getState() {
        return state;
    }

    public MainMenuModel getMainMenuModel() {
        return mainMenuModel;
    }
    public GameModel getGameModel() {
        return gameModel;
    }
    public IntroModel getIntroModel() {
        return introModel;
    }

    public Settings getSettings() {
        return settings;
    }

    /*****************************************/
    /* Utilities */
    /*****************************************/


    public void finishIntro() {
        if (getState() == AppState.intro) {
            this.state = AppState.mainMenu;
            this.introModel = null;
            this.mainMenuModel = new MainMenuModel(this);
        }
    }

    public void runNewGame(GameSaveInfo gameSaveInfo){
        //starting new game should dispose of mainMenuModel
    }

    public void quitGame() {
        if (getState() == AppState.inGame) {
            this.state = AppState.mainMenu;
            this.gameModel = null;
            this.mainMenuModel = new MainMenuModel(this);
            
        }
    }

    public void quitApp(){
        this.introModel = null;
        this.mainMenuModel = null;
        this.gameModel = null;
    }
}