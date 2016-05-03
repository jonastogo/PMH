package b05;
/**
 * Teil der Vorgabe
 */

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Carsten Gips
 * @author Ronald Lepp
 * @author Christian Gawlik
 * @param <S>
 * @since 04.05.2105
 *
 */
public abstract class Liga <M extends Mannschaft<?>>{
	private ArrayList<M> mannschaftListe = new ArrayList<M>();
    
    
    /**
     * Fügt eine Mannschaft der Liga hinzu.
     *
     * Eine Mannschaft kann in der Liga nur einmal vorkommen.
     *
     * @param mannschaft
     *            Mannschaft, die hinzugefügt werden soll.
     * @return false bei einem Fehler, ansonsten true.
     */
    public boolean aufnehmen(M mannschaft) {
    	if(mannschaftListe.contains(mannschaft))
    		return false;
    	mannschaftListe.add(mannschaft);
    	return true;
    }

    /**
     * Entfernt eine Mannschaft aus der Liga.
     *
     * @param mannschaft
     *            Mannschaft, die entfernt werden soll.
     * @return false bei einem Fehler, ansonsten true.
     */
    public boolean rauswerfen(M mannschaft) {
    	if(!mannschaftListe.contains(mannschaft))
    		return false;
    	mannschaftListe.remove(mannschaft);
    	return true;
    }

    /**
     * Sortiert die Mannschaften der Liga absteigend nach Punkten
     *
     */
    public void sortMannschaften() {
    	Collections.sort(mannschaftListe, new MannschaftsComperator());
    }
    
    /**
     * Gives the number of mannschaften
     * @return The number
     */
    public int getMannschaftNum() {
    	return mannschaftListe.size();
    }
    
    /**
     * Pops the last mannschaft off the list
     * @return The popped object
     */
    public M popLast() {
    	int last_index = mannschaftListe.size()-1;
    	
    	// Avoid "freeing" and loss of the popped Element
    	M last = mannschaftListe.get(last_index);
    	
    	mannschaftListe.remove(last_index);
    	
    	return last;
    }
    /**
     * Pops the first mannschaft off the list
     * @return The poppped object
     */
    public M popFirst() {
    	M first = mannschaftListe.get(0);
    	
    	mannschaftListe.remove(0);
    	
    	return first;
    }
    
    public String toString() {
    	String str = "";
    	
    	for(M tmp : mannschaftListe) {
    		str += tmp.getName() + " " + String.valueOf(tmp.getPunkte()) + "\n";
    	}
    	
    	return str;
    }

}
