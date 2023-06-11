/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Enums.OperationPorpuse;
import Enums.Patent;
import Models.*;

import java.time.Year;
import java.util.Scanner;

import static Controllers.CorvetteController.searchCorvette;
import static Controllers.CrewController.searchCrew;
import static Controllers.FrigateController.searchFrigate;
import static Controllers.OperationController.getOperationPorpuse;
import static Controllers.ShipController.getOption;
import static Controllers.SpeedBoatController.searchSpeedBoat;

public class StatisticsController {

    /**
     * Method to run the Statistics Controller
     *
     * @param sc           Scanner for inputs
     * @param navalCommand Naval Command to use
     */
    public static void run(Scanner sc, NavalCommand navalCommand) {
        int option;
        do {
            switch (option = menu(sc)) {
                case 1 -> shipsBaptized(sc, navalCommand);
                case 2 -> operationsPerShip(sc, navalCommand);
                case 3 -> avgOperationPerShipType(navalCommand);
                case 4 -> operationsPerPorpuse(sc, navalCommand);
                case 5 -> estimatedTimeList(sc, navalCommand);
                case 6 -> operationPerCrewMember(sc, navalCommand);
            }
        } while (option != 0);
    }

    /**
     * Statistics Main Menu
     *
     * @param sc Scanner for inputs
     * @return user's option
     */
    public static int menu(Scanner sc) {
        int option;
        do {
            System.out.println("\nStatistics Menu");
            System.out.println("1. Ships Baptized in the same year;"); //Point a. on Requisites.
            System.out.println("2. Operations per Ship"); //Point b. on Requisites
            System.out.println("3. Avg number of Operations per Ship Type;"); // Pointt c. on Requisites
            System.out.println("4. Operations per Porpuse;"); //Point d. on Requisites
            System.out.println("5. Ships per Estimated Life Span;");
            System.out.println("6. Operations per Crew Member;"); // Point f. on Rquisites
            System.out.println("0. Back;");
            option = (int) getOption(sc);
        } while (option < 0 || option > 6);
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
     * Complies with point c. on requisites
     *
     * @param navalCommand Naval Command to use
     */
    public static void avgOperationPerShipType(NavalCommand navalCommand) {
        double avg;
        int sum = 0;
        for (Frigate f : navalCommand.getFrigatesContainer().getContainer()) {
            sum += f.getHistory().getLength();
        }
        avg = (double) sum / navalCommand.getFrigatesContainer().getLength();
        sum = 0;
        System.out.println("\nAverage Number of Operations per Frigate: " + avg);
        for (Corvette c : navalCommand.getCorvetteContainer().getContainer()) {
            sum += c.getHistory().getLength();
        }
        avg = (double) sum / navalCommand.getCorvetteContainer().getLength();
        System.out.println("\nAverage Number of Operations per Corvette: " + avg);
        sum = 0;
        for (SpeedBoat sb : navalCommand.getSpeedBoatContainer().getContainer()) {
            sum += sb.getHistory().getLength();
        }
        avg = (double) sum / navalCommand.getSpeedBoatContainer().getLength();
        System.out.println("\nAverage Number of Operations per SpeedBoat: " + avg);

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

    /**
     * Checks if a given {@link CrewMember} is on an {@link Operation#getOperationCrew()}
     *
     * @param crewMember Crew Member to compare
     * @param o          operation to search in
     * @return true if the Crew Member is on the Operation, false otherwise.
     */
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

    /**
     * Complies with point e. on requisites.
     *
     * @param sc           Scanner to read input
     * @param navalCommand Naval Command to iterate
     */
    public static void estimatedTimeList(Scanner sc, NavalCommand navalCommand) {
        try {
            System.out.println("Enter the life span to search: ");
            int lifeSpan = Integer.parseInt(sc.nextLine());
            FrigateList frigateList = new FrigateList();
            for (Frigate f : navalCommand.getFrigatesContainer().getContainer()) {
                if (f.getNextMaintenance().getYear() < Year.now().getValue() + lifeSpan && f.getNextMaintenance().getYear() > Year.now().getValue()) {
                    frigateList.add(f);
                }
            }
            for (Frigate f : frigateList.getContainer()) {
                if (f != null) {
                    System.out.println(f);
                }
            }
            CorvetteList corvetteList = new CorvetteList();
            for (Corvette f : navalCommand.getCorvetteContainer().getContainer()) {
                if (f.getNextMaintenance().getYear() < Year.now().getValue() + lifeSpan && f.getNextMaintenance().getYear() > Year.now().getValue()) {
                    corvetteList.add(f);
                }
            }
            for (Corvette f : corvetteList.getContainer()) {
                if (f != null) {
                    System.out.println(f);
                }
            }
            SpeedBoatList speedBoatList = new SpeedBoatList();
            for (SpeedBoat f : navalCommand.getSpeedBoatContainer().getContainer()) {
                if (f.getNextMaintenance().getYear() < Year.now().getValue() + lifeSpan && f.getNextMaintenance().getYear() > Year.now().getValue()) {
                    speedBoatList.add(f);
                }
            }
            for (SpeedBoat f : speedBoatList.getContainer()) {
                if (f != null) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Complies with point f. on the requisites.
     *
     * @param sc           Scanner for inputs
     * @param navalCommand Naval Command to use
     */
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
