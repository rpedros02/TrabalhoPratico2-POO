/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Enums.Equipment;
import Enums.FrigateType;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Exceptions.InvalidInputException;
import Models.Date;
import Models.Frigate;
import Models.NavalCommand;

import java.util.Scanner;

import static Controllers.OperationController.searchOperation;
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
                case 1 -> addFrigate(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Frigate's ID: ");
                    try {
                        editFrigate(searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Frigate's ID: ");
                    try {
                        System.out.println(searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listFrigates(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Frigate's ID: ");
                    try {
                        navalCommand.getFrigatesContainer().delete(searchFrigate(Integer.parseInt(sc.nextLine()), navalCommand));
                        DataOperations.save(navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Input not recognized.");
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
        int option;
        do {
            System.out.println("\nFrigate Menu");
            System.out.println("1. Add Frigate;");
            System.out.println("2. Edit Frigate;");
            System.out.println("3. Search Frigate;");
            System.out.println("4. List Frigates;");
            System.out.println("5. Delete Frigate;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Method to Edit a {@link Frigate} instance.
     *
     * @param frigate      {@link Frigate} instance to edit.
     * @param navalCommand {@link NavalCommand} to save.
     */
    public static void editFrigate(Frigate frigate, NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing - " + frigate.getName());
        System.out.println("Select field to edit: ");
        System.out.println("1. Name;");
        System.out.println("2. Manufacturer;");
        System.out.println("3. Baptism Date;");
        System.out.println("4. Last Inspection Date;");
        System.out.println("5. Next Inspection Date;");
        System.out.println("6. Last Maintenance;");
        System.out.println("7. Next Maintenance;");
        System.out.println("8. Length in Meters;");
        System.out.println("9. Weight in tons;");
        System.out.println("10. Max Speed in knots;");
        System.out.println("11. Frigate Type;");
        System.out.println("0. Back;");
        System.out.print("--> ");
        int option = (int) getOption(sc);
        switch (option) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Current name: " + frigate.getName());
                System.out.print("New name: ");
                frigate.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Current manufacturer: " + frigate.getManufacturer());
                System.out.print("New manufacturer: ");
                frigate.setManufacturer(sc.nextLine());
            }
            case 3 -> {
                System.out.println("Current Baptism Date: " + frigate.getBaptismDate().toString());
                frigate.setBaptismDate(Date.newDate("new Baptism Date"));
            }
            case 4 -> {
                System.out.println("Current Last Inspection Date: " + frigate.getLastInspection().toString());
                System.out.println("New Last Inspection Date: ");
                frigate.setLastInspection(Date.newDate("new Last Inspection Date"));
            }
            case 5 -> {
                System.out.println("Current Next Inspection Date: " + frigate.getNextInspection().toString());
                System.out.println("New Next Inspection Date: ");
                frigate.setNextInspection(Date.newDate("new Next Inspection Date"));
            }
            case 6 -> {
                System.out.println("Current Last Maintenance Date: " + frigate.getLastMaintenance().toString());
                System.out.println("New Last Maintenance Date: ");
                frigate.setLastMaintenance(Date.newDate("new Last Maintenance Date"));
            }
            case 7 -> {
                System.out.println("Current Next Maintenance Date: " + frigate.getNextMaintenance().toString());
                System.out.println("New Next Maintenance Date: ");
                frigate.setNextMaintenance(Date.newDate("new Next Maintenance Date"));
            }
            case 8 -> {
                System.out.println("Current Length in Meters: " + frigate.getLengthInMeters());
                System.out.print("New Length in Meters: ");
                try {
                    frigate.setLengthInMeters(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 9 -> {
                System.out.println("Current Weight in Tons: " + frigate.getWeightInTons());
                System.out.print("New Weight in Tons: ");
                try {
                    frigate.setWeightInTons(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 10 -> {
                System.out.println("Current Max Speed in knots: " + frigate.getMaxSpeedKnots());
                System.out.print("New Max Speed in knots: ");
                try {
                    frigate.setMaxSpeedKnots(Integer.parseInt(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 11 -> {
                System.out.println("Current Frigate Type: " + FrigateType.toString(frigate.getFrigateType()));
                System.out.println("New Frigate Type: ");
                try {
                    frigate.setFrigateType(getFrigateType(sc));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            default -> System.out.println("Input not recognized, returning to menu.");
        }
        DataOperations.save(navalCommand);
    }

    /**
     * Method to request the user for the frigate type.
     *
     * @param sc Scanner to read input.
     * @return the {@link FrigateType}.
     */
    public static FrigateType getFrigateType(Scanner sc) {
        int op;
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

    /**
     * Method to request the user for the Equipment.
     *
     * @param sc Scanner to read input.
     * @return the {@link Equipment}.
     */
    public static Equipment getEquipment(Scanner sc) {
        int op;
        do {
            System.out.println("Enter the Equipment: ");
            System.out.println("1. Torpedo;");
            System.out.println("2. Javelin;");
            System.out.println("3. Stinger;");
            System.out.println("4. Phalanx;");
            System.out.println("5. RAM;");
            System.out.println("6. Radar;");
            System.out.println("7. Sonar;");
            op = (int) getOption(sc);
            if (op < 1 || op > 7) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 7);
        switch (op) {
            case 1 -> {
                return Equipment.TORPEDO;
            }
            case 2 -> {
                return Equipment.JAVELIN;
            }
            case 3 -> {
                return Equipment.STINGER;
            }
            case 4 -> {
                return Equipment.PHALANX;
            }
            case 5 -> {
                return Equipment.RAM;
            }
            case 6 -> {
                return Equipment.RADAR;
            }
            default -> {
                return Equipment.SONAR;
            }
        }
    }

    /**
     * Method that iterates the FrigateList and searches for the given id.
     *
     * @param id           -> Frigate Id to search for.
     * @param navalCommand -> NavalCommand to search in.
     */
    public static Frigate searchFrigate(int id, NavalCommand navalCommand) {
        Frigate[] container = navalCommand.getFrigatesContainer().getContainer();
        for (Frigate f : container) {
            if (f.getId() == id) {
                return f;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
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
        newFrigate.setId(Frigate.getNextId());
        System.out.println("New Frigate ID: " + newFrigate.getId());
        System.out.print("Enter new Frigate's Name: ");
        newFrigate.setName(sc.nextLine());
        System.out.print("Enter new Frigate's Manufacturer: ");
        newFrigate.setManufacturer(sc.nextLine());
        newFrigate.setFrigateType(getFrigateType(sc));
        boolean flag = false;
        while (!flag) {
            try {
                if (newFrigate.getBaptismDate() == null) {
                    newFrigate.setBaptismDate(Date.newDate("Frigate's Baptism Date"));
                    flag = true;
                }
                if (newFrigate.getLastInspection() == null) {
                    newFrigate.setLastInspection(Date.newDate("Frigate's Last Inspection Date"));
                    flag = true;
                }
                if (newFrigate.getNextInspection() == null) {
                    newFrigate.setNextInspection(Date.newDate("Frigate's Next Inspection Date"));
                    flag = true;
                }
                if (newFrigate.getLastMaintenance() == null) {
                    newFrigate.setLastMaintenance(Date.newDate("Frigate's Last Maintenance Date"));
                    flag = true;
                }
                if (newFrigate.getNextMaintenance() == null) {
                    newFrigate.setNextMaintenance(Date.newDate("Frigate's Next Maintenance Date"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter new Frigate's Length (in meters)");
        newFrigate.setLengthInMeters(getOption(sc));
        System.out.print("Enter new Frigate's Weight (in tons)");
        newFrigate.setWeightInTons(getOption(sc));
        System.out.print("Enter new Frigate's Max Speed (in knots)");
        newFrigate.setMaxSpeedKnots((int) getOption(sc));
        System.out.print("Enter how many Operations the ship has: ");
        int count = 0;
        try {
            int nOp = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < nOp; i++) {
                System.out.print("Enter the Operation ID: ");
                newFrigate.getHistory().add(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand));
                count++;
            }
            System.out.println("Added " + count + " operation(s).");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter how many Equipment the ship has: ");
        count = 0;
        try {
            int nEquipment = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < nEquipment; i++) {
                newFrigate.getEquipment().add(getEquipment(sc));
                count++;
            }
            System.out.println("Added " + count + " equipment(s).");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        navalCommand.getFrigatesContainer().add(newFrigate);
        DataOperations.save(navalCommand);
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
