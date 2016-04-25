package uml2code;

/**
 * Klasse für den Author
 * 
 */
@ClassAnno(autoren={"Markus Lanz", "Bud Spencer"}, datum = "22.05.2012")
public class Author {
	private int personalNummer;
	private String name;
	
	/**
	 * Konstruktor für Author, setzt Name und Personal-Nummer.
	 * 
	 * @param personalNummer	Die Personal-Nummer des Authors
	 * @param name 				Der Name des Authors.
	 */
	public Author(int personalNummer, String name) {
		this.personalNummer = personalNummer;
		this.name = name;
	}
}
