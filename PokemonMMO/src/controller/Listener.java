package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Listener extends Actions {
	Listener() throws IOException { 
		frame.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {}
			
			@Override
			public void keyReleased(KeyEvent e) {}
			
			@Override
			public void keyPressed(KeyEvent e) {
				getAction(e).run();
			}
		});
	}
}
