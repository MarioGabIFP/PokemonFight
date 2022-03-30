package view;

import java.io.File;
import java.io.IOException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Screen extends Frame {
	private static final long serialVersionUID = 1L;
	
	public Screen() throws IOException {
		// establecemos los elementos de la escena en su posisicon inicial
		player.setBounds(200, 200, 35, 80);
		player.setPlayer_bmp(new File(spritePlayer + "2.png"));
		
		// Establecemos el espacio de juego.
		g_base.setBounds(223, 64, 514, 512);
		frame.add(g_base);
		
		//Corremos los graficos
		super.run();
	}
}