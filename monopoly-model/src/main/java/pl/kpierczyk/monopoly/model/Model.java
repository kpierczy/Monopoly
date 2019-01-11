package pl.kpierczyk.monopoly.model;

import java.io.*;
import pl.kpierczyk.monopoly.model.mainMenuController.*;
import pl.kpierczyk.monopoly.model.gameController.*;










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
        beggining, mainMenu, inGame, quitting
    }

    

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private AppState state; // state of the whole app

    private final MainMenuController mainMenuController; // controller responsible for main menu
    private final GameController gameController; // controller responsible for in-game simulation

    /* Required paths */
    private String configPath; // path to config.txt file
    private String gameHome; //path to the main game folder
    private String sourcesHome; // path to sources folder

    /* Settings */
    private Settings settings;



    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public Model(String configPath_t) {
        configPath = configPath_t;
        settings = new Settings();

        /* reading configuration from config.txt */
        try {
            FileReader fileReader = new FileReader(configPath_t);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // tmp string for reading language version from config.txt
            String line = null;

            // source path initialization
            if ((line = bufferedReader.readLine()) != null) {
                gameHome = line;
                sourcesHome = gameHome + "\\sources";
            }

            // language initialization
            if ((line = bufferedReader.readLine()) != null) {
                settings.setLanguage(line);
            }

            // resolution initialization
            if ((line = bufferedReader.readLine()) != null) {
                settings.getResolution()[0] = Integer.parseInt(line);
            }
            if ((line = bufferedReader.readLine()) != null) {
                settings.getResolution()[1] = Integer.parseInt(line);
            }

            // fullscreen option initialization
            if ((line = bufferedReader.readLine()) != null) {
                switch (line) {
                case "on":
                    settings.setFullscreen(true);
                    break;
                case "off":
                    settings.setFullscreen(false);
                    break;
                }
            }

            // sound level initialization
            if ((line = bufferedReader.readLine()) != null) {
                settings.setSoundLevel(Integer.parseInt(line));
            }

            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + configPath_t + "'");
            //default settings
            settings = new Settings();
        } catch (IOException ex) {
            System.out.println("Error reading file '" + configPath_t + "'");
            //default settings
            settings = new Settings();
        }

        
        
        
        /* initializing app's state */
        state = AppState.beggining;

        /* initializing mainMenuController */
        mainMenuController = new MainMenuController(sourcesHome + "\\lang\\" + settings.getLanguage() + "\\mainMenuFields.txt");

        /* initializing mainMenuController */
        gameController = new GameController();
    }



    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public AppState getState() {
        return state;
    }
    public void setState(AppState t_state) {
        state = t_state;
    }



    public MainMenuController getMainMenuController() {
        return mainMenuController;
    }
    public GameController getGameController() {
        return gameController;
    }



    public String getConfigPath() {
        return configPath;
    }
    public void setConfigPath(String configPath_t) {
        configPath = configPath_t;
    }

    public String getSourcesHome() {
        return sourcesHome;
    }
    public void setSourcesHome(String sourcesHome_t) {
        sourcesHome = sourcesHome_t;
    }

    public Settings getSettings() {
        return settings;
    }
    public void setSettings(Settings settings) {
        this.settings = settings;
    }


    /*****************************************/
    /*              Utilities                */
    /*****************************************/
}










// *******************************************//
// Setting class contains all setting
// which can be set during app is runinng.
// Instance of this class is preserved in
// theinstance of Model.
// *******************************************//

class Settings {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private String language;
    private int resolution[];
    private boolean fullscreen;
    private int soundLevel;
    private SettingsWarning registeredWarnings;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    // default constructor
    public Settings() {
        this.language = "en";
        this.resolution = new int[] { 1920, 1080 };
        this.fullscreen = false;
        this.soundLevel = 50;
    }

    // full specified constructor
    public Settings(String language, int resolution[], boolean fullscreen, int soundLevel) {

        SettingsWarning warnings = new SettingsWarning();

        switch (language) {
        case "en":
            this.language = language;
        case "pl":
            this.language = language;
        default:
            this.language = language;
            warnings.setLanguageWarning(true);
        }

        if (resolution.length == 2) {
            this.resolution = resolution;
        } else {
            this.resolution = new int[] { 1920, 1080 };
            warnings.setResolutionWarning(true);
        }

        this.fullscreen = fullscreen;

        if (soundLevel >= 0 && soundLevel <= 100) {
            this.soundLevel = soundLevel;
        } else {
            this.soundLevel = 50;
            warnings.setSoundLevelWarning(true);
        }

        this.registeredWarnings = warnings;
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public String getLanguage() {
        return language;
    }

    public boolean setLanguage(String language) {
        if (language == "en" || language == "pl") {
            this.language = language;
            return true;
        } else
            return false;
    }

    public int[] getResolution() {
        return resolution;
    }

    public boolean setResolution(int[] resolution) {
        if (resolution.length == 2) {
            this.resolution = resolution;
            return true;
        } else
            return false;
    }

    public boolean isFullscreen() {
        return fullscreen;
    }

    public void setFullscreen(boolean fullscreen) {
        this.fullscreen = fullscreen;
    }

    public int getSoundLevel() {
        return soundLevel;
    }

    public boolean setSoundLevel(int soundLevel) {
        if (soundLevel >= 0 && soundLevel <= 100) {
            this.soundLevel = soundLevel;
            return true;
        } else
            return false;
    }

    public SettingsWarning getRegisteredWarnings() {
        return registeredWarnings;
    }

    public void setRegisteredWarnings(SettingsWarning registeredWarnings) {
        this.registeredWarnings = registeredWarnings;
    }
}










// *******************************************//
// SettingWarnings class is defined for
// containg boolean statements describing
// if a prticular setting was asigned
// correctly or it was asigned in the default
// way.
// *******************************************//

class SettingsWarning {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    boolean languageWarning;
    boolean resolutionWarning;
    boolean fullscreenWarning;
    boolean soundLevelWarning;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    // default constructor
    public SettingsWarning() {
        languageWarning = false;
        resolutionWarning = false;
        soundLevelWarning = false;
    }

    // full specified constructor
    public SettingsWarning(boolean languageWarning_t, boolean resolutionWarning_t, boolean fullscreenWarning_t,
            boolean soundLevelWarning_t) {
        languageWarning = languageWarning_t;
        resolutionWarning = resolutionWarning_t;
        fullscreenWarning = fullscreenWarning_t;
        soundLevelWarning = soundLevelWarning_t;
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public boolean isLanguageWarning() {
        return languageWarning;
    }

    public void setLanguageWarning(boolean languageWarning) {
        this.languageWarning = languageWarning;
    }

    public boolean isResolutionWarning() {
        return resolutionWarning;
    }

    public void setResolutionWarning(boolean resolutionWarning) {
        this.resolutionWarning = resolutionWarning;
    }

    public boolean isSoundLevelWarning() {
        return soundLevelWarning;
    }

    public void setSoundLevelWarning(boolean soundLevelWarning) {
        this.soundLevelWarning = soundLevelWarning;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public void clear() {
        this.languageWarning = false;
        this.resolutionWarning = false;
        this.soundLevelWarning = false;
    }
}