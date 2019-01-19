package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.colourFields;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.Player;
import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.ColourField;

/**
 * Class representing set of ColourFields with the same colour. This class make
 * it easier to manipulate captive fields, delivering information about
 * monopolization, and possibility of building next apartment/hotel.
 * 
 * @author Krzysztof Pierczyk
 * @version 1.0
 * @since 1.0
 * @see ColourField
 */
public class ColourFieldsSet {

    /** Colour of the fields in set. */
    private final int colour;

    /** Size of the set.*/
    private final int size; 

    /** Set of CoolourField */
    private ColourField first = null;
    private ColourField second = null;
    private ColourField third = null;

    /** Statement about if group is monopolized. */
    private boolean captive;

    /** Owner of the group. Null if no monopolist. */
    private Player owner;

    /**
     * Initializes sets of ColourFields with the same colour.
     * 
     * @param colour
     * @see ColourField
     */
    public ColourFieldsSet(int colour, int size) {
        this.colour = colour;
        this.size = size;
    }

    /**
     * @return colour
     */
    public int getColour() {
        return colour;
    }

    /**
     * @return the size
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns first field from the group.
     * 
     * @return first
     */
    public ColourField getFirst() {
        return first;
    }

    /**
     * Returns second field from the group.
     * 
     * @return second
     */
    public ColourField getSecond() {
        return second;
    }

    /**
     * Returns third field from the group.
     * 
     * @return third
     */
    public ColourField getThird() {
        if(size == 3)
            return third;
        else
            return null;
    }

    /**
     * States if the set is captive by one player.
     * 
     * @return captive
     */
    public boolean isCaptive() {
        return captive;
    }

    /**
     * @param first the first to set
     */
    public boolean setFirst(ColourField first) {
        if(this.colour == first.getColour()){
            this.first = first;
            return true;
        }
        else return false;
    }

    /**
     * @param second the second to set
     */
    public boolean setSecond(ColourField second) {
        if(this.colour == second.getColour()){
            this.second = second;
            return true;
        }
        else return false;
    }

    /**
     * @param third the third to set
     */
    public boolean setThird(ColourField third) {
        if(size == 3){
            if(this.colour == third.getColour()){
                this.third = third;
                return true;
            }
            else return false;
        }
        else return false;
    }





    /********************************/
    /* Utilities */
    /********************************/


    /**
     * Return owner of the whole set. Null returned if not owner exists.
     * 
     * @return owner
     */
    public Player getMonopolist() {
        if (isCaptive())
            return owner;
        else
            return null;
    }


    /**
     * Set refference to this set inside all ColourFields in set.
     * 
     * @see ColourField
     */
    public void group(){
        if(this.first != null)
            first.setSet(this);
        if(this.second != null)
            second.setSet(this);

        if(size == 3){
            if(this.third != null)
                third.setSet(this);
        }
    }


    /**
     * Updates information about monopolisation and sets values of owner and
     * captive.
     * 
     * @return updated information about monopolisation of the set.
     * @see Player
     */
    public boolean updateOwner() {
        Player firstOwner = first.getOwner();
        Player secondOwner = second.getOwner();
        Player thirdOwner = third.getOwner();

        if(size == 3){
            if (firstOwner != null && secondOwner != null && thirdOwner != null) {
                if (firstOwner == secondOwner && secondOwner == thirdOwner && firstOwner == thirdOwner) {
                    this.captive = true;
                    this.owner = firstOwner;
                    return true;
                } else {
                    this.captive = false;
                    this.owner = null;
                    return false;
                }

            } else {
                this.captive = false;
                this.owner = null;
                return false;
            }
        }
        else{
            if (firstOwner != null && secondOwner != null) {
                if (firstOwner == secondOwner) {
                    this.captive = true;
                    this.owner = firstOwner;
                    return true;
                } 
                else {
                    this.captive = false;
                    this.owner = null;
                    return false;
                }

            } 
            else {
                this.captive = false;
                this.owner = null;
                return false;
            }
        }
    }


    /**
     * Check if pointed field can be upbuilt. Throws an exception
     * if pointed field is not i the set.
     * 
     * @param   field
     * @return  statement if field can be downbuilt
     * @throws  Exception
     * @see     ColourField
     */
    public boolean canUpbuild(ColourField field) throws Exception {
        if(this.captive){
            if (field == first) {
                if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                    if (field.isHotel())
                        return false;
                    else {
                        int apartmentsNumber = field.getApartmentsNumber();
                        if (apartmentsNumber <= second.getApartmentsNumber()
                                && apartmentsNumber <= third.getApartmentsNumber())
                            return true;
                        else return false;
                    }
                } else return false;
            }
            else if (field == second) {
                if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                    if (field.isHotel())
                        return false;
                    else {
                        int apartmentsNumber = field.getApartmentsNumber();
                        if (apartmentsNumber <= first.getApartmentsNumber()
                                && apartmentsNumber <= third.getApartmentsNumber())
                            return true;
                        else return false;
                    }
                } else return false;
            }
            else if(size == 3){
                if (field == third) {
                    if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                        if (field.isHotel())
                            return false;
                        else {
                            int apartmentsNumber = field.getApartmentsNumber();
                            if (apartmentsNumber <= first.getApartmentsNumber()
                                    && apartmentsNumber <= second.getApartmentsNumber())
                                return true;
                            else return false;
                        }
                    }else return false;
                } 
                else throw new Exception();
            }
            else return false;
        }
        else return false;
    }


    /**
     * Check if pointed field can be downbuilt. Throws an exception
     * if pointed field is not i the set.
     * 
     * @param   field
     * @return  statement if field can be downbuilt
     * @throws  Exception
     * @see     ColourField
     */
    public boolean canDownbuild(ColourField field) throws Exception {
        if (field == first) {
            if(field.isBuilt()){
                if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                    if (field.isHotel())
                        return true;
                    else {
                        int apartmentsNumber = field.getApartmentsNumber();
                        if (apartmentsNumber >= second.getApartmentsNumber()
                                && apartmentsNumber >= third.getApartmentsNumber())
                            return true;
                        else 
                            return false;
                    }
                } else return true;
            } else return false;

        }
        else if (field == second) {
            if(field.isBuilt()){
                if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                    if (field.isHotel())
                        return true;
                    else {
                        int apartmentsNumber = field.getApartmentsNumber();
                        if (apartmentsNumber >= first.getApartmentsNumber()
                                && apartmentsNumber >= third.getApartmentsNumber())
                            return true;
                        else 
                            return false;
                    }
                } else return true;
            } else return false;
        }
        else if(size == 3){
            if (field == third) {
                if(field.isBuilt()){
                    if(!first.isPledged() && !second.isPledged() && !third.isPledged()){
                        if (field.isHotel())
                            return true;
                        else {
                            int apartmentsNumber = field.getApartmentsNumber();
                            if (apartmentsNumber >= first.getApartmentsNumber()
                                    && apartmentsNumber >= second.getApartmentsNumber())
                                return true;
                            else 
                                return false;
                        }
                    } else return true;
                } else return false;
            } 
            else throw new Exception();
        }
        else return false;
    }


    /**
     * Returns true if something is built on fields from the set.
     * 
     * @return true if something is built on fields from the set.
     */
    public boolean isBuilt(){
        if(size == 3){
            if(first.isBuilt() || second.isBuilt() || third.isBuilt())
                return true;
            else return false;
        }
        else{
            if(first.isBuilt() || second.isBuilt())
                return true;
            else return false;
        }
    }

}