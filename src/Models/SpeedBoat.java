/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Data.DataOperations;

import java.io.File;
import java.io.Serializable;

public class SpeedBoat extends Ship implements Serializable {
    public int id; // Identifier of the Ship
    public static int lastID = 0;
    private int numberOfLifeVests; // Number of life vests on the SpeedBoat

    public SpeedBoat(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, OperationList history, int numberOfLifeVests) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.id = getNextId();
        this.numberOfLifeVests = numberOfLifeVests;
    }

    public static int getNextId() {
        File f = new File("navalCommandData.dat");
        if (f.exists()) {
            SpeedBoat[] container = DataOperations.load().getSpeedBoatContainer().getContainer();
            for (int i = container.length - 1; i > 0; i--) {
                if (container[i] != null) {
                    return container[i].getId() + 1;
                }
            }
            return 0;
        } else {
            return lastID++;
        }
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public int getNumberOfLifeVests() {
        return numberOfLifeVests;
    }

    public void setNumberOfLifeVests(int numberOfLifeVests) {
        this.numberOfLifeVests = numberOfLifeVests;
    }
}
