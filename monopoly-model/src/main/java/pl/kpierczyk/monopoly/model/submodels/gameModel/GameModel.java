package pl.kpierczyk.monopoly.model.submodels.gameModel;

import pl.kpierczyk.monopoly.model.Model;




/**
 * 
 * 
 * 
 * 
 * 
 * 
 */
public class GameModel {

    public enum State{
        _default
    }


    Model model;

    State state;

    //private MovementManagementModel movementManagementModel; //constructor gets particular field after movement
    //private InGameMenuModel inGameMenuModel;
    //private AuctionModel auctionModel;

    //private Board board;
    //private Dices dices; //remember how many doublets was
    //private Player players[];

    
    boolean hasPlayerRolled;


    public GameModel(Model model)
    {
        this.model = model;
    }

    

    /*****************************************/
    /*          Getters & setters            */
    /*****************************************/



    /*Bonus getters & setters*/


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




    public boolean endTurn(){
        return true;
    }
}