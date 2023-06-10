/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
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

    /**
     * Method that dynamically adds a {@link CrewMember} to the container;
     * @param newCrewMember - {@link CrewMember} to add to the container.
     */
    public void add(CrewMember newCrewMember) {
        if (nCrewMembers == container.length) {
            CrewMember[] temp = new CrewMember[nCrewMembers + 4];
            System.arraycopy(container, 0, temp, 0, nCrewMembers);
            container = temp;
        }
        container[nCrewMembers++] = newCrewMember;
    }

    /**
     * Method that dynamically delets a {@link CrewMember} from the container;
     * @param object - object to delete.
     */
    public void delete(CrewMember object) {
        CrewMember[] temp = new CrewMember[nCrewMembers];
        for (int i = 0; i < (container.length - 1); i++) {
            if (container[i] != null) {
                if (container[i].getId() != object.getId()) {
                    temp[i] = container[i];
                }
            }
        }
        container = temp;
    }
}
