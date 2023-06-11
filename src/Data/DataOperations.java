/*
 * Nome: Rui Pedro Correia da Silva
 * Número: 8210694
 * Turma: LSIG
 */
package Data;

import Models.NavalCommand;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.CREATE;

public class DataOperations {
    static final String NAVAL_COMMAND_FILE = "navalCommandData.dat";

    /**
     * Loads the Data from the file 'navalCommandData.dat'
     *
     * @return the read NavalC Command
     */
    public static NavalCommand load() {
        NavalCommand navalCommand = null;
        Path file = Paths.get(NAVAL_COMMAND_FILE);
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file.toString()));
            navalCommand = (NavalCommand) o.readObject();
            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return navalCommand;
    }

    /**
     * Saves the Naval Command into the file. If doesn´t exists, creates it.
     *
     * @param navalCommand Naval command to save
     */
    public static void save(NavalCommand navalCommand) {
        Path file = Paths.get(NAVAL_COMMAND_FILE);
        try {
            ObjectOutputStream o = new ObjectOutputStream(Files.newOutputStream(file, CREATE));
            o.writeObject(navalCommand);
            o.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
