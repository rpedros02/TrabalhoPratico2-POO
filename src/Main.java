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
import Exceptions.InvalidInputException;
import Exceptions.InvalidNumberException;
import Models.NavalCommand;

import java.util.Scanner;

public class Main {
    private static int initialMenu() throws InvalidNumberException {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("Main Menu");
            System.out.println("1. Load Naval Command;");
            System.out.println("2. Create New Naval Command;");
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

    private static NavalCommand createNavalCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nNaval Command Name: ");
        return new NavalCommand(sc.nextLine());
    }

    private static int mainMenu() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do {
            System.out.println("Main Menu");
            System.out.println("1. Naval Command Menu;");
            System.out.println("2. Ship Menu;");
            System.out.println("3. Crew Menu;");
            System.out.println("0. Quit");
            System.out.println("--> ");
            try {
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error: " + e);
            }
            if (option < 0 || option > 3) {
                System.out.println("Invalid Option!\n");
            }
        } while (option < 0 || option > 3);
        return option;
    }

    /**
     * Naval Command's Menu
     * The only editable attribute is its name, so the only option given to the user is if they want to edit the name or not.
     *
     * @param navalCommand → The Naval Command to edit.
     */
    private static void navalMenu(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing - " + navalCommand.getName());
        System.out.println("Are you sure you want to change the name? (y - yes | n- no)");
        System.out.print("--> ");
        switch (sc.nextLine().toLowerCase()) {
            case "y" -> {
                System.out.println("Enter the new Naval Command's name: ");
                System.out.print("--> ");
                navalCommand.setName(sc.nextLine());
            }
            case "n" -> System.out.println("Answer not registered.\n");
            default -> throw new InvalidInputException("Error: the given input doesnt satisfy the requirements!\n");
        }
    }

    public static void main(String[] args) {
        NavalCommand navalCommand = new NavalCommand();
        int option;
        switch (option = initialMenu()) {
            case 1 -> {
                if (DataOperations.load() == null) {
                    navalCommand = new NavalCommand();
                    MockData.generateData(navalCommand);
                    DataOperations.save(navalCommand);
                    System.out.println(navalCommand.getName() + " loaded.\n");
                } else {
                    navalCommand = DataOperations.load();
                    System.out.println(navalCommand.getName() + " loaded.\n");
                }
            }
            case 2 -> {
                navalCommand = createNavalCommand();
                System.out.println(navalCommand.getName() + " created.\n");
            }
            default -> System.out.println("Goodbye!");
        }
        if (option != 0) {
            if (mainMenu() == 1) {
                navalMenu(navalCommand);
            }
        }
    }
}

