package b09.bildbetrachter;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class FarbbildTest {
	final static String	DATA	= "data\\Test\\diagram.jpg";
	int					x		= 5;
	int					y		= 5;
	Color				color	= new Color(0, 0, 0, 255);
	File				file	= new File(DATA);

	@Test
	public void testSetzePunktfarbe() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.setzePunktfarbe(this.x, this.y, this.color);
		assertEquals(bild.getRGB(this.x, this.y), -16777216);
	}

	@Test
	public void testGibPunktfarbe() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.setzePunktfarbe(this.x, this.y, this.color);
		Color ref = new Color(bild.getRGB(this.x, this.y));
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));

	}

	@Test
	public void testInventieren() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		Color ref = new Color(196, 192, 189);
		bild.inventieren();
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

	@Test
	public void testSpiegelnY() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.spiegelnY();
		Color ref = new Color(59, 63, 66);
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

	@Test
	public void testSpiegelnX() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.spiegelnX();
		Color ref = new Color(59, 63, 66);
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

	@Test
	public void testAbdunkeln() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.abdunkeln();
		Color ref = new Color(41, 44, 46);
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

	@Test
	public void testAufhellen() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.abdunkeln();
		Color ref = new Color(41, 44, 46);
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

	@Test
	public void testSchwellwerteAnwenden() throws IOException {
		BufferedImage buff = ImageIO.read(this.file);
		Farbbild bild = new Farbbild(buff);
		bild.abdunkeln();
		Color ref = new Color(41, 44, 46);
		assertEquals(ref, bild.gibPunktfarbe(this.x, this.y));
	}

}
