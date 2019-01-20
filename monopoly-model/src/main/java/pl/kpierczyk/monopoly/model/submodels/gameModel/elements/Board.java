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
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields.ColourFieldsSet;
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
        this.groupFields();
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
            ArrayList<Field> potentialBoard = new ArrayList<Field>();
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
                        if(line.equals("START_FIELD")){

                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            int startBenefit = Integer.parseInt(bufferedReader.readLine());

                            potentialBoard.add(new StartField(ID, name, startBenefit));
                        }
                        /** ColourField initializing*/
                        else if(line.equals("COLOUR_FIELD")){

                            String ID;
                            String name;
                            int price;
                            int pledgeValue;
                            double buybackMultiplier;
                            
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
                            ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            
                            price = Integer.parseInt(bufferedReader.readLine());
                            pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            buybackMultiplier = Double.parseDouble(bufferedReader.readLine());

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
                            potentialBoard.add(new ColourField(ID, name, price, pledgeValue,
                                                         buybackMultiplier, prices, colour));
                        }
                        else if(line.equals("CARD_DRAW_FIELD")){
                            
                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            CardKind kind;

                            line = bufferedReader.readLine();
                            if(line.equals("CHANCE")){
                                kind = CardKind.chance;
                            }
                            else if(line.equals("DEAL")){
                                kind = CardKind.deal;
                            }
                            else
                                kind = CardKind.none;

                            /** Initializing new DrawCardField*/
                            potentialBoard.add(new CardDrawField(ID, name, kind));
                        }
                        else if(line.equals("TAX_FIELD")){
                            
                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            int taxValue = Integer.parseInt(bufferedReader.readLine());

                            /** Initializing new TaxField*/
                            potentialBoard.add(new TaxField(ID, name, taxValue));
                        }
                        else if(line.equals("TRAIN_STATION_FIELD")){
                            
                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            int price = Integer.parseInt(bufferedReader.readLine());
                            int pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            double buybackMultiplier = Double.parseDouble(bufferedReader.readLine());
                            int baseRent = Integer.parseInt(bufferedReader.readLine());

                            /** Initializing new TrainSTationField*/
                            potentialBoard.add(new TrainStationField(ID, name, price, pledgeValue,
                                                               buybackMultiplier, baseRent));
                        }
                        else if(line.equals("NEUTRAL_FIELD")){
                            
                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");

                            /** Initializes new NeutralField*/
                            potentialBoard.add(new NeutralField(ID, name));
                            
                        }
                        else if(line.equals("SPECIAL_PROPERTY_FIELD")){
                            
                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            int price = Integer.parseInt(bufferedReader.readLine());
                            int pledgeValue = Integer.parseInt(bufferedReader.readLine());
                            double buybackMultiplier = Double.parseDouble(bufferedReader.readLine());
                            int baseMultiplier = Integer.parseInt(bufferedReader.readLine());
                            int setMultiplier = Integer.parseInt(bufferedReader.readLine());

                            /** Initializes new NeutralField*/
                            potentialBoard.add(new SpecialPropertyField(ID, name, price, pledgeValue, 
                                                                  buybackMultiplier, baseMultiplier, setMultiplier));
                        }
                        else if(line.equals("TELEPORTING_FIELD")){

                            String ID = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String name = new String(bufferedReader.readLine().getBytes(), "UTF-8");
                            String destinationID = new String(bufferedReader.readLine().getBytes(), "UTF-8");

                            /** Initializes new teleporting field - e.g. jail*/
                            potentialBoard.add(new TeleportingField(ID, name, destinationID));
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




    /**
     * Groups colour fields into coulr sets
     */
    public boolean groupFields(){
        if(board.size() == 40){
            if(((ColourField)board.get(1)).getSet() != null){
                    
                ColourFieldsSet brown = new ColourFieldsSet(Colours.BROWN, 2);
                ColourFieldsSet blue = new ColourFieldsSet(Colours.BLUE, 3);
                ColourFieldsSet pink = new ColourFieldsSet(Colours.PINK, 3);
                ColourFieldsSet orange = new ColourFieldsSet(Colours.ORANGE, 3);
                ColourFieldsSet red = new ColourFieldsSet(Colours.RED, 3);
                ColourFieldsSet yellow = new ColourFieldsSet(Colours.YELLOW, 3);
                ColourFieldsSet green = new ColourFieldsSet(Colours.GREEN, 3);
                ColourFieldsSet navy = new ColourFieldsSet(Colours.NAVY, 2);
            
                brown.setFirst((ColourField)board.get(1));
                brown.setSecond((ColourField)board.get(3));

                blue.setFirst((ColourField)board.get(6));
                blue.setSecond((ColourField)board.get(8));
                blue.setThird((ColourField)board.get(9));

                pink.setFirst((ColourField)board.get(11));
                pink.setSecond((ColourField)board.get(13));
                pink.setThird((ColourField)board.get(14));

                orange.setFirst((ColourField)board.get(16));
                orange.setSecond((ColourField)board.get(18));
                orange.setThird((ColourField)board.get(19));

                red.setFirst((ColourField)board.get(21));
                red.setSecond((ColourField)board.get(23));
                red.setThird((ColourField)board.get(24));

                yellow.setFirst((ColourField)board.get(26));
                yellow.setSecond((ColourField)board.get(27));
                yellow.setThird((ColourField)board.get(29));

                green.setFirst((ColourField)board.get(31));
                green.setSecond((ColourField)board.get(32));
                green.setThird((ColourField)board.get(34));

                navy.setFirst((ColourField)board.get(37));
                navy.setSecond((ColourField)board.get(39));


                brown.group();
                blue.group();
                pink.group();
                orange.group();
                red.group();
                yellow.group();
                green.group();
                navy.group();

                return true;
            }
            return true;
        }
        else return false;
    }
}