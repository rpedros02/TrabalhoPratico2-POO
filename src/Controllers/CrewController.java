/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Enums.Patent;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Models.CrewMember;
import Models.Date;
import Models.NavalCommand;

import java.io.Serializable;
import java.util.Scanner;

import static Controllers.ShipController.getOption;

public class CrewController implements Serializable {
    /**
     * Void to run the Crew Controller.
     *
     * @param navalCommand Naval command to use
     */
    public static void run(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = crewMenu(sc);
            switch (op) {
                case 0 -> {
                }
                case 1 -> addCrew(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Crew Member's ID: ");
                    try {
                        editCrew(sc, searchCrew(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Crew Member's ID: ");
                    try {
                        System.out.println(searchCrew(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listCrew(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Crew Member's ID: ");
                    try {
                        navalCommand.getCrewMemberContainer().delete(searchCrew(Integer.parseInt(sc.nextLine()), navalCommand));
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

    /**
     * Crew Main Menu
     *
     * @param sc Scanner Input
     * @return user's option
     */
    public static int crewMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nCrew Menu");
            System.out.println("1. Add Crew Member;");
            System.out.println("2. Edit Crew Member;");
            System.out.println("3. Search Crew Member;");
            System.out.println("4. List Crew Members;");
            System.out.println("5. Delete Crew Member;");
            System.out.println("6. Captain Controller.");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 6) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 6);
        return option;
    }

    /**
     * Method to request the user for the Patente.
     *
     * @param sc Scanner to read input.
     * @return the {@link Patent}.
     */
    public static Patent getPatent(Scanner sc) {
        int op;
        do {
            System.out.println("Enter the Crew Member's Patent: ");
            System.out.println("1. Praça;");
            System.out.println("2. Sargento;");
            System.out.println("3. Oficial Subalterno;");
            System.out.println("4. Oficial General.");
            op = (int) getOption(sc);
            if (op < 1 || op > 4) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 4);
        switch (op) {
            case 1 -> {
                return Patent.PRACA;
            }
            case 2 -> {
                return Patent.SARGENTO;
            }
            case 3 -> {
                return Patent.SUBALTERNO;
            }
            default -> {
                return Patent.GENERAL;
            }
        }
    }

    /**
     * Method to request the data and create a new Crew Member. See {@link Models.CrewList#add(CrewMember)} for the method that adds to the CrewList.
     *
     * @param sc           Scanner to read input.
     * @param navalCommand The naval command to add the Crew Member.
     */
    public static void addCrew(Scanner sc, NavalCommand navalCommand) {
        CrewMember crewMember = new CrewMember();
        System.out.println("\n-Creating Crew Member-");
        System.out.println("New Crew Member ID: " + crewMember.getId());
        System.out.print("Enter new Crew Member's Name: ");
        crewMember.setName(sc.nextLine());
        crewMember.setPatent(getPatent(sc));
        boolean flag = false;
        while (!flag) {
            try {
                if (crewMember.getDateOfBirth() == null) {
                    crewMember.setDateOfBirth(Date.newDate("Crew Member's Birth Date:"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                System.out.println(e.getMessage());
            }
        }
        navalCommand.getCrewMemberContainer().add(crewMember);
        DataOperations.save(navalCommand);
    }

    /**
     * Method to Edit a {@link CrewMember} instance.
     *
     * @param crewMember   {@link CrewMember} instance to edit.
     * @param navalCommand {@link NavalCommand} to save.
     */
    public static void editCrew(Scanner sc, CrewMember crewMember, NavalCommand navalCommand) {
        System.out.println("\nEditing - " + crewMember.getName());
        System.out.println("Select field to edit: ");
        System.out.println("1. Name;");
        System.out.println("2. Patent;");
        System.out.println("3. Birth Date;");
        System.out.println("0. Back;");
        System.out.print("--> ");
        int option = (int) getOption(sc);
        switch (option) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Current name: " + crewMember.getName());
                System.out.print("New name: ");
                crewMember.setName(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Current Patent: " + crewMember.getPatent());
                crewMember.setPatent(getPatent(sc));
            }
            case 3 -> {
                System.out.println("Current Birth Date: " + crewMember.getDateOfBirth().toString());
                crewMember.setDateOfBirth(Date.newDate("new Baptism Date"));
            }
            default -> System.out.println("Input not recognized, returning to menu.");
        }
        DataOperations.save(navalCommand);
    }

    /**
     * Searches the CrewList for a given id;
     *
     * @param id           id to search for
     * @param navalCommand Naval Command to search in
     * @return the found Crew Member
     */
    public static CrewMember searchCrew(int id, NavalCommand navalCommand) {
        CrewMember[] container = navalCommand.getCrewMemberContainer().getContainer();
        for (CrewMember c : container) {
            if (c.getId() == id) {
                return c;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
    }

    /**
     * Lists the Crew Members
     *
     * @param navalCommand Naval Command to List
     */
    private static void listCrew(NavalCommand navalCommand) {
        for (CrewMember c : navalCommand.getCrewMemberContainer().getContainer()) {
            if (c != null) {
                System.out.println(c);
            }
        }
    }
}
