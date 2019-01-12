package pl.kpierczyk.monopoly.model.mainMenuController.controllers;
import pl.kpierczyk.monopoly.model.*;
import java.io.*;

import pl.kpierczyk.monopoly.model.gameController.GameController;

//*******************************************//
//
//
//
//
//
//
//
//*******************************************//


public class InstructionController {


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    /*Invisible*/
    private final int pagesNumber; // number of pages
    private int actualPage; // actual displayed page
    private final String instructionHome; // path to the folder with pages

    /*Visible*/
    private String actualPagePath;
    private final String backButtonText;

    


    /*****************************************/
    /* Constructor */
    /*****************************************/

    public InstructionController(String instructionHome, String backButtonText) {
        pagesNumber = new File(instructionHome).listFiles().length;
        actualPage = 1;
        this.instructionHome = instructionHome;

        this.actualPagePath = this.instructionHome + "/" + Integer.toString(this.actualPage);
        this.backButtonText = backButtonText;
    }




    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public String getActualPagePath() {
        return actualPagePath;
    }
    public String getBackButtonText() {
        return backButtonText;
    }

    
    /*****************************************/
    /*               Utilities               */
    /*****************************************/

    public String nextPage() {
        if (actualPage < pagesNumber)
            actualPage++;
        this.actualPagePath = this.instructionHome + "/" + Integer.toString(this.actualPage);
        return this.actualPagePath;
    }

    public String previousPage() {
        if (actualPage > 1)
            actualPage--;
        this.actualPagePath = this.instructionHome + "/" + Integer.toString(this.actualPage);
        return this.actualPagePath;
    }
}
