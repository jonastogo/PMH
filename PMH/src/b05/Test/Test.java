package b05.Test;

import static org.junit.Assert.assertEquals;

import b05.BundesLigaNongeneric;
import b05.FussballSpieler;
import b05.Mannschaft;

public class Test {
	@org.junit.Test
	public void testFuﬂballspieler() {
		FussballSpieler h = new FussballSpieler("hans", 8);

		assertEquals("hans", h.getName());
		assertEquals(8, h.getPunkte());

	}

	@org.junit.Test
	public void testManschaft() {
		Mannschaft<FussballSpieler> lastinfirst = new Mannschaft<FussballSpieler>("bielefeld");

		assertEquals("bielefeld", lastinfirst.getName());
	}

	@org.junit.Test
	public void testBundes() {
		BundesLigaNongeneric first = new BundesLigaNongeneric();
		Mannschaft<FussballSpieler> lastinfirst = new Mannschaft<FussballSpieler>("bielefeld");
		lastinfirst.aufnehmen(new FussballSpieler("rolf", 1));
		first.aufnehmen(lastinfirst);

		assertEquals("bielefeld 1\n", first.toString());

	}

}
