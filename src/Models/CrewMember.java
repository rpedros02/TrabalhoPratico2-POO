/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Data.DataOperations;
import Enums.Patent;

import java.io.File;
import java.io.Serializable;

/**
 * Class that represents a generic Crew Member.
 */
public class CrewMember implements Serializable {
    public int id; // Crew Member Identifier
    private static int lastId = 0; // Last Crew Member Identifier
    public String name; // Crew Member's Name
    public Patent patent; // Crew Member's Patent
    public Date dateOfBirth; // Crew Member's Date of Birth

    public CrewMember(String name, Patent patent, Date dateOfBirth) {
        this.id = getNextId();
        this.name = name;
        this.patent = patent;
        this.dateOfBirth = dateOfBirth;
    }

    public CrewMember() {
        this.id = getNextId();
    }

    public static int getNextId() {
        File f = new File("navalCommandData.dat");
        if (f.exists()) {
            CrewMember[] container = DataOperations.load().getCrewMemberContainer().getContainer();
            for (int i = container.length - 1; i > 0; i--) {
                if (container[i] != null) {
                    return container[i].getId() + 1;
                }
            }
            return 0;
        } else {
            return lastId++;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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

    @Override
    public String toString() {
        return "ID: " + id +
                "\nName: " + name +
                "\nPatent: " + Patent.toString(patent) +
                "\nDate of Birth: " + dateOfBirth.toString();
    }
}
