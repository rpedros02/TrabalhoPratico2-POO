/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */

import Controllers.CrewController;
import Controllers.OperationController;
import Controllers.ShipController;
import Controllers.StatisticsController;
import Data.DataOperations;
import Data.MockData;
import Exceptions.InvalidInputException;
import Exceptions.InvalidNumberException;
import Models.NavalCommand;

import java.util.Scanner;

public class Main {
    /**
     * Main Funcion
     */
    public static void main(String[] args) {
        NavalCommand navalCommand;
        if (DataOperations.load() == null) {
            switch (initialMenu()) {
                case 1 -> {
                    navalCommand = new NavalCommand();
                    MockData.generateData(navalCommand);
                    DataOperations.save(navalCommand);
                    navalCommand = DataOperations.load();
                    System.out.println(navalCommand.getName() + " loaded.\b");
                }
                case 2 -> {
                    navalCommand = createNavalCommand();
                    System.out.println(navalCommand.getName() + " created.\b");
                }
                default -> System.out.println("\b--Goodbye!--");
            }
        }
        navalCommand = DataOperations.load();
        int option;
        do {
            option = mainMenu();
            switch (option) {
                case 1 -> navalMenu(navalCommand);
                case 2 -> ShipController.run(navalCommand);
                case 3 -> CrewController.run(navalCommand);
                case 4 -> OperationController.run(navalCommand);
                case 5 -> StatisticsController.run(new Scanner(System.in), navalCommand);
            }
        } while (option != 0);
        System.out.println("\b--Goodbye!--");
    }


    /**
     * Initial menu deployed when there is no data about a Naval Command, it allows the user to choose either to generate a new MOCK using {@link MockData}, or creating an empty one.
     *
     * @return a fresh new Naval Command object, either with data, or not.
     * @throws InvalidNumberException when an error occurs while parsing the user input.
     */
    private static int initialMenu() throws InvalidNumberException {
        Scanner sc = new Scanner(System.in);
        int option;
        do {
            System.out.println("\nData Menu");
            System.out.println("1. Generate MOCK Naval Command;");
            System.out.println("2. Create New Naval Command;");
            System.out.println("0. Quit");
            option = (int) ShipController.getOption(sc);
        } while (option < 0 || option > 2);
        return option;
    }

    /**
     * Function that prints the main menu of the app and retrieves the users input option.
     *
     * @return users option
     */
    private static int mainMenu() throws InvalidNumberException {
        Scanner sc = new Scanner(System.in);
        NavalCommand navalCommand = DataOperations.load();
        int option;
        do {
            System.out.println("\nMain Menu");
            System.out.println("Naval Command: " + navalCommand.getName());
            System.out.println("1. Edit Naval Command;");
            System.out.println("2. Ship Menu;");
            System.out.println("3. Crew Menu;");
            System.out.println("4. Operation Menu;");
            System.out.println("5. Statistics Menu;");
            System.out.println("0. Quit");
            option = (int) ShipController.getOption(sc);
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Naval Command's Menu
     * The only editable attribute is its name, so the only option given to the user is if they want to edit the name or not.
     *
     * @param navalCommand → The Naval Command to edit.
     * @throws InvalidInputException when the input doesn't satisfy the required.
     */
    private static void navalMenu(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("\bEditing - " + navalCommand.getName());
        System.out.println("Are you sure you want to change the name? (y - yes | n- no)");
        System.out.print("--> ");
        try {
            switch (sc.nextLine().toLowerCase()) {
                case "y" -> {
                    System.out.println("Enter the new Naval Command's name: ");
                    System.out.print("--> ");
                    String newName = sc.nextLine();
                    navalCommand.setName(newName);
                    DataOperations.save(navalCommand);
                }
                case "n" -> System.out.println("Answer not registered.\b");
                default -> throw new InvalidInputException("Error: the given input is not recognized!\n");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Funcion that creates a new standard Naval Command
     *
     * @return the new Naval Command
     * @throws InvalidNumberException when an error occurs while parsing the user input.
     */
    private static NavalCommand createNavalCommand() {
        Scanner sc = new Scanner(System.in);
        System.out.print("\bNaval Command Name: ");
        return new NavalCommand(sc.nextLine());
    }

}

