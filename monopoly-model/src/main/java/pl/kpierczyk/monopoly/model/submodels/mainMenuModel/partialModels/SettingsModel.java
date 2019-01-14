package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import pl.kpierczyk.monopoly.model.Model;
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

public class SettingsModel{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    /*Invisible*/
    private Model model;
    private Settings settingsCopy;
    private final String configPath;

    /*Visible*/
    private final String okButtonText;
    private final String backButtonText;
    private final String settingsTexts[];
    private final String settingsbackgroundImagePath;



    
    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public SettingsModel(Model model,
                         String configPath,
                         String buttonsPath[],
                         String SettingsTextsPath,
                         String settingsbackgroundImagePath){


        /*Invisible elements initialization*/
        this.model = model;
        this.settingsCopy = new Settings(this.model.getSettings());
        this.configPath = configPath;

        /* Buttons' texts initialization */
        String okButtonText;
        String backButtonText;

        try {
            FileReader fileReader = new FileReader(buttonsPath[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            okButtonText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + buttonsPath[0]);
            okButtonText = "???";
        }

        try {
            FileReader fileReader = new FileReader(buttonsPath[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            backButtonText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + buttonsPath[0]);
            backButtonText = "???";
        }

        this.okButtonText = okButtonText;
        this.backButtonText = backButtonText;


        /*Initializing settings text*/
        String settingsTexts[] = new String[this.settingsCopy.getSettingsNumber()];

        try {
            FileReader fileReader = 
                new FileReader(SettingsTextsPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            for(int i = 0; i < settingsTexts.length; i++){
                settingsTexts[i] = bufferedReader.readLine();
            }
            
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read settings text from " + SettingsTextsPath);
            for(int i = 0; i < settingsTexts.length; i++){
                settingsTexts[i] = "???";
            }
        }

        this.settingsTexts = settingsTexts;
        this.settingsbackgroundImagePath = settingsbackgroundImagePath;
    }



    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getConfigPath() {
        return configPath;
    }

    public String getOkButtonText() {
        return okButtonText;
    }
    public String getBackButtonText() {
        return backButtonText;
    }
    
    public String[] getSettingsTexts() {
        return settingsTexts;
    }
    public String getSettingsTexts(int textNumber) {
        if(textNumber <= 0)
            return settingsTexts[0];
        else if(textNumber >= settingsTexts.length)
            return settingsTexts[settingsTexts.length - 1];
        else
            return settingsTexts[textNumber];
    }

    public String getSettingsbackgroundImagePath() {
        return settingsbackgroundImagePath;
    }


    public String getSettingsValues(int valueNumber) {
        if(valueNumber <= 0)
            return settingsCopy.getValueOf(0);
        else if(valueNumber >= this.settingsCopy.getSettingsNumber())
            return settingsCopy.getValueOf(settingsCopy.getSettingsNumber() - 1);
        else
            return settingsCopy.getValueOf(valueNumber);
    }




    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean previousLanguage(){
        return this.settingsCopy.getLanguageSetting().nextValue();
    }
    public boolean nextLanguage(){
        return this.settingsCopy.getLanguageSetting().previousValue();
    }

    public boolean previousResolution(){
        return this.settingsCopy.getResolutionSetting().nextValue();
    }
    public boolean nextResolution(){
        return this.settingsCopy.getResolutionSetting().previousValue();
    }

    public void switchFullscreen(){
        this.settingsCopy.getFullscreenSetting().switchValue();
    }

    public void setVolume(int volumeValue){
        this.settingsCopy.getSoundSetting().setValue(volumeValue);
    }


    public boolean backToMainMenu(){
        return this.model.getMainMenuModel().closeChild();
    }

    public boolean saveChanges(){
        this.settingsCopy.writeToFile(this.configPath);
        return this.model.getMainMenuModel().closeChild(); 
    }
}