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

    public static void run(NavalCommand navalCommand){
        switch(shipMenu()){

        }
    }

    /**
     * Ship Menu
     *
     * @param navalCommand → Naval Command
     */
    public static int shipMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
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
}
