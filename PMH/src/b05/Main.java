package b05;

public class Main {

	public static void main(String[] args) {

		BundesLigaNongeneric first = new BundesLigaNongeneric();
		BundesLigaNongeneric second = new BundesLigaNongeneric();

		Mannschaft<FussballSpieler> bestinfirst = new Mannschaft<FussballSpieler>("hagen west");
		Mannschaft<FussballSpieler> lastinfirst = new Mannschaft<FussballSpieler>("bielefeld");
		Mannschaft<FussballSpieler> bestinsecond = new Mannschaft<FussballSpieler>("compton");
		Mannschaft<FussballSpieler> lastinsecond = new Mannschaft<FussballSpieler>("minden");
		
		bestinfirst.aufnehmen(new FussballSpieler("hans", 8));
		lastinfirst.aufnehmen(new FussballSpieler("rolf", 1));
		
		bestinsecond.aufnehmen(new FussballSpieler("joe", 4));
		lastinsecond.aufnehmen(new FussballSpieler("dan", 0));
		first.aufnehmen(lastinfirst);		
		first.aufnehmen(bestinfirst);

		second.aufnehmen(bestinsecond);
		second.aufnehmen(lastinsecond);
		
		
		System.out.println(first);
		System.out.println(second);
		
		
		SaisonEnde.aufAbstieg(first, second);
		
		System.out.println("\n\n" + first);
		System.out.println(second);
	}

}
