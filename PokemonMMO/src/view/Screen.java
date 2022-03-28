package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.elements.screen.IMaps;
import view.elements.screen.Sprites;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Screen extends Frame implements Sprites, IMaps {
	public Screen() throws IOException {
		map.setBounds(223, 64, 514, 512);
		
		player.setBounds(100, 100, 35, 80);
		player.setPlayer_bmp(new File(spritePlayer + "2.png"));
		
		frame.add(map);
		
		loadMap(_1_bmp);
		loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
	}

	@Override
	public void loadMap(File image) throws IOException {
		Image bmp = ImageIO.read(image).getScaledInstance(514, 512, Image.SCALE_FAST);
		map.getGraphics().drawImage(bmp, 0, 0, map);
	}

	@Override
	public void loadSprite(File image, int x, int y) throws IOException {
		Image png = ImageIO.read(image).getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_FAST);
		map.getGraphics().drawImage(png, x, y, map);
	}
}