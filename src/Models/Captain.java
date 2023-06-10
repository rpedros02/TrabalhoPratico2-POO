/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Enums.Patent;

import java.io.Serializable;

/**
 * Class that represents a specific type of {@link CrewMember}.
 */
public class Captain extends CrewMember implements Serializable {
    private MedalList medals; // An Array of Strings that keeps track of a Captain's Medals

    public Captain(String name, Patent patent, Date dateOfBirth, MedalList medals) {
        super(name, patent, dateOfBirth);
        this.medals = medals;
    }

    public Captain(){
        super();
        this.medals = new MedalList();
    }
    public MedalList getMedals() {
        return medals;
    }
}
