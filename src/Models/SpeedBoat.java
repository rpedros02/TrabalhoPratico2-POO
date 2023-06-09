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

import java.io.Serializable;

public class SpeedBoat extends Ship implements Serializable {
    private int numberOfLifeVests; // Number of life vests on the SpeedBoat

    public SpeedBoat(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, OperationList history, int numberOfLifeVests) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.numberOfLifeVests = numberOfLifeVests;
    }

    public int getNumberOfLifeVests() {
        return numberOfLifeVests;
    }

    public void setNumberOfLifeVests(int numberOfLifeVests) {
        this.numberOfLifeVests = numberOfLifeVests;
    }
}
