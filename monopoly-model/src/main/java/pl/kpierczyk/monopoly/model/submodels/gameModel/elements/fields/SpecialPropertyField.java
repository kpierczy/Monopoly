package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.BasePropertyField;

/**
 * Class representing special properties whose rent is based
 * on a number of points that visitor rolled during their turn.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     BasePropertyField
 */
public class SpecialPropertyField extends BasePropertyField{

    /** Base multiplier for calculating rent. */
    private final int baseMultiplier;

    /** Multiplier for calculating rent when both special fields are owned by the player. */
    private final int setMultiplier;

    /** Static collection of all stations on the board. */
    private static final ArrayList<SpecialPropertyField> specialFields =
        new ArrayList<SpecialPropertyField>();

    

    /**
     * Initializes special properties whose rent is based
     * on a number of points that visitor rolled during their turn.
     * 
     * @param   ID
     * @param   name
     * @param   price
     * @param   pledgeValue
     * @param   buybackMultplier
     * @param   baseMultiplier
     * @param   setMultiplier
     * @see     BasePropertyField
     */
    public SpecialPropertyField(String ID, String name, int price,
                             int pledgeValue, int buybackMultplier,
                             int baseMultiplier, int setMultiplier){
        super(ID, name, price, pledgeValue, buybackMultplier);
        this.baseMultiplier = baseMultiplier;
        this.setMultiplier = setMultiplier;
        this.specialFields.add(this);
    }


    /**
     * @return the baseMultiplier
     */
    public int getBaseMultiplier() {
        return baseMultiplier;
    }

    /**
     * @return the setMultiplier
     */
    public int getSetMultiplier() {
        return setMultiplier;
    }


    /**
     * Returns amount of cash that should be paid by a visitor
     * basing on the number rolled during their turn.
     * 0 returned when no owner.
     * 
     * @param rolledValue
     * @return
     */
    public int getActualRent(int rolledValue){
        int ownedSpecials = 0;
        for(SpecialPropertyField special: specialFields){
            if(special.getOwner() == this.getOwner())
                ownedSpecials++;
        }

        if(ownedSpecials == 1)
            return baseMultiplier*rolledValue;
        else if(ownedSpecials == 2)
            return setMultiplier*rolledValue;
        else
            return 0;        
    }
}