/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
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

    /**
     * Method that dynamically adds an {@link Operation} to the container;
     *
     * @param newOperation - {@link Operation} to add to the container.
     */
    public void add(Operation newOperation) {
        if (nOperations == container.length) {
            Operation[] temp = new Operation[nOperations + 4];
            System.arraycopy(container, 0, temp, 0, nOperations);
            container = temp;
        }
        container[nOperations++] = newOperation;
    }

    /**
     * Method that dynamically delets an {@link Operation} from the container;
     *
     * @param object - object to delete.
     */
    public void delete(Operation object) {
        Operation[] temp = new Operation[nOperations];
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
        for (Operation o : container) {
            if (o != null) count++;
        }
        return count;
    }

}
