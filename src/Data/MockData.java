/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */
package Data;


import Enums.*;
import Models.*;

public class MockData {
    private static final int FRIGATE_INITIAL_NUMBER = 4;
    private static final int CORVETTE_INITIAL_NUMBER = 5;
    private static final int SPEEDBOAT_INITIAL_NUMBER = 8;
    private static final int CREWMEMBER_INITIAL_NUMBER = 20;
    private static final int CAPTAIN_INITIAL_NUMBER = 5;
    private static final int OPERATION_INITIAL_NUMBER = 20;
    private static final String[] SHIPS1STNAMES = {"Apollo", "Crusader", "Land", "Savage", "Buggy", "Lag", "Raptor", "Bit", "Air", "Shop", "Snow", "Ice", "Black"};
    private static final String[] SHIPS2NDNAMES = {"Destroyer", "Constructor", "House", "Ship", "Commander", "Rescuer", "Racer", "Tigers", "Monkeys"};
    private static final String[] MANUFACTURERS = {"General Dynamics", "BAE Systems", "Naval Group SA", "United ShipBuilding"};
    private static final String[] NAMES = {"António", "Marta", "Rita", "Tomás", "Ana", "Gustavo", "Renata", "Catarina", "Joana", "Margarida", "Maria", "Mariana", "", "Pedro", "João", "Dínis", "Diogo", "José", "Rodrigo", "Guilherme"};
    private static final String[] SURNAMES = {"Silva", "Pinto", "Castro", "Carvalho", "Horta", "Marques", "Ortiz", "Conceição", "Figueiredo", "Besteiro", "Pereira", "Lopes", "Salvador", "Rodrigues", "Alves"};
    private static final String[] MEDALS = {"Medalha de Valor", "Medalha de Salvamento Ultramar", "Medalha de Extremo Valor", "Medalha de Bons Serviços", "Medalha Militar da Cruz da Guerra"};

    private static String genShipName() {
        return SHIPS1STNAMES[genRandomInt(0, SHIPS1STNAMES.length)] + " " + SHIPS2NDNAMES[genRandomInt(0, SHIPS2NDNAMES.length)];
    }

    private static int genRandomInt(int origin, int bound) {
        int range = (bound - origin) + 1;
        return (int) (Math.random() * range) + origin;

    }

    private static Date genDate() {
        int day = genRandomInt(1, 28);
        int month = genRandomInt(1, 12);
        int year = genRandomInt(1980, 2004);
        return new Date(day, month, year);
    }

    private static FrigateType genFrigateType() {
        switch (genRandomInt(1, 3)) {
            case 1 -> {
                return FrigateType.PATROL;
            }
            case 2 -> {
                return FrigateType.ANTISUBMARINE;
            }
            default -> {
                return FrigateType.ANTIAIR;
            }
        }
    }

    private static Equipment genEquipment() {
        switch (genRandomInt(1, 7)) {
            case 1 -> {
                return Equipment.RAM;
            }
            case 2 -> {
                return Equipment.JAVELIN;
            }
            case 3 -> {
                return Equipment.RADAR;
            }
            case 4 -> {
                return Equipment.SONAR;
            }
            case 5 -> {
                return Equipment.PHALANX;
            }
            case 6 -> {
                return Equipment.STINGER;
            }
            default -> {
                return Equipment.TORPEDO;
            }
        }
    }

    private static Equipment[] genEquipmentList() {
        Equipment[] equipment = new Equipment[genRandomInt(1, 4)];
        for (int i = 0; i < equipment.length; i++) {
            equipment[i] = genEquipment();
        }
        return equipment;
    }

    private static Patent genPatent() {
        switch (genRandomInt(1, 4)) {
            case 1 -> {
                return Patent.PRACA;
            }
            case 2 -> {
                return Patent.SUBALTERNO;
            }
            case 3 -> {
                return Patent.GENERAL;
            }
            default -> {
                return Patent.SARGENTO;
            }
        }
    }

    private static CrewMember genCrewMember() {
        return new CrewMember(NAMES[genRandomInt(0, NAMES.length)], genPatent(), genDate());
    }

    private static String[] genMedals() {
        String[] medals = new String[genRandomInt(0, 5)];
        for (int i = 0; i < medals.length; i++) {
            medals[i] = MEDALS[genRandomInt(0, MEDALS.length)];
        }
        return medals;
    }

    private static Captain genCaptain() {
        return new Captain(NAMES[genRandomInt(0, NAMES.length)], genPatent(), genDate(), genMedals());
    }

    private static CorvetteType genCorvetteType() {
        switch (genRandomInt(1, 3)) {
            case 1 -> {
                return CorvetteType.PATROL;
            }
            case 2 -> {
                return CorvetteType.COMBAT;
            }
            default -> {
                return CorvetteType.RESCUE;
            }
        }
    }

    private static OperationType genOperationType() {
        switch (genRandomInt(1, 7)) {
            case 1 -> {
                return OperationType.RESCUE;
            }
            case 2 -> {
                return OperationType.COMBAT;
            }
            case 3 -> {
                return OperationType.PATROL;
            }
            case 4 -> {
                return OperationType.DEFENSE;
            }
            case 5 -> {
                return OperationType.ESCORT;
            }
            default -> {
                return OperationType.RECON;
            }
        }
    }

    private static void insertCrewMember(CrewMember[] container) {
        for (int i = 0; i < CREWMEMBER_INITIAL_NUMBER; i++) {
            container[i] = genCrewMember();
        }
    }

    private static void insertCaptains(Captain[] container) {
        for (int i = 0; i < CAPTAIN_INITIAL_NUMBER; i++) {
            container[i] = genCaptain();
        }
    }

    private static void insertFrigates(Frigate[] container, Operation[] operationsContainer) {
        for (int i = 0; i < FRIGATE_INITIAL_NUMBER; i++) {
            container[i] = new Frigate(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length)], genDate(), genDate(), genDate(), genDate(), genDate(), (double) genRandomInt(75, 150), (double) genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genFrigateType(), genEquipmentList());
        }
    }

    private static void insertCorvettes(Corvette[] container, Operation[] operationsContainer) {
        for (int i = 0; i < CORVETTE_INITIAL_NUMBER; i++) {
            container[i] = new Corvette(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length)], genDate(), genDate(), genDate(), genDate(), genDate(), (double) genRandomInt(75, 150), (double) genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genCorvetteType(), genRandomInt(1, 20));
        }
    }

    private static void insertSpeedBoats(SpeedBoat[] container, Operation[] operationsContainer) {
        for (int i = 0; i < SPEEDBOAT_INITIAL_NUMBER; i++) {
            container[i] = new SpeedBoat(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length)], genDate(), genDate(), genDate(), genDate(), genDate(), (double) genRandomInt(75, 150), (double) genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genRandomInt(1, 20));
        }
    }

    private static void insertOperation(int i, Operation[] container, Captain captain, CrewMember approving, CrewMember[] crew) {
        container[i] = new Operation(genDate(), genDate(), "MOCK MISSION", genDate(), captain, approving, crew, genOperationType());
    }

    public static void generateData(NavalCommand navalCommand) {
        navalCommand.setName("Comando Naval - MOCK");
        insertFrigates(navalCommand.getFrigatesContainer(), navalCommand.getOperationsContainer());
        insertCorvettes(navalCommand.getCorvettes(), navalCommand.getOperationsContainer());
        insertSpeedBoats(navalCommand.getSpeedBoats(), navalCommand.getOperationsContainer());
        insertCaptains(navalCommand.getCaptains());
        insertCrewMember(navalCommand.getCrewMembers());
        for (int k = 0; k < OPERATION_INITIAL_NUMBER; k++) {
            int crewSize = genRandomInt(4, 9);
            CrewMember[] crew = new CrewMember[crewSize];
            for (int i = 0; i < crewSize; i++) {
                crew[i] = navalCommand.getCrewMembers()[genRandomInt(0, navalCommand.getCrewMembers().length)];
            }
            CrewMember approving = navalCommand.getCrewMembers()[genRandomInt(0,navalCommand.getCrewMembers().length)];
            Captain captain = navalCommand.getCaptains()[genRandomInt(0, navalCommand.getCaptains().length)];
            insertOperation(k, navalCommand.getOperationsContainer(), captain,approving,crew);
        }
    }
}
