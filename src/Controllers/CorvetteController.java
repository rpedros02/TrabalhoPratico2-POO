/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Enums.CorvetteType;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Exceptions.InvalidInputException;
import Models.Corvette;
import Models.CorvetteList;
import Models.Date;
import Models.NavalCommand;

import java.util.Scanner;

import static Controllers.OperationController.searchOperation;
import static Controllers.ShipController.getOption;

public class CorvetteController {

    /**
     * Corvette Menus Controller
     *
     * @param sc → Scanner to read the info
     */
    public static void run(Scanner sc, NavalCommand navalCommand) throws InvalidInputException {
        int op;
        do {
            op = corvetteMenu(sc);
            switch (op) {
                case 1 -> addCorvette(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Corvette's ID: ");
                    try {
                        editCorvette(searchCorvette(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Corvette's ID: ");
                    try {
                        System.out.println(searchCorvette(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listCorvettes(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Corvette's ID: ");
                    try {
                        navalCommand.getCorvetteContainer().delete(searchCorvette(Integer.parseInt(sc.nextLine()), navalCommand));
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
     * Corvette Menu
     *
     * @param sc → Scanner to read the info
     * @return user's option
     */
    public static int corvetteMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nCorvette Menu");
            System.out.println("1. Add Corvette;");
            System.out.println("2. Edit Corvette;");
            System.out.println("3. Search Corvette;");
            System.out.println("4. List Corvettes;");
            System.out.println("5. Delete Corvette;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Method to Edit a {@link Corvette} instance.
     *
     * @param corvette     {@link Corvette} instance to edit.
     * @param navalCommand {@link NavalCommand} to save.
     */
    public static void editCorvette(Corvette corvette, NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing - " + corvette.getName());
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
        System.out.println("11. Corvette Type;");
        System.out.println("12. Number of Life Vests;");
        System.out.println("0. Back;");
        System.out.print("--> ");
        int option = (int) getOption(sc);
        switch (option) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Current name: " + corvette.getName());
                System.out.print("New name: ");
                corvette.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Current manufacturer: " + corvette.getManufacturer());
                System.out.print("New manufacturer: ");
                corvette.setManufacturer(sc.nextLine());
            }
            case 3 -> {
                System.out.println("Current Baptism Date: " + corvette.getBaptismDate().toString());
                corvette.setBaptismDate(Date.newDate("new Baptism Date"));
            }
            case 4 -> {
                System.out.println("Current Last Inspection Date: " + corvette.getLastInspection().toString());
                System.out.println("New Last Inspection Date: ");
                corvette.setLastInspection(Date.newDate("new Last Inspection Date"));
            }
            case 5 -> {
                System.out.println("Current Next Inspection Date: " + corvette.getNextInspection().toString());
                System.out.println("New Next Inspection Date: ");
                corvette.setNextInspection(Date.newDate("new Next Inspection Date"));
            }
            case 6 -> {
                System.out.println("Current Last Maintenance Date: " + corvette.getLastMaintenance().toString());
                System.out.println("New Last Maintenance Date: ");
                corvette.setLastMaintenance(Date.newDate("new Last Maintenance Date"));
            }
            case 7 -> {
                System.out.println("Current Next Maintenance Date: " + corvette.getNextMaintenance().toString());
                System.out.println("New Next Maintenance Date: ");
                corvette.setNextMaintenance(Date.newDate("new Next Maintenance Date"));
            }
            case 8 -> {
                System.out.println("Current Length in Meters: " + corvette.getLengthInMeters());
                System.out.print("New Length in Meters: ");
                try {
                    corvette.setLengthInMeters(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 9 -> {
                System.out.println("Current Weight in Tons: " + corvette.getWeightInTons());
                System.out.print("New Weight in Tons: ");
                try {
                    corvette.setWeightInTons(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 10 -> {
                System.out.println("Current Max Speed in knots: " + corvette.getMaxSpeedKnots());
                System.out.print("New Max Speed in knots: ");
                try {
                    corvette.setMaxSpeedKnots(Integer.parseInt(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 11 -> {
                System.out.println("Current Corvette Type: " + CorvetteType.toString(corvette.getCorvetteType()));
                System.out.println("New Corvette Type: ");
                try {
                    corvette.setCorvetteType(getCorvetteType(sc));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 12 -> {
                System.out.println("Current Number of Life Vests: " + corvette.getNumberOfLifeVests());
                System.out.print("New number of life vests: ");
                try {
                    corvette.setNumberOfLifeVests(Integer.parseInt(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            default -> System.out.println("Input not recognized, returning to menu.");
        }
        DataOperations.save(navalCommand);
    }

    /**
     * Method to request the user for the Corvette type.
     *
     * @param sc Scanner to read input.
     * @return the {@link Enums.CorvetteType}.
     */
    public static CorvetteType getCorvetteType(Scanner sc) {
        int op;
        do {
            System.out.println("Enter the Corvette Type: ");
            System.out.println("1. Rescue;");
            System.out.println("2. Combat;");
            System.out.println("3. Patrol;");
            op = (int) getOption(sc);
            if (op < 1 || op > 3) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 3);
        switch (op) {
            case 1 -> {
                return CorvetteType.RESCUE;
            }
            case 2 -> {
                return CorvetteType.COMBAT;
            }
            default -> {
                return CorvetteType.PATROL;
            }
        }
    }

    /**
     * Method that iterates the {@link CorvetteList} and searches for the given id.
     *
     * @param id           -> {@link Corvette} Id to search for.
     * @param navalCommand -> NavalCommand to search in.
     */
    public static Corvette searchCorvette(int id, NavalCommand navalCommand) {
        Corvette[] container = navalCommand.getCorvetteContainer().getContainer();
        for (Corvette f : container) {
            if (f.getId() == id) {
                return f;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
    }


    /**
     * Method to request the data and create a new Corvette. See {@link Models.CorvetteList#add(Corvette)} for the method that adds to the Corvette List.
     *
     * @param sc           Scanner to read input.
     * @param navalCommand The naval command to add the Corvette.
     */
    public static void addCorvette(Scanner sc, NavalCommand navalCommand) {
        Corvette corvette = new Corvette();
        System.out.println("\n-Creating Corvette-");
        corvette.setId(Corvette.getNextId());
        System.out.println("New Corvette ID: " + corvette.getId());
        System.out.print("Enter new Corvette's Name: ");
        corvette.setName(sc.nextLine());
        System.out.print("Enter new Corvette's Manufacturer: ");
        corvette.setManufacturer(sc.nextLine());
        corvette.setCorvetteType(getCorvetteType(sc));
        boolean flag = false;
        while (!flag) {
            try {
                if (corvette.getBaptismDate() == null) {
                    corvette.setBaptismDate(Date.newDate("Corvette's Baptism Date"));
                    flag = true;
                }
                if (corvette.getLastInspection() == null) {
                    corvette.setLastInspection(Date.newDate("Corvette's Last Inspection Date"));
                    flag = true;
                }
                if (corvette.getNextInspection() == null) {
                    corvette.setNextInspection(Date.newDate("Corvette's Next Inspection Date"));
                    flag = true;
                }
                if (corvette.getLastMaintenance() == null) {
                    corvette.setLastMaintenance(Date.newDate("Corvette's Last Maintenance Date"));
                    flag = true;
                }
                if (corvette.getNextMaintenance() == null) {
                    corvette.setNextMaintenance(Date.newDate("Corvette's Next Maintenance Date"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter new Corvette's Length (in meters)");
        corvette.setLengthInMeters(getOption(sc));
        System.out.print("Enter new Corvette's Weight (in tons)");
        corvette.setWeightInTons(getOption(sc));
        System.out.print("Enter new Corvette's Max Speed (in knots)");
        corvette.setMaxSpeedKnots((int) getOption(sc));
        System.out.print("Enter how many life vests the ship has: ");
        try {
            corvette.setNumberOfLifeVests(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter how many Operations the ship has: ");
        int count = 0;
        try {
            int nOp = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < nOp; i++) {
                System.out.print("Enter the Operation ID: ");
                corvette.getHistory().add(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand));
                count++;
            }
            System.out.println("Added " + count + " operations.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        navalCommand.getCorvetteContainer().add(corvette);
        DataOperations.save(navalCommand);
    }

    /**
     * Method that iterates the {@link Models.CorvetteList} and outputs all the instances.
     *
     * @param navalCommand The naval command to iterate.
     */
    private static void listCorvettes(NavalCommand navalCommand) {
        for (Corvette corvette : navalCommand.getCorvetteContainer().getContainer()) {
            if (corvette != null) {
                System.out.println(corvette);
            }
        }
    }

}
