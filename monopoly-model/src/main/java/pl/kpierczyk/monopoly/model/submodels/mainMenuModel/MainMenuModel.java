package pl.kpierczyk.monopoly.model.submodels.mainMenuModel;

import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.menu.Menu;
import pl.kpierczyk.monopoly.model.Model;
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
    
    private MainMenuState state;
    private Model model;

    /* MainMenu visible elements */
    private Menu mainMenu;
    private final String backgroundImagePath;

    
    /*Submenus models*/
    private LoadingModel loadingModel;
    private SettingsModel settingsModel;
    private TitlesModel titlesModel;
    private InstructionModel instructionModel;






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
        this.model.runNewGame();
    }


    public void openLoadingMenu() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.loading;

            //check if getResource can find it!
            /*Getting saves home path*/
            String relativeSavesHome = "/saves";
            String savesHome = 
                Util.convert(getClass().getResource(relativeSavesHome).getPath());

            /*Getting buttons text files paths*/
            String relativeButtonsPath[] = new String[] {
                "/lang/" + this.model.getSettings().getLanguage() + "/okButton.txt",
                "/lang/" + this.model.getSettings().getLanguage() + "/backButton.txt"
            };

            String buttonsPath[] = new String[]{
                Util.convert(getClass().getResource(relativeButtonsPath[0]).getPath()),
                Util.convert(getClass().getResource(relativeButtonsPath[1]).getPath())
            };

            /*Initializing loadingModel*/
            this.loadingModel = new LoadingModel(this.model,
                                                 savesHome,
                                                 buttonsPath);
        }
    }


    public void openSettings(){
        if(getState() == MainMenuState._default){
            this.state = MainMenuState.options;
            
            /*Getting config file path*/
            String relativeConfigPath = "/config.txt";
            String configPath = 
                Util.convert(getClass().getResource(relativeConfigPath).getPath());

            /*Getting buttons text files paths*/
            String relativeButtonsPath[] = new String[] {
                "/lang/" + this.model.getSettings().getLanguage() + "/okButton.txt",
                "/lang/" + this.model.getSettings().getLanguage() + "/backButton.txt"
            };

            String buttonsPath[] = new String[]{
                Util.convert(getClass().getResource(relativeButtonsPath[0]).getPath()),
                Util.convert(getClass().getResource(relativeButtonsPath[1]).getPath())
            };

            /*Getting settings text file path*/
            String relativeSettingsTextPath = "/lang/" +
                                              this.model.getSettings().getLanguage() + 
                                              "/optionsMenu.txt";
            String settingsTextPath = 
                Util.convert(getClass().getResource(relativeSettingsTextPath).getPath());


            /*Initializing settingsModel*/
            this.settingsModel = new SettingsModel(this.model,
                                                   configPath,
                                                   buttonsPath,
                                                   settingsTextPath);
        }
    }

    public void openInstruction() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.instruction;
            
            //check if getResources can find it!
            /*Getting instruction home path*/
            String relativeInstructionHome = "lang/" +
                                             this.model.getSettings().getLanguage() +
                                             "/img/instruction";                
            String instructionHome = 
                Util.convert(getClass().getResource(relativeInstructionHome).getPath());
   

            /*Getting backButton text file path*/
            String relativeBackButtonPath = "/lang/" +
                                            this.model.getSettings().getLanguage() +
                                            "/backButton.txt";
            String backButtonText = 
                Util.convert(getClass().getResource(relativeBackButtonPath).getPath());
            

            /*Initializing instructionModel*/
            this.instructionModel = new InstructionModel(this.model,
                                                         instructionHome,
                                                         backButtonText);
        }
    }

    public void openTitles() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.titles;

            /*Getting backButton text file path*/
            String relativeTitlesPath = "lang/" +
                                        this.model.getSettings().getLanguage() +
                                        "/titles.png";
            String titlesPath = 
            Util.convert(getClass().getResource(relativeTitlesPath).getPath());

            /*Getting backButton text file path*/
            String relativeBackButtonPath = "/lang/" +
                                            this.model.getSettings().getLanguage() +
                                            "/backButton.txt";
            String backButtonText = 
                Util.convert(getClass().getResource(relativeBackButtonPath).getPath());

            /*Initializing titlesModel*/
            this.titlesModel = new TitlesModel(this.model,
                                               titlesPath,
                                               backButtonText);
        }
    }


    public void closeChild() {
        if (getState() != MainMenuState._default) {
            this.state = MainMenuState._default;
            
            this.loadingModel = null;
            this.settingsModel = null;
            this.titlesModel = null;
            this.instructionModel = null;
        }
    }
}