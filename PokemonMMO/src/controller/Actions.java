package controller;

import java.awt.Image;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import view.elements.screen.IMaps;
import view.elements.screen.Sprites;

/**
 * @author mario
 *
 */
public class Actions implements IMaps, Sprites {
	public Runnable getAction(KeyEvent e) {
		Runnable moveDown = new Runnable() {
			@Override
			public void run() {
				int codeKey = e.getKeyCode();
				if (codeKey == 40 || codeKey == 83) {
					player.setBounds(player.getX(), player.getY() + 5, player.getWidth(), player.getHeight());
					
					try {
						loadMap(_1_bmp);
						loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				} else if (codeKey == 38 || codeKey == 87) { 
					player.setBounds(player.getX(), player.getY() - 5, player.getWidth(), player.getHeight());
					
					try {
						loadMap(_1_bmp);
						loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				} else if (codeKey == 37 || codeKey == 65) { 
					player.setBounds(player.getX() - 5, player.getY(), player.getWidth(), player.getHeight());
					
					try {
						loadMap(_1_bmp);
						loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					
				} else if (codeKey == 39 || codeKey == 68) { 
					player.setBounds(player.getX() + 5, player.getY(), player.getWidth(), player.getHeight());
					
					try {
						loadMap(_1_bmp);
						loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		};
		
		return moveDown;
	}
	
	@Override
	public void loadSprite(File image, int x, int y) throws IOException {
		Image bmp = ImageIO.read(image).getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_FAST);
		map.getGraphics().drawImage(bmp, x, y, map);
	}

	@Override
	public void loadMap(File image) throws IOException {
		Image bmp = ImageIO.read(image).getScaledInstance(514, 512, Image.SCALE_FAST);
		map.getGraphics().drawImage(bmp, 0, 0, map);
	}

}
