package pl.kpierczyk.monopoly.app;

import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.*;
import pl.kpierczyk.monopoly.controller.*;

/**
 * Main App's class that initializes Model, View and Controller.
 * Actual version of application is based on Java Swing library.
 * Event's character of the Swing plays along with MVC based
 * application
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Model
 * @see     View
 * @see     Controller
 */
public class App 
{
    public static void main( String[] args )
    {
        Model model  = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
