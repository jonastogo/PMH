package uml2code;


/**
 * Abstrakte Klasse für eine Anforderung enthält Text und ID
 * 
 */
@ClassAnno(autoren={"Markus Lanz", "Terence Hill"}, datum = "23.05.2012")
public abstract class Anforderung {
	protected int id;
	protected String text;
	protected Author ersteller;
}
