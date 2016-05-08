package uml2code;


/**
 * Annotation für jegliche Klasse, enthält Author(en) und das Erstellungsdatum
 * 
 */
public @interface ClassAnno {
	String[] autoren();
	String datum();
	
}
