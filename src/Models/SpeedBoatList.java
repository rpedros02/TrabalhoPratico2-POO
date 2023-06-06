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

public class SpeedBoatList implements Serializable {
    public SpeedBoat[] container;
    public int nSpeedBoats = 0;

    public SpeedBoatList() {
        container = new SpeedBoat[4];
    }

    public SpeedBoat[] getContainer() {
        return container;
    }

    public void add(SpeedBoat newSpeedBoat) {
        if (nSpeedBoats == container.length) {
            SpeedBoat[] temp = new SpeedBoat[nSpeedBoats + 4];
            System.arraycopy(container, 0, temp, 0, nSpeedBoats);
            container = temp;
        }
        container[nSpeedBoats++] = newSpeedBoat;
    }
}
