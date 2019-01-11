package pl.kpierczyk.monopoly.model.utilities.settings;







// *******************************************//
// SettingWarnings class is defined for
// containg boolean statements describing
// if a prticular setting was asigned
// correctly or it was asigned in the default
// way.
// *******************************************//


public class SettingsWarnings {

    /*****************************************/
    /* Class Fields */
    /*****************************************/

    boolean languageWarning;
    boolean resolutionWarning;
    boolean soundLevelWarning;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    // default constructor
    public SettingsWarnings() {
        languageWarning = false;
        resolutionWarning = false;
        soundLevelWarning = false;
    }

    // full specified constructor
    public SettingsWarnings(boolean languageWarning_t, boolean resolutionWarning_t,
            boolean soundLevelWarning_t) {
        languageWarning = languageWarning_t;
        resolutionWarning = resolutionWarning_t;
        soundLevelWarning = soundLevelWarning_t;
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public boolean isLanguageWarning() {
        return languageWarning;
    }

    public void setLanguageWarning(boolean languageWarning) {
        this.languageWarning = languageWarning;
    }

    public boolean isResolutionWarning() {
        return resolutionWarning;
    }

    public void setResolutionWarning(boolean resolutionWarning) {
        this.resolutionWarning = resolutionWarning;
    }

    public boolean isSoundLevelWarning() {
        return soundLevelWarning;
    }

    public void setSoundLevelWarning(boolean soundLevelWarning) {
        this.soundLevelWarning = soundLevelWarning;
    }

    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public void clear() {
        this.languageWarning = false;
        this.resolutionWarning = false;
        this.soundLevelWarning = false;
    }
}