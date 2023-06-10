/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Enums;

public enum OperationType {
    COMBAT,
    DEFENSE,
    PATROL,
    ESCORT,
    RECON,
    RESCUE;
    public static String toString(OperationType operationType){
        switch (operationType){
            case COMBAT -> {return "Combat";}
            case DEFENSE -> {return "Defense";}
            case ESCORT -> {return "Escort";}
            case RECON -> {return "Recon";}
            case RESCUE -> {return "Rescue";}
            default -> {return "Patrol";}
        }
    }
}
