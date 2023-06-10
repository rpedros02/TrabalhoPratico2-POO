/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import java.io.Serializable;

public class MedalList implements Serializable {

    public String[] container;
    private int nMedals = 0;

    public MedalList() {
        container = new String[4];
    }

    public String[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds a Medal to the container;
     * @param newMedal - Medal to add to the container.
     */
    public void add(String newMedal) {
        if (nMedals == container.length) {
            String[] temp = new String[nMedals + 4];
            System.arraycopy(container, 0, temp, 0, nMedals);
            container = temp;
        }
        container[nMedals++] = newMedal;
    }

    /**
     * Method that dynamically delets a Medal from the container;
     * @param object - object to delete.
     */
    public void delete(String object) {
        String[] temp = new String[nMedals];
        for (int i = 0; i < (container.length - 1); i++) {
            if (container[i] != null) {
                if (!container[i].equals(object)) {
                    temp[i] = container[i];
                }
            }
        }
        container = temp;
    }
}
