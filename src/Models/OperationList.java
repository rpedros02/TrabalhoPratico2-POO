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

public class OperationList implements Serializable {
    public Operation[] container;
    private int nOperations = 0;

    public OperationList() {
        container = new Operation[4];
    }

    public Operation[] getContainer() {
        return container;
    }

    public void add(Operation newOperation) {
        if (nOperations == container.length) {
            Operation[] temp = new Operation[nOperations + 4];
            System.arraycopy(container, 0, temp, 0, nOperations);
            container = temp;
        }
        container[nOperations++] = newOperation;
    }
}
