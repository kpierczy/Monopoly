package pl.kpierczyk.monopoly.model.utilities.settings;

import pl.kpierczyk.monopoly.model.utilities.settings.settingsKinds.*;

/**
 * Simple interface determining way of communicating
 * with settings objects.
 * 
 * @author  Krzysztof Pierczyk
 * @version 1.0
 * @since   1.0
 * @see     BooleanSetting
 * @see     SelectSetting
 * @see     InRangeSetting
 * @see     PathSetting
 */
public interface Setting {


    /**
     * Returns actual value of the setting.
     * 
     * @return actual value of the setting.
     */
    Object getValue();

    /**
     * Setts actual value of the setting.
     * 
     * @param value
     * @return true if change performed.
     */
    boolean setValue(Object value);

    /**
     * Returns array of all possible values of
     * the setting.
     * 
     * @return array of all possible values of the setting.
     */
    Object[] getPossibleValues();



    /*****************************************/
    /*              Utilities                */
    /*****************************************/

    /**
     * Changes values for the "next" possible.
     * 
     * @return true if value change was possible.
     */
    boolean nextValue();

    /**
     * Changes values for the "previous" possible.
     * 
     * @return true if value change was possible.
     */
    boolean previousValue();
}