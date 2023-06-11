package Controllers;

import Enums.OperationPorpuse;
import Enums.Patent;
import Models.*;

import java.util.Scanner;

import static Controllers.CorvetteController.searchCorvette;
import static Controllers.CrewController.searchCrew;
import static Controllers.FrigateController.searchFrigate;
import static Controllers.OperationController.getOperationPorpuse;
import static Controllers.ShipController.getOption;
import static Controllers.SpeedBoatController.searchSpeedBoat;

public class StatisticsController {

    public static void run(Scanner sc, NavalCommand navalCommand) {
        int option;
        do {
            switch (option = menu(sc)) {
                case 1 -> shipsBaptized(sc, navalCommand);
                case 2 -> operationsPerShip(sc, navalCommand);
                case 3 -> operationsPerPorpuse(sc, navalCommand);
                case 4 -> operationPerCrewMember(sc, navalCommand);
            }
        } while (option != 0);
    }

    public static int menu(Scanner sc) {
        int option;
        do {
            System.out.println("\nStatistics Menu");
            System.out.println("1. Ships Baptized in the same year;"); //Point a. on Requisites.
            System.out.println("2. Operations per Ship"); //Point b. on Requisites
            System.out.println("3. Operations per Porpuse;"); //Point d. on Requisites
            System.out.println("4. Operations per Crew Member;"); // Point f. on Rquisites
            System.out.println("0. Back;");
            option = (int) getOption(sc);
        } while (option < 0 || option > 3);
        return option;
    }

    /**
     * Method that complies with point a. on the requisites.
     *
     * @param sc           Scanner
     * @param navalCommand NavalCOmmend
     */
    public static void shipsBaptized(Scanner sc, NavalCommand navalCommand) {
        Date date = new Date();
        System.out.print("Enter the year to search for: ");
        date.setYear(sc.nextInt());
        sc.nextLine();
        FrigateList frigateList = new FrigateList();
        for (Frigate s : navalCommand.getFrigatesContainer().getContainer()) {
            if (s != null) {
                if (s.getBaptismDate().getYear() == date.getYear()) frigateList.add(s);
            }
        }
        CorvetteList corvetteList = new CorvetteList();
        for (Corvette c : navalCommand.getCorvetteContainer().getContainer()) {
            if (c != null) {
                if (c.getBaptismDate().getYear() == date.getYear()) corvetteList.add(c);
            }
        }
        SpeedBoatList list = new SpeedBoatList();
        for (SpeedBoat s : navalCommand.getSpeedBoatContainer().getContainer()) {
            if (s != null) {
                if (s.getBaptismDate().getYear() == date.getYear()) list.add(s);
            }
        }
        System.out.println("\nShips Baptized in the year " + date);
        for (Frigate ship : frigateList.getContainer()) {
            if (ship != null) {
                System.out.println("ID: " + ship.getId() +
                        "\nShip Type: Frigate " + ship.getFrigateType() +
                        "\nShip Last inspection Date: " + ship.getLastInspection() +
                        "\nShip Next inspection Date: " + ship.getNextInspection() + "\n----------");
            }
        }
        for (Corvette ship : corvetteList.getContainer()) {
            if (ship != null) {
                System.out.println("ID: " + ship.getId() +
                        "\nShip Type: Corvette " + ship.getCorvetteType() +
                        "\nShip Last inspection Date: " + ship.getLastInspection() +
                        "\nShip Next inspection Date: " + ship.getNextInspection() + "\n----------");
            }
        }
        for (SpeedBoat ship : list.getContainer()) {
            if (ship != null) {
                System.out.println("ID: " + ship.getId() +
                        "\nShip Type: SpeedBoat" +
                        "\nShip Last inspection Date: " + ship.getLastInspection() +
                        "\nShip Next inspection Date: " + ship.getNextInspection() + "\n----------");
            }
        }
    }

    /**
     * Method that complies with point b on the requisites
     *
     * @param sc           Scanner
     * @param navalCommand Naval command
     */
    public static void operationsPerShip(Scanner sc, NavalCommand navalCommand) {
        try {
            System.out.println("Enter the Ship type: ");
            System.out.println("1. Frigate;");
            System.out.println("2. Corvette;");
            System.out.println("3. Speed Boat");
            System.out.print("--> ");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> {
                    System.out.print("Enter Frigate's id: ");
                    Frigate frigate = searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationList list = frigate.getHistory();
                    for (Operation o : list.getContainer()) {
                        if (o != null) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Authorizing Crew Member: " + o.getApprovingMember().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()));
                        }
                    }
                }
                case 2 -> {
                    System.out.print("Enter Corvette's id: ");
                    Corvette corvette = searchCorvette(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationList list = corvette.getHistory();
                    for (Operation o : list.getContainer()) {
                        if (o != null) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Authorizing Crew Member: " + o.getApprovingMember().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()));
                        }
                    }
                }
                case 3 -> {
                    System.out.print("Enter Speed Boat's id: ");
                    SpeedBoat speedBoat = searchSpeedBoat(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationList list = speedBoat.getHistory();
                    for (Operation o : list.getContainer()) {
                        if (o != null) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Authorizing Crew Member: " + o.getApprovingMember().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()));
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method that complies with point d on requisites
     *
     * @param sc           Scanner
     * @param navalCommand Naval Command
     */
    public static void operationsPerPorpuse(Scanner sc, NavalCommand navalCommand) {
        try {
            System.out.println("Enter the Ship type: ");
            System.out.println("1. Frigate;");
            System.out.println("2. Corvette;");
            System.out.println("3. Speed Boat");
            System.out.print("--> ");
            switch (Integer.parseInt(sc.nextLine())) {
                case 1 -> {
                    System.out.println("Enter Frigate id: ");
                    Frigate frigate = searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationPorpuse porpuse = getOperationPorpuse(sc);
                    for (Operation o : frigate.getHistory().getContainer()) {
                        if (o == null) {
                            break;
                        }
                        if (o.getOperationPorpuse() == porpuse) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Captain: " + o.getCaptain().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()) +
                                    "\nNumber of Crew Member: " + o.getOperationCrew().getLength());
                        }
                    }
                }
                case 2 -> {
                    System.out.println("Enter Corvette id: ");
                    Corvette corvette = searchCorvette(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationPorpuse porpuse = getOperationPorpuse(sc);
                    for (Operation o : corvette.getHistory().getContainer()) {
                        if (o == null) {
                            break;
                        }
                        if (o.getOperationPorpuse() == porpuse) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Captain: " + o.getCaptain().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()) +
                                    "\nNumber of Crew Member: " + o.getOperationCrew().getLength());
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Enter Speed Boat id: ");
                    SpeedBoat speedBoat = searchSpeedBoat(Integer.parseInt(sc.nextLine()), navalCommand);
                    OperationPorpuse porpuse = getOperationPorpuse(sc);
                    for (Operation o : speedBoat.getHistory().getContainer()) {
                        if (o == null) {
                            break;
                        }
                        if (o.getOperationPorpuse() == porpuse) {
                            System.out.println("\nOperation " + o.getId() +
                                    "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                                    "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                                    "Captain: " + o.getCaptain().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()) +
                                    "\nNumber of Crew Member: " + o.getOperationCrew().getLength());
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean crewMemberOnOperation(CrewMember crewMember, Operation o) {
        boolean flag = false;
        for (CrewMember c : o.getOperationCrew().getContainer()) {
            if (c.getId() == crewMember.getId()) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public static void operationPerCrewMember(Scanner sc, NavalCommand navalCommand) {
        try {
            System.out.print("Entre crew member's id: ");
            CrewMember crewMember = searchCrew(Integer.parseInt(sc.nextLine()), navalCommand);
            OperationList onOperation = new OperationList();
            for (Operation o : navalCommand.getOperationsContainer().getContainer()) {
                if (crewMemberOnOperation(crewMember, o)) {
                    onOperation.add(o);
                }
            }
            for (Operation o : onOperation.getContainer()) {
                System.out.println("\nOperation " + o.getId() +
                        "\nOperation Span: " + o.getBeginDate() + " - " + o.getEndMission() +
                        "\nOperation Briefing: \n" + o.getMissionBriefing() + "\n--------\n" +
                        "Captain: " + o.getCaptain().getName() + " - " + Patent.toString(o.getApprovingMember().getPatent()) +
                        "\nNumber of Crew Members: " + o.getOperationCrew().getLength());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
