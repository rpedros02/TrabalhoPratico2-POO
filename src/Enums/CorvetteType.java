package Enums;

import java.io.Serializable;

public enum CorvetteType implements Serializable {
    RESCUE,
    COMBAT,
    PATROL;
    public static String toString(CorvetteType corvetteType){
        switch (corvetteType){
            case RESCUE -> {return "Rescue";}
            case COMBAT -> {return "Combat";}
            default -> {return "Patrol";}
        }
    }
}

