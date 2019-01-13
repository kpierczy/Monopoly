package pl.kpierczyk.monopoly.model;

import pl.kpierczyk.monopoly.model.mainMenuModel.*;
import pl.kpierczyk.monopoly.model.gameModel.*;
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

    private final int introTime = 4000;
    private IntroModel introModel;
    private MainMenuModel mainMenuModel; // Model responsible for main menu
    private GameModel gameModel; // Model responsible for in-game simulation

    final private Settings settings;

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
        String relativeIntroPosterPath = "/lang/" + settings.getLanguage() + "/img/intro/introPoster_" +
                                         settings.getResolutionSetting().toString() + ".png";
        String introPosterPath = this.convert(getClass().getResource(relativeIntroPosterPath).getPath());

        introModel = new IntroModel(introPosterPath);


        /* initializing mainMenuModel */
        this.mainMenuModel = new MainMenuModel(settings);

        /* initializing mainMenuModel */
        gameModel = new GameModel();

    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public AppState getState() {
        return state;
    }

    private void setState(AppState state) {
        this.state = state;
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

    public int getIntroTime() {
        return introTime;
    }

    public Settings getSettings() {
        return settings;
    }

    /*****************************************/
    /* Utilities */
    /*****************************************/

    public static String convert(String url){
        String uri = url.replaceAll("%20", " ");
        return uri;
    }


    public boolean finishIntro() {
        if (getState() == AppState.intro) {
            setState(AppState.mainMenu);
            this.introModel = null;
            this.mainMenuModel = new MainMenuModel(settings);
            return true;
        } else
            return false;
    }

    public boolean quitGame() {
        if (getState() == AppState.inGame) {
            setState(AppState.mainMenu);
            this.gameModel = null;
            this.mainMenuModel = new MainMenuModel(settings);
            return true;
        } else
            return false;
    }

    public boolean startGame() {
        if (getState() == AppState.mainMenu) {
            setState(AppState.inGame);
            this.mainMenuModel = null;
            this.gameModel = new GameModel();
            return true;
        } else
            return false;
    }

    public boolean loadGame(GameModel gameModel) {
        if (getState() == AppState.mainMenu) {
            setState(AppState.inGame);
            this.mainMenuModel = null;
            this.gameModel = gameModel;
            return true;
        } else
            return false;
    }
}