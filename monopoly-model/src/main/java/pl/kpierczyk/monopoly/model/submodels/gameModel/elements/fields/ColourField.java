package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.abstracts.BasePropertyField;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields.ColourFieldCashInfo;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields.ColourFieldsSet;

/**
 * Class representing colourfull properties on the Monopoly's
 * board. These fields' characteristic point is possibility
 * to build apartments and hotels on it. 
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     BasePropertyField
 */
public class ColourField extends BasePropertyField{

    /** Field's colour */
    private final int colour;

    /** Base rent (no set collected) that is paid when player visits field. */
    private final int baseRent;

    /** 
     * Multipiller of the base rent that is used to calculate rent
     * when full set is collected by the one player that is paid
     * when player visits field. 
     */
    private final int fullsetRentMultipiller;
    
    /**Rent value when one apartment is built. */
    private final int oneApartmentRent;
    
    /**Rent value when two apartmenta are built. */
    private final int twoApartmentsRent;
    
    /**Rent value when three apartmenta are built. */
    private final int threeApartmentsRent;
    
    /**Rent value when four apartmenta are built. */
    private final int fourApartmentsRent;
    
    /**Rent value when a hotel is built. */
    private final int hotelRent;
    
    /**Cost of the single apartment. */
    private final int apartmentCost;
    
    /**Cost of a hotel. */
    private final int hotelCost;
    

    /**Number of apartments built on the field. Value 5 means that hotel is built.*/
    private int apartmentsNumber = 0;

    /**Information about if hotel is built. */
    private boolean hotel = false;

    /**Set of the fields with the same colour. */
    private ColourFieldsSet set = null;


    /**
     * Initializes colour buyable field on the Monopoly's board.
     * This kind of field can be gathered in to colour set by one owner
     * which makes him able to get higher rent and build apartments 
     * and hotels. 
     *
     * @param ID
     * @param name
     * @param price
     * @param pledgeValue
     * @param buybackMultiplier
     * @param prices
     * @param colour
     * @see     BasePropertyField
     * @see     ColourFieldCashInfo
     * @see     ColourFieldsSet
     */
    public ColourField(String ID, String name, int price, int pledgeValue,
                       double buybackMultiplier, ColourFieldCashInfo prices,
                       int colour){
        super(ID, name, price, pledgeValue, buybackMultiplier);
        this.colour = colour;

        this.baseRent = prices.getBaseRent();
        this.fullsetRentMultipiller = prices.getFullsetRentMultipiller();
    
        this.oneApartmentRent = prices.getOneApartmentRent();
        this.twoApartmentsRent = prices.getTwoApartmentsRent();
        this.threeApartmentsRent = prices.getThreeApartmentsRent();
        this.fourApartmentsRent = prices.getFourApartmentsRent();
        this.hotelRent = prices.getHotelRent();
    
        this.apartmentCost = prices.getApartmentCost();
        this.hotelCost = prices.getHotelCost();
    }



    
    /**
     * @return the colour
     */
    public int getColour() {
        return colour;
    }

    /**
     * 
     * @return the baseRent
     */
    public int getBaseRent() {
        return baseRent;
    }

    /**
     * @return the fullSetRentMultipiller
     */
    public int getFullsetRentMultipiller() {
        return fullsetRentMultipiller;
    }

    /**
     * @return the oneApartmentRent
     */
    public int getOneApartmentRent() {
        return oneApartmentRent;
    }
    
    /**
     * @return the twoApartmentsRent
     */
    public int getTwoApartmentsRent() {
        return twoApartmentsRent;
    }

    /**
     * @return the threeApartmentsRent
     */
    public int getThreeApartmentsRent() {
        return threeApartmentsRent;
    }

    /**
     * @return the fourApartmentsRent
     */
    public int getFourApartmentsRent() {
        return fourApartmentsRent;
    }

    /**
     * @return the hotelRent
     */
    public int getHotelRent() {
        return hotelRent;
    }

    /**
     * @return the apartmentCost
     */
    public int getApartmentCost() {
        return apartmentCost;
    }

    /**
     * @return the hotelCost
     */
    public int getHotelCost() {
        return hotelCost;
    }

    /**
     * Returns number of apartments buuild on the field.
     * Value 5 means that hotel is built.
     * 
     * @return the apartmentsNumber
     */
    public int getApartmentsNumber() {
        return apartmentsNumber;
    }

    /**
     * @return the hotel
     */
    public boolean isHotel() {
        return hotel;
    }

    /**
     * @return the set
     */
    public ColourFieldsSet getSet() {
        return set;
    }



    /**
     * Set's group that this field is signed
     * for.
     * 
     * @param set the set to set
     */
    public boolean setSet(ColourFieldsSet set) {
        if (this.colour == set.getColour()){
            this.set = set;
            return true;
        }
        else return false;
    }    





    /********************************/
    /*           Utilities          */
    /********************************/

    /**
     * 
     * @return statement about if something is built on the field.
     */
    public boolean isBuilt(){
        return (getApartmentsNumber() > 0);
    }


    public int getActualRent(){
        int actualRent = 0;
        if(set.isCaptive()){
            if(isBuilt()){
                if(!isHotel()){
                    if(apartmentsNumber == 1)
                        actualRent = oneApartmentRent;
                    else if(apartmentsNumber == 2)
                        actualRent = twoApartmentsRent;
                    else if(apartmentsNumber == 3)
                        actualRent = threeApartmentsRent;
                    else if(apartmentsNumber == 4)
                        actualRent = fourApartmentsRent;
                }
                else
                    actualRent = hotelRent;
            }
            else
                actualRent = baseRent * fullsetRentMultipiller;
        }
        else 
            actualRent = baseRent;

        return actualRent;
    }



    /**
     * Redefines changeOwner(Player) from BasePropertyField
     * so that new conditions like apartaments built.
     * 
     * @param   newOwner
     * @return  statement about if change has been succesfull
     * @see     BasePropertyField
     */
    @Override
    public boolean changeOwner(Player newOwner) {
        if(this.set.isBuilt())
            return false;
        else
            return this.changeOwner(newOwner);
    }


    /**
     * 
     * @return  information if apartment was added
     */
    public boolean buildApartment(){
        if(this.apartmentsNumber < 4){
            try{
                if(this.set.canUpbuild(this)){
                    this.apartmentsNumber++;
                    return true;
                }
                else return false;
            }
            catch (Exception ex){
                return false;
            }
        } else return false;
    }

    /**
     * 
     * @return  information if apartment was subtracted
     */
    public boolean knockApartment(){
        if(!this.hotel){
            try{
                if(this.set.canDownbuild(this)){
                    this.apartmentsNumber--;
                    return true;
                }
                else return false;
            }
            catch (Exception ex){
                return false;
            }
        } else return false; 
    }

    /**
     * 
     * @return  information if hotel was added
     */
    public boolean buildHotel(){
        if(this.apartmentsNumber == 4){
            try{
                if(this.set.canUpbuild(this)){
                    this.apartmentsNumber++;
                    this.hotel = true;
                    return true;
                }
                else return false;
            }
            catch (Exception ex){
                return false;
            }
        } else return false;
    }

    /**
     * 
     * @return  information if apartment was subtracted
     */
    public boolean knockHotel(){
        if(this.hotel){
            try{
                if(this.set.canDownbuild(this)){
                    this.apartmentsNumber--;
                    this.hotel = false;
                    return true;
                }
                else return false;
            }
            catch (Exception ex){
                return false;
            }
        } else return false; 
    }
}   