package pl.kpierczyk.monopoly.model.utilities.settings;

import java.io.*;








// *******************************************//
// Setting class contains all setting
// which can be set during app is runinng.
// Instance of this class is preserved in
// theinstance of Model.
// *******************************************//

public class Settings {


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private PathSetting gameHome; // path to the main game folder
    private SelectSetting language;
    private SelectSetting resolution;
    private BooleanSetting fullscreen;
    private InRangeSetting soundLevel;
    private SettingsWarnings registeredWarnings;





    /*****************************************/
    /* Constructor */
    /*****************************************/



    // default constructor
    public Settings() {
        this.language = new SelectSetting(0, new String[] { "en", "pl" });
        this.resolution = new SelectSetting(0, new String[] { "1920x1080", "800x600" });
        this.fullscreen = new BooleanSetting(false);
        this.soundLevel = new InRangeSetting(50, new Integer[] { 0, 100 });
    }



    // full specified constructor
    public Settings(String gameHome, Integer language, Integer resolution,
                    Boolean fullscreen, Integer soundLevel) {

        SettingsWarnings warnings = new SettingsWarnings();

        this.gameHome = new PathSetting(gameHome);
        this.language = new SelectSetting(0, new String[] { "en", "pl" });
        this.resolution = new SelectSetting(0, new String[] { "1920x1080", "800x600" });
        this.fullscreen = new BooleanSetting(false);
        this.soundLevel = new InRangeSetting(50, new Integer[] { 0, 100 });

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








    /*****************************************/
    /* Getters & setters */
    /*****************************************/



    public String getLanguage() {
        return language.getValue();
    }

    public boolean setLanguage(Integer language) {
        return this.language.setValue(language);
    }

    public Integer[] getResolution() {
        String width = "";
        String height = "";

        if (this.resolution.getValue().indexOf("x") == 3) {
            width = this.resolution.getValue().substring(0, 2);
            height = this.resolution.getValue().substring(4, 6);
        } else if (this.resolution.getValue().indexOf("x") == 4) {
            width = this.resolution.getValue().substring(0, 3);
            height = this.resolution.getValue().substring(4, 8);
        }

        return new Integer[] { Integer.parseInt(width), Integer.parseInt(height) };
    }

    public boolean setResolution(Integer resolution) {
        return this.resolution.setValue(resolution);
    }

    public boolean isFullscreen() {
        return this.fullscreen.getValue();
    }

    public boolean setFullscreen(Boolean fullscreen) {
        return this.fullscreen.setValue(fullscreen);
    }

    public Integer getSoundLevel() {
        return soundLevel.getValue();
    }

    public Boolean setSoundLevel(Integer soundLevel) {
        return this.soundLevel.setValue(soundLevel);
    }

    public String getGameHome() {
        return this.gameHome.getValue();
    }

    public boolean setGameHome(String gameHome) {
        return this.gameHome.setValue(gameHome);
    }

    public SettingsWarnings getRegisteredWarnings() {
        return registeredWarnings;
    }

    public void setRegisteredWarnings(SettingsWarnings registeredWarnings) {
        this.registeredWarnings = registeredWarnings;
    }












    /*****************************************/
    /* Utilities */
    /*****************************************/




    public void reset() {
        this.gameHome.setValue("");
        this.language.setValue(0);
        this.resolution.setValue(0);
        this.fullscreen.setValue(false);
        this.soundLevel.setValue(50);
        this.registeredWarnings.clear();
    }






    public boolean readFromFile(String gameHome) {

        String filePath = gameHome + "\\config.txt";

        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // tmp string for reading language version from config.txt
            String line = null;

            // source path initialization
            this.gameHome.setValue(gameHome);


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
                    this.setResolution(0);
                    break;
                case "800x600":
                    this.setResolution(1);
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
        } catch (FileNotFoundException ex) {
            System.out.println("Unable to open file '" + filePath + "'");
            // default settings
            this.reset();
            return false;
        } catch (IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
            // default settings
            this.reset();
            return false;
        }
        return true;
    }






    public boolean writeToFile() {

        String filePath = this.gameHome.getValue() + "\\config.txt";

        try {
            FileWriter fileWriter = new FileWriter(filePath);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            printWriter.print(this.getGameHome());
            printWriter.print(this.getLanguage());
            printWriter.print(this.getResolution());
            printWriter.print(this.isFullscreen());
            printWriter.print(this.getGameHome());            
            printWriter.print(this.getSoundLevel());
                
            printWriter.close();
        } catch (FileNotFoundException ex) {
            return false;
        } catch (IOException ex) {
            return false;
        }

        return true;
    }
}
