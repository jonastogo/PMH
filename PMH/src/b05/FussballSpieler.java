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
public class FussballSpieler extends Spieler{

    // Fill me :)
    
    
    public FussballSpieler(String name, int punkte) {
		super(name, punkte);
		// TODO Auto-generated constructor stub
	}

	/**
     * Damit erzielt der Fussballspieler einen Punkt.
     *
     */
    private void schiessTor() {
    	punkte++;
    }

	@Override
	public void score() {
		schiessTor();
		
	}

}
