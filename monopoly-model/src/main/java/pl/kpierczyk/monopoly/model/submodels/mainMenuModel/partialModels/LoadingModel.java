package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

import java.io.*;
import pl.kpierczyk.monopoly.model.*;
import pl.kpierczyk.monopoly.model.submodels.gameModel.*;


//*******************************************//
//
//
//
//
//
//
//
//*******************************************//



public class LoadingModel {


    /*****************************************/
    /*             Class Fields              */
    /*****************************************/

    final private String savesNames[];
    final private String loadButtonText;
    final private String backButtonText;
    private int checkedSave;



    /*****************************************/
    /*              Constructor              */
    /*****************************************/

    public LoadingModel(String textPath) {
        ClassLoader classLoader = getClass().getClassLoader();
        String savesHome = Model.convert(classLoader.getResource("saves").getPath());
        File folder = new File(savesHome);
        File[] listOfFiles = folder.listFiles();
        this.savesNames = new String[listOfFiles.length];

        for (int i = 0; i < listOfFiles.length; i++) {
            this.savesNames[i] = listOfFiles[i].getName();
        }


        String loadButtonText;
        String backButtonText;

        try {
            FileReader fileReader = 
                new FileReader(textPath);
            BufferedReader bufferedReader =
                new BufferedReader(fileReader);

            loadButtonText = bufferedReader.readLine();
            backButtonText = bufferedReader.readLine();
            bufferedReader.close();
        }
        catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + textPath);
            loadButtonText = "???";
            backButtonText = "???";
        }

        this.loadButtonText = loadButtonText;
        this.backButtonText = backButtonText;

        checkedSave = 0;
    }



    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/

    public String[] getSavesNames() {
        return savesNames;
    }
    public String getBackButtonText() {
        return backButtonText;
    }
    public String getLoadButtonText() {
        return loadButtonText;
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



    /*!!!!!!!!!!!!!DOKOŃCZYĆ WCZYTYWANIE!!!!!!!!!!! */
    public GameModel loadActualSave(){
        return new GameModel();
    }
}