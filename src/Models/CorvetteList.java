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

public class CorvetteList implements Serializable {
    public Corvette[] container;
    public int nCorvettes = 0;

    public CorvetteList() {
        container = new Corvette[4];
    }

    public Corvette[] getContainer() {
        return container;
    }

    public void add(Corvette newCorvette) {
        if (nCorvettes == container.length) {
            Corvette[] temp = new Corvette[nCorvettes + 4];
            System.arraycopy(container, 0, temp, 0, nCorvettes);
            container = temp;
        }
        container[nCorvettes++] = newCorvette;
    }
}
