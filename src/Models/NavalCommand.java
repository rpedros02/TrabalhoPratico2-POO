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
 * Class that refers and saves all the data from the Naval Command.
 */
public class NavalCommand implements Serializable {
    private String name; // Naval Command's name
    private CrewMember[] crewMembers; // List of Crew Members
    private Captain[] captains; // List of Captains
    private Frigate[] frigatesContainer; // List of Frigates
    private Corvette[] corvettes; // List of Corvettes
    private SpeedBoat[] speedBoats; // List of Speed Boats
    private Operation[] operationsContainer; // List of Operations

    public NavalCommand(String name, CrewMember[] crewMembers, Captain[] captains, Frigate[] frigates, Corvette[] corvettes, SpeedBoat[] speedBoats, Operation[] operationsContainer) {
        this.name = name;
        this.crewMembers = crewMembers;
        this.captains = captains;
        this.frigatesContainer = frigates;
        this.corvettes = corvettes;
        this.speedBoats = speedBoats;
        this.operationsContainer = operationsContainer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CrewMember[] getCrewMembers() {
        return crewMembers;
    }

    public Captain[] getCaptains() {
        return captains;
    }

    public Frigate[] getFrigatesContainer() {
        return frigatesContainer;
    }

    public Corvette[] getCorvettes() {
        return corvettes;
    }

    public SpeedBoat[] getSpeedBoats() {
        return speedBoats;
    }

    public Operation[] getOperationsContainer() {
        return operationsContainer;
    }
}
