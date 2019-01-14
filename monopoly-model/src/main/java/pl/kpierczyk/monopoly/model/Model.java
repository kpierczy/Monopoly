package pl.kpierczyk.monopoly.model;

import java.io.File;
import java.net.URL;

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

    //<-- TO DO --->
    // repair getResource code so that it worked while running app from jar - use appache.commons.io.FilenameUtils.separatorsToSystem()
    // if you want to convert paths between systems


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
                                         settings.getLanguage() +
                                         "/img/intro/introPoster_" +
                                         settings.getResolutionSetting().toString() +
                                         ".png";

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




    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public AppState getState() {
        return state;
    }

    public IntroModel getIntroModel() {
        return introModel;
    }
    public MainMenuModel getMainMenuModel() {
        return mainMenuModel;
    }
    public GameModel getGameModel() {
        return gameModel;
    }


    public Settings getSettings() {
        return settings;
    }



    
    /*****************************************/
    /* Utilities */
    /*****************************************/


    public boolean finishIntro() {
        if (getState() == AppState.intro) {
            this.state = AppState.mainMenu;
            this.introModel = null;
            this.mainMenuModel = new MainMenuModel(this);
            return true;
        }
        else return false;
    }

    public void runNewGame(){
        //loadGame(empty gameSaveInfo)
    }

    public void loadGame(GameSaveInfo gameSaveInfo){
        if (getState() == AppState.mainMenu){
            this.state = AppState.inGame;

            //starting new game should dispose of mainMenuModel
        
        }
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