package uml2code;


/**
 * Klasse für eine Nicht-Funktionale Anforderung
 * 
 */
@ClassAnno(autoren={"Charlie Sheen", "Bill Gates"}, datum = "02.05.2012")
public class NichtFunktionaleAnforderung extends Anforderung{
	/**
	 * Konstruktor für eine Nicht-Funktionale Anforderung, setzt id und text
	 * 
	 * 
	 * @param id
	 * @param text
	 */
	public NichtFunktionaleAnforderung(int id, String text) {
		this.id = id;
		this.text = text;
	}
}
