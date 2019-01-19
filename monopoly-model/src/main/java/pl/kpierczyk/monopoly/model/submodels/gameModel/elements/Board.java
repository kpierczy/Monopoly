package pl.kpierczyk.monopoly.model.submodels.gameModel.elements;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Card.CardType;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.CardDrawField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.ColourField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.NeutralField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.SpecialPropertyField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.StartField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TaxField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TeleportingField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TrainStationField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.CardDrawField.CardKind;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts.Field;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields.ColourFieldCashInfo;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields.Colours;
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
    

    /**
     * Initializes game board with specific language parameters.
     * Loads required info from text files.
     * 
     * @param settings
     */
    public Board(Settings settings){
        String boardFile;
        String chanceFile;
        String dealFile;

        boardFile = "/lang/" + settings.getLanguage() + "/gameTexts/board.txt";
        chanceFile = "/lang/" + settings.getLanguage() + "/gameTexts/chance.txt";
        dealFile = "/lang/" + settings.getLanguage() + "/gameTexts/deal.txt";

        this.loadFromFile(boardFile, chanceFile, dealFile);
    }




    /**
     * @return the board
     */
    public ArrayList<Field> getBoard() {
        return board;
    }

    /**
     * @return the chanceCards
     */
    public CardsStack getChanceCards() {
        return chanceCards;
    }

    /**
     * @return the dealCards
     */
    public CardsStack getDealCards() {
        return dealCards;
    }








    /********************************/
    /* Utilities */
    /********************************/

    /**
     * Loads required fields and stacks info from 
     * specified files. Returns false if loading error.
     * 
     * @param boardFile
     * @param chanceFile
     * @param dealFile
     * @return false if loading error.
     */
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

                        /** StartField initializing*/
                        if(line == "START_FIELD"){

                            String ID;
                            String name;
                            int startBenefit;

                            ID = bufferedReader.readLine();
                            name = bufferedReader.readLine();
                            startBenefit = Integer.parseInt(bufferedReader.readLine());

                            board.set(i, new StartField(ID, name, startBenefit));
                        }
                        /** ColourField initializing*/
                        else if(line == "COLOUR_FIELD"){

                            String ID;
                            String name;
                            int price;
                            int pledgeValue;
                            int buybackMultiplier;
                            
                            ColourFieldCashInfo prices = new ColourFieldCashInfo();

                            int baseRent;
                            int fullsetRentMultipiller;
                            int oneApartmentRent;
                            int twoApartmentsRent;
                            int threeApartmentsRent;
                            int fourApartmentsRent;
                            int hotelRent;
                            int apartmentCost;
                            int hotelCost;

                            int colour;

                            

                            /** Base info*/
                            ID = bufferedReader.readLine();
                            name = bufferedReader.readLine();
                            price = Integer.parseInt(bufferedReader.readLine());
                            pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            buybackMultiplier = Integer.parseInt(bufferedReader.readLine());

                            /** ColourFieldCashInfo*/
                            baseRent = Integer.parseInt(bufferedReader.readLine());
                            fullsetRentMultipiller = Integer.parseInt(bufferedReader.readLine());
                            oneApartmentRent = Integer.parseInt(bufferedReader.readLine());
                            twoApartmentsRent = Integer.parseInt(bufferedReader.readLine());
                            threeApartmentsRent = Integer.parseInt(bufferedReader.readLine());
                            fourApartmentsRent = Integer.parseInt(bufferedReader.readLine());
                            hotelRent = Integer.parseInt(bufferedReader.readLine());
                            apartmentCost = Integer.parseInt(bufferedReader.readLine());
                            hotelCost = Integer.parseInt(bufferedReader.readLine());

                            switch(bufferedReader.readLine()){
                                case "BROWN":
                                    colour = Colours.BROWN;
                                case "BLUE":
                                    colour = Colours.BLUE;
                                case "PINK":
                                    colour = Colours.PINK;
                                case "ORANGE":
                                    colour = Colours.ORANGE;
                                case "RED":
                                    colour = Colours.RED;
                                case "YELLOW":
                                    colour = Colours.YELLOW;
                                case "GREEN":
                                    colour = Colours.GREEN;
                                case "NAVY":
                                    colour = Colours.NAVY;
                                default:
                                    colour = Colours.NONE;
                            }

                            /** Set ColourFieldCashInfo fields.*/
                            prices.setBaseRent(baseRent);
                            prices.setFullsetRentMultipiller(fullsetRentMultipiller);
                            prices.setOneApartmentRent(oneApartmentRent);
                            prices.setTwoApartmentsRent(twoApartmentsRent);
                            prices.setThreeApartmentsRent(threeApartmentsRent);
                            prices.setFourApartmentsRent(fourApartmentsRent);
                            prices.setHotelRent(hotelRent);
                            prices.setApartmentCost(apartmentCost);
                            prices.setHotelCost(hotelCost);

                            /** Initializes new */
                            board.set(i, new ColourField(ID, name, price, pledgeValue,
                                                         buybackMultiplier, prices, colour));
                        }
                        else if(line == "CARD_DRAW_FIELD"){
                            
                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();
                            CardKind kind;
                            switch(bufferedReader.readLine()){
                                case "CHANCE":
                                    kind = CardKind.chance;
                                case "DEAL":
                                    kind = CardKind.deal;
                                default:
                                    kind = CardKind.none;

                            }

                            /** Initializing new DrawCardField*/
                            board.set(i, new CardDrawField(ID, name, kind));
                        }
                        else if(line == "TAX_FIELD"){
                            
                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();
                            int taxValue = Integer.parseInt(bufferedReader.readLine());

                            /** Initializing new TaxField*/
                            board.set(i, new TaxField(ID, name, taxValue));
                        }
                        else if(line == "TRAIN_STATION_FIELD"){
                            
                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();
                            int price = Integer.parseInt(bufferedReader.readLine());
                            int pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            int buybackMultiplier = Integer.parseInt(bufferedReader.readLine());
                            int baseRent = Integer.parseInt(bufferedReader.readLine());

                            /** Initializing new TrainSTationField*/
                            board.set(i, new TrainStationField(ID, name, price, pledgeValue,
                                                               buybackMultiplier, baseRent));
                        }
                        else if(line == "NEUTRAL_FIELD"){
                            
                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();

                            /** Initializes new NeutralField*/
                            board.set(i, new NeutralField(ID, name));
                            
                        }
                        else if(line == "SPECIAL_PROPERTY_FIELD"){
                            
                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();
                            int price = Integer.parseInt(bufferedReader.readLine());
                            int pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            int buybackMultiplier = Integer.parseInt(bufferedReader.readLine());
                            int baseMultiplier = Integer.parseInt(bufferedReader.readLine());
                            int setMultiplier = Integer.parseInt(bufferedReader.readLine());

                            /** Initializes new NeutralField*/
                            board.set(i, new SpecialPropertyField(ID, name, price, pledgeValue, 
                                                                  buybackMultiplier, baseMultiplier, setMultiplier));
                        }
                        else if(line == "TELEPORTING_FIELD"){

                            String ID = bufferedReader.readLine();
                            String name = bufferedReader.readLine();
                            String destinationID = bufferedReader.readLine();

                            /** Initializes new teleporting field - e.g. jail*/
                            board.set(i, new TeleportingField(ID, name, destinationID));
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