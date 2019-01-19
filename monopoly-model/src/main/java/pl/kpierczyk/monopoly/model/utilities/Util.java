package pl.kpierczyk.monopoly.model.utilities;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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


    /**
     * Returns instance of temporary File being a copy
     * of a file whose path was given by the argument.
     * 
     * @param resourcePath
     * @return
     */
    public static File getResourceAsFile(String resourcePath) {
        try {
            InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(resourcePath);
            if (in == null) {
                return null;
            }
    
            File tempFile = File.createTempFile(String.valueOf(in.hashCode()), ".tmp");
            tempFile.deleteOnExit();
    
            try (FileOutputStream out = new FileOutputStream(tempFile)) {
                //copy stream
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            return tempFile;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}