package uml2code;


/**
 * Klasse für Funktionale Anforderung
 * 
 *
 */
@ClassAnno(autoren={"Helge Schneider", "Kerstin Müller"}, datum = "02.05.2012")
public class FunktionaleAnforderung extends Anforderung{
	/**
	 * Konstruktor für Funktionale Anforderung, setzt id und Text
	 * 
	 * 
	 * @param id
	 * @param text
	 */
	public FunktionaleAnforderung(int id, String text) {
		this.id = id;
		this.text = text;
		
	}
}
