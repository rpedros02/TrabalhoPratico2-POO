/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */

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
                    frigateController(sc);
                }
            }
        } while (option != 0);
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
            option = Main.getOption(sc);
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
            option = Main.getOption(sc);
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Frigate Menus Controller
     *
     * @param sc → Scanner to read the info
     */
    public static void frigateController(Scanner sc) {
        switch (frigateMenu(sc)) {
            case 1 -> {

            }
        }
    }
}
