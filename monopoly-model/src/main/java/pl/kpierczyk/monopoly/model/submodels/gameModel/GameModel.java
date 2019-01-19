package pl.kpierczyk.monopoly.model.submodels.gameModel;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Board;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Dices;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.utilities.GameSaveInfo;




/**
 * 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class GameModel {

    public enum State{
        _default, menu, auction
    }


    /** Reference to model.*/
    Model model;

    /** State of the gameplay.*/
    State state;

    /** Game board*/
    private Board board;

    /** Couple pf dices.*/
    private Dices dices; //remember how many doublets was
    
    /** List of players*/
    private ArrayList<Player> players;

    /** Actual turn player's number*/
    private int actualPlayerNumber;

    /** Has player rolles dices this turn.*/
    boolean hasPlayerRolled;

    //private MovementManagementModel movementManagementModel; //constructor gets particular field after movement
    //private InGameMenuModel inGameMenuModel;
    //private AuctionModel auctionModel;


    /**
     * Initializes new game basing on GameSaveInfo object.
     * 
     * @param   model
     * @param   gameSaveInfo
     * @see     Model
     * @see     GameSaveInfo
     */
    public GameModel(Model model, GameSaveInfo gameSaveInfo){
        this.model = model;
        this.state = State._default;
        this.board = gameSaveInfo.getBoard();
        this.dices = new Dices();
        this.players = gameSaveInfo.getPlayers();
        this.actualPlayerNumber = gameSaveInfo.getActualPlayerNumber();
        this.hasPlayerRolled = gameSaveInfo.isHasPlayerRolled();
    }


    



    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    public void rollDices(){

    }


    public void goTo(){ 

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