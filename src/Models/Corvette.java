/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Data.DataOperations;
import Enums.CorvetteType;

import java.io.File;
import java.io.Serializable;

public class Corvette extends Ship implements Serializable {
    public int id; // Identifier of the Ship
    private static int lastID = 0; // Last Ship's ID
    private CorvetteType corvetteType; // Corvette Type
    private int numberOfLifeVests; // Number of life vests on the Corvette

    public Corvette(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, OperationList history, CorvetteType corvetteType, int numberOfLifeVests) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.id = getNextId();
        this.corvetteType = corvetteType;
        this.numberOfLifeVests = numberOfLifeVests;
    }

    public Corvette() {
        super();
    }

    public static int getNextId() {
        File f = new File("navalCommandData.dat");
        if (f.exists()) {
            Corvette[] container = DataOperations.load().getCorvetteContainer().getContainer();
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

    public CorvetteType getCorvetteType() {
        return corvetteType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCorvetteType(CorvetteType corvetteType) {
        this.corvetteType = corvetteType;
    }

    public int getNumberOfLifeVests() {
        return numberOfLifeVests;
    }

    public void setNumberOfLifeVests(int numberOfLifeVests) {
        this.numberOfLifeVests = numberOfLifeVests;
    }

    @Override
    public String toString() {
        return "\nCorvette ID: " + id +
                "\nCorvette Type: " + CorvetteType.toString(corvetteType) +
                "\nName: " + name +
                "\nManufacturer: " + manufacturer +
                "\nBaptism Date: " + baptismDate.toString() +
                "\nLast Inspection Date: " + lastInspection.toString() +
                "\nNext Inspection Date: " + nextInspection.toString() +
                "\nLast Maintenance Date: " + lastMaintenance.toString() +
                "\nNext Maintenance Date: " + nextMaintenance.toString() +
                "\nLength(meters): " + lengthInMeters +
                "\nWeight(tons): " + weightInTons +
                "\nMax Speed(knots): " + maxSpeedKnots +
                "\nNumber of Live vests: " + numberOfLifeVests + "\n----------";

    }
}
