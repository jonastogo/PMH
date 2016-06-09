package b09.bildbetrachter;

import static org.junit.Assert.*;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

public class BilddateiManagerTest {
	BilddateiManager manager = new BilddateiManager();
	@Test
	public void testLadeBild(){
		File file =new File("data\\Test\\diagram.jpg");
		assertTrue(manager.ladeBild(file)!=null);
	}

}
