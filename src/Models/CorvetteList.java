/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import java.io.Serializable;

public class CorvetteList implements Serializable {
    public Corvette[] container;
    public int nCorvettes = 0;

    public CorvetteList() {
        container = new Corvette[4];
    }

    public Corvette[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds a {@link Corvette} to the container;
     *
     * @param newCorvette - {@link Corvette} to add to the container.
     */
    public void add(Corvette newCorvette) {
        if (nCorvettes == container.length) {
            Corvette[] temp = new Corvette[nCorvettes + 4];
            System.arraycopy(container, 0, temp, 0, nCorvettes);
            container = temp;
        }
        container[nCorvettes++] = newCorvette;
    }

    /**
     * Method that dynamically delets a {@link Corvette} from the container;
     *
     * @param object - object to delete.
     */
    public void delete(Corvette object) {
        Corvette[] temp = new Corvette[nCorvettes];
        for (int i = 0; i < (container.length - 1); i++) {
            if (container[i] != null) {
                if (container[i].getId() != object.getId()) {
                    temp[i] = container[i];
                }
            }
        }
        container = temp;
    }

    /**
     * Returns the length without null objects
     *
     * @return length
     */
    public int getLength() {
        int count = 0;
        for (Corvette c : container) {
            if (c != null) count++;
        }
        return count;
    }

}
