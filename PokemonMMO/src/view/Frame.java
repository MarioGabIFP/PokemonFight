package view;

import javax.swing.JFrame;

public class Frame {

	public JFrame frame;

	/**
	 * Contructor de la ventana.
	 */
	public Frame() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
