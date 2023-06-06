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

public class CaptainList implements Serializable {
    public Captain[] container;

    public int nCaptains = 0;

    public CaptainList() {
        container = new Captain[4];
    }

    public Captain[] getContainer() {
        return container;
    }

    public void add(Captain newCaptain) {
        if (nCaptains == container.length) {
            Captain[] temp = new Captain[nCaptains + 4];
            System.arraycopy(container, 0, temp, 0, nCaptains);
            container = temp;
        }
        container[nCaptains++] = newCaptain;
    }
}
