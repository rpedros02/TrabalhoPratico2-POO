/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */
package Controllers;

import Enums.FrigateType;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Exceptions.InvalidInputException;
import Models.Date;
import Models.Frigate;
import Models.NavalCommand;

import java.util.Scanner;

import static Controllers.ShipController.getOption;

public class FrigateController {

    /**
     * Frigate Menus Controller
     *
     * @param sc → Scanner to read the info
     */
    public static void run(Scanner sc, NavalCommand navalCommand) throws InvalidInputException {
        int op;
        do {
            op = frigateMenu(sc);
            switch (op) {
                case 1 -> {
                    addFrigate(sc, navalCommand);
                }
                case 3 -> {
                    System.out.print("Enter the Frigate's ID: ");
                    try {
                        searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 4 -> {
                    listFrigates(navalCommand);
                }
            }
        } while (op != 0);
    }

    /**
     * Frigate Menu
     *
     * @param sc → Scanner to read the info
     * @return user's option
     */
    public static int frigateMenu(Scanner sc) {
        int option = -1;
        do {
            System.out.println("\nFrigate Menu");
            System.out.println("1. Add Frigate;");
            System.out.println("2. Edit Frigate;");
            System.out.println("3. Search Frigate;");
            System.out.println("4. List Frigates;");
            System.out.println("5. Delete Frigates;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }


    /**
     * Method to request the user for the frigate type.
     *
     * @param sc Scanner to read input.
     * @return the {@link FrigateType}.
     */
    public static FrigateType getFrigateType(Scanner sc) {
        int op = -1;
        do {
            System.out.println("Enter the Frigate Type: ");
            System.out.println("1. Anti-Submarine;");
            System.out.println("2. Anti-Air;");
            System.out.println("3. Patrol;");
            op = (int) getOption(sc);
            if (op < 1 || op > 3) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 3);
        switch (op) {
            case 1 -> {
                return FrigateType.ANTISUBMARINE;
            }
            case 2 -> {
                return FrigateType.ANTIAIR;
            }
            default -> {
                return FrigateType.PATROL;
            }
        }
    }

    public static void searchFrigate(int id, NavalCommand navalCommand) {
        Frigate[] container = navalCommand.getFrigatesContainer().getContainer();
        for (Frigate f : container) {
            if (f.getId() == id) {
                System.out.println(f);
                return;
            }
        }
        throw new FrigateNotFoundException("Frigate not found in the records.");
    }

    /**
     * Method to request the data and create a new Frigate. See {@link Models.FrigateList#add(Frigate)} for the method that adds to the Frigate List.
     *
     * @param sc           Scanner to read input.
     * @param navalCommand The naval command to add the Frigate.
     */
    public static void addFrigate(Scanner sc, NavalCommand navalCommand) {
        Frigate newFrigate = new Frigate();
        System.out.println("\n-Creating Frigate-");
        System.out.print("Frigate Name: ");
        newFrigate.setName(sc.nextLine());
        System.out.print("Frigate Manufacturer: ");
        newFrigate.setManufacturer(sc.nextLine());
        newFrigate.setFrigateType(getFrigateType(sc));
        boolean flag = false;
        while (!flag) {
            try {
                if (newFrigate.getBaptismDate() == null) {
                    newFrigate.setBaptismDate(Date.newDate("Baptism Date"));
                    flag = true;
                }
                if (newFrigate.getLastInspection() == null) {
                    newFrigate.setLastInspection(Date.newDate("Last Inspection Date"));
                    flag = true;
                }
                if (newFrigate.getNextInspection() == null) {
                    newFrigate.setNextInspection(Date.newDate("Next Inspection Date"));
                    flag = true;
                }
                if (newFrigate.getLastMaintenance() == null) {
                    newFrigate.setLastMaintenance(Date.newDate("Last Maintenance Date"));
                    flag = true;
                }
                if (newFrigate.getNextMaintenance() == null) {
                    newFrigate.setNextMaintenance(Date.newDate("Next Maintenance Date"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Frigate Length (in meters)");
        newFrigate.setLengthInMeters(getOption(sc));
        System.out.print("Frigate Weight (in tons)");
        newFrigate.setWeightInTons(getOption(sc));
        System.out.print("Frigate Max Speed (in knots)");
        newFrigate.setMaxSpeedKnots((int) getOption(sc));
//        System.out.print("Add Operation History? (y - yes | n - no): ");
//        switch (sc.nextLine().toLowerCase()) {
//            case "y" -> {
//
//            }
//            case "n" -> {
//
//            }
//            default -> {
//                System.out.println("Invalid Answer, not adding Operations.");
//            }
//        }
        newFrigate.setId(Frigate.getNextId());
        navalCommand.getFrigatesContainer().add(newFrigate);
    }

    /**
     * Method that iterates the {@link Models.FrigateList} and outputs all the instances.
     *
     * @param navalCommand The naval command to iterate.
     */
    private static void listFrigates(NavalCommand navalCommand) {
        for (Frigate f : navalCommand.getFrigatesContainer().getContainer()) {
            if (f != null) {
                System.out.println(f);
            }
        }
    }

}
