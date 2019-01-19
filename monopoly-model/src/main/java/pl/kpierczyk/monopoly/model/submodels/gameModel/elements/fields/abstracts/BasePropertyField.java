package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;

/**
 * Class representing Monopoly board's field that can be bought by players.
 * It is base class for specialized property Fields.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     Field
 */
public abstract class BasePropertyField extends Field{

    /** Price of the field when bought from bank.*/
    private final int price;

    /** Amount of cash that can be get for pledging field.*/
    private final int pledgeValue;

    /** Coefficient that pledge value is multiplied by when cost of buyback is calculated.*/
    private final double buybackMultiplier;

    /** Player who owns this field.*/
    private Player owner = null;

    /** State of popping of the field*/
    private boolean pledged = false;

    //<-- TO DO -->
    // Change way of passing arguments to the constructor
    // to make it more elegant - group some values into
    // group objects.

   /**
    * Initializes abstract base field for all buyable fields
    * on the Monopoly's board like train stations. 
    *
    * @param    ID
    * @param    name
    * @param    price
    * @param    pledgeValue
    * @param    buybackMultplier
    * @see      Field
    */
   public BasePropertyField(String ID, String name, int price,
                            int pledgeValue, double buybackMultiplier){
        super(ID, name);
        this.price = price;
        this.pledgeValue = pledgeValue;
        this.buybackMultiplier = buybackMultiplier;
    }

    /**
     * Returns base price of the field when bought
     * from bank.
     * 
     * @return the price
     */
    public int getPrice() {
        return price;
    }

    /**
     * Returns amount of cash that player gets when
     * pledge this field
     * 
     * @return the pledgeValue
     */
    public int getPledgeValue() {
        return pledgeValue;
    }

    /**
     * Returns coefficient that pledge value is multiplied by
     * when cost of buyback is calculated.
     * 
     * @return the buybackMultplier
     */
    public double getBuybackMultiplier() {
        return  buybackMultiplier;
    }

    /**
     * Returns cost of buyback field after pledging it.
     * 
     * @return the buybackCost
     */
    public final int getBuybackCost(){
        return (int)buybackMultiplier*pledgeValue;
    }

    /**
     * Returns owner of the field. Null if no owner exists.
     * 
     * @return the owner
     */
    public Player getOwner() {
        return owner;
    }

    /**
     * @return the pledged
     */
    public boolean isPledged() {
        return pledged;
    }






    


    /********************************/
    /*           Utilities          */
    /********************************/

    /**
     * Make it able for player to buy this field
     * if it's not bought yet.
     * 
     * @param buyer
     * @return information if first owner have been set
     */
    public boolean setOwner(Player buyer){
        if(owner != null)
            return false;
        else{
            owner = buyer;
            return true;
        }
    }

    /**
     * Make it able to change owner e.g. in case
     * of auction.
     * 
     * @param newOwner
     */
    public boolean changeOwner(Player newOwner){
        owner = newOwner;
        return true;
    }


    /**
     * Pledge the field if it's not pledged.
     * 
     * @return informations about if change was made.
     */
    public boolean pledge(){
        if(pledged == true)
            return false;
        else{
            pledged = true;
            return true;
        }
    }

    /**
     * Unpledge the field if it's pledged.
     * 
     * @return informations about if change was made.
     */
    public boolean unpledge(){
        if(pledged == false)
            return false;
        else{
            pledged = false;
            return true;
        }
    }
}