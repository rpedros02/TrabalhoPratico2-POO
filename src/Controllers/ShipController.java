/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

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
        int option;
        do {
            switch (option = shipMenu(sc)) {
                case 1 -> FrigateController.run(sc, navalCommand);
                case 2 -> CorvetteController.run(sc, navalCommand);
                case 3 -> SpeedBoatController.run(sc, navalCommand);
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
            System.out.println("0. Back;");
            option = (int) getOption(sc);
        } while (option < 0 || option > 3);
        return option;
    }
}
