package pl.kpierczyk.monopoly.model.utilities;

public class Util{
    
    public static String convert(String URL){
        String URI = URL.replaceAll("%20", " ");
        return URI;
    }
}