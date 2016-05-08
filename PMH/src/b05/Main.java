package b05;

public class Main {

	BundesLigaNongeneric		first, second;
	Mannschaft<FussballSpieler>	bestinfirst;
	Mannschaft<FussballSpieler>	lastinfirst;
	Mannschaft<FussballSpieler>	bestinsecond;
	Mannschaft<FussballSpieler>	lastinsecond;
	PieChart					pieChart;
	BarChart					barChart;
	LineChart					lineChart;

	public Main() {
		first = new BundesLigaNongeneric();
		second = new BundesLigaNongeneric();

		bestinfirst = new Mannschaft<FussballSpieler>("hagen west");
		lastinfirst = new Mannschaft<FussballSpieler>("bielefeld");
		bestinsecond = new Mannschaft<FussballSpieler>("compton");
		lastinsecond = new Mannschaft<FussballSpieler>("minden");

		bestinfirst.aufnehmen(new FussballSpieler("hans", 8));
		lastinfirst.aufnehmen(new FussballSpieler("rolf", 1));

		bestinfirst.aufnehmen(new FussballSpieler("joe", 4));
		lastinfirst.aufnehmen(new FussballSpieler("dan", 0));

		bestinfirst.aufnehmen(new FussballSpieler("martin", 6));
		lastinsecond.aufnehmen(new FussballSpieler("ernst", 3));

		bestinsecond.aufnehmen(new FussballSpieler("dieter", 9));
		lastinsecond.aufnehmen(new FussballSpieler("otto", 2));

		first.aufnehmen(lastinfirst);
		first.aufnehmen(bestinfirst);

		second.aufnehmen(bestinsecond);
		second.aufnehmen(lastinsecond);

		System.out.println(first);
		System.out.println(second);

		SaisonEnde.aufAbstieg(first, second);

		System.out.println("\n\n" + first);
		System.out.println(second);

		pieChart = new PieChart("Pie Chart", "Punkte pro Spieler", this);
		barChart = new BarChart("Punkte", this);
		lineChart = new LineChart("Line Chart");
	}

	public static void main(String[] args) {
		new Main();
	}

	public BundesLigaNongeneric getFirst() {
		return first;
	}

	public void setFirst(BundesLigaNongeneric first) {
		this.first = first;
	}

	public BundesLigaNongeneric getSecond() {
		return second;
	}

	public void setSecond(BundesLigaNongeneric second) {
		this.second = second;
	}

	public Mannschaft<FussballSpieler> getBestinfirst() {
		return bestinfirst;
	}

	public void setBestinfirst(Mannschaft<FussballSpieler> bestinfirst) {
		this.bestinfirst = bestinfirst;
	}

	public Mannschaft<FussballSpieler> getLastinfirst() {
		return lastinfirst;
	}

	public void setLastinfirst(Mannschaft<FussballSpieler> lastinfirst) {
		this.lastinfirst = lastinfirst;
	}

	public Mannschaft<FussballSpieler> getBestinsecond() {
		return bestinsecond;
	}

	public void setBestinsecond(Mannschaft<FussballSpieler> bestinsecond) {
		this.bestinsecond = bestinsecond;
	}

	public Mannschaft<FussballSpieler> getLastinsecond() {
		return lastinsecond;
	}

	public void setLastinsecond(Mannschaft<FussballSpieler> lastinsecond) {
		this.lastinsecond = lastinsecond;
	}

}
