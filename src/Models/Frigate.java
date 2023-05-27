/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */
package Models;

import Enums.Equipment;
import Enums.FrigateType;

import java.io.Serializable;

public class Frigate extends Ship implements Serializable {
    private FrigateType frigateType; // Frigate Type
    private Equipment[] equipment; // Frigate equipment

    public Frigate(String name,String manufacturer,Date baptismDate,Date lastInspection, Date nextInspection, Date lastMaintenance,Date nextMaintenance,double lengthInMeters, double weightInTons,int maxSpeedKnots, Operation[] history,FrigateType frigateType, Equipment[] equipment) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.frigateType = frigateType;
        this.equipment = equipment;
    }
}
