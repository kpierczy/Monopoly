package pl.kpierczyk.monopoly.model.submodels.mainMenuModel;

import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.menu.Menu;
import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.InstructionModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.LoadingModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.SettingsModel;
import pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels.TitlesModel;

import java.io.*;
import java.net.URL;



//<--- TO DO --->
// Create base class MenuModel for MainMenuModel and InGameMenuModel
// At least InGameController can extend MainMenucontroller with overloaded method quit()

/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class MainMenuModel {


    public enum MainMenuState {
        _default, loading, settings, instruction, titles
    }

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
                           "/interfaceTexts/mainMenu.txt";

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

        URL notConvertedBackgroundImage = getClass().getResource(backgroundImageRelativePath);

        if(notConvertedBackgroundImage != null)
            this.backgroundImagePath = Util.convert(notConvertedBackgroundImage.getPath());
        else
            this.backgroundImagePath = "";
    }

    /*Main menu elements methods*/

    public MainMenuState getState() {
        return state;
    }
    
    
    public Menu getMainMenu() {
        return mainMenu;
    }
    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }



    /*Submenus elements methods*/

    public InstructionModel getInstructionModel() {
        return instructionModel;
    }
    public LoadingModel getLoadingModel() {
        return loadingModel;
    }
    public SettingsModel getSettingsModel() {
        return settingsModel;
    }
    public TitlesModel getTitlesModel() {
        return titlesModel;
    }




    

    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean openLoadingMenu() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.loading;

            //<--- TO DO --->
            //Find way to get directory od saves

            /*Getting saves home path*/
            String relativeSavesHome = "/saves";
            String savesHome = 
                Util.convert(getClass().getResource(relativeSavesHome).getPath());

            /*Getting buttons text files paths*/
            String relativeButtonsPath[] = new String[] {
                "/lang/" + this.model.getSettings().getLanguage() + "/interfaceTexts/okButton.txt",
                "/lang/" + this.model.getSettings().getLanguage() + "/interfaceTexts/backButton.txt"
            };
          
          URL notConvertedButtonsPath[] = new URL[]{
                getClass().getResource(relativeButtonsPath[0]),
                getClass().getResource(relativeButtonsPath[1])
            };


            if(notConvertedButtonsPath[0] != null && notConvertedButtonsPath[1] != null){
                String buttonsPath[] = new String[]{
                    Util.convert(notConvertedButtonsPath[0].getPath()),
                    Util.convert(notConvertedButtonsPath[1].getPath())
                };
                
                File okButton = new File(buttonsPath[0]);
                File backButton = new File(buttonsPath[1]);
                
                if(!okButton.exists() || !backButton.exists()){
                    this.state = MainMenuState._default;
                    return false;
                }

                /*Initializing loadingModel*/
                this.loadingModel = new LoadingModel(this.model,
                                                    savesHome,
                                                    buttonsPath);
                return true;                                                     
            }
            else
                return false;                                                   
        }
        else
            return false;
    }


    public boolean openSettings(){
        if(getState() == MainMenuState._default){
            this.state = MainMenuState.settings;
            
            /*Getting config file path*/
            String relativeConfigPath = "/config.txt";
            URL notConvertedConfigPath = 
                getClass().getResource(relativeConfigPath);

            /*Getting buttons text files paths*/
            String relativeButtonsPath[] = new String[] {
                "/lang/" + this.model.getSettings().getLanguage() + "/interfaceTexts/okButton.txt",
                "/lang/" + this.model.getSettings().getLanguage() + "/interfaceTexts/backButton.txt"
            };

            URL notConvertedButtonsPath[] = new URL[]{
                getClass().getResource(relativeButtonsPath[0]),
                getClass().getResource(relativeButtonsPath[1])
            };


            /*Getting settings text file path*/
            String relativeSettingsTextPath = "/lang/" +
                                              this.model.getSettings().getLanguage() + 
                                              "/interfaceTexts/settingsMenu.txt";
            URL notConvertedSettingsTextPath = 
                getClass().getResource(relativeSettingsTextPath);


            /*Getting settingsbackgroundImagePath */
            String relativeSettingsbackgroundImagePath = "/img/" +
                                                         this.model.getSettings().getResolutionSetting().toString() + 
                                                         "/settingsBackgrounds/settingsBackground_1.png";
            URL notConvertedSettingsbackgroundImagePath = 
                getClass().getResource(relativeSettingsbackgroundImagePath);

            /*Validation of path*/
            if(notConvertedConfigPath != null && notConvertedButtonsPath[0] != null &&
               notConvertedButtonsPath[1] != null && notConvertedSettingsTextPath != null &&
               notConvertedSettingsbackgroundImagePath != null){ 
                
                String configPath = Util.convert(notConvertedConfigPath.getPath());
                String buttonsPath[] = new String[]{
                    Util.convert(notConvertedButtonsPath[0].getPath()),
                    Util.convert(notConvertedButtonsPath[1].getPath())
                };
                String settingsTextPath = Util.convert(notConvertedSettingsTextPath.getPath());
                String settingsbackgroundImagePath = Util.convert(notConvertedSettingsbackgroundImagePath.getPath());

                File config = new File(configPath);
                File okButton = new File(buttonsPath[0]);
                File backButton = new File(buttonsPath[1]);
                File settingsText = new File(settingsTextPath);
                File settingsBackground = new File(settingsbackgroundImagePath);

                if(!config.exists() || !okButton.exists() || !backButton.exists() ||
                   !settingsText.exists() || !settingsBackground.exists()){
                    this.state = MainMenuState._default;
                    return false;
                }

                /*Initializing settingsModel*/
                this.settingsModel = new SettingsModel(this.model,
                                                    configPath,
                                                    buttonsPath,
                                                    settingsTextPath,
                                                    settingsbackgroundImagePath);

                return true;
            }
            else
                return false;                                                     
        }
        else
            return false;
    }

    public boolean openInstruction() {
        if (getState() == MainMenuState._default) {            

            /*Getting instruction home path*/
            String relativeInstructionFirstSlidePath = "/lang/" +
                                             this.model.getSettings().getLanguage() + "/img/" +
                                             this.model.getSettings().getResolutionSetting().getValue() +
                                             "/instruction/1.png";                
            URL notConvertedInstructionFirstSlidePath = 
                getClass().getResource(relativeInstructionFirstSlidePath);
            

            /*Getting backButton text file path*/
            String relativeBackButtonPath = "/lang/" +
                                            this.model.getSettings().getLanguage() +
                                            "/interfaceTexts/backButton.txt";
            URL notConvertedBackButtonTextPath = 
                getClass().getResource(relativeBackButtonPath);
            

            if(notConvertedInstructionFirstSlidePath != null && notConvertedBackButtonTextPath != null){         

                String instructionFirstSlidePath = Util.convert(notConvertedInstructionFirstSlidePath.getPath());
                String backButtonTextPath = Util.convert(notConvertedBackButtonTextPath.getPath()); 

                File instructionFirstSlide = new File(instructionFirstSlidePath);
                File backButton = new File(backButtonTextPath);

                if(!backButton.exists() || !instructionFirstSlide.exists()){
                    this.state = MainMenuState._default;
                    return false;
                }

                String instructionHome = instructionFirstSlide.getParent();

                /*Initializing instructionModel*/
                this.instructionModel = new InstructionModel(this.model,
                                                            instructionHome,
                                                            backButtonTextPath);
                
                this.state = MainMenuState.instruction;
                return true;
            }
            else
                return false;
        }
        else
            return false;
    }

    public boolean openTitles() {
        if (getState() == MainMenuState._default) {

            /*Getting titles file path*/
            String relativeTitlesPath = "/lang/" +
                                        this.model.getSettings().getLanguage() + "/img/" +
                                        this.model.getSettings().getResolutionSetting().getValue() +
                                        "/titles/titles.png";
            URL notConvertedTitlesPath = 
                getClass().getResource(relativeTitlesPath);

            /*Getting backButton text file path*/
            String relativeBackButtonPath = "/lang/" +
                                            this.model.getSettings().getLanguage() +
                                            "/interfaceTexts/backButton.txt";
            URL notConvertedBackButtonTextPath = 
                getClass().getResource(relativeBackButtonPath);


            if(notConvertedBackButtonTextPath != null && notConvertedTitlesPath != null){

                String backButtonTextPath = Util.convert(notConvertedBackButtonTextPath.getPath());
                String titlesPath = Util.convert(notConvertedTitlesPath.getPath());

                File backButton = new File(backButtonTextPath);
                File titles = new File(titlesPath);

                if(!backButton.exists() || !titles.exists()){
                    this.state = MainMenuState._default;
                    return false;
                }

                /*Initializing titlesModel*/
                this.titlesModel = new TitlesModel(this.model,
                                                titlesPath,
                                                backButtonTextPath);

                this.state = MainMenuState.titles; 
                return true;    
            }
            else
                return false;                                   
        }
        else
            return false;
    }


    public boolean closeChild() {
        if (getState() != MainMenuState._default) {
            this.state = MainMenuState._default;
            
            this.loadingModel = null;
            this.settingsModel = null;
            this.titlesModel = null;
            this.instructionModel = null;

            return true;
        }
        else
            return false;
    }
}