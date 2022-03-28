package view.elements.screen;

import java.io.File;
import java.io.IOException;

import javax.swing.JPanel;
import view.elements.Assets;

/**
 * @author Mario Núñez Alcázar de Velasco
 */
public interface IMaps extends Assets {
	JPanel map = new JPanel();
	File _1_bmp = new File(Maps + "1.bmp");
	
	public void loadMap(File image) throws IOException;
}
