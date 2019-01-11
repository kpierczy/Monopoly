package pl.kpierczyk.monopoly.app;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.*;
import pl.kpierczyk.monopoly.controller.*;

// Starting Module

public class App 
{
    public static void main( String[] args )
    {
        Model model  = new Model("\\resources");
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
