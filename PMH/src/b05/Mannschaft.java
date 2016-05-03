package b05;

import java.util.ArrayList;

/**
 * Teil der Vorgabe
 */

/**
 * @author Carsten Gips
 * @author Ronald Lepp
 * @author Christian Gawlik
 * @since 04.05.2105
 *
 */
public class Mannschaft <S extends Spieler>{
	private ArrayList<S> spielerListe = new ArrayList<S>();
    private String name;
    
    /**
     * Setzt den Namen
     * @param name
     */
    public Mannschaft(String name) {
    	this.name = name;
    }
    /**
     * Gibt den Namen
     * @return Namen der Mannschaft
     */
    public String getName() {
    	return name;
    }
    
    /**
     * Nimmt einen Spieler in die Mannschaft auf.
     *
     * Ein Spieler kann in mehreren verschiedenen Mannschaften spielen, aber in
     * einer Mannschaft nur einmal gelistet sein.
     *
     * @param spieler
     *            Spieler, der aufgenommen werden soll.
     * @return false wenn Spieler nicht hinzugefügt werden konnte, ansonsten
     *         true.
     */
    public boolean aufnehmen(S spieler) {
    	if(spielerListe.contains(spieler))
    		return false;
    	spielerListe.add(spieler);
    	return true;
    
    
    }

    /**
     * Entfernt einen Spieler aus der Mannschaft.
     *
     * @param spieler
     *            Spieler, der entfernt werden soll.
     * @return false wenn Spieler nicht entfernt werden konnte, ansonsten true.
     */
    public boolean rauswerfen(S spieler) {
    	if(!spielerListe.contains(spieler))
    		return false;
    	spielerListe.remove(spieler);
    	return true;
    }

    /**
     * Wechselt zwei Spieler aus.
     *
     * @param alt
     *            Alter Spieler, der entfernt werden soll.
     * @param neu
     *            Neuer Spieler, der hinzugefügt werden soll.
     * @return False bei einem Fehler, ansonsten true.
     */
    public boolean auswechseln(S alt, S neu) {
    	if(!rauswerfen(alt))
    		return false;
    	if(!aufnehmen(neu))
    		return false;
    	return true;
    
    }

    /**
     * Addiert die Punkte der einzelnen Spieler und liefert die Summe zurück.
     *
     * @return Punktzahl der Mannschaft
     */
    public int getPunkte() {
    	int	sum = 0;
    	
    	for(Spieler tmp : spielerListe)
    		sum += tmp.getPunkte();
    	
    	return sum;
    
    }

}
