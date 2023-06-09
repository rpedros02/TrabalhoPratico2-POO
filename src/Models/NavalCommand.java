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
    private CrewList crewMemberContainer; // List of Crew Members
    private CaptainList captainContainer; // List of Captains
    private FrigateList frigatesContainer; // List of Frigates
    private CorvetteList corvetteContainer; // List of Corvettes
    private SpeedBoatList speedBoatContainer; // List of Speed Boats
    private OperationList operationsContainer; // List of Operations

    public NavalCommand() {
        setCrewMemberContainer(new CrewList());
        setCaptainContainer(new CaptainList());
        setFrigatesContainer(new FrigateList());
        setCorvetteContainer(new CorvetteList());
        setSpeedBoatContainer(new SpeedBoatList());
        setOperationsContainer(new OperationList());
    }

    public NavalCommand(String name) {
        setName(name);
        setCrewMemberContainer(new CrewList());
        setCaptainContainer(new CaptainList());
        setFrigatesContainer(new FrigateList());
        setCorvetteContainer(new CorvetteList());
        setSpeedBoatContainer(new SpeedBoatList());
        setOperationsContainer(new OperationList());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CrewList getCrewMemberContainer() {
        return crewMemberContainer;
    }

    public void setCrewMemberContainer(CrewList crewMemberContainer) {
        this.crewMemberContainer = crewMemberContainer;
    }

    public CaptainList getCaptainContainer() {
        return captainContainer;
    }

    public void setCaptainContainer(CaptainList captainContainer) {
        this.captainContainer = captainContainer;
    }


    public void setFrigatesContainer(FrigateList frigatesContainer) {
        this.frigatesContainer = frigatesContainer;
    }

    public CorvetteList getCorvetteContainer() {
        return corvetteContainer;
    }

    public void setCorvetteContainer(CorvetteList corvetteContainer) {
        this.corvetteContainer = corvetteContainer;
    }

    public SpeedBoatList getSpeedBoatContainer() {
        return speedBoatContainer;
    }

    public void setSpeedBoatContainer(SpeedBoatList speedBoatContainer) {
        this.speedBoatContainer = speedBoatContainer;
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
