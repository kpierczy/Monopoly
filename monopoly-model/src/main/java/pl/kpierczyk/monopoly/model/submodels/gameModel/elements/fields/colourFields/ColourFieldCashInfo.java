package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.ColourField;

/**
 * Class containing informations about cost parameters of
 * ColourField properties. It is used to initialize new
 * ColourField object.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     ColourField
 */
public class ColourFieldCashInfo{

    /** Base rent (no set collected) that is paid when player visits field. */
    private int baseRent;

    /** 
     * Multipiller of the base rent that is used to calculate rent
     * when full set is collected by the one player that is paid
     * when player visits field. 
     */
    private int fullsetRentMultipiller;

    /**Rent value when one apartment is built. */
    private int oneApartmentRent;

    /**Rent value when two apartmenta are built. */
    private int twoApartmentsRent;

    /**Rent value when three apartmenta are built. */
    private int threeApartmentsRent;

    /**Rent value when four apartmenta are built. */
    private int fourApartmentsRent;

    /**Rent value when a hotel is built. */
    private int hotelRent;

    /**Cost of the single apartment. */
    private int apartmentCost;

    /**Cost of a hotel. */
    private int hotelCost;

    /**
     * Initializes container structure that is used to initialize
     * ColourField.
     * 
     * @see ColourField
     */
    public ColourFieldCashInfo(){
        this.baseRent = 0;
        this.fullsetRentMultipiller = 0;
    
        this.oneApartmentRent = 0;
        this.twoApartmentsRent = 0;
        this.threeApartmentsRent = 0;
        this.fourApartmentsRent = 0;
        this.hotelRent = 0;
    
        this.apartmentCost = 0;
        this.hotelCost = 0;
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
     * @param baseRent the baseRent to set
     */
    public void setBaseRent(int baseRent) {
        this.baseRent = baseRent;
    }

    /**
     * @param fullsetRentMultipiller the fullsetRentMultipiller to set
     */
    public void setFullsetRentMultipiller(int fullsetRentMultipiller) {
        this.fullsetRentMultipiller = fullsetRentMultipiller;
    }

    /**
     * @param oneApartmentRent the oneApartmentRent to set
     */
    public void setOneApartmentRent(int oneApartmentRent) {
        this.oneApartmentRent = oneApartmentRent;
    }

    /**
     * @param twoApartmentsRent the twoApartmentsRent to set
     */
    public void setTwoApartmentsRent(int twoApartmentsRent) {
        this.twoApartmentsRent = twoApartmentsRent;
    }

    /**
     * @param threeApartmentsRent the threeApartmentsRent to set
     */
    public void setThreeApartmentsRent(int threeApartmentsRent) {
        this.threeApartmentsRent = threeApartmentsRent;
    }

    /**
     * @param fourApartmentsRent the fourApartmentsRent to set
     */
    public void setFourApartmentsRent(int fourApartmentsRent) {
        this.fourApartmentsRent = fourApartmentsRent;
    }

    /**
     * @param hotelRent the hotelRent to set
     */
    public void setHotelRent(int hotelRent) {
        this.hotelRent = hotelRent;
    }

    /**
     * @param apartmentCost the apartmentCost to set
     */
    public void setApartmentCost(int apartmentCost) {
        this.apartmentCost = apartmentCost;
    }

    /**
     * @param hotelCost the hotelCost to set
     */
    public void setHotelCost(int hotelCost) {
        this.hotelCost = hotelCost;
    }    
}