/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Controllers;

import Data.DataOperations;
import Enums.OperationPorpuse;
import Enums.OperationType;
import Exceptions.FrigateNotFoundException;
import Exceptions.InvalidDateException;
import Models.*;

import java.util.Scanner;

import static Controllers.CaptainController.searchCaptain;
import static Controllers.CrewController.searchCrew;
import static Controllers.ShipController.getOption;

public class OperationController {

    /**
     * Method to run the Operation Controller
     * @param navalCommand Naval command to use
     */
    public static void run(NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        int op;
        do {
            op = operationMenu(sc);
            switch (op) {
                case 1 -> addOperation(sc, navalCommand);
                case 2 -> {
                    System.out.print("Enter the Operation ID: ");
                    try {
                        editFrigate(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand), navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 3 -> {
                    System.out.print("Enter the Operation ID: ");
                    try {
                        System.out.println(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand));
                    } catch (Exception e) {
                        System.out.println(e.getMessage().toLowerCase());
                    }
                }
                case 4 -> listOperations(navalCommand);
                case 5 -> {
                    System.out.print("Enter the Operation ID: ");
                    try {
                        navalCommand.getOperationsContainer().delete(searchOperation(Integer.parseInt(sc.nextLine()), navalCommand));
                        DataOperations.save(navalCommand);
                    } catch (Exception e) {
                        System.out.println("Invalid input " + e.getMessage().toLowerCase());
                    }
                }
                case 0 -> {
                }
                default -> System.out.println("Input not recognized.");
            }
        } while (op != 0);
    }

    /**
     * Operation Main Menu
     * @param sc Scanner for inputs
     * @return user's option
     */
    public static int operationMenu(Scanner sc) {
        int option;
        do {
            System.out.println("\nOperation Menu");
            System.out.println("1. Add Operation;");
            System.out.println("2. Edit Operation;");
            System.out.println("3. Search Operation;");
            System.out.println("4. List Operation;");
            System.out.println("5. Delete Operation;");
            System.out.println("0. Back;");
            option = (int) getOption(sc);
            if (option < 0 || option > 5) {
                System.out.println("Input not recognised.");
            }
        } while (option < 0 || option > 5);
        return option;
    }

    /**
     * Method to request the data and create a new Frigate. See {@link Models.OperationList#add(Operation)} for the method that adds to the Frigate List.
     *
     * @param sc           Scanner to read input.
     * @param navalCommand The naval command to add the Frigate.
     */
    public static void addOperation(Scanner sc, NavalCommand navalCommand) {
        Operation newOperation = new Operation();
        System.out.println("\n-Creating Frigate-");
        newOperation.setId(Frigate.getNextId());
        System.out.println("New Operation ID: " + newOperation.getId());
        System.out.println("Enter Operation briefing: ");
        System.out.print("--> ");
        newOperation.setMissionBriefing(sc.nextLine());
        boolean flag = false;
        while (!flag) {
            try {
                if (newOperation.getBeginDate() == null) {
                    newOperation.setBeginDate(Date.newDate("Operation Begin Date"));
                    flag = true;
                }
                if (newOperation.getEndMission() == null) {
                    newOperation.setEndMission(Date.newDate("Opration End Date"));
                    flag = true;
                }
                if (newOperation.getApprovedDate() == null) {
                    newOperation.setApprovedDate(Date.newDate("Operation Approved Date"));
                    flag = true;
                }
            } catch (InvalidDateException e) {
                flag = false;
                System.out.println(e.getMessage());
            }
        }
        flag = false;
        while (!flag) {
            try {
                System.out.print("Enter the Approving Member ID: ");
                newOperation.setApprovingMember(searchCrew(Integer.parseInt(sc.nextLine()), navalCommand));
                flag = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        flag = false;
        while (!flag) {
            try {
                System.out.print("Enter the Captain in charge ID: ");
                newOperation.setCaptain(searchCaptain(Integer.parseInt(sc.nextLine()), navalCommand));
                flag = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        newOperation.setOperationPorpuse(getOperationPorpuse(sc));
        newOperation.setOperationType(getOperationType(sc));
        System.out.print("Enter Crew Size: ");
        int nCrew = sc.nextInt();
        sc.nextLine();
        CrewList crewList = new CrewList();
        try {
            for (int i = 0; i < nCrew; i++) {
                System.out.print("Enter Crew Member's ID: ");
                crewList.add(searchCrew(Integer.parseInt(sc.nextLine()), navalCommand));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        navalCommand.getOperationsContainer().add(newOperation);
        DataOperations.save(navalCommand);
    }

    /**
     * Get user input for {@link OperationType}
     * @param sc Scanner for inputs
     * @return user's {@link OperationType}
     */
    public static OperationType getOperationType(Scanner sc) {
        int op;
        do {
            System.out.println("Enter the Operation Type: ");
            System.out.println("1. Combat;");
            System.out.println("2. Defense;");
            System.out.println("3. Patrol;");
            System.out.println("4. Escort;");
            System.out.println("5. Recon;");
            System.out.println("6. Rescue.");
            op = (int) getOption(sc);
            if (op < 1 || op > 6) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 6);
        switch (op) {
            case 1 -> {
                return OperationType.COMBAT;
            }
            case 2 -> {
                return OperationType.DEFENSE;
            }
            case 3 -> {
                return OperationType.PATROL;
            }
            case 4 -> {
                return OperationType.ESCORT;
            }
            case 5 -> {
                return OperationType.RECON;
            }
            default -> {
                return OperationType.RESCUE;
            }
        }
    }

    /**
     * Get user input for {@link OperationPorpuse}
     * @param sc Scanner for inputs
     * @return user's {@link OperationPorpuse}
     */
    public static OperationPorpuse getOperationPorpuse(Scanner sc) {
        int op;
        do {
            System.out.println("Enter the Operation Porpuse: ");
            System.out.println("1. National;");
            System.out.println("2. NATO;");
            System.out.println("3. ONU;");
            op = (int) getOption(sc);
            if (op < 1 || op > 3) {
                System.out.println("Try again!\n");
            }
        } while (op < 1 || op > 3);
        switch (op) {
            case 1 -> {
                return OperationPorpuse.NATIONAL;
            }
            case 2 -> {
                return OperationPorpuse.OTAN;
            }
            default -> {
                return OperationPorpuse.UN;
            }
        }
    }

    /**
     * Method to Edit a {@link Operation} instance.
     *
     * @param operation    {@link Operation} instance to edit.
     * @param navalCommand {@link NavalCommand} to save.
     */
    public static void editFrigate(Operation operation, NavalCommand navalCommand) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Editing Operation - " + operation.getId());
        System.out.println("Select field to edit: ");
        System.out.println("1. Briefing;");
        System.out.println("2. Begin Date;");
        System.out.println("3. End Date;");
        System.out.println("4. Approved Date;");
        System.out.println("5. Approving Member;");
        System.out.println("6. Captain;");
        System.out.println("7. Operation Type;");
        System.out.println("8. Operation Organisation;");
        System.out.println("0. Back;");
        System.out.print("--> ");
        int option = (int) getOption(sc);
        switch (option) {
            case 0 -> {
            }
            case 1 -> {
                System.out.println("Current Briefing: " + operation.getMissionBriefing());
                System.out.print("New briefing: ");
                operation.setMissionBriefing(sc.nextLine());
            }
            case 2 -> {
                System.out.println("Current Begin Date: " + operation.getBeginDate().toString());
                operation.setBeginDate(Date.newDate("new begin date"));
            }
            case 3 -> {
                System.out.println("Current End Date: " + operation.getEndMission().toString());
                operation.setEndMission(Date.newDate("new End Date"));
            }
            case 4 -> {
                System.out.println("Current Approved Date: " + operation.getApprovedDate().toString());
                System.out.println("New Approved Date: ");
                operation.setApprovedDate(Date.newDate("new Approved Date"));
            }
            case 5 -> {
                System.out.println("Current approving Member: " + searchCrew(operation.getApprovingMember().getId(), navalCommand));
                boolean flag = false;
                while (!flag) {
                    try {
                        System.out.print("Enter the new Approving Member ID: ");
                        operation.setApprovingMember(searchCrew(Integer.parseInt(sc.nextLine()), navalCommand));
                        flag = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            case 6 -> {
                System.out.println("Current Captain : " + searchCaptain(operation.getCaptain().getId(), navalCommand));
                boolean flag = false;
                while (!flag) {
                    try {
                        System.out.print("Enter the new Captain in charge ID: ");
                        operation.setCaptain(searchCaptain(Integer.parseInt(sc.nextLine()), navalCommand));
                        flag = true;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            case 7 -> {
                System.out.println("Current Operation type: " + OperationType.toString(operation.getOperationType()));
                operation.setOperationType(getOperationType(sc));
            }
            case 8 -> {
                System.out.println("Current Operation Organization: " + OperationPorpuse.toString(operation.getOperationPorpuse()));
                operation.setOperationPorpuse(getOperationPorpuse(sc));
            }
            default -> System.out.println("Input not recognized, returning to menu.");
        }
        DataOperations.save(navalCommand);
    }


    /**
     * Method that iterates the {@link OperationList} and searches for the given id.
     *
     * @param id           -> Frigate Id to search for.
     * @param navalCommand -> NavalCommand to search in.
     */
    public static Operation searchOperation(int id, NavalCommand navalCommand) {
        Operation[] container = navalCommand.getOperationsContainer().getContainer();
        for (Operation o : container) {
            if (o.getId() == id) {
                return o;
            }
        }
        throw new FrigateNotFoundException("id not found in the records.");
    }

    /**
     * Method that iterates the {@link Models.OperationList} and outputs all the instances.
     *
     * @param navalCommand The naval command to iterate.
     */
    private static void listOperations(NavalCommand navalCommand) {
        for (Operation o : navalCommand.getOperationsContainer().getContainer()) {
            if (o != null) {
                System.out.println(o);
            }
        }
    }
}
