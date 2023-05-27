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
 * Class that represents a specific type of {@link CrewMember}.
 */
public class Captain extends CrewMember implements Serializable {
    private String[] medals; // An Array of Strings that keeps track of a Captain's Medals

    public Captain(String name, Patent patent, Date dateOfBirth, String[] medals) {
        super(name, patent, dateOfBirth);
        this.medals = medals;
    }
}
