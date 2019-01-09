package pl.kpierczyk.monopoly.model.mainMenu.controllers;

public class InstructionController{

    /*****************************************/
    /*             Class Fields              */
    /*****************************************/
    
    private final int pagesNumber; //number of pages
    private int actualPage; //actual displayed page
    private String pagesHome; //path to the folder with pages


    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public InstructionController(String pagesHome_t){
        pagesNumber = 20;   //CREATE SLIDES!//
        actualPage = 1;
        pagesHome = pagesHome_t;
    }


    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/
    
    public int getActualPage() { return actualPage; }
    public boolean setActualPage(int actualPage_t) {
        if(actualPage_t > 0 && actualPage_t <= pagesNumber){
            this.actualPage = actualPage_t;
            return true;
        }
        else
            return false;
    }
    public String getPagesHome() { return pagesHome; }
    public void setPagesHome(String pagesHome) { this.pagesHome = pagesHome; }


    /*****************************************/
    /*            Other Methods              */
    /*****************************************/

    public int nextPage(){
        if(actualPage < pagesNumber)
            actualPage++;
        return actualPage;
    }
    public int previousPage(){
        if(actualPage > 1)
            actualPage--;
        return actualPage;
    }
}
