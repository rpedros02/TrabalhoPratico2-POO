/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Exceptions.InvalidInputException;
import Models.Date;
import Models.NavalCommand;
import Models.SpeedBoat;
import Models.SpeedBoatList;

import java.util.Scanner;

import static Controllers.OperationController.searchOperation;
import static Controllers.ShipController.getOption;

public class SpeedBoatController {

    /**
     * Speed Boat Menus Controller
     *
     * @param sc → Scanner to read the info
     */
    public static void run(Scanner sc, NavalCommand navalCommand) throws InvalidInputException {
        int op;
        do {
            op = speedBoatMenu(sc);
            switch (op) {
                case 1 -> addSpeedBoat(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Speed Boat's ID: ");
                    try {
                        editSpeedBoat(searchSpeedBoat(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Speed Boat's ID: ");
                    try {
                        System.out.println(searchSpeedBoat(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listSpeedBoats(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Speed Boat's ID: ");
                    try {
                        navalCommand.getSpeedBoatContainer().delete(searchSpeedBoat(Integer.parseInt(sc.nextLine()), navalCommand));
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
     * Speed Boat Menu
     *
     * @param sc → Scanner to read the info
     * @return user's option
     */
    public static int speedBoatMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nSpeed Boat Menu");
            System.out.println("1. Add Speed Boat;");
            System.out.println("2. Edit Speed Boat;");
            System.out.println("3. Search Speed Boat;");
            System.out.println("4. List Speed Boats;");
            System.out.println("5. Delete Speed Boat;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Method to Edit a {@link SpeedBoat} instance.
     *
     * @param speedBoat    {@link SpeedBoat} instance to edit.
     * @param navalCommand {@link NavalCommand} to save.
     */
    public static void editSpeedBoat(SpeedBoat speedBoat, NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing - " + speedBoat.getName());
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
        System.out.println("11. Number of Life Vests;");
        System.out.println("0. Back;");
        System.out.print("--> ");
        int option = (int) getOption(sc);
        switch (option) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Current name: " + speedBoat.getName());
                System.out.print("New name: ");
                speedBoat.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Current manufacturer: " + speedBoat.getManufacturer());
                System.out.print("New manufacturer: ");
                speedBoat.setManufacturer(sc.nextLine());
            }
            case 3 -> {
                System.out.println("Current Baptism Date: " + speedBoat.getBaptismDate().toString());
                speedBoat.setBaptismDate(Date.newDate("new Baptism Date"));
            }
            case 4 -> {
                System.out.println("Current Last Inspection Date: " + speedBoat.getLastInspection().toString());
                System.out.println("New Last Inspection Date: ");
                speedBoat.setLastInspection(Date.newDate("new Last Inspection Date"));
            }
            case 5 -> {
                System.out.println("Current Next Inspection Date: " + speedBoat.getNextInspection().toString());
                System.out.println("New Next Inspection Date: ");
                speedBoat.setNextInspection(Date.newDate("new Next Inspection Date"));
            }
            case 6 -> {
                System.out.println("Current Last Maintenance Date: " + speedBoat.getLastMaintenance().toString());
                System.out.println("New Last Maintenance Date: ");
                speedBoat.setLastMaintenance(Date.newDate("new Last Maintenance Date"));
            }
            case 7 -> {
                System.out.println("Current Next Maintenance Date: " + speedBoat.getNextMaintenance().toString());
                System.out.println("New Next Maintenance Date: ");
                speedBoat.setNextMaintenance(Date.newDate("new Next Maintenance Date"));
            }
            case 8 -> {
                System.out.println("Current Length in Meters: " + speedBoat.getLengthInMeters());
                System.out.print("New Length in Meters: ");
                try {
                    speedBoat.setLengthInMeters(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 9 -> {
                System.out.println("Current Weight in Tons: " + speedBoat.getWeightInTons());
                System.out.print("New Weight in Tons: ");
                try {
                    speedBoat.setWeightInTons(Double.parseDouble(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 10 -> {
                System.out.println("Current Max Speed in knots: " + speedBoat.getMaxSpeedKnots());
                System.out.print("New Max Speed in knots: ");
                try {
                    speedBoat.setMaxSpeedKnots(Integer.parseInt(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            case 11 -> {
                System.out.println("Current Number of Life Vests: " + speedBoat.getNumberOfLifeVests());
                System.out.print("New number of life vests: ");
                try {
                    speedBoat.setNumberOfLifeVests(Integer.parseInt(sc.nextLine()));
                } catch (InvalidInputException e) {
                    System.out.println("Error " + e.getMessage());
                }
            }
            default -> System.out.println("Input not recognized, returning to menu.");
        }
        DataOperations.save(navalCommand);
    }

    /**
     * Method that iterates the {@link SpeedBoatList} and searches for the given id.
     *
     * @param id           -> {@link SpeedBoat} Id to search for.
     * @param navalCommand -> NavalCommand to search in.
     */
    public static SpeedBoat searchSpeedBoat(int id, NavalCommand navalCommand) {
        SpeedBoat[] container = navalCommand.getSpeedBoatContainer().getContainer();
        for (SpeedBoat f : container) {
            if (f.getId() == id) {
                return f;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
    }


    /**
     * Method to request the data and create a new SpeedBoat. See {@link Models.SpeedBoatList#add(SpeedBoat)} for the method that adds to the SpeedBoat List.
     *
     * @param sc           Scanner to read input.
     * @param navalCommand The naval command to add the Corvette.
     */
    public static void addSpeedBoat(Scanner sc, NavalCommand navalCommand) {
        SpeedBoat speedBoat = new SpeedBoat();
        System.out.println("\n-Creating SpeedBoat-");
        speedBoat.setId(SpeedBoat.getNextId());
        System.out.println("New SpeedBoat ID: " + speedBoat.getId());
        System.out.print("Enter new SpeedBoat's Name: ");
        speedBoat.setName(sc.nextLine());
        System.out.print("Enter new SpeedBoat's Manufacturer: ");
        speedBoat.setManufacturer(sc.nextLine());
        boolean flag = false;
        while (!flag) {
            try {
                if (speedBoat.getBaptismDate() == null) {
                    speedBoat.setBaptismDate(Date.newDate("SpeedBoat's Baptism Date"));
                    flag = true;
                }
                if (speedBoat.getLastInspection() == null) {
                    speedBoat.setLastInspection(Date.newDate("SpeedBoat's Last Inspection Date"));
                    flag = true;
                }
                if (speedBoat.getNextInspection() == null) {
                    speedBoat.setNextInspection(Date.newDate("SpeedBoat's Next Inspection Date"));
                    flag = true;
                }
                if (speedBoat.getLastMaintenance() == null) {
                    speedBoat.setLastMaintenance(Date.newDate("SpeedBoat's Last Maintenance Date"));
                    flag = true;
                }
                if (speedBoat.getNextMaintenance() == null) {
                    speedBoat.setNextMaintenance(Date.newDate("SpeedBoat's Next Maintenance Date"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter new SpeedBoat's Length (in meters)");
        speedBoat.setLengthInMeters(getOption(sc));
        System.out.print("Enter new SpeedBoat's Weight (in tons)");
        speedBoat.setWeightInTons(getOption(sc));
        System.out.print("Enter new SpeedBoat's Max Speed (in knots)");
        speedBoat.setMaxSpeedKnots((int) getOption(sc));
        System.out.print("Enter how many life vests the ship has: ");
        try {
            speedBoat.setNumberOfLifeVests(Integer.parseInt(sc.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.print("Enter how many Operations the ship has: ");
        int count = 0;
        try {
            int nOp = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < nOp; i++) {
                System.out.print("Enter the Operation ID: ");
                speedBoat.getHistory().add(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand));
                count++;
            }
            System.out.println("Added " + count + " operations.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        navalCommand.getSpeedBoatContainer().add(speedBoat);
        DataOperations.save(navalCommand);
    }

    /**
     * Method that iterates the {@link Models.SpeedBoatList} and outputs all the instances.
     *
     * @param navalCommand The naval command to iterate.
     */
    private static void listSpeedBoats(NavalCommand navalCommand) {
        for (SpeedBoat boat : navalCommand.getSpeedBoatContainer().getContainer()) {
            if (boat != null) {
                System.out.println(boat);
            }
        }
    }

}
