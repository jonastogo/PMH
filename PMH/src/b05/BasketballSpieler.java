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
public class BasketballSpieler extends Spieler{

    // Fill me :)
    
    
    public BasketballSpieler(String name, int punkte) {
		super(name, punkte);
		// TODO Auto-generated constructor stub
	}

	/**
     * Damit erzielt der Basketballspieler zwei Punkte.
     *
     */
    private void wirfKorb() {
    	punkte += 2;
    }

	@Override
	public void score() {
		wirfKorb();
	}

}
