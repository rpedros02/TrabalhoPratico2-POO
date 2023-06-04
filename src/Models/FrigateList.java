package Models;

import java.io.Serializable;

public class FrigateList implements Serializable {
    Frigate[] container;
    public static int nFrigates = 0;

    public FrigateList(){
        container = new Frigate[4];
    }

    public Frigate[] getContainer(){
        return container;
    }

    public void add(Frigate newFrigate){
        if (nFrigates == container.length) {
            Frigate[] temp = new Frigate[nFrigates + 4];
            System.arraycopy(container, 0, temp, 0, nFrigates);
            container = temp;
        }
        container[nFrigates++] = newFrigate;
    }
}
