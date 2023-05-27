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

import Enums.Patent;

import java.io.Serializable;

/**
 * Class that represents a generic Crew Member.
 */
public class CrewMember implements Serializable {
    public int id; // Crew Member Identifier
    private static int lastId = 0; // Last Crew Member Identifier
    private String name; // Crew Member's Name
    private Patent patent; // Crew Member's Patent
    private Date dateOfBirth; // Crew Member's Date of Birth

    public CrewMember(String name, Patent patent, Date dateOfBirth) {
        this.id = lastId++;
        this.name = name;
        this.patent = patent;
        this.dateOfBirth = dateOfBirth;
    }
}
