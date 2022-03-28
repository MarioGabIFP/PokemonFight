package view;

import javax.swing.JFrame;
import view.elements.Base;

public class Frame implements Base{

	/**
	 * Contructor de la ventana.
	 */
	public Frame() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 960, 640);
		frame.setMaximizedBounds(frame.getBounds());
		frame.setResizable(false);
		frame.setUndecorated(true);
		frame.getContentPane().setBackground(grayGameBoy);
		frame.setVisible(true);
	}
}