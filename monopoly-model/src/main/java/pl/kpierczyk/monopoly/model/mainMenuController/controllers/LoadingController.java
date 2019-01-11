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



public class LoadingController {


    /*****************************************/
    /*             Class Fields              */
    /*****************************************/

    final private String savesHome;
    final private String savesNames[];
    private int checkedSave;



    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public LoadingController(String savesHome) {
        this.savesHome = savesHome;

        File folder = new File(savesHome);
        File[] listOfFiles = folder.listFiles();
        this.savesNames = new String[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            this.savesNames[i] = listOfFiles[i].getName();
        }

        checkedSave = 0;
    }



    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String getSavesHome() {
        return savesHome;
    }
    public String[] getSavesNames() {
        return savesNames;
    }
    
    public int getCheckedSave() {
        return checkedSave;
    }
    public void setCheckedSave(int checkedSave) {
        this.checkedSave = checkedSave;
    }



    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public boolean checkSave(int saveNumber){
        if(saveNumber > 0 && saveNumber <= savesNames.length){
            this.checkedSave = saveNumber;
            return true;
        }
        else
            return false;
    }

    public void uncheckSave(){
        setCheckedSave(0);
    }
}