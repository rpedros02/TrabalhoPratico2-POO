/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Enums;

import java.io.Serializable;

public enum OperationPorpuse implements Serializable {
    NATIONAL,
    OTAN,
    UN;
    public static String toString(OperationPorpuse operationPorpuse){
        switch (operationPorpuse){
            case NATIONAL -> {return "Nacional";}
            case OTAN -> {return "NATO";}
            default -> {return "ONU";}
        }
    }
}
