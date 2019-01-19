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
    private final int START_CASH = 1500;

    /** Game elements*/
    private Board board;
    private ArrayList<Player> players;

    /** Number of ongoing turn's player*/
    private int actualPlayerNumber;

    /** Points if player has rolled dices this turn.*/
    private boolean hasPlayerRolled;


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
        this.players = new ArrayList<Player>(playersNumber);
        for(int i = 0; i < players.size(); i++){
            players.set(i, new Player("Player " + (i+1), this.board.getBoard().get(0).getID(),
                                       START_CASH, 0, i+1, false));
        }

        /** Initializing basic game infos.*/
        this.actualPlayerNumber = 0;
        hasPlayerRolled = false;
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
    public int getActualPlayerNumber() {
        return actualPlayerNumber;
    }

    /**
     * @return the hasPlayerRolled
     */
    public boolean isHasPlayerRolled() {
        return hasPlayerRolled;
    }
}