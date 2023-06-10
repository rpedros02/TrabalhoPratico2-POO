/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Data.DataOperations;
import Enums.OperationPorpuse;
import Enums.OperationType;

import java.io.File;
import java.io.Serializable;

/**
 * Class that represents a Mission and its attributes.
 */
public class Operation implements Serializable {
    private int id; // Mission Identifier
    private static int lastID = 0; // Last Mission's Identifier
    private Date beginDate; // Mission begin Date
    private Date endMission; // Mission end Date
    private String missionBriefing; // Brief description of the mission
    private OperationPorpuse operationPorpuse; //Operation porpuse being National, OTAN or UN.
    private Date approvedDate; // Date of mission's approval
    private CrewMember approvingMember; // Person who approved the mission
    private Captain captain; // Operation Captain
    private CrewList operationCrew; // Array of Crew Members that represents the Crew of the mission;
    private OperationType operationType; // Operation Type

    public Operation(Date beginDate, Date endMission, String missionBriefing, Date approvedDate, Captain captain, CrewMember approvingMember, CrewList operationCrew, OperationType operationType,OperationPorpuse operationPorpuse) {
        this.id = getNextId();
        this.beginDate = beginDate;
        this.endMission = endMission;
        this.missionBriefing = missionBriefing;
        this.approvedDate = approvedDate;
        this.captain = captain;
        this.approvingMember = approvingMember;
        this.operationCrew = operationCrew;
        this.operationType = operationType;
    }

    public Operation(){
        this.id = getNextId();
        this.operationCrew = new CrewList();
    }

    public static int getNextId() {
        File f = new File("navalCommandData.dat");
        if (f.exists()) {
            Operation[] container = DataOperations.load().getOperationsContainer().getContainer();
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
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(Date beginDate) {
        this.beginDate = beginDate;
    }

    public Date getEndMission() {
        return endMission;
    }

    public void setEndMission(Date endMission) {
        this.endMission = endMission;
    }

    public String getMissionBriefing() {
        return missionBriefing;
    }

    public void setMissionBriefing(String missionBriefing) {
        this.missionBriefing = missionBriefing;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }

    public CrewMember getApprovingMember() {
        return approvingMember;
    }

    public void setApprovingMember(CrewMember approvingMember) {
        this.approvingMember = approvingMember;
    }

    public Captain getCaptain() {
        return captain;
    }

    public void setCaptain(Captain captain) {
        this.captain = captain;
    }

    public CrewList getOperationCrew() {
        return operationCrew;
    }

    public void setOperationCrew(CrewList operationCrew) {
        this.operationCrew = operationCrew;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }

    public void setOperationPorpuse(OperationPorpuse operationPorpuse) {
        this.operationPorpuse = operationPorpuse;
    }

    public OperationPorpuse getOperationPorpuse() {
        return operationPorpuse;
    }

    public OperationType getOperationType() {
        return operationType;
    }
}
