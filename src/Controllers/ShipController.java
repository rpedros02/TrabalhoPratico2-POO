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

import Models.Date;
import Models.Frigate;
import Models.NavalCommand;

import java.util.Scanner;

public class ShipController {

    /**
     * Void to start the Ship Menu
     *
     * @param navalCommand → Naval Command to edit
     */
    public static void run(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            switch (option = shipMenu(sc)) {
                case 1 -> {
                    frigateController(sc, navalCommand);
                }
            }
        } while (option != 0);
    }

    /**
     * Method to retrieve users input.
     *
     * @param sc → Scanner
     * @return int value of user input
     */
    public static double getOption(Scanner sc) {
        int option = -1;
        System.out.print("--> ");
        try {
            option = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error: " + e);
        }
        return option;
    }

    /**
     * Ship Menu
     *
     * @param sc → Scanner to read the info
     */
    public static int shipMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nShip Menu");
            System.out.println("1. Frigate Menu;");
            System.out.println("2. Corvette Menu;");
            System.out.println("3. Speed Boat Menu;");
            System.out.println("0. Quit;");
            option = (int) getOption(sc);
        } while (option < 0 || option > 3);
        return option;
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
            System.out.println("0. Quit;");
            option = (int) getOption(sc);
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Frigate Menus Controller
     *
     * @param sc → Scanner to read the info
     */
    public static void frigateController(Scanner sc, NavalCommand navalCommand) {
        switch (frigateMenu(sc)) {
            case 1 -> {
                addFrigate(sc, navalCommand);
            }
        }
    }

    public static void addFrigate(Scanner sc, NavalCommand navalCommand) {
        Frigate newFrigate = new Frigate();
        System.out.println("\n-Creating Frigate-");
        System.out.print("Frigate Name: ");
        newFrigate.setName(sc.nextLine());
        System.out.print("Frigate Manufacturer: ");
        newFrigate.setManufacturer(sc.nextLine());
        newFrigate.setBaptismDate(Date.newDate("Baptism Date"));
        newFrigate.setLastInspection(Date.newDate("Last Inspection Date"));
        newFrigate.setNextInspection(Date.newDate("Next Inspection Date"));
        newFrigate.setLastMaintenance(Date.newDate("Last Maintenance Date"));
        newFrigate.setNextMaintenance(Date.newDate("Next Maintenance Date"));
        System.out.print("Frigate Length (in meters)");
        newFrigate.setLengthInMeters(getOption(sc));
        System.out.print("Frigate Weight (in tons)");
        newFrigate.setWeightInTons(getOption(sc));
        System.out.print("Frigate Max Speed (in knots)");
        newFrigate.setMaxSpeedKnots((int) getOption(sc));
        System.out.print("Add Operation History? (y - yes | n - no): ");
        switch (sc.nextLine().toLowerCase()) {
            case "y" -> {

            }
            case "n" -> {

            }
            default -> {
                System.out.println("Invalid Answer, not adding Operations.");
            }
        }
    }
}
