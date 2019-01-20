package pl.kpierczyk.monopoly.model.submodels.gameModel;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Board;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Dices;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.utilities.GameSaveInfo;




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

    private final String JailID = "#11";

    /** Reference to the parent-model.*/
    private final Model model;

    /** State of the game.*/
    private State state;

    /** Game board*/
    private Board board;

    /** Couple pf dices.*/
    private Dices dices;
    
    /** List of players*/
    private ArrayList<Player> players;

    /** Actual turn player's number*/
    private int actualPlayerNumber;

    /** Has player rolles dices this turn.*/
    boolean hasPlayerRolled;

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
        this.actualPlayerNumber = gameSaveInfo.getActualPlayerNumber();

        /** Get information if player rolled dices this turn.*/
        this.hasPlayerRolled = gameSaveInfo.isHasPlayerRolled();
    }


    /**
     * Returns number of the actual turn's player.
     * 
     * @return number of the actual turn's player.
     */
    public int getActualPlayerNumber() {
        return actualPlayerNumber;
    }

    /**
     * Returns true if player rolled dices this turn.
     * 
     * @return true if player rolled dices this turn.
     */
    public boolean isHasPlayerRolled() {
        return hasPlayerRolled;
    }









    /*****************************************/
    /*              Utilities                */
    /*****************************************/




    /**
     * Represents rolling dices by the player. Manages all possible
     * scenarios of player's move calling appropriate methods.
     */
    public void rollDices(){

        /** Check if player has rolled this turn*/
        if(!isHasPlayerRolled()){

            /** Simulate dices roll.*/
            boolean thirdDouble = dices.roll();

            /** Check if player should go to jail*/
            if(thirdDouble){
                goToJail();
                hasPlayerRolled = true;
                return;
            }
        }
    }


    /** 
     * Teleports actual player to the Jail.
    */
    public void goToJail(){
        this.players.get(actualPlayerNumber).setPositionID(JailID);
    }


    /*Movement utilities*/
    public boolean payRent(){
        return true;
    }
    public void collectMoney(){

    }
    public boolean payTax(){
        return true;
    }

    
    /*Cards drawing*/
    public boolean drawChanceCard(){
        return true;
    }
    public boolean drawDealCard(){
        return true;
    }


    /*Fields trade*/
    public boolean buyField(){
        return true;
    }
    public boolean putFieldOnAuction(){
        return true;
    }


    /*Field management*/
    public boolean pledgeField(){
        return true;
    }
    public boolean buybackField(){
        return true;
    }
    public boolean buildApartment(){
        return true;
    }
    public boolean buildHotel(){
        return true;
    }
    
    public boolean sellApartment(){
        return true;
    }
    public boolean sellHotel(){
        return true;
    }



    /** Finishing player's turn.*/
    public boolean endTurn(){
        return true;
    }
}