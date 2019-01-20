package pl.kpierczyk.monopoly.model.submodels.gameModel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Board;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Card;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Dices;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.CardDrawField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.ColourField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.SpecialPropertyField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.StartField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TaxField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TeleportingField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.TrainStationField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.CardDrawField.CardKind;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts.Field;
import pl.kpierczyk.monopoly.model.submodels.gameModel.utilities.GameSaveInfo;
import pl.kpierczyk.monopoly.model.utilities.menu.Menu;




/**
 * Class managing informations about the application when
 * the game is running. It covers info about board, players,
 * opened submodels etc.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class GameModel {

    /** Main game states.*/
    public enum State{
        _default, menu, auction, trade, buyoutDecision
    }

    /** Id of the Jail field.*/
    private final String JailID = "#11";

    /** Fee to pay to get out of jail.*/
    private final int JailFee = 500;

    /** Reference to the parent-model.*/
    private final Model model;

    private final Menu gameMenu;

    /** State of the game.*/
    private State state;

    /** Game board*/
    private Board board;

    /** Couple pf dices.*/
    private Dices dices;
    
    /** List of players*/
    private ArrayList<Player> players;

    /** Actual turn player's number*/
    private int actualPlayerIndex;

    /** Has player rolles dices this turn.*/
    private boolean hasPlayerRolled;

    /** States if player must pay something before they end turn.*/
    /** Payment source can be in three states:                   */
    /**     "Jail"                                               */
    /**     "Banker"                                             */
    /**     "Player's name"                                      */
    /** establishing subject to pay.                             */
    private boolean hasToPay;
    private int toPay;
    private String paymentSource;

    private final String JAIL_SOURCE = "Jail";
    private final String BANKER_SOURCE = "Banker";

    /** MenuModel handling menu services in the in-game panel.*/
    //private InGameMenuModel inGameMenuModel;

    /** Object managing making buyout decision by the player vising buyable field.*/
    //private BuyoutDecisionModel;

    /** Object managing auctions performed when player quit buying parcel.*/
    //private AuctionModel auctionModel;

    /** Model managing attempts of players to sell certain goodies to other players.*/
    /** Attempts of trade can be prtected by the players security keys.*/
    //private SellModel sellModel;

    /**
     * Initializes new game basing on GameSaveInfo object. GameSaveInfo object
     * has two constructors that make it able to either load game from the save files
     * or create new game, which normalizes interface of initializing GameModel.
     * 
     * @param   model
     * @param   gameSaveInfo
     * @see     Model
     * @see     GameSaveInfo
     */
    public GameModel(Model model, GameSaveInfo gameSaveInfo){
        
        /** Save reference to parent-model.*/
        this.model = model;

        /** Set default game state.*/
        this.state = State._default;

        /** Copy board object from GameSaveInfo object*/
        this.board = gameSaveInfo.getBoard();

        /** Create new couple of dices.*/
        this.dices = new Dices();

        /** Copy player's list.*/
        this.players = gameSaveInfo.getPlayers();

        /** Get number of player that should have their turn now.*/
        this.actualPlayerIndex = gameSaveInfo.getActualPlayerIndex();

        /** Get information if player rolled dices this turn.*/
        this.hasPlayerRolled = gameSaveInfo.isHasPlayerRolled();

        /** Get information if player has some debts.*/
        this.hasToPay = gameSaveInfo.isHasToPay();

        /** Get information about amount of debt.*/
        this.toPay = gameSaveInfo.getToPay();

        /** Get source of the debt.*/
        this.paymentSource = gameSaveInfo.getPaymentSource();


        /*Menu initializing*/
        String textPath = "/lang/" +
                           this.model.getSettings().getLanguage() +
                           "/interfaceTexts/gameMenu.txt";

        String fieldsText[] = new String[7];

        try {
            BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(textPath)));

            String line;
            for(int i = 0; i < fieldsText.length; i++){
                if((line = bufferedReader.readLine()) != null){
                    fieldsText[i] = new String(line.getBytes(), "UTF-8");
                }
            }

            bufferedReader.close();
        }
        catch (IOException ex) {
            System.out.println("Error reading file '" + textPath + "'");
        }

        this.gameMenu = new Menu(fieldsText, 7);
    }



    /**
     * Returns state of the GameModel.
     * 
     * @return state of the GameModel.
     */
    public State getState() {
        return state;
    }


    /** 
     * Returns refference to the board.
     * 
     * @return refference to the board.
     */
    public Board getBoard() {
        return board;
    }


    /**
     * Returns refference to the ArrayList of players.
     * 
     * @return refference to the ArrayList of players.
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }
    
    /**
     * Returns true if player rolled dices this turn.
     * 
     * @return true if player rolled dices this turn.
     */
    public boolean isHasPlayerRolled() {
        return hasPlayerRolled;
    }


    /**
     * Returns refference to the actual turn's player object.
     * 
     * @return refference to the actual turn's player object.
     */
    private Player getActualPlayer(){
        return players.get(actualPlayerIndex);
    }


    /**
     * @return the gameMenu
     */
    public Menu getGameMenu() {
        return gameMenu;
    }






    /*****************************************/
    /*              Utilities                */
    /*****************************************/


    /**
     * Represents rolling dices by the player. Manages all possible
     * scenarios of player's movement. After calling this function,
     * causeFieldEffect should be called next.
     */
    public void rollDices(){

        /** Check if player has rolled this turn and if they owe something.*/
        if(!hasPlayerRolled && !hasToPay){

            /** Player in jail*/
            if(getActualPlayer().isInJail()){

                /** Try to get double.*/
                dices.roll();

                /** If succed rolling double.*/
                if(dices.isDouble()){
                    movePlayer();
                    return;
                }
                else{
                    /** Player cannot roll anymore this turn.*/
                    hasPlayerRolled = true;

                    /** If player spent 3 turns in jail they must pay and move.*/
                    if(getActualPlayer().getTurnsInJail() == 3){
                        
                        /** If player could afford Jail fee.*/
                        if(payJail()){
                            getActualPlayer().setInJail(false);
                            movePlayer();
                        }
                        return;  
                    }
                    return;
                }
            }



            /** Players out of jail.*/
            else{
                
                /** Simulate dices roll.*/
                boolean thirdDouble = dices.roll();

                /** Check if player should go to jail*/
                if(thirdDouble){
                    goToJail();
                    hasPlayerRolled = true;
                    return;
                }
                /** If no third double*/
                else{

                    String startPositionID = 
                        getActualPlayer().getPositionID();

                    /** Check if double*/
                    if(!dices.isDouble()){
                        /** Make player unable to roll one more time.*/
                        hasPlayerRolled = true;
                    }

                    movePlayer();

                    /** Check if player crossed Start field. If so, they get Start Bonus.*/
                    checkStartCrossing(startPositionID);
                    return;
                }
            }
        }
        else return;
    }

    /**
     * Moves actual player basing on the actual position and
     * actual values of dices.
     */
    public void movePlayer(){

        /** Set players position.*/
        getActualPlayer().setPositionID(
            /** Actual Player's position index*/
            board.getBoard().get(
                (
                    /** Index of the field tha player stands on.*/
                    board.getFieldsNumberByID(
                        getActualPlayer().getPositionID()
                    ) +
                
                    /** + sum of dices.*/
                    dices.getFirst() + dices.getSecond()
                
                /** Cut to the modulo(size of the board).*/
                ) % board.BOARD_SIZE 
            ).getID()
        );
    }

    /** 
     * Teleports actual player to the Jail. Sets inJail flag
     * on the player.
    */
    public void goToJail(){
        this.players.get(actualPlayerIndex).setPositionID(JailID);
        getActualPlayer().setInJail(true);
    }

    /**
     * Checks if player crossed Start field during their roll. If so
     * they receive Start Bonus.
     * 
     * @param startPositionID
     */
    public void checkStartCrossing(String startPositionID){
        int startIndex = 
            board.getFieldsNumberByID(startPositionID);
        int finishIndex = 
            board.getFieldsNumberByID(
                getActualPlayer().getPositionID()
            );

        /** If player crossed start field.*/
        if(startIndex > finishIndex)
            /** Give Start benefit to the player.*/
            getActualPlayer().give( 
                ((StartField) board.getBoard().get(0)).
                    getStartBenefit()
            );
    }

    /**
     * Trigger effect of the field that actual players
     * stands upon. This method should be called by the
     * controller.
     * 
     * 
     */

     /**
     * Trigger effect of the field that actual players
     * stands upon. This method should be called by the
     * controller. Parameter want to buy should be true
     * if player is eager to buy field and false in other
     * cases.
     * 
     * @param wantToBuy
     */
    public void causeFieldEffect(boolean wantToBuy){
        Field actualField = 
            board.getFieldByID(
                getActualPlayer().getPositionID());


        /** Handling colour fields.*/
        if(actualField instanceof ColourField){
            ColourField colourField = (ColourField) actualField;
            
            if(colourField.getOwner() == null){
                if(wantToBuy){
                    if(getActualPlayer().getCash() >= colourField.getPrice()){
                        getActualPlayer().takeAway(colourField.getPrice());
                        colourField.setOwner(getActualPlayer());
                    }
                }
                //else
                    //startAuction();
            }
            else if(colourField.getOwner() != getActualPlayer()){
                getActualPlayer().takeAway(colourField.getActualRent());
                
                if(getActualPlayer().getCash() < 0){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = colourField.getOwner().getName();
                    colourField.getOwner().give(colourField.getActualRent() + 
                                                getActualPlayer().getCash());
                }
                else
                    colourField.getOwner().give(colourField.getActualRent());
            }
        }
        /** Handling Train Stations.*/
        else if(actualField instanceof TrainStationField){
            TrainStationField trainStation = 
                (TrainStationField) actualField;

            if(trainStation.getOwner() == null){
                if(wantToBuy){
                    if(getActualPlayer().getCash() >= trainStation.getPrice()){
                        getActualPlayer().takeAway(trainStation.getPrice());
                        trainStation.setOwner(getActualPlayer());
                    }
                }
                //else
                    //startAuction();
            }
            else if(trainStation.getOwner() != getActualPlayer()){
                getActualPlayer().takeAway(trainStation.getActualRent());
                
                if(getActualPlayer().getCash() < 0){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = trainStation.getOwner().getName();
                    trainStation.getOwner().give(trainStation.getActualRent() + 
                                                getActualPlayer().getCash());
                }
                else
                    trainStation.getOwner().give(trainStation.getActualRent());
            }
        }
        /** Handling Special properties*/
        else if(actualField instanceof SpecialPropertyField){
            SpecialPropertyField specialPropety = 
                (SpecialPropertyField) actualField;

            if(specialPropety.getOwner() == null){
                if(wantToBuy){
                    if(getActualPlayer().getCash() >= specialPropety.getPrice()){
                        getActualPlayer().takeAway(specialPropety.getPrice());
                        specialPropety.setOwner(getActualPlayer());
                    }
                }
                //else
                    //startAuction();
            }
            else if(specialPropety.getOwner() != getActualPlayer()){
                getActualPlayer().takeAway(specialPropety.getActualRent(dices.getFirst() + dices.getSecond()));
                
                if(getActualPlayer().getCash() < 0){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = specialPropety.getOwner().getName();
                    specialPropety.getOwner().give(specialPropety.getActualRent(dices.getFirst() + dices.getSecond()) + 
                                                getActualPlayer().getCash());
                }
                else
                    specialPropety.getOwner().give(specialPropety.getActualRent(dices.getFirst() + dices.getSecond()));
            }
        }
        /** Handling Card draw fields.*/
        else if(actualField instanceof CardDrawField ){
            if(((CardDrawField) actualField).getKind() == CardKind.chance){
                drawChance();
            }
            else if(((CardDrawField) actualField).getKind() == CardKind.deal){
                drawDeal();
            }
        }
        /** Handling Tax fields.*/
        else if(actualField instanceof TaxField){
            int taxAmount = ((TaxField) actualField).getTaxValue();
            if(!getActualPlayer().takeAway(taxAmount)){
                hasToPay = true;
                toPay = Math.abs(getActualPlayer().getCash());
                paymentSource = BANKER_SOURCE;
            }
        }
        /** Handling "Go to jail" field.*/
        else if(actualField instanceof TeleportingField){
            getActualPlayer().setPositionID(JailID);
            getActualPlayer().setInJail(true);
        }
    }


    /**
     * Take away JailFee from the player. If the player cannot afford
     * fee hasToPay counter is set and appropriate informations about
     * debt are saved.
     */
    public boolean payJail(){
        if(getActualPlayer().takeAway(JailFee)){
            return true;
        }
        else{
            hasToPay = true;
            toPay += Math.abs(getActualPlayer().getCash());
            paymentSource = JAIL_SOURCE;
            return false;
        }
    }
    






    /** 
     * Draws card from the ChanceStack and trigger the effect of
     * the drawn card.
    */
    private void drawChance(){
        Card drawnCard = board.getChanceCards().draw();
        String startPositionID;
        int payAmount;

        switch(drawnCard.getEffect()){
            case Card.CH_GET_1000:
                getActualPlayer().give(1000);
                break;

            case Card.CH_GET_1500:
                getActualPlayer().give(1500);
                break;

            case Card.CH_GET_500:
                getActualPlayer().give(500);
                break;

            case Card.CH_GET_OUT_OF_JAIL:
                getActualPlayer().addOutOfJailNumber();
                break;

            case Card.CH_GO_BACK_3:
                int actualIndex = board.getFieldsNumberByID(
                    getActualPlayer().getPositionID()
                );

                int destinationIndex = 0;
                if(actualIndex - 3 >=0)
                    destinationIndex = actualIndex - 3;
                else
                    destinationIndex = 40 - (3 - actualIndex);
                getActualPlayer().setPositionID(
                    board.getBoard().get(destinationIndex).getID()
                );
                break;

            case Card.CH_GO_TO_FIRST_PINK:
                startPositionID = 
                            getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(11).getID()
                );
                checkStartCrossing(startPositionID);
                break;

            case Card.CH_GO_TO_FIRST_STATION:
                startPositionID = 
                            getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(5).getID()
                );
                checkStartCrossing(startPositionID);
                break;

            case Card.CH_GO_TO_JAIL:
                getActualPlayer().setPositionID(
                    board.getBoard().get(10).getID()
                );
                getActualPlayer().setInJail(true);
                break;

            case Card.CH_GO_TO_SECOND_NAVY:
                startPositionID = 
                            getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(39).getID()
                );
                checkStartCrossing(startPositionID);
                break;

            case Card.CH_GO_TO_START:
                startPositionID = 
                            getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(0).getID()
                );
                checkStartCrossing(startPositionID);
                break;

            case Card.CH_GO_TO_THIRD_RED:
                startPositionID = 
                            getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(24).getID()
                );
                checkStartCrossing(startPositionID);
                break;

            case Card.CH_PAY_150:
                payAmount = 150;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;

            case Card.CH_PAY_1500:
                payAmount = 1500;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;

            case Card.CH_PAY_200:
                payAmount = 200;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;

            case Card.CH_PAY_250A_1000H:
                for(int i = 0; i < board.BOARD_SIZE; i++){
                    Field field = board.getBoard().get(i);
                    if(field instanceof ColourField){
                        ColourField colourField = 
                            (ColourField) field;
                        if(colourField.getOwner() == getActualPlayer()){
                            getActualPlayer().takeAway(250*colourField.getApartmentsNumber());
                            if(colourField.isHotel()){
                                getActualPlayer().takeAway(750);
                            }
                        }
                    }
                }
                if(getActualPlayer().getCash() < 0){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;

            case Card.CH_PAY_400A_1150H:
                for(int i = 0; i < board.BOARD_SIZE; i++){
                    Field field = board.getBoard().get(i);
                    if(field instanceof ColourField){
                        ColourField colourField = 
                            (ColourField) field;
                        if(colourField.getOwner() == getActualPlayer()){
                            getActualPlayer().takeAway(400*colourField.getApartmentsNumber());
                            if(colourField.isHotel()){
                                getActualPlayer().takeAway(750);
                            }
                        }
                    }
                }
                if(getActualPlayer().getCash() < 0){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;
        }

    }



    private void drawDeal(){
        Card drawnCard = board.getChanceCards().draw();
        String startPositionID;
        int payAmount;

        switch(drawnCard.getEffect()){
            case Card.D_BACK_TO_START:
                startPositionID = 
                    getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(0).getID()
                );
                checkStartCrossing(startPositionID);
                break;
            
            case Card.D_GET_100:
                getActualPlayer().give(100);
                break;
            
            case Card.D_GET_1000_1:
                getActualPlayer().give(1000);
                break;
            
            case Card.D_GET_1000_2:
                getActualPlayer().give(1000);
                break;
            
            /*<-- TO DO --> */
            /** Check if players than have been taken away money can afford it.*/
            case Card.D_GET_100_PER_PLAYER:
                for(int i = 0; i < players.size(); i++){
                    if(players.get(i).isInGame()){
                        players.get(i).takeAway(100);
                        getActualPlayer().give(100);
                    }
                }
                break;
            
            case Card.D_GET_200:
                getActualPlayer().give(1000);
                break;
            
            case Card.D_GET_2000:
                getActualPlayer().give(2000);
                break;
            
            case Card.D_GET_250:
                getActualPlayer().give(250);
                break;
            
            case Card.D_GET_500:
                getActualPlayer().give(500);
                break;
                
            
            case Card.D_GET_OUT_OF_JAIL:
                getActualPlayer().addOutOfJailNumber();
                break;
            
            case Card.D_GO_TO_FIRST_BROWN:
                startPositionID = 
                    getActualPlayer().getPositionID();

                getActualPlayer().setPositionID(
                    board.getBoard().get(1).getID()
                );
                checkStartCrossing(startPositionID);
                break;
            
            case Card.D_GO_TO_JAIL:
                getActualPlayer().setPositionID(
                    board.getBoard().get(10).getID()
                );
                getActualPlayer().setInJail(true);
                break;
            
            case Card.D_PAY_1000:
                payAmount = 100;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;
            
            /*<-- TO DO -->*/
            /** Give possibility to draw chance card.*/
            case Card.D_PAY_100_OR_CHANCE:
                payAmount = 100;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;
            
            case Card.D_PAY_500_1:
                payAmount = 500;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;
            
            case Card.D_PAY_500_2:
                payAmount = 500;
                if(!getActualPlayer().takeAway(payAmount)){
                    hasToPay = true;
                    toPay = Math.abs(getActualPlayer().getCash());
                    paymentSource = BANKER_SOURCE;
                }
                break;
        }
    }
























    /**
     * Finishes turn of the player. Checks if the next player on
     * the list is still in game and if they are not, look for the
     * next player on the list. Increment turnInJail counter on the
     * player of they stay in jail.
     * 
     * @return false if player has not rolled this turn.
     */
    public boolean endTurn(){

        /** Player can finish turn only when they rolled.*/
        /** Player cannot finish turn when owe something.*/
        if(hasPlayerRolled && !hasToPay){

            /** If the next player on the list is in game.*/
            if(players.get((actualPlayerIndex + 1) % players.size()).
                isInGame()){

                /** If player is in Jail add one to the turnInJail counter*/
                if(getActualPlayer().isInJail())
                    getActualPlayer().nextTurnInJail();
                
                /** Change actual player index to the next*/
                actualPlayerIndex = (actualPlayerIndex + 1) % players.size();

                /** Reset flag hasPlayerRolled for the player beggining turn.*/
                hasPlayerRolled = false;

                return true;
            }
            /** If the next player is out of game.*/
            else{
                /** Increment actualPlayerIndex*/
                actualPlayerIndex = (actualPlayerIndex + 1) % players.size();

                /** Look for the next player on the list.*/
                return endTurn();
            }
        }
        else return false;
    }
}