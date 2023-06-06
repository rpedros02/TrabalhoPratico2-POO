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

public class FrigateList implements Serializable {
    public Frigate[] container;
    public  int nFrigates = 0;

    public FrigateList() {
        container = new Frigate[4];
    }

    public Frigate[] getContainer() {
        return container;
    }

    public void add(Frigate newFrigate) {
        if (nFrigates == container.length) {
            Frigate[] temp = new Frigate[nFrigates + 4];
            System.arraycopy(container, 0, temp, 0, nFrigates);
            container = temp;
        }
        container[nFrigates++] = newFrigate;
    }
}
