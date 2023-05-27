/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 *
 * Nome: Miguel Correia da Silva
 * Número: 8221002
 * Turma: LSIG
 */

import Data.DataOperations;
import Data.MockData;
import Exceptions.InvalidNumberException;
import Models.Frigate;
import Models.NavalCommand;
import Models.Ship;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int option = mainMenu();
        switch (option) {
            case 1 -> {
                if (DataOperations.load() == null) {
                    NavalCommand navalCommand = new NavalCommand();
                    MockData.generateData(navalCommand);
                    DataOperations.save(navalCommand);
                    System.out.println(navalCommand.getName());
                } else {
                    NavalCommand navalCommand = DataOperations.load();
                    for(Frigate ship : navalCommand.getFrigatesContainer()){
                        System.out.println(ship.getName());
                    }
                }
            }
            case 2 -> {

            }
            default -> {
                System.out.println("Goodbye!");
            }
        }
    }

    public static int mainMenu() throws InvalidNumberException {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("Main Menu");
            System.out.println("1. Generate MOCK;");
            System.out.println("2. Create New Command;");
            System.out.println("0. Quit");
            System.out.print("--> ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
            }
            if (option < 0 || option > 2) {
                System.out.println("Invalid Option!\n");
            }
        } while (option < 0 || option > 2);
        return option;
    }
}