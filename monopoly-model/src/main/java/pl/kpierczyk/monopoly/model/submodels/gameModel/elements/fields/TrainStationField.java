package pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields;

import java.util.ArrayList;

import pl.kpierczyk.monopoly.model.submodels.gameModel.elements.fields.BasePropertyField;

/**
 * Class representing train station field on the Monopoly's board.
 * There are 4 stations that can be collected. The more stations
 * player has the higher rent is to be paid by visitors.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 */
public class TrainStationField extends BasePropertyField{

    /** Base rent (per owned station) that is paid when player visits field. */
    private final int baseRent;

    /** Static collection of all stations on the board. */
    private static final ArrayList<TrainStationField> stations =
        new ArrayList<TrainStationField>();

    
    /**
     * Initializes TrainStationField with pointed base rent value
     * that should be paid by visitors per every owned station.
     * 
     * @param   ID
     * @param   name
     * @param   price
     * @param   pledgeValue
     * @param   buybackMultplier
     * @param   baseRent
     * @see     BasePropertyField
     */
    public TrainStationField(String ID, String name, int price,
                             int pledgeValue, int buybackMultplier,
                             int baseRent){
        super(ID, name, price, pledgeValue, buybackMultplier);
        this.baseRent = baseRent;
        this.stations.add(this);
    }


    /**
     * Returns base rent (per owned station) that is paid
     * when player visits field.
     * 
     * @return  the baseRrent (per owned station)
     * @see     TrainStationField
     */
    public int getBaseRent() {
        return baseRent;
    }


    /**
     * Returns actual rent that should be paid for the actual owner
     * when this field is visited. Actual rent depends on number
     * of stations possessed by the owner. Returns 0 when no owner.
     * 
     * @return  actual rent price of actual owner of the station.
     * @see     BasePropertyField
     */
    public int getActualRent(){
        int ownedStations = 0;
        for(TrainStationField station: stations){
            if(station.getOwner() == this.getOwner())
                ownedStations++;
        }

        return ownedStations*baseRent;
    }
}