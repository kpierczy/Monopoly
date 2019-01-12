package pl.kpierczyk.monopoly.model.mainMenuController.controllers;
import pl.kpierczyk.monopoly.model.utilities.settings.*;
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

public class OptionsController{

    /*****************************************/
    /*            Class Fields               */
    /*****************************************/

    /*Invisible*/
    final Settings settingsHanger;
    final String configPath;

    /*Visible*/
    final String submitButtonText;
    final String backButtonText;
    final String optionsTexts[];
    String optionsValues[];



    
    /*****************************************/
    /*             Constructor               */
    /*****************************************/

    public OptionsController(String submitButtonText, String backButtonText, String optionsTexts[],
                             Settings settingsHanger, String configPath){
        this.submitButtonText = submitButtonText;
        this.backButtonText = backButtonText;
        this.optionsTexts = optionsTexts;

        this.settingsHanger = settingsHanger;
        this.configPath = configPath;
        
        for(int i = 0; i < this.settingsHanger.getSettingsNumber(); i++){
            this.optionsValues[i] = settingsHanger.getValueOf(i);
        }
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/


    public Settings getSettingsHanger() {
        return settingsHanger;
    }
    public String getConfigPath() {
        return configPath;
    }

    
    public String getSubmitButtonText() {
        return submitButtonText;
    }
    public String getBackButtonText() {
        return backButtonText;
    }
    public String[] getOptionsTexts() {
        return optionsTexts;
    }
    public String[] getOptionsValues() {
        return optionsValues;
    }



    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean previousLanguage(){
        return this.settingsHanger.getLanguageSetting().nextValue();
    }
    public boolean nextLanguage(){
        return this.settingsHanger.getLanguageSetting().previousValue();
    }

    public boolean previousResolution(){
        return this.settingsHanger.getResolutionSetting().nextValue();
    }
    public boolean nextResolution(){
        return this.settingsHanger.getResolutionSetting().previousValue();
    }

    public void switchFullscreen(){
        this.settingsHanger.getFullscreenSetting().switchValue();
    }

    public void setVolume(int volumeValue){
        this.settingsHanger.getSoundSetting().setValue(volumeValue);
    }

    public boolean saveChanges(){
        return this.settingsHanger.writeToFile();
    }
}