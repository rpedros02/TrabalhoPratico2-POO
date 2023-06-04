package Models;

import java.io.Serializable;

public class CorvetteList implements Serializable {
    public Corvette[] container;
    public int nCorvettes;

    public CorvetteList(){
        container = new Corvette[4];
    }

    public Corvette[] getContainer() {
        return container;
    }
}
