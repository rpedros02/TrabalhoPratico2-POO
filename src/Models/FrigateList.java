/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import java.io.Serializable;

public class FrigateList implements Serializable {
    public Frigate[] container;
    public int nFrigates = 0;

    public FrigateList() {
        container = new Frigate[4];
    }

    public Frigate[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds a {@link Frigate} to the container;
     *
     * @param newFrigate - {@link Frigate} to add to the container.
     */
    public void add(Frigate newFrigate) {
        if (nFrigates == container.length) {
            Frigate[] temp = new Frigate[nFrigates + 4];
            System.arraycopy(container, 0, temp, 0, nFrigates);
            container = temp;
        }
        container[nFrigates++] = newFrigate;
    }

    /**
     * Method that dynamically delets a {@link Frigate} from the container;
     *
     * @param object - object to delete.
     */
    public void delete(Frigate object) {
        Frigate[] temp = new Frigate[nFrigates];
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
