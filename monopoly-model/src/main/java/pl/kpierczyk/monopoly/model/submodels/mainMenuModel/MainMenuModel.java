package pl.kpierczyk.monopoly.model.submodels.mainMenuModel;

import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.menu.Menu;
import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.gameModel.GameSaveInfo;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.InstructionModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.LoadingModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.SettingsModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.TitlesModel;

import java.io.*;







//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class MainMenuModel {


    public enum MainMenuState {
        _default, loading, options, instruction, titles
    }


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    /* Invisible */
    private MainMenuState state;

    private Model model;

    private LoadingModel loadingModel;
    private SettingsModel settingsModel;
    private TitlesModel titlesModel;
    private InstructionModel instructionModel;

    /* Visible */
    private Menu mainMenu;
    private final String backgroundImagePath;




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuModel(Model model) {
        
        /*Utilities initializing*/
        this.state = MainMenuState._default;
        this.model = model;

        /*Models initializing*/
        this.loadingModel = null;
        this.settingsModel = null;
        this.titlesModel = null;
        this.instructionModel = null;

        /*Menu initializing*/
        String textPath = "/lang/" +
                           this.model.getSettings().getLanguage() +
                           "/mainMenu.txt";

        String fieldsText[] = new String[6];

        try {
            BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(textPath)));

            String line;
            for(int i = 0; i < fieldsText.length; i++){
                if((line = bufferedReader.readLine()) != null){
                    fieldsText[i] = line;
                }
            }

            bufferedReader.close();
        }
        catch (IOException ex) {
            System.out.println("Error reading file '" + textPath + "'");
        }

        this.mainMenu = new Menu(fieldsText, 6);
       

        /*Menu's background image initialization*/
        String backgroundImageRelativePath = 
                "/img/" +
                this.model.getSettings().getResolutionSetting().toString() +
                "/menuBackgrounds/menuBackground_1.png";

        this.backgroundImagePath = Util.convert(getClass().getResource(backgroundImageRelativePath).getPath());
    }




    /*****************************************/
    /* Getters & setters */
    /*****************************************/
    
    
    public MainMenuState getState() {
        return state;
    }
    
    
    public Menu getMainMenu() {
        return mainMenu;
    }
    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }


    public InstructionModel getInstructionModel() {
        return instructionModel;
    }
    public LoadingModel getLoadingModel() {
        return loadingModel;
    }
    public SettingsModel getOptionsModel() {
        return settingsModel;
    }
    public TitlesModel getTitlesModel() {
        return titlesModel;
    }




    /*****************************************/
    /* Utilities */
    /*****************************************/

    public void newGame(){
        GameSaveInfo emptyGameInfo = new GameSaveInfo();
        this.model.runNewGame(emptyGameInfo);
    }


    public void openLoadingMenu() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.loading;

            String relativeSavesPath = "/saves";
            String savesPath = Util.convert(getClass().getResource(relativeSavesPath).getPath());

            String relativeButtonsPath[] = new String[] {
                "/lang/" + this.model.getSettings().getLanguage() + "/okButton.txt",
                "/lang/" + this.model.getSettings().getLanguage() + "/backButton.txt"
            };

            String buttonsPath[] = new String[]{
                Util.convert(getClass().getResource(relativeButtonsPath[0]).getPath()),
                Util.convert(getClass().getResource(relativeButtonsPath[1]).getPath())
            };

            this.loadingModel = new LoadingModel(this.model,
                                                 savesPath,
                                                 buttonsPath);
        }
    }


    public boolean openSettings(){
        if(getState() == MainMenuState._default){
            this.state = MainMenuState.options;
            

            String submitButtonText = "???";
            String backButtonText = "???";
            String optionsTexts[] = new String[this.model.getSettings().getSettingsNumber()];
            String configPath = "/config.txt";

            try{
                FileReader fileReader = 
                    new FileReader("/lang/" + this.model.getSettings().getLanguage() + "/submitButtonText.txt");
                BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

                if((submitButtonText = bufferedReader.readLine()) == null)
                    submitButtonText = "???";

                bufferedReader.close();
            }
            catch(IOException ex){
                System.out.println("Couln't read submitButton.txt");
            }


            try{
                FileReader fileReader = 
                    new FileReader("/lang/" + this.model.getSettings().getLanguage() + "/backButtonText.txt");
                BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

                if((backButtonText = bufferedReader.readLine()) == null)
                    backButtonText = "???";

                    bufferedReader.close();
            }
            catch(IOException ex){
                System.out.println("Couln't read backButton.txt");
            }            


            try{
                FileReader fileReader = 
                    new FileReader("/lang/" + this.model.getSettings().getLanguage() + "/optionsMenu.txt");
                BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

                for(int i = 0; i < this.model.getSettings().getSettingsNumber(); i++){
                    if((optionsTexts[i] = bufferedReader.readLine()) == null)
                        backButtonText = "???";
                }

                bufferedReader.close();
            }
            catch(IOException ex){
                System.out.println("Couln't read backButton.txt");
            } 

            this.settingsModel = new SettingsModel(this.model,
                                                   , buttonsPath, SettingsTextsPath);
            return true;
        }
        else
            return false;
    }

    public boolean openInstruction() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.instruction;
            String instructionHome = "lang/" + this.model.getSettings().getLanguage() + "/instruction";
            String backButtonText = "lang/" + this.model.getSettings().getLanguage() + "/backButton.txt";
            this.instructionModel = new InstructionModel(instructionHome, backButtonText);
            return true;
        } else
            return false;
    }

    public boolean openTitles() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.titles;
            String titlesPath = "lang/" + this.model.getSettings().getLanguage() + "/titles.png";
            String backButtonText = "lang/" + this.model.getSettings().getLanguage() + "/backButton.txt";
            this.titlesModel = new TitlesModel(titlesPath, backButtonText);
            return true;
        } else
            return false;
    }

    public boolean closeChild() {
        if (getState() != MainMenuState._default) {
            this.state = MainMenuState._default;
            loadingModel = null;
            optionsModel = null;
            titlesModel = null;
            instructionModel = null;
            return true;
        } else
            return false;
    }
}