package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Card.CardType;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts.Field;
import pl.kpierczyk.monopoly.model.utilities.settings.Settings;

/**
 * Class representing Monopoly's boards. Storages references to Field's
 * objects and stacks of drawable cards.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public class Board{

    /** Default size of card's stacks.*/
    public final int STACKS_SIZE = 16;

    /** Default size of the board.*/
    public final int BOARD_SIZE = 40;
    

    /** List of fields representing board*/
    private ArrayList<Field> board = new ArrayList<Field>(BOARD_SIZE);

    /** Stacks of chance and deal drawable cards.*/
    private CardsStack chanceCards = new CardsStack(STACKS_SIZE, CardType.chance);
    private CardsStack dealCards = new CardsStack(STACKS_SIZE, CardType.deal);
    


    public Board(Settings settings){
        String boardFile;
        String chanceFile;
        String dealFile;

        boardFile = "/lang/" + settings.getLanguage() + "/gameTexts/board.txt";
        chanceFile = "/lang/" + settings.getLanguage() + "/gameTexts/chance.txt";
        dealFile = "/lang/" + settings.getLanguage() + "/gameTexts/deal.txt";

        this.loadFromFile(boardFile, chanceFile, dealFile);
    }





    /********************************/
    /* Utilities */
    /********************************/


    public boolean loadFromFile(String boardFile, String chanceFile, String dealFile){
        if(boardFile != null && chanceFile != null && dealFile != null){
            
            /** Initializing potentially loaded elements.*/
            ArrayList<Field> potentialBoard = new ArrayList<Field>(BOARD_SIZE);
            CardsStack potentialChanceCards = new CardsStack(STACKS_SIZE, CardType.chance);
            CardsStack potentialDealCards = new CardsStack(STACKS_SIZE, CardType.deal);

            /** loading stacks texts from file.*/
            if(potentialChanceCards.loadFromFile(chanceFile) == false)
                return false;
            if(potentialDealCards.loadFromFile(dealFile) == false)
                return false;


            try{

                BufferedReader bufferedReader =
                    new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(boardFile)));

                /** here lines from file are read*/
                String line;

                /** number of fields loaded*/
                int i = 0;

                /** <-- IMPORTANT -->*/
                /** First line of the file should be empty.*/
                for(i = 0; (i < BOARD_SIZE) && ((line = bufferedReader.readLine()) != null); i++){
                    
                    /** Checking */
                    if((line = bufferedReader.readLine()) != null){

                        if(line == "START_FIELD"){

                        }
                        else if(line == ""){

                        }
                        else if(line == ""){
                            
                        }
                        else if(line == ""){
                            
                        }
                        else if(line == ""){
                            
                        }
                        else if(line == ""){
                            
                        }
                        else if(line == ""){
                            
                        }
                        else if(line == ""){
                            
                        }





                    }
                }

                /** If not all fields have been loaded.*/
                if(i < BOARD_SIZE)
                    return false;

            }
            catch(Exception ex){
                System.out.println("Could not load boardInfo from file.");
                return false;
            }
            


            /** Save loadings*/
            board = potentialBoard;
            chanceCards = potentialChanceCards;
            dealCards = potentialDealCards;
            return true;
        }
        else return false;
    }
}