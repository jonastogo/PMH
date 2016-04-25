package uml2code;

import java.sql.Date;

/**
 * Klasse für eine Änderung mit Grund und Datum
 * 
 */
@ClassAnno(autoren={"Markus Lanz", "Terence Hill"}, datum = "23.05.2012")
public class Aenderung {
	private Date datum;
	private String grund;
	private Author author;
	private Anforderung anf;
	
	/**
	 * Konstruktor für Aenderung
	 */
	public Aenderung() {
		
	}
}
