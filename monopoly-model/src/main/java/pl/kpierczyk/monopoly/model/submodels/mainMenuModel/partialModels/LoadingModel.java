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
    /* Class Fields */
    /*****************************************/

    /* Invisible */

    Model model;
    String savesPath;

    /* Visible */
    final private String savesNames[];

    final private String okButtonText;
    final private String backButtonText;

    private int checkedSave;

    /*****************************************/
    /* Constructor */
    /*****************************************/

    public LoadingModel(Model model, String savesPath, String buttonsPath[]) {

        /* Model's hanger initialization */
        this.model = model;
        this.savesPath = savesPath;

        /* Saves list initialization */
        File folder = new File(savesPath);
        File[] listOfFiles = folder.listFiles();
        this.savesNames = new String[listOfFiles.length];
        for (int i = 0; i < listOfFiles.length; i++) {
            this.savesNames[i] = listOfFiles[i].getName();
        }

        /* Buttons' texts initialization */
        String okButtonText;
        String backButtonText;

        try {
            FileReader fileReader = new FileReader(buttonsPath[0]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            okButtonText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + buttonsPath[0]);
            okButtonText = "???";
        }

        try {
            FileReader fileReader = new FileReader(buttonsPath[1]);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            backButtonText = bufferedReader.readLine();
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + buttonsPath[0]);
            backButtonText = "???";
        }

        this.okButtonText = okButtonText;
        this.backButtonText = backButtonText;

        /* Checked save position initialization */
        this.checkedSave = 0;
    }

    /*****************************************/
    /* Getters & setters */
    /*****************************************/

    public String[] getSavesNames() {
        return savesNames;
    }

    public String getBackButtonText() {
        return backButtonText;
    }

    public String getokButtonText() {
        return okButtonText;
    }

    public int getCheckedSave() {
        return checkedSave;
    }

    public boolean setCheckedSave(int checkedSave) {
        if (checkedSave > 0 && checkedSave <= savesNames.length) {
            this.checkedSave = checkedSave;
            return true;
        } else
            return false;
    }

    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean checkSave(int saveNumber) {
        return setCheckedSave(saveNumber);
    }

    public void uncheckSave() {
        setCheckedSave(0);
    }

    public void backToMainMenu() {

        this.model.getMainMenuModel().closeChild();
    }

    public boolean loadActualSave() {        
        
        GameSaveInfo gameSaveInfo = new GameSaveInfo();
        //Here change save state from empty to not empty - difference between loaded game and new game
        
        String savePath = this.savesPath +
                          this.savesNames[checkedSave];
        try {
            FileReader fileReader = 
                new FileReader(savePath);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            //Here happens whole gameSaveInfoSetting;


            bufferedReader.close();
        } 
        catch (IOException ex) {
            System.out.println("Couldn't read buttons text from " + savePath);
            return false;
        }

        //Not sure if i should close loadModel before running new game
        this.model.getMainMenuModel().closeChild();
        this.model.runNewGame(gameSaveInfo);
        //Not sure if return happens - probably yes, because Model is automat of states, but not sure
        return true;
    }
}