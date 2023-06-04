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
    private FrigateList frigatesContainer; // List of Frigates
    private Corvette[] corvettes; // List of Corvettes
    private SpeedBoat[] speedBoats; // List of Speed Boats
    private Operation[] operationsContainer; // List of Operations

    public NavalCommand() {
    }

    public NavalCommand(String name) {
        setName(name);
    }

    public NavalCommand(String name, CrewMember[] crewMembers, Captain[] captains, FrigateList frigates, Corvette[] corvettes, SpeedBoat[] speedBoats, Operation[] operationsContainer) {
        setName(name);
        setCrewMembers(crewMembers);
        setCaptains(captains);
        setFrigatesContainer(frigates);
        setCorvettes(corvettes);
        setSpeedBoats(speedBoats);
        setOperationsContainer(operationsContainer);
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

    public void setCrewMembers(CrewMember[] crewMemxbers) {
        this.crewMembers = crewMemxbers;
    }

    public Captain[] getCaptains() {
        return captains;
    }

    public void setCaptains(Captain[] captains) {
        this.captains = captains;
    }


    public void setFrigatesContainer(FrigateList frigatesContainer) {
        this.frigatesContainer = frigatesContainer;
    }

    public Corvette[] getCorvettes() {
        return corvettes;
    }

    public void setCorvettes(Corvette[] corvettes) {
        this.corvettes = corvettes;
    }

    public SpeedBoat[] getSpeedBoats() {
        return speedBoats;
    }

    public void setSpeedBoats(SpeedBoat[] speedBoats) {
        this.speedBoats = speedBoats;
    }

    public Operation[] getOperationsContainer() {
        return operationsContainer;
    }

    public void setOperationsContainer(Operation[] operationsContainer) {
        this.operationsContainer = operationsContainer;
    }

    public FrigateList getFrigatesContainer() {
        return frigatesContainer;
    }
}
