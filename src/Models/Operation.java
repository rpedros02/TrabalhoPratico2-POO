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

import Enums.OperationType;

import java.io.Serializable;

/**
 * Class that represents a Mission and its attributes.
 */
public class Operation implements Serializable {
    private int id; // Mission Identifier
    private static int lastId = 0; // Last Mission's Identifier
    private Date beginDate; // Mission begin Date
    private Date endMission; // Mission end Date
    private String missionBriefing; // Brief description of the mission
    private Date approvedDate; // Date of mission's approval
    private CrewMember approvingMember; // Person who approved the mission
    private Captain captain; // Operation Captain
    private CrewMember[] operationCrew; // Array of Crew Members that represents the Crew of the mission;
    private OperationType operationType; // Operation Type

    public Operation(Date beginDate, Date endMission, String missionBriefing, Date approvedDate,Captain captain, CrewMember approvingMember, CrewMember[] operationCrew, OperationType operationType) {
        this.id = lastId++;
        this.beginDate = beginDate;
        this.endMission = endMission;
        this.missionBriefing = missionBriefing;
        this.approvedDate = approvedDate;
        this.captain = captain;
        this.approvingMember = approvingMember;
        this.operationCrew = operationCrew;
        this.operationType = operationType;
    }
}
