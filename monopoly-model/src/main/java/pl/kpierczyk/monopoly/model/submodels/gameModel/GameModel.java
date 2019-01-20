package pl.kpierczyk.monopoly.model.submodels.gameModel;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.Model;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Board;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Dices;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.StartField;
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

    /** Id of the Jail field.*/
    private final String JailID = "#11";

    /** Fee to pay to get out of jail.*/
    private final int JailFee = 500;

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
    private int actualPlayerIndex;

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
        this.actualPlayerIndex = gameSaveInfo.getActualPlayerIndex();

        /** Get information if player rolled dices this turn.*/
        this.hasPlayerRolled = gameSaveInfo.isHasPlayerRolled();
    }


    /**
     * Returns number of the actual turn's player.
     * 
     * @return number of the actual turn's player.
     */
    public int getactualPlayerIndex() {
        return actualPlayerIndex;
    }

    /**
     * Returns true if player rolled dices this turn.
     * 
     * @return true if player rolled dices this turn.
     */
    public boolean isHasPlayerRolled() {
        return hasPlayerRolled;
    }

    private Player getActualPlayer(){
        return players.get(actualPlayerIndex);
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

            /** Player in jail*/
            if(getActualPlayer().isInJail()){

                /** Try to get double.*/
                dices.roll();

                /** If succed rolling double.*/
                if(dices.isDouble()){
                    movePlayer();
                    causeFieldEffect();
                    return;
                }
                else{
                    /** Player cannot roll anymore this turn.*/
                    hasPlayerRolled = true;

                    /** If player spent 3 turns in jail they must pay and move.*/
                    if(getActualPlayer().getTurnsInJail() == 3){
                        payJail();
                        getActualPlayer().setInJail(false);
                        movePlayer();
                        causeFieldEffect(); 
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

                    /** Trigger effect of staying at actual field.*/
                    causeFieldEffect();
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
     * stands upon.
     */
    public void causeFieldEffect(){

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
        if(hasPlayerRolled){

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