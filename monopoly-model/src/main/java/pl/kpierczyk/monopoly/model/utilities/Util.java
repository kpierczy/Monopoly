package pl.kpierczyk.monopoly.model.utilities;


/**
 * Simple class storing utility methods responsible for
 * e.g. converting character strings.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class Util{
    
    /**
     * Converts given String (Path) from Windows format
     * to Unix format.
     * 
     * @param URL
     * @return Unix-formated path
     */
    public static String convert(String URL){
        String URI = URL.replaceAll("%20", " ");
        return URI;
    }
}