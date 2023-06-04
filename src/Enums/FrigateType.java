package Enums;

import java.io.Serializable;

public enum FrigateType implements Serializable {
    ANTISUBMARINE,
    ANTIAIR,
    PATROL;

    public static String toString(FrigateType frigateType){
        switch (frigateType){
            case ANTISUBMARINE -> {return "Anti-Submarine";}
            case ANTIAIR -> {return "Anti-Air";}
            default -> {return "Patrol";}
        }
    }
}
