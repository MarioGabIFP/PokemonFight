package controller;

import view.Frame;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public class Launcher extends Thread {
	
	/**
	 * M�todo lanzador.
	 * 
	 * Ejecuta el videojuego para el usuario activo.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Launcher launch = new Launcher();
		launch.run();
	}
	
	@Override
	public void run() {
		Frame window = new Frame();
		window.frame.setVisible(true);
	}
}
