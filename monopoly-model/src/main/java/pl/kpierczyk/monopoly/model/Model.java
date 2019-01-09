package pl.kpierczyk.monopoly.model;
import java.io.*;
import pl.kpierczyk.monopoly.model.mainMenu.*;

public class Model 
{
    public enum AppState{
        beggining,
        mainMenu,
        inGame,
        quitting
    }

    /*****************************************/
    /*             Class Fields              */
    /*****************************************/

    private AppState state; //state of the whole app

    private final MainMenuController mainMenuController; //controller responsible for main menu
    private final GameController gameController; //controller responsible for in-game simulation
    
    /*Required paths*/
    private String configPath; //path to config.txt file
    private String sourcesHome; //path to sources folder

    /*Settings*/
    private String language; //app's language
    private int resolution[];
    private boolean fullscreen;
    private int soundLevel;


    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public Model(String configPath_t)
    {
        configPath = configPath_t;

        /*reading configuration from config.txt*/
        try {
            FileReader fileReader = 
                new FileReader(configPath_t);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            //tmp string for reading language version from config.txt
            String line = null; 

            //language initialization
            if((line = bufferedReader.readLine()) != null){
                switch (line){
                case "en": //english version
                    language = "en";
                    break;
                case "pl": //polish version
                    language = "pl";
                    break;
                }
            }
            
            //source path initialization
            if((line = bufferedReader.readLine()) != null){
                sourcesHome = line;
            }

            //resolution initialization
            resolution = new int[2];
            if((line = bufferedReader.readLine()) != null){
                resolution[0] = Integer.parseInt(line);
            }
            if((line = bufferedReader.readLine()) != null){
                resolution[1] = Integer.parseInt(line);
            }

            //fullscreen option initialization
            if((line = bufferedReader.readLine()) != null){
                switch(line){
                case "on":
                    fullscreen = true;
                    break;
                case "off":
                    fullscreen = false;
                    break;
                }
            }

            //sound level initialization
            if((line = bufferedReader.readLine()) != null){
                soundLevel = Integer.parseInt(line);
            }


            bufferedReader.close();
        }
        catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + configPath_t + "'");
            
            //default config
            language = "en";
        } 
        catch (IOException ex) {
            System.out.println("Error reading file '" + configPath_t + "'");
            
            //default config
            language = "en";
        }

        /*initializing app's state*/
        state = AppState.beggining; 

        /*initializing mainMenuController*/
        mainMenuController = new MainMenuController(sourcesHome,
            sourcesHome + "\\lang\\" + language + "\\mainMenuFields.txt", 6);

        /*initializing mainMenuController*/
        gameController = new GameController();
    }
    

    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/


    public AppState getAppState() {return state;}
    public void setAppState(AppState t_state) {state = t_state;}

    public MainMenuController getMainMenuController() {return mainMenuController;}
    public GameController getGameController() {return gameController;}

    public String getConfigPath() { return configPath; }
    public void setConfigPath(String configPath_t) { configPath = configPath_t; }

    public String getSourcesHome() { return sourcesHome; }
    public void setSourcesHome(String sourcesHome_t) { sourcesHome = sourcesHome_t; }
    public String getLanguage() { return language; }
    public void setLanguage(String language_t) { language = language_t; }
    public int[] getResolution() { return resolution; }
    public boolean setSourcesHome(int resolution_t[]) {
        if(resolution_t.length == 2){
            resolution = resolution_t; 
            return true;
        }
        else
            return false;
    }
    public int getResolution(int dimension) {
        if(dimension == 1 || dimension == 2)
            return resolution[dimension];
        else
            return 0;
    }
    public boolean setResolution(int dimension, int resolution_t) {
        if(dimension == 1 || dimension == 2){
            resolution[dimension] = resolution_t; 
            return true;
        }
        else
            return false;
    }
    public boolean isFullscreen() { return fullscreen; }
    public void setFullscrean(boolean active) { fullscreen = active; }
    public int getSoundLevel() { return soundLevel; }
    public void setSoundLevel(int soundLevel_t) { soundLevel = soundLevel_t; }
}
