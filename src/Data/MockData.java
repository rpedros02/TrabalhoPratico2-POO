/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Data;


import Enums.*;
import Models.*;

public class MockData {
    private static final int CREWMEMBER_INITIAL_NUMBER = 20;
    private static final int CAPTAIN_INITIAL_NUMBER = 5;
    private static final String[] SHIPS1STNAMES = {"Apollo", "Crusader", "Land", "Savage", "Buggy", "Lag", "Raptor", "Bit", "Air", "Shop", "Snow", "Ice", "Black"};
    private static final String[] SHIPS2NDNAMES = {"Destroyer", "Constructor", "House", "Ship", "Commander", "Rescuer", "Racer", "Tigers", "Monkeys"};
    private static final String[] MANUFACTURERS = {"General Dynamics", "BAE Systems", "Naval Group SA", "United ShipBuilding"};
    private static final String[] NAMES = {"António", "Marta", "Rita", "Tomás", "Ana", "Gustavo", "Renata", "Catarina", "Joana", "Margarida", "Maria", "Mariana", "", "Pedro", "João", "Dínis", "Diogo", "José", "Rodrigo", "Guilherme"};
    private static final String[] SURNAMES = {"Silva", "Pinto", "Castro", "Carvalho", "Horta", "Marques", "Ortiz", "Conceição", "Figueiredo", "Besteiro", "Pereira", "Lopes", "Salvador", "Rodrigues", "Alves"};
    private static final String[] MEDALS = {"Medalha de Valor", "Medalha de Salvamento Ultramar", "Medalha de Extremo Valor", "Medalha de Bons Serviços", "Medalha Militar da Cruz da Guerra"};

    private static String genShipName() {
        return SHIPS1STNAMES[genRandomInt(0, SHIPS1STNAMES.length - 1)] + " " + SHIPS2NDNAMES[genRandomInt(0, SHIPS2NDNAMES.length - 1)];
    }

    public static int genRandomInt(int origin, int bound) {
        int range = (bound - origin) + 1;
        return (int) (Math.random() * range) + origin;

    }

    public static Date genDate() {
        int day = genRandomInt(1, 28);
        int month = genRandomInt(1, 12);
        int year = genRandomInt(2010, 2019);
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

    private static EquipmentList genEquipmentList() {
        EquipmentList container = new EquipmentList();
        for (int i = 0; i < genRandomInt(1, 4); i++) {
            container.add(genEquipment());
        }
        return container;
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
        return new CrewMember(NAMES[genRandomInt(0, NAMES.length - 1)] + " " + SURNAMES[genRandomInt(0, SURNAMES.length - 1)], genPatent(), genDate());
    }

    private static MedalList genMedals() {
        MedalList container = new MedalList();
        for (int i = 0; i < genRandomInt(0, 5); i++) {
            container.add(MEDALS[genRandomInt(0, 4)]);
        }
        return container;
    }

    private static Captain genCaptain() {
        return new Captain(NAMES[genRandomInt(0, NAMES.length - 1)] + " " + SURNAMES[genRandomInt(0, SURNAMES.length - 1)], genPatent(), genDate(), genMedals());
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

    private static OperationPorpuse genPorpuse() {
        switch (genRandomInt(1, 3)) {
            case 1 -> {
                return OperationPorpuse.NATIONAL;
            }
            case 2 -> {
                return OperationPorpuse.OTAN;
            }
            default -> {
                return OperationPorpuse.UN;
            }
        }
    }

    private static void insertCrewMember(CrewList container) {
        for (int i = 0; i < CREWMEMBER_INITIAL_NUMBER; i++) {
            container.add(genCrewMember());
        }
    }

    private static void insertCaptains(CaptainList container) {
        for (int i = 0; i < CAPTAIN_INITIAL_NUMBER; i++) {
            container.add(genCaptain());
        }
    }

    private static void insertFrigates(FrigateList container, OperationList operationsContainer) {
        for (int i = 0; i < container.getContainer().length; i++) {
            container.add(new Frigate(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length - 1)], genDate(), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genRandomInt(75, 150), genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genFrigateType(), genEquipmentList()));
        }
    }

    private static void insertCorvettes(CorvetteList container, OperationList operationsContainer) {
        for (int i = 0; i < container.getContainer().length; i++) {
            container.add(new Corvette(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length - 1)], genDate(), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genRandomInt(75, 150), genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genCorvetteType(), genRandomInt(1, 20)));
        }
    }

    private static void insertSpeedBoats(SpeedBoatList container, OperationList operationsContainer) {
        for (int i = 0; i < container.getContainer().length; i++) {
            container.add(new SpeedBoat(genShipName(), MANUFACTURERS[genRandomInt(0, MANUFACTURERS.length - 1)], genDate(), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genDate(), Date.genDateLater(new Date(12, 12, 2017)), genRandomInt(75, 150), genRandomInt(1500, 5000), genRandomInt(20, 40), operationsContainer, genRandomInt(1, 20)));
        }
    }

    private static void insertOperation(OperationList container, Captain captain, CrewMember approving, CrewList crew) {
        container.add(new Operation(genDate(), Date.genDateLater(new Date(12, 12, 2017)), "MOCK MISSION", genDate(), captain, approving, crew, genOperationType(), genPorpuse()));
    }

    public static void generateData(NavalCommand navalCommand) {
        navalCommand.setName("Naval Command - MOCK");
        insertFrigates(navalCommand.getFrigatesContainer(), navalCommand.getOperationsContainer());
        insertCorvettes(navalCommand.getCorvetteContainer(), navalCommand.getOperationsContainer());
        insertSpeedBoats(navalCommand.getSpeedBoatContainer(), navalCommand.getOperationsContainer());
        insertCaptains(navalCommand.getCaptainContainer());
        insertCrewMember(navalCommand.getCrewMemberContainer());
        for (int k = 0; k < navalCommand.getOperationsContainer().getContainer().length - 1; k++) {
            CrewList crew = new CrewList();
            for (int i = 0; i < genRandomInt(4, 9); i++) {
                crew.add(navalCommand.getCrewMemberContainer().getContainer()[genRandomInt(0, navalCommand.getCrewMemberContainer().getContainer().length - 1)]);
            }
            CrewMember approving = navalCommand.getCrewMemberContainer().getContainer()[genRandomInt(0, navalCommand.getCrewMemberContainer().getContainer().length - 1)];
            Captain captain = navalCommand.getCaptainContainer().getContainer()[genRandomInt(0, navalCommand.getCaptainContainer().getContainer().length - 4)];
            insertOperation(navalCommand.getOperationsContainer(), captain, approving, crew);
        }
    }
}
