package pl.kpierczyk.monopoly.app;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.view.*;
import java.awt.event.*;
import javax.swing.*;

import pl.kpierczyk.monopoly.controller.*;

// Starting Module

public class App 
{
    public static void main( String[] args )
    {
        Model model  = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);
    }
}
