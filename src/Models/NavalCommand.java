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
    private CrewList crewMembers; // List of Crew Members
    private CaptainList captains; // List of Captains
    private FrigateList frigatesContainer; // List of Frigates
    private CorvetteList corvettes; // List of Corvettes
    private SpeedBoatList speedBoats; // List of Speed Boats
    private OperationList operationsContainer; // List of Operations

    public NavalCommand() {
    }

    public NavalCommand(String name) {
        setName(name);
    }

    public NavalCommand(String name, CrewList crewMembers, CaptainList captains, FrigateList frigates, CorvetteList corvettes, SpeedBoatList speedBoats, OperationList operationsContainer) {
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

    public CrewList getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(CrewList crewMembers) {
        this.crewMembers = crewMembers;
    }

    public CaptainList getCaptains() {
        return captains;
    }

    public void setCaptains(CaptainList captains) {
        this.captains = captains;
    }


    public void setFrigatesContainer(FrigateList frigatesContainer) {
        this.frigatesContainer = frigatesContainer;
    }

    public CorvetteList getCorvettes() {
        return corvettes;
    }

    public void setCorvettes(CorvetteList corvettes) {
        this.corvettes = corvettes;
    }

    public SpeedBoatList getSpeedBoats() {
        return speedBoats;
    }

    public void setSpeedBoats(SpeedBoatList speedBoats) {
        this.speedBoats = speedBoats;
    }

    public OperationList getOperationsContainer() {
        return operationsContainer;
    }

    public void setOperationsContainer(OperationList operationsContainer) {
        this.operationsContainer = operationsContainer;
    }

    public FrigateList getFrigatesContainer() {
        return frigatesContainer;
    }
}
