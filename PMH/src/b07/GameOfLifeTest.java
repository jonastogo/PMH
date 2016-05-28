package b07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GameOfLifeTest {

	String		s			= "           XXX            ";
	int			x			= 5;
	int			y			= 5;
	GameOfLife	game		= new GameOfLife(this.x, this.y);
	String		gametest	= "\n - - - - -\n - - - - -\n -X-X-X- -\n - - - - -\n - - - - -";

	@Test
	public void testGameOfLife() {

		assertTrue("Game Size X Test", this.game.game.length == 5);
		assertTrue("Game Size Y Test", this.game.game[1].length == 5);

	}

	@Test
	public void testToString() {
		this.game.initGame(this.s);

		assertEquals("toString Test ", this.game.toString(), this.gametest);
	}

	@Test
	public void testInitGame() {
		this.game.initGame(this.s);

		assertEquals("initGame test ", this.game.toString(), this.gametest);
	}

	@Test
	public void testNextGen() {
		this.game.initGame(this.s);
		assertTrue("NextGen Test", this.game.nextGen() == true);
	}

}
