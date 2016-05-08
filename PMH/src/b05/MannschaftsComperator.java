package b05;

import java.util.Comparator;


/**
 * Um Mannschaften innerhalb einer Liga noch Punkten absteigend zu Sortieren
 * @author karl
 *
 */
public class MannschaftsComperator implements Comparator<Mannschaft> {
    @Override
    public int compare(Mannschaft o1, Mannschaft o2) {
        return o2.getPunkte()-o1.getPunkte();
    }
}

