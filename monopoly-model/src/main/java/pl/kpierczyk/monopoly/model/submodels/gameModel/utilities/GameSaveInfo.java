package pl.kpierczyk.monopoly.model.submodels.gameModel.utilities;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Board;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.utilities.settings.Settings;

/**
 * Class representing saved state of the Game Model. Makes it able to
 * load game state from a file (first constructor) or to create new game
 * (second constructor).
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class GameSaveInfo{

    /** Start player's cash.*/
    private final int START_CASH = 15000;

    /** Game elements*/
    private Board board;
    private ArrayList<Player> players;

    /** Number of ongoing turn's player*/
    private int actualPlayerIndex;

    /** Points if player has rolled dices this turn.*/
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

    /**
     * Constructor enabling to load game from pointed
     * folder containing save files.
     * 
     * @param saveFolder
     */
    public GameSaveInfo(String saveFolder){

    }


    /**
     * Constructor enabling to create new game with pointed
     * language settings and players number.
     * 
     * @param playersNumber
     * @param settings
     */
    public GameSaveInfo(int playersNumber, Settings settings){

        /** Loading board with specified language.*/
        this.board = new Board(settings); 

        /** Creating players list.*/
        this.players = new ArrayList<Player>();
        for(int i = 0; i < playersNumber; i++){
            players.add(new Player("Player " + (i+1), this.board.getBoard().get(0).getID(),
                                    START_CASH, 0, i+1, false, true));
        }

        /** Initializing basic game infos.*/
        this.actualPlayerIndex = 0;
        hasPlayerRolled = false;

        hasToPay = false;
        toPay = 0;
        paymentSource = null;
    }

    /**
     * @return the players
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @return the board
     */
    public Board getBoard() {
        return board;
    }

    /**
     * @return the actualPlayerNumber
     */
    public int getActualPlayerIndex() {
        return actualPlayerIndex;
    }

    /**
     * @return the hasPlayerRolled
     */
    public boolean isHasPlayerRolled() {
        return hasPlayerRolled;
    }

    /**
     * @return the hasToPay
     */
    public boolean isHasToPay() {
        return hasToPay;
    }

    /**
     * @return the toPay
     */
    public int getToPay() {
        return toPay;
    }

    /**
     * @return the paymentSource
     */
    public String getPaymentSource() {
        return paymentSource;
    }
}