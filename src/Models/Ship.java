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
    private static int lastId; // Last Ship's ID
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
    private Mission[] history; // Ship Mission History - Array of Missions


}
