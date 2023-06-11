/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Models;

import Enums.Equipment;

import java.io.Serializable;

public class EquipmentList implements Serializable {
    public Equipment[] container;
    private int nEquipments = 0;

    public EquipmentList() {
        container = new Equipment[4];
    }

    public Equipment[] getContainer() {
        return container;
    }

    /**
     * Method that dynamically adds Equipment to the container;
     *
     * @param newEquipment - Equipment to add to the container.
     */
    public void add(Equipment newEquipment) {
        if (nEquipments == container.length) {
            Equipment[] temp = new Equipment[nEquipments + 4];
            System.arraycopy(container, 0, temp, 0, nEquipments);
            container = temp;
        }
        container[nEquipments++] = newEquipment;
    }

    /**
     * Method that dynamically delets a {@link Equipment} from the container;
     *
     * @param object - object to delete.
     */
    public void delete(Equipment object) {
        Equipment[] temp = new Equipment[nEquipments];
        for (int i = 0; i < (container.length - 1); i++) {
            if (container[i] != null) {
                if (container[i] != object) {
                    temp[i] = container[i];
                }
            }
        }
        container = temp;
    }
}
