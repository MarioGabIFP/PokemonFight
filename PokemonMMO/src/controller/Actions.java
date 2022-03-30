package controller;

import java.util.ArrayList;
import view.Graphic;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions extends Graphic{
	private static final long serialVersionUID = 1L;

	ArrayList<Integer> KeyPressedList = new ArrayList<Integer>();

	public Runnable PlayerActions() {
		Runnable move = new Runnable() {
			@Override
			public void run() {
				if (!KeyPressedList.isEmpty()) {
					int x = player.getX();
					int y = player.getY();
					int w = player.getWidth();
					int h = player.getHeight();
					
					if (KeyPressedList.size() == 1) {
						int codeKey = KeyPressedList.get(0);
						
						if (codeKey == 40 || codeKey == 83) {
							player.setBounds(x, y + 5, w, h);
						} else if (codeKey == 38 || codeKey == 87) { 
							player.setBounds(x, y - 5, w, h);
						} else if (codeKey == 37 || codeKey == 65) { 
							player.setBounds(x - 5, y, w, h);
						} else if (codeKey == 39 || codeKey == 68) { 
							player.setBounds(x + 5, y, w, h);
						}
					} else if(KeyPressedList.size() > 1) {
						//Movimiento oblicuo
//						int codeKey_1 = KeyPressedList.get(0);
//						int codeKey_2 = KeyPressedList.get(1);
//						
//						if ((codeKey_1 == 40 || codeKey_1 == 83) && (codeKey_2 == 37 || codeKey_2 == 65)) {
//							player.setBounds(x - 5, y + 5, w, h);
//						} else if ((codeKey_1 == 40 || codeKey_1 == 83) && (codeKey_2 == 39 || codeKey_2 == 68)) {
//							player.setBounds(x + 5, y + 5, w, h);
//						} else if ((codeKey_1 == 38 || codeKey_1 == 87) && (codeKey_2 == 37 || codeKey_2 == 65)) {
//							player.setBounds(x - 5, y - 5, w, h);
//						} else if ((codeKey_1 == 38 || codeKey_1 == 87) && (codeKey_2 == 39 || codeKey_2 == 68)) {
//							player.setBounds(x + 5, y - 5, w, h);
//						} else if ((codeKey_1 == 37 || codeKey_1 == 65) && (codeKey_2 == 40 || codeKey_2 == 83)) {
//							player.setBounds(x - 5, y + 5, w, h);
//						} else if ((codeKey_1 == 37 || codeKey_1 == 65) && (codeKey_2 == 38 || codeKey_2 == 87)) {
//							player.setBounds(x - 5, y - 5, w, h);
//						} else if ((codeKey_1 == 39 || codeKey_1 == 68) && (codeKey_2 == 40 || codeKey_2 == 83)) {
//							player.setBounds(x + 5, y + 5, w, h);
//						} else if ((codeKey_1 == 39 || codeKey_1 == 68) && (codeKey_2 == 38 || codeKey_2 == 87)) {
//							player.setBounds(x + 5, y - 5, w, h);
//						}
					}
				}
			}
		};
		
		return move;
	}

}
