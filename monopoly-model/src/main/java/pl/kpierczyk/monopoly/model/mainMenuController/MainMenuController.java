package pl.kpierczyk.monopoly.model.mainMenuController;

import pl.kpierczyk.monopoly.model.utilities.*;
import pl.kpierczyk.monopoly.model.utilities.settings.*;
import pl.kpierczyk.monopoly.model.mainMenuController.controllers.*;
import java.util.ArrayList;
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

public class MainMenuController {


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

    private LoadingController loadingController;
    private OptionsController optionsController;
    private TitlesController titlesControlleler;
    private InstructionController instructionController;

    /* Visible */
    private Menu mainMenu;
    private final String backgroundImagePath;




    /*****************************************/
    /* Constructor */
    /*****************************************/

    public MainMenuController(Settings settingsHanger) {
        this.state = MainMenuState._default;
        this.settingsHanger = settingsHanger;
        this.savesPath = "/saves";

        this.loadingController = null;
        this.optionsController = null;
        this.titlesControlleler = null;
        this.instructionController = null;

        String textPath = "/lang/" + this.settingsHanger.getLanguage() + "/mainMenu.txt";
        String fieldsText[] = new String[6];
        try {
            FileReader fileReader = 
                new FileReader(textPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

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

        this.backgroundImagePath = "/lang/" + this.settingsHanger.getLanguage() + "/mainMenu.txt";
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


    public InstructionController getInstructionController() {
        return instructionController;
    }
    public LoadingController getLoadingController() {
        return loadingController;
    }
    public OptionsController getOptionsController() {
        return optionsController;
    }
    public TitlesController getTitlesControlleler() {
        return titlesControlleler;
    }




    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean openLoadingList() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.loading;
            this.loadingController = new LoadingController(this.savesPath);
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

            this.optionsController = new OptionsController(submitButtonText, backButtonText,
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
            this.titlesControlleler = new TitlesController(titlesPath, backButtonText);
            return true;
        } else
            return false;
    }

    public boolean openInstruction() {
        if (getState() == MainMenuState._default) {
            this.state = MainMenuState.instruction;
            String instructionHome = "lang/" + this.settingsHanger.getLanguage() + "/instruction";
            String backButtonText = "lang/" + this.settingsHanger.getLanguage() + "/backButton.txt";
            this.instructionController = new InstructionController(instructionHome, backButtonText);
            return true;
        } else
            return false;
    }

    public boolean closeChild() {
        if (getState() != MainMenuState._default) {
            this.state = MainMenuState._default;
            loadingController = null;
            optionsController = null;
            titlesControlleler = null;
            instructionController = null;
            return true;
        } else
            return false;
    }
}