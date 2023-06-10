/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import java.io.Serializable;

public class CaptainList implements Serializable {
    public Captain[] container;

    public int nCaptains = 0;

    public CaptainList() {
        container = new Captain[4];
    }

    public Captain[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds a {@link Captain} to the container;
     * @param newCaptain - {@link Captain} to add to the container.
     */
    public void add(Captain newCaptain) {
        if (nCaptains == container.length) {
            Captain[] temp = new Captain[nCaptains + 4];
            System.arraycopy(container, 0, temp, 0, nCaptains);
            container = temp;
        }
        container[nCaptains++] = newCaptain;
    }

    /**
     * Method that dynamically delets a {@link Captain} from the container;
     * @param object - object to delete.
     */
    public void delete(Captain object) {
        Captain[] temp = new Captain[nCaptains];
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
