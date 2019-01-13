package pl.kpierczyk.monopoly.model.mainMenuModel;

import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.settings.*;
import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.mainMenuModel.models.*;
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
        _default, loading, options, titles, instruction
    }


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    /* Invisible */
    private MainMenuState state;
    private final Settings settingsHanger;
    private final String savesPath;

    private LoadingModel loadingModel;
    private OptionsModel optionsModel;
    private TitlesModel titlesModel;
    private InstructionModel instructionModel;

    /* Visible */
    private Menu mainMenu;
    private final String backgroundImagePath;




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuModel(Settings settingsHanger) {
        
        /*Utilities initializing*/
        this.state = MainMenuState._default;
        this.settingsHanger = settingsHanger;
        this.savesPath = "/saves";

        /*Models initializing*/
        this.loadingModel = null;
        this.optionsModel = null;
        this.titlesModel = null;
        this.instructionModel = null;

        /*Menu initializing*/
        String textPath = "/lang/" + this.settingsHanger.getLanguage() + "/mainMenu.txt";
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
       
        String backgroundImageRelativePath = 
                "/img/" + settingsHanger.getResolutionSetting().toString() + "/menuBackgrounds/menuBackground_1.png";
        this.backgroundImagePath = Model.convert(getClass().getResource(backgroundImageRelativePath).getPath());
    }




    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public Menu getMainMenu() {
        return mainMenu;
    }
    public String getBackgroundImagePath() {
        return backgroundImagePath;
    }


    public MainMenuState getState() {
        return state;
    }


    public InstructionModel getInstructionModel() {
        return instructionModel;
    }
    public LoadingModel getLoadingModel() {
        return loadingModel;
    }
    public OptionsModel getOptionsModel() {
        return optionsModel;
    }
    public TitlesModel getTitlesModel() {
        return titlesModel;
    }




    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean openLoadingList() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.loading;
            this.loadingModel = new LoadingModel(this.savesPath);
            return true;
        } else
            return false;
    }


    public boolean openOptions(){
        if(getState() == MainMenuState._default){
            this.state = MainMenuState.options;
            
            String submitButtonText = "???";
            String backButtonText = "???";
            String optionsTexts[] = new String[this.settingsHanger.getSettingsNumber()];
            String configPath = "/config.txt";

            try{
                FileReader fileReader = 
                    new FileReader("/lang/" + this.settingsHanger.getLanguage() + "/submitButtonText.txt");
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
                    new FileReader("/lang/" + this.settingsHanger.getLanguage() + "/backButtonText.txt");
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
                    new FileReader("/lang/" + this.settingsHanger.getLanguage() + "/optionsMenu.txt");
                BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

                for(int i = 0; i < this.settingsHanger.getSettingsNumber(); i++){
                    if((optionsTexts[i] = bufferedReader.readLine()) == null)
                        backButtonText = "???";
                }

                bufferedReader.close();
            }
            catch(IOException ex){
                System.out.println("Couln't read backButton.txt");
            } 

            this.optionsModel = new OptionsModel(submitButtonText, backButtonText,
                                                           optionsTexts, settingsHanger, configPath);
            return true;
        }
        else
            return false;
    }


    public boolean openTitles() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.titles;
            String titlesPath = "lang/" + this.settingsHanger.getLanguage() + "/titles.png";
            String backButtonText = "lang/" + this.settingsHanger.getLanguage() + "/backButton.txt";
            this.titlesModel = new TitlesModel(titlesPath, backButtonText);
            return true;
        } else
            return false;
    }

    public boolean openInstruction() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.instruction;
            String instructionHome = "lang/" + this.settingsHanger.getLanguage() + "/instruction";
            String backButtonText = "lang/" + this.settingsHanger.getLanguage() + "/backButton.txt";
            this.instructionModel = new InstructionModel(instructionHome, backButtonText);
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