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
    public  String name; // Crew Member's Name
    public  Patent patent; // Crew Member's Patent
    public  Date dateOfBirth; // Crew Member's Date of Birth

    public CrewMember(String name, Patent patent, Date dateOfBirth) {
        this.id = lastId++;
        this.name = name;
        this.patent = patent;
        this.dateOfBirth = dateOfBirth;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Patent getPatent() {
        return patent;
    }

    public void setPatent(Patent patent) {
        this.patent = patent;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
