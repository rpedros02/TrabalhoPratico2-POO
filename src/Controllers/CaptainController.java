/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Models.Captain;
import Models.Date;
import Models.NavalCommand;

import java.util.Scanner;

import static Controllers.ShipController.getOption;
import static Controllers.CrewController.getPatent;
import static Controllers.CrewController.editCrew;

public class CaptainController {
    public static void run(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = captainMenu(sc);
            switch (op) {
                case 0 -> {
                }
                case 1 -> addCaptain(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Captain's ID: ");
                    try {
                        editCrew(sc, searchCaptain(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Captains's ID: ");
                    try {
                        System.out.println(searchCaptain(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listCaptain(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Captains's ID: ");
                    try {
                        navalCommand.getCaptainContainer().delete(searchCaptain(Integer.parseInt(sc.nextLine()), navalCommand));
                        DataOperations.save(navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 6 -> CaptainController.run(navalCommand);
                default -> System.out.println("Input not recognized.");
            }
        } while (op != 0);
    }

    public static int captainMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nCaptain Menu");
            System.out.println("1. Add Captain Member;");
            System.out.println("2. Edit Captain Member;");
            System.out.println("3. Search Captain Member;");
            System.out.println("4. List Captain Members;");
            System.out.println("5. Delete Captain Member;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    public static void addCaptain(Scanner sc, NavalCommand navalCommand) {
        Captain captain = new Captain();
        System.out.println("\n-Creating Captain-");
        System.out.println("New Captain ID: " + captain.getId());
        System.out.print("Enter new Captain's Name: ");
        captain.setName(sc.nextLine());
        captain.setPatent(getPatent(sc));
        boolean flag = false;
        while (!flag) {
            try {
                if (captain.getDateOfBirth() == null) {
                    captain.setDateOfBirth(Date.newDate("Captain's Birth Date:"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print("Enter the number of Medals the Captain " + captain.getName() + " has: ");
        int count = 0;
        try {
            int numMedals = Integer.parseInt(sc.nextLine());
            for (int i = 0; i < numMedals; i++) {
                System.out.print("Enter the name of the Medal: ");
                String medal = sc.nextLine();
                captain.getMedals().add(medal);
                count ++;
            }
            System.out.println("Added " + count + " Medals");
        } catch (Exception e) {
            System.out.println("Invalid input " + e.getMessage().toLowerCase());
        }
        navalCommand.getCaptainContainer().add(captain);
        DataOperations.save(navalCommand);
    }


    public static Captain searchCaptain(int id, NavalCommand navalCommand) {
        Captain[] container = navalCommand.getCaptainContainer().getContainer();
        for (Captain c : container) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
    }

    private static void listCaptain(NavalCommand navalCommand) {
        System.out.println();
        for (Captain c : navalCommand.getCaptainContainer().getContainer()) {
            if (c != null) {
                System.out.println(c);
                int count = 0;
                System.out.println("Medals:");
                for (String s : c.getMedals().getContainer()) {
                    if (s != null) {
                        System.out.println(s + "; ");
                        count++;
                    }
                }
                if (count == 0) System.out.println("No Medals on the records.");
                System.out.println("---------\n");
            }
        }
    }
}
