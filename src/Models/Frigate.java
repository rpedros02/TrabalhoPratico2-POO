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

import Data.DataOperations;
import Enums.FrigateType;

import java.io.File;
import java.io.Serializable;


public class Frigate extends Ship implements Serializable {
    public int id; // Identifier of the Ship
    public static int lastID = 0;
    private FrigateType frigateType; // Frigate Type
    private EquipmentList equipment; // Frigate equipment

    public Frigate(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, OperationList history, FrigateType frigateType, EquipmentList equipment) {
        super(name, manufacturer, baptismDate, lastInspection, nextInspection, lastMaintenance, nextMaintenance, lengthInMeters, weightInTons, maxSpeedKnots, history);
        this.id = getNextId();
        this.frigateType = frigateType;
        this.equipment = equipment;
    }

    public Frigate() {
        super();
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FrigateType getFrigateType() {
        return frigateType;
    }

    public void setFrigateType(FrigateType frigateType) {
        this.frigateType = frigateType;
    }

    public EquipmentList getEquipment() {
        return equipment;
    }

    public void setEquipment(EquipmentList equipment) {
        this.equipment = equipment;
    }

    public static int getNextId() {
        File f = new File("navalCommandData.dat");
        if (f.exists()) {
            Frigate[] container = DataOperations.load().getFrigatesContainer().getContainer();
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

    @Override
    public String toString() {
        return "\nFrigate ID: " + id +
                "\nFrigate Type: " + FrigateType.toString(frigateType) +
                "\nName: " + name +
                "\nManufacturer: " + manufacturer +
                "\nBaptism Date: " + baptismDate.toString() +
                "\nLast Inspection Date: " + lastInspection.toString() +
                "\nNext Inspection Date: " + nextInspection.toString() +
                "\nLast Maintenance Date: " + lastMaintenance.toString() +
                "\nNext Maintenance Date: " + nextMaintenance.toString() +
                "\nLength(meters): " + lengthInMeters +
                "\nWeight(tons): " + weightInTons +
                "\nMax Speed(knots): " + maxSpeedKnots + "\n----------";

    }
}
