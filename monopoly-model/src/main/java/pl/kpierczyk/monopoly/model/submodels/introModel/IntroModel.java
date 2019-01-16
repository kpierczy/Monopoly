package pl.kpierczyk.monopoly.model.submodels.introModel;




// <-- TO DO -->
// Model should NOT store graphics paths!

/**
 * Class representing state of the applications during intro.
 * Stores number of ms that intro lasts and Path of graphic
 * displayed during its lasting.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class IntroModel{

    /** Time of intro in ms*/
    private final long introTime = 4000; //intro time in ms

    /** Absolute path of intro graphic. */
    private final String introPosterPath;

    /**
     * Initializes intro's model with a certain absolute path
     * of intro image.
     *  
     * @param introPosterPath
     */
    public IntroModel(String introPosterPath){
        this.introPosterPath = introPosterPath;
    }

    /**
     * Returns intro time in ms.
     * 
     * @return intro time in ms.
     */
    public long getIntroTime() {
        return introTime;
    }

    /**
     * Returns absolute path to the intro's graphic.
     * 
     * @return absolute path to the intro's graphic.
     */
    public String getIntroPosterPath() {
        return introPosterPath;
    }
}