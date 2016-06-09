package b09.bildbetrachter;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class FarbbildTest {
	final static String DATA = "data\\Test\\diagram.jpg";
	File file = new File(DATA);

	


	@Test
	public void testSetzePunktfarbe() throws IOException {
		int x= 5;
		int y =5;
		Color color = new Color(0,0,0,255);
		BufferedImage buff = ImageIO.read(file);
		Farbbild bild = new Farbbild(buff);
		bild.setzePunktfarbe(x, y, color);
		assertEquals(bild.getRGB(x, y),-16777216);
	}

	@Test
	public void testGibPunktfarbe() throws IOException {
		int x= 5;
		int y =5;
		Color color = new Color(0,0,0,255);
		BufferedImage buff = ImageIO.read(file);
		Farbbild bild = new Farbbild(buff);
		bild.setzePunktfarbe(x, y, color);
		Color ref = new Color(bild.getRGB(x, y));
		assertEquals(ref,bild.gibPunktfarbe(x, y));
		
	}

}
