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
 * Class that represents a Mission and its attributes.
 */
public class Mission implements Serializable {
    private int id; // Mission Identifier
    private static int lastId; // Last Mission's Identifier
    private Date beginDate; // Mission begin Date
    private Date endMission; // Mission end Date
    private String missionBriefing; // Brief description of the mission
    private Date approvedDate; // Date of mission's approval
    private CrewMember approvedMember; // Person who approved the mission
    private CrewMember missionCrew[]; // Array of Crew Members that represents the Crew of the mission;

}
