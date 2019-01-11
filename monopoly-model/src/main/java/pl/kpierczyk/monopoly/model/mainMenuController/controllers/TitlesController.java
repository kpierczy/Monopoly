package pl.kpierczyk.monopoly.model.mainMenuController.controllers;
import java.io.*;








//*******************************************//
//
//
//
//
//
//
//
//*******************************************//

public class TitlesController{


    /*****************************************/
    /* Class Fields */
    /*****************************************/

    private final int pagesNumber; // number of pages
    private int actualPage; // actual displayed page
    private String pagesHome; // path to the folder with pages



    /*****************************************/
    /* Constructor */
    /*****************************************/

    public TitlesController(String pagesHome) {
        pagesNumber = new File(pagesHome).listFiles().length;
        actualPage = 1;
        this.pagesHome = pagesHome;
    }



    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public int getActualPage() {
        return actualPage;
    }
    public boolean setActualPage(int actualPage_t) {
        if (actualPage_t > 0 && actualPage_t <= pagesNumber) {
            this.actualPage = actualPage_t;
            return true;
        } else
            return false;
    }

    public String getPagesHome() {
        return pagesHome;
    }
    public void setPagesHome(String pagesHome) {
        this.pagesHome = pagesHome;
    }


    
    /*****************************************/
    /*               Utilities               */
    /*****************************************/

    public int nextPage() {
        if (actualPage < pagesNumber)
            actualPage++;
        return actualPage;
    }

    public int previousPage() {
        if (actualPage > 1)
            actualPage--;
        return actualPage;
    }
}