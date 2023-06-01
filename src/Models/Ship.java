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

    public Ship (){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Date getBaptismDate() {
        return baptismDate;
    }

    public void setBaptismDate(Date baptismDate) {
        this.baptismDate = baptismDate;
    }

    public Date getLastInspection() {
        return lastInspection;
    }

    public void setLastInspection(Date lastInspection) {
        this.lastInspection = lastInspection;
    }

    public Date getNextInspection() {
        return nextInspection;
    }

    public void setNextInspection(Date nextInspection) {
        this.nextInspection = nextInspection;
    }

    public Date getLastMaintenance() {
        return lastMaintenance;
    }

    public void setLastMaintenance(Date lastMaintenance) {
        this.lastMaintenance = lastMaintenance;
    }

    public Date getNextMaintenance() {
        return nextMaintenance;
    }

    public void setNextMaintenance(Date nextMaintenance) {
        this.nextMaintenance = nextMaintenance;
    }

    public double getLengthInMeters() {
        return lengthInMeters;
    }

    public void setLengthInMeters(double lengthInMeters) {
        this.lengthInMeters = lengthInMeters;
    }

    public double getWeightInTons() {
        return weightInTons;
    }

    public void setWeightInTons(double weightInTons) {
        this.weightInTons = weightInTons;
    }

    public int getMaxSpeedKnots() {
        return maxSpeedKnots;
    }

    public void setMaxSpeedKnots(int maxSpeedKnots) {
        this.maxSpeedKnots = maxSpeedKnots;
    }

    public Operation[] getHistory() {
        return history;
    }

    public void setHistory(Operation[] history) {
        this.history = history;
    }
}
