package controller;

import java.awt.event.KeyEvent;
import view.Graphic;

/**
 * @author mario
 *
 */
public class Actions extends Graphic{
	public Runnable getAction(KeyEvent e) {
		Runnable moveDown = new Runnable() {
			@Override
			public void run() {
				int codeKey = e.getKeyCode();
				if (codeKey == 40 || codeKey == 83) {
					player.setBounds(player.getX(), player.getY() + 5, player.getWidth(), player.getHeight());
					
				} else if (codeKey == 38 || codeKey == 87) { 
					player.setBounds(player.getX(), player.getY() - 5, player.getWidth(), player.getHeight());
					
					
				} else if (codeKey == 37 || codeKey == 65) { 
					player.setBounds(player.getX() - 5, player.getY(), player.getWidth(), player.getHeight());
					
					
				} else if (codeKey == 39 || codeKey == 68) { 
					player.setBounds(player.getX() + 5, player.getY(), player.getWidth(), player.getHeight());
					
				}
			}
		};
		
		return moveDown;
	}

}
