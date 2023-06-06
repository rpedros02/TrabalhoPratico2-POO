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

public class CrewList implements Serializable {

    public CrewMember[] container;

    public int nCrewMembers = 0;

    public CrewList() {
        container = new CrewMember[4];
    }

    public CrewMember[] getContainer() {
        return container;
    }

    public void add(CrewMember newCrewMember) {
        if (nCrewMembers == container.length) {
            CrewMember[] temp = new CrewMember[nCrewMembers + 4];
            System.arraycopy(container, 0, temp, 0, nCrewMembers);
            container = temp;
        }
        container[nCrewMembers++] = newCrewMember;
    }
}
