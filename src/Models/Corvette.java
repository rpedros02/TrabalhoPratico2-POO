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

import Enums.CorvetteType;

import java.io.Serializable;

public class Corvette extends Ship implements Serializable {
    public int id; // Identifier of the Ship
    private static int lastId = 0; // Last Ship's ID
    private CorvetteType corvetteType; // Corvette Type
    private int numberOfLifeVests; // Number of life vests on the Corvette

    public Corvette(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, Operation[] history, CorvetteType corvetteType, int numberOfLifeVests) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.id = lastId++;
        this.corvetteType = corvetteType;
        this.numberOfLifeVests = numberOfLifeVests;
    }
}
