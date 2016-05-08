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
public class SaisonEnde {

//     Fill me :)
    

    /**
     * Lässt die nach Punkten letzte Mannschaft der ersten Liga in die zweite
     * Liga absteigen und die nach Punkte erste Mannschaft der zweiten Liga in
     * die erste Liga aufsteigen.
     *
     * @param liga1
     *            Erste Liga
     * @param liga2
     *            Zweite Liga
     * @return False bei einem Fehler, ansonsten true.
     */
    public static <M extends Mannschaft<?>, L extends Liga<M>>boolean aufAbstieg(L liga1, L liga2) {
    	M secondsFirst;
    	M firstsLast;
    	
    	if(liga1.getMannschaftNum() < 1 || liga2.getMannschaftNum() < 1)
    		return false;
    	
    	liga1.sortMannschaften();
    	liga2.sortMannschaften();
    	
    	firstsLast = liga1.popLast();
    	secondsFirst = liga2.popFirst();
    	
    	liga1.aufnehmen(secondsFirst);
    	liga2.aufnehmen(firstsLast);
    	
        return true;
    
    
    }

}
