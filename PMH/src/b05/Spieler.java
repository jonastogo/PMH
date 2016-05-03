package b05;
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
public abstract class Spieler {
	
    // Fill me :)
	protected int punkte = 0;
    private String name;
    
    
    /**
     * Setzt die Spieler Werte
     * @param name
     * @param punkte
     */
    public Spieler(String name, int punkte) {
    	this.name = name;
    	this.punkte = punkte;
    }
    
    /**
     * Liefert den Namen des Spielers zurück.
     *
     * @return String Name des Spielers
     *
     */
    public String getName() {
    	return name;
    }

    /**
     * Liefert die vom Spieler erzielten Punkte zurück.
     *
     * @return int Punkte des Spielers
     *
     */
    public int getPunkte() {
    	return punkte;
    }

    /**
     * Erzielt einen Punkt.
     *
     * Muss in abgeleiteten Klassen implementiert werden: Ein Fussballspieler
     * erzielt einen Punkt, indem er ein Tor schiesst. Ein Basketballspieler
     * muss analog einen Korb für zwei Punkte werfen.
     *
     */
    public abstract void score();

}
