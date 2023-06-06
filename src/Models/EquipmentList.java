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

    public void add(Equipment newEquipment) {
        if (nEquipments == container.length) {
            Equipment[] temp = new Equipment[nEquipments + 4];
            System.arraycopy(container, 0, temp, 0, nEquipments);
            container = temp;
        }
        container[nEquipments++] = newEquipment;
    }

}
