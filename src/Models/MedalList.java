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

public class MedalList implements Serializable {

    public String[] container;
    private int nMedals = 0;

    public MedalList() {
        container = new String[4];
    }

    public String[] getContainer() {
        return container;
    }

    public void add(String newMedal) {
        if (nMedals == container.length) {
            String[] temp = new String[nMedals + 4];
            System.arraycopy(container, 0, temp, 0, nMedals);
            container = temp;
        }
        container[nMedals++] = newMedal;
    }

}
