package view.elements.screen;

import java.awt.Canvas;
import java.io.File;
import java.io.IOException;
import view.elements.Assets;

/**
 * @author Mario Núñez Alcázar de Velasco
 */
public interface IMaps extends Assets {
	Canvas g_base = new Canvas();
	File _1_bmp = new File(Maps + "1.bmp");
	
	public void loadMap(File image) throws IOException;
}
