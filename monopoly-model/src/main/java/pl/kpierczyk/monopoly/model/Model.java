package pl.kpierczyk.monopoly.model;

import java.io.File;
import java.net.URL;

import pl.kpierczyk.monopoly.model.submodels.introModel.IntroModel;
import pl.kpierczyk.monopoly.model.submodels.gameModel.GameModel;
import pl.kpierczyk.monopoly.model.submodels.gameModel.utilities.GameSaveInfo;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.MainMenuModel;
import pl.kpierczyk.monopoly.model.utilities.Util;
import pl.kpierczyk.monopoly.model.utilities.settings.*;






// <-- TO DO -->
// Precisily describe Model

/**
 * Class representing MVC's Model. Stores state of the application
 * and manages modules responsible for particular activities.
 * 
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class Model {

    /** App's possible states*/
    public enum AppState {
        intro, mainMenu, inGame
    }

    /** App's state which is got by the View and Controller*/
    private AppState state; // state of the whole app

    /** App's actual settings; covers language, resolution, fullscreen and music sound level. */
    private Settings settings;
    
    /** Intro model responsible for app's state during intro.*/
    private IntroModel introModel;

    /** Model responsible for specific parameters of app during being in main menu. */
    private MainMenuModel mainMenuModel;
    
    /** Model responsible for specific parameters of app during the game is running*/
    private GameModel gameModel;



    //<-- TO DO --->
    // repair getResource code so that it worked while running app from jar - use appache.commons.io.FilenameUtils.separatorsToSystem()
    // if you want to convert paths between systems


    /**
     * Default Model's constructor that read's and initializes
     * app's settings. Initializes Intro Model ;if cannot be
     * loaded beacuse of graphic blackade, MainMenuModel is
     * initialized.
     * 
     * @see     Settings
     * @see     IntroModel
     * @see     MainMenuModel
     */
    public Model() {

        /* initializing app's state */
        this.state = AppState.intro;

        /* initializing settings */
        this.settings = new Settings();
        
        String relativeConfigPath = "/config.txt";
        URL notConvertedconfigPath = getClass().getResource(relativeConfigPath);
        
        String configPath = "";
        if(notConvertedconfigPath != null)
            configPath = Util.convert(notConvertedconfigPath.getPath());
        this.settings.readFromFile(configPath);



        /* initializing introModel */
        String relativeIntroPosterPath = "/lang/" +
                                         settings.getLanguage() + "/img/" +
                                         settings.getResolutionSetting().toString() +
                                         "/intro/introPoster.png";
                                         
        URL notConvertedIntroPosterPath = getClass().getResource(relativeIntroPosterPath);

        if(notConvertedIntroPosterPath != null){
    
            String introPosterPath = Util.convert(notConvertedIntroPosterPath.getPath());
            
            File introPoster = new File(introPosterPath);
            if(introPoster.exists()){
            introModel = new IntroModel(introPosterPath);
            }
            else{
                this.state = AppState.mainMenu;
                this.mainMenuModel = new MainMenuModel(this);
            }
        }
        else{
            this.state = AppState.mainMenu;
            this.mainMenuModel = new MainMenuModel(this);
        }
    }




    /**
     * Returns app state from three possible values.
     * 
     * @return  app state from three possible values.
     * @see     Model.AppState
     */
    public AppState getState() {
        return state;
    }

    /**
     * Returns refference to IntroModel.
     * 
     * @return  refference to IntroModel.
     * @see     IntroModel
     */
    public IntroModel getIntroModel() {
        return introModel;
    }

    /**
     * Returns refference to MainMenuModel.
     * 
     * @return  refference to MainMenuModel.
     * @see     MainMenuModel
     */
    public MainMenuModel getMainMenuModel() {
        return mainMenuModel;
    }

    /**
     * Returns refference to GameModel.
     * 
     * @return  refference to GameModel.
     * @see     GameModel
     */
    public GameModel getGameModel() {
        return gameModel;
    }


    /**
     * Returns refference to actual settings object.
     * 
     * @return  refference to actual settings object.
     * @see     Settings
     */
    public Settings getSettings() {
        return settings;
    }

    /**
     * Sets Settings object passed by parameter as effective Settings
     * of application.
     * 
     * @param settings
     */
    public void setSettings(Settings settings){
        this.settings = null;
        this.settings = new Settings(settings);
    }




    
    /*****************************************/
    /* Utilities */
    /*****************************************/


    /**
     * Finishes Intro. Initializes MainModelMenu.
     * Before action is taken app's state is checked . 
     * 
     * @return if state of the app has chenged
     */
    public boolean finishIntro() {
        if (getState() == AppState.intro) {
            this.state = AppState.mainMenu;
            this.introModel = null;
            this.mainMenuModel = new MainMenuModel(this);
            return true;
        }
        else return false;
    }


    /**
     * Runs new game.
     */
    public void runNewGame(int playersNumber){
        if(this.state == AppState.mainMenu){
            GameSaveInfo newGame = new GameSaveInfo(playersNumber, this.getSettings());

            this.state = AppState.inGame;
            this.gameModel = 
                new GameModel(this, newGame);
        }
    }


    /**
     * Initializes new game using loaded from save file 
     * gameSaveInfo object.
     * 
     * @param   gameSaveInfo
     * @see     gameSaveInfo
     */
    public void loadGame(GameSaveInfo gameSaveInfo){
        if (getState() == AppState.mainMenu){
            this.state = AppState.inGame;

            //starting new game should dispose of mainMenuModel
        
        }
    }


    /**
     * Closes Model responsibble for game and make app back to
     * the main menu.
     * 
     * @see     MainMenuModel
     * @see     GameModel
     */
    public boolean quitGame() {
        if (getState() == AppState.inGame) {
            this.state = AppState.mainMenu;
            this.gameModel = null;
            this.mainMenuModel = new MainMenuModel(this);

            return true;
        }
        else return false;
    }


    /**
     * Prepares app for closing. Deletes all servant modules.
     * 
     * @see     IntroModel
     * @see     MainMenuModel
     * @see     GameModel
     */
    public void quitApp(){
        this.introModel = null;
        this.mainMenuModel = null;
        this.gameModel = null;
    }


    /**
     * Reloads app state. Is used when settings change during
     * app's running.
     */
    public void update(){
        this.mainMenuModel = null;
        this.mainMenuModel = new MainMenuModel(this);
    }
}