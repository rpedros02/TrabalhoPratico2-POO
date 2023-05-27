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

/**
 * Class that refers to a generic Ship.
 */
public abstract class Ship implements Serializable {
    public int id; // Identifier of the Ship
    private static int lastId = 0; // Last Ship's ID
    public String name; // Ship's Name
    private String manufacturer; // Ship Manufacturer
    private Date baptismDate; // Ship Baptism Date
    private Date lastInspection; // Ship Last Inspection Date
    private Date nextInspection; // Ship Next Inspection Date
    private Date lastMaintenance; // Ship Last Maintenance Date
    private Date nextMaintenance; // Ship Next Maintenance Date
    private double lengthInMeters; // Ship Length in Meters
    private double weightInTons; // Ship weight in Tons
    private int maxSpeedKnots; // Ship Max Speed in Knots
    private Operation[] history; // Ship Operation History - Array of Missions


    protected Ship(String name, String manufacturer, Date baptismDate, Date lastInspection, Date nextInspection, Date lastMaintenance, Date nextMaintenance, double lengthInMeters, double weightInTons, int maxSpeedKnots, Operation[] history) {
        this.id = lastId++;
        this.name = name;
        this.manufacturer = manufacturer;
        this.baptismDate = baptismDate;
        this.lastInspection = lastInspection;
        this.nextInspection = nextInspection;
        this.lastMaintenance = lastMaintenance;
        this.nextMaintenance = nextMaintenance;
        this.lengthInMeters = lengthInMeters;
        this.weightInTons = weightInTons;
        this.maxSpeedKnots = maxSpeedKnots;
        this.history = history;
    }

    public String getName(){
        return this.name;
    }

}
