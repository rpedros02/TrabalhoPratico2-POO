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

    public static void run(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        switch (shipMenu(sc)) {
            case 1 -> {
                frigateController(sc);
            }
        }
    }

    /**
     * Ship Menu
     *
     * @param navalCommand → Naval Command
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

    public static int frigateMenu(Scanner sc) {
        int option = -1;
        do {
            System.out.println("\nFrigate Menu");
            System.out.println("1. Frigate Menu;");
            System.out.println("2. Corvette Menu;");
            System.out.println("3. Speed Boat Menu;");
            System.out.println("0. Quit;");
            option = Main.getOption(sc);
        } while (option < 0 || option > 3);
        return option;
    }

    public static void frigateController(Scanner sc) {
        switch (frigateMenu(sc)) {
            case 1 -> {

            }
        }
    }
}
