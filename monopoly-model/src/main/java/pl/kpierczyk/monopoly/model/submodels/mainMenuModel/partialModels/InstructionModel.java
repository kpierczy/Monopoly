package pl.kpierczyk.monopoly.model.submodels.mainMenuModel.partialModels;

import java.io.*;

import pl.kpierczyk.monopoly.model.Model;



/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class InstructionModel {

    /* Invisible */

    Model model;

    private final int pagesNumber; // number of pages
    private int actualPage; // actual displayed page

    private final String instructionHome; // path to the folder with pages

    /* Visible */
    private final String backButtonText;

    public InstructionModel(Model model, String instructionHome, String backButtonTextPath) {

        /* Initializing invisible elements */

        this.model = model;

        this.pagesNumber = new File(instructionHome).listFiles().length;
        this.actualPage = 1;

        this.instructionHome = instructionHome;

        /* Reading back button's text */
        String backButtonText;

        try {
            FileReader fileReader = new FileReader(backButtonTextPath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            backButtonText = new String(bufferedReader.readLine().getBytes(), "UTF-8");
            bufferedReader.close();
        } catch (IOException ex) {
            System.out.println("Couldn't read buttons text from" + backButtonTextPath);
            backButtonText = "???";
        }

        this.backButtonText = backButtonText;
    }

    
    public String getActualPagePath() {
        return instructionHome + "/" + Integer.toString(actualPage) + ".png";
    }

    public String getBackButtonText() {
        return backButtonText;
    }





    
    /*****************************************/
    /* Utilities */
    /*****************************************/

    public boolean nextPage() {
        if (actualPage < pagesNumber) {
            actualPage++;

            File actualPageFile = new File(this.instructionHome + "/" + Integer.toString(actualPage) + ".png");

            if (!actualPageFile.exists()) {
                actualPage--;
                return false;
            }
            return true;
        } else
            return false;
    }

    public boolean previousPage() {
        if (actualPage > 1) {
            actualPage--;
            File actualPageFile = new File(this.instructionHome + "/" + Integer.toString(actualPage) + ".png");

            if (!actualPageFile.exists()) {
                actualPage++;
                return false;
            }
            return true;
        } else
            return false;
    }

    public boolean backToMainMenu() {
        return this.model.getMainMenuModel().closeChild();
    }
}
