package pl.kpierczyk.monopoly.model.utilities.settings;

import pl.kpierczyk.monopoly.model.utilities.settings.settingUtilities.SettingsWarnings;
import pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds.BooleanSetting;
import pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds.InRangeSetting;
import pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds.SelectSetting;

import java.io.*;

/**
 * Setting class contains all setting which can be set
 * during app is runinng. Instance of this class is
 * preserved in theinstance of Model.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Setting
 * @see     BooleanSetting
 * @see     SelectSetting
 * @see     InRangeSetting
 * @see     PathSetting
 */

public class Settings {

    /** Number of settings in the object */
    private final int settingsNumber = 4;

    /** Setting responsible for language of the app. */
    private SelectSetting language;

    /** Setting indicating resolution of the app. */
    private SelectSetting resolution;

    /** Setting indicating fullscreen state of the window. */
    private BooleanSetting fullscreen;

    /** Sound level of music in application*/
    private InRangeSetting soundLevel;

    /** Abstract object representing settings changes that failed. */
    private SettingsWarnings registeredWarnings;


    /**
     * Default initialization of app's settings
     */
    public Settings() {
        this.language =
            new SelectSetting(0, new String[] { "en", "pl" });
        this.resolution =
            new SelectSetting(1, new String[] { "800x600", "1920x1080" });
        this.fullscreen =
            new BooleanSetting(false);
        this.soundLevel =
            new InRangeSetting(50, new int[] { 0, 100 });

        this.registeredWarnings =
            new SettingsWarnings();
    }


    
    /**
     * Initialization of specified settings set.
     * 
     * @param gameHome
     * @param language
     * @param resolution
     * @param fullscreen
     * @param soundLevel
     */
    public Settings(String gameHome, Integer language, Integer resolution, Boolean fullscreen, Integer soundLevel) {

        SettingsWarnings warnings = new SettingsWarnings();

        this.language =
            new SelectSetting(0, new String[] { "en", "pl" });
        this.resolution =
            new SelectSetting(1, new String[] { "800x600", "1920x1080"});
        this.fullscreen =
            new BooleanSetting(false);
                
        this.soundLevel =
            new InRangeSetting(50, new int[] { 0, 100 });

        if (!this.language.setValue(language)) {
            warnings.setLanguageWarning(true);
            this.language.setValue(0);
        }

        if (!this.resolution.setValue(resolution)) {
            warnings.setResolutionWarning(true);
            this.resolution.setValue(0);
        }

        this.fullscreen.setValue(fullscreen);

        if (!this.soundLevel.setValue(soundLevel)) {
            warnings.setLanguageWarning(true);
            this.soundLevel.setValue(50);
        }

        this.registeredWarnings = warnings;
    }


    /**
     * Copying constructor.
     * 
     * @param settings
     */
    public Settings(Settings settings){
        this.language =
            new SelectSetting(settings.getLanguageSetting());
        this.resolution =
            new SelectSetting(settings.getResolutionSetting());
        this.fullscreen =
            new BooleanSetting(settings.getFullscreenSetting());
        this.soundLevel =
            new InRangeSetting(settings.getSoundSetting());
        
        this.registeredWarnings = new SettingsWarnings(settings.getRegisteredWarnings());
    }

    

    /**
     * Returns actual language setting as String.
     * "en" - english
     * "pl" - polish
     * 
     * @return actual language setting as String.
     */
    public String getLanguage() {
        return language.getValue();
    }

    /**
     * Returns actual resolution of the window as 2D Integer
     * array.
     * 
     * @return actual resolution of the window as 2D Integer array.
     */
    public Integer[] getResolution() {
        String width = "";
        String height = "";

        if (this.resolution.getValue().indexOf("x") == 3) {
            width = this.resolution.getValue().substring(0, 3);
            height = this.resolution.getValue().substring(4, 7);
        } else if (this.resolution.getValue().indexOf("x") == 4) {
            width = this.resolution.getValue().substring(0, 4);
            height = this.resolution.getValue().substring(5, 9);
        }

        return new Integer[] { Integer.parseInt(width), Integer.parseInt(height) };
    }

    /**
     * Returns true if game is in fullscreen.
     * 
     * @return true if game is in fullscreen.
     */
    public boolean isFullscreen() {
        return this.fullscreen.getValue();
    }

    /**
     * Returns sound level from 0 to 100.
     * 
     * @return sound level from 0 to 100.
     */
    public Integer getSoundLevel() {
        return soundLevel.getValue();
    }


    /**
     * Returns refference to settings object responsible for language.
     * 
     * @return  refference to settings object responsible for language.
     */
    public SelectSetting getLanguageSetting(){
        return this.language;
    }

        /**
     * Returns refference to settings object responsible for resolution.
     * 
     * @return  refference to settings object responsible for resolution.
     */
    public SelectSetting getResolutionSetting(){
        return this.resolution;
    }

    /**
     * Returns refference to settings object responsible for fullscreen.
     * 
     * @return  refference to settings object responsible for fullscreen.
     */
    public BooleanSetting getFullscreenSetting(){
        return this.fullscreen;
    }

    /**
     * Returns refference to settings object responsible for sound level.
     * 
     * @return  refference to settings object responsible for sound level.
     */
    public InRangeSetting getSoundSetting(){
        return this.soundLevel;
    }


    /**
     * Sets actual value of language.
     * 0 - "pl"
     * 1 - "en"
     *  
     * @param   language
     * @return  true if change performed
     */
    public boolean setLanguage(Integer language) {
        return this.language.setValue(language);
    }

    /**
     * Sets resolution of the app.
     * 0 - "800x600"
     * 1 - "1920x1080"
     * 
     * @param resolution
     * @return true if change performed
     */
    public boolean setResolution(Integer resolution) {
        return this.resolution.setValue(resolution);
    }

    /**
     * Sets fullscreen option on or off.
     * 
     * @param boolean state of fullscreen
     * @return true if change performed
     */
    public boolean setFullscreen(Boolean fullscreen) {
        return this.fullscreen.setValue(fullscreen);
    }

    /**
     * Sets level of sound from 0 to 100. If higher or
     * lower value passed, extreme value is set.
     * 
     * @param level of sound
     * @return true if change performed
     */
    public boolean setSoundLevel(Integer soundLevel) {
        return this.soundLevel.setValue(soundLevel);
    }


    /**
     * Returns refference to SettingsWarnings.
     * 
     * @return  refference to SettingsWarnings.
     * @see     SettingsWarnings
     */
    public SettingsWarnings getRegisteredWarnings() {
        return registeredWarnings;
    }

    /**
     * Sets new SettingWarning object as actual.
     * 
     * @param registeredWarnings
     */
    public void setRegisteredWarnings(SettingsWarnings registeredWarnings) {
        this.registeredWarnings = registeredWarnings;
    }

    /**
     * Returns number of app's options.
     * 
     * @return number of app's options.
     */
    public int getSettingsNumber() {
        return settingsNumber;
    }

    /**
     * Returns String representation of values of setting choosen
     * by passed parameter.
     * 
     * <=0 - language
     * 1 - resolution
     * 2 - fullscreen state
     * 3>= - volume level
     * 
     * @param settingNumber
     * @return String representation of values of choosen setting.
     */
    public String getValueOf(int settingNumber){
        if(settingNumber <= 0)
            return this.language.toString();
        else if(settingNumber == 1)
            return this.resolution.toString();
        else if(settingNumber == 2)
            return this.fullscreen.toString();
        else
            return this.soundLevel.toString();
    }



    /*****************************************/
    /* Utilities */
    /*****************************************/


    /**
     * Resets settings to default values.
     * Resets warnings flags.
     */
    public void reset() {
        this.language.setValue(0);
        this.resolution.setValue(0);
        this.fullscreen.setValue(false);
        this.soundLevel.setValue(50);
        this.registeredWarnings.clearFlags();
    }

    /**
     * Reads settings from the file which has been passed
     * by the absolute Path. Returns true if reading succesfull.
     * 
     * @param configPath
     * @return true if reading succesfull.
     */
    public boolean readFromFile(String configPath) {

        try {
            FileReader fileReader =
                new FileReader(configPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);


            // tmp string for reading language version from config.txt
            String line = null;

            // language initialization
            if ((line = bufferedReader.readLine()) != null) {
                switch (line) {
                case "en":
                    this.setLanguage(0);
                    break;
                case "pl":
                    this.setLanguage(1);
                    break;
                }
            }

            // resolution initialization
            if ((line = bufferedReader.readLine()) != null) {
                switch (line) {
                case "1920x1080":
                    this.setResolution(1);
                    break;
                case "800x600":
                    this.setResolution(0);
                    break;
                }
            }

            // fullscreen option initialization
            if ((line = bufferedReader.readLine()) != null) {
                switch (line) {
                case "on":
                    this.setFullscreen(true);
                    break;
                case "off":
                    this.setFullscreen(false);
                    break;
                }
            }

            // sound level initialization
            if ((line = bufferedReader.readLine()) != null) {
                this.setSoundLevel(Integer.parseInt(line));
            }

            bufferedReader.close();
        } 
        catch (FileNotFoundException ex) {
            System.out.println("Unable to find " + configPath);
            // default settings
            this.reset();
            return false;
        } 
        catch (IOException ex) {
            System.out.println("Unable to load settings from " + configPath);
            // default settings
            this.reset();
            return false;
        }

        return true;
    }


    /**
     * Writes settings to the file pointed with absolute path
     * in the passed parameter. Returns true if writting succesfull.
     * 
     * @param configPath
     * @return true if writting succesfull.
     */
    public boolean writeToFile(String configPath) {

        try {
            FileWriter fileWriter =
                new FileWriter(configPath);
            PrintWriter printWriter =
                new PrintWriter(fileWriter);

            printWriter.println(this.getLanguageSetting().toString());
            printWriter.println(this.getResolutionSetting().toString());
            printWriter.println(this.getFullscreenSetting().toString());
            printWriter.println(this.getSoundSetting().toString());

            printWriter.close();
        } 
        catch (FileNotFoundException ex) {
            return false;
        } 
        catch (IOException ex) {
            return false;
        }

        return true;
    }
}