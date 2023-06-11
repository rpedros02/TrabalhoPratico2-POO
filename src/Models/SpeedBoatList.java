/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import java.io.Serializable;

public class SpeedBoatList implements Serializable {
    public SpeedBoat[] container;
    public int nSpeedBoats = 0;

    public SpeedBoatList() {
        container = new SpeedBoat[4];
    }

    public SpeedBoat[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds an {@link SpeedBoat} to the container;
     *
     * @param newSpeedBoat - {@link SpeedBoat} to add to the container.
     */
    public void add(SpeedBoat newSpeedBoat) {
        if (nSpeedBoats == container.length) {
            SpeedBoat[] temp = new SpeedBoat[nSpeedBoats + 4];
            System.arraycopy(container, 0, temp, 0, nSpeedBoats);
            container = temp;
        }
        container[nSpeedBoats++] = newSpeedBoat;
    }

    /**
     * Method that dynamically delets a {@link SpeedBoat} from the container;
     *
     * @param object - object to delete.
     */
    public void delete(SpeedBoat object) {
        SpeedBoat[] temp = new SpeedBoat[nSpeedBoats];
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
        for (SpeedBoat c : container) {
            if (c != null) count++;
        }
        return count;
    }
}
