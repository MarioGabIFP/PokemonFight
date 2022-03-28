package view.elements;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Mario Gabriel N��ez Alc�zar de Velasco
 */
public interface Base {
	/**
	 * <strong>Ventana principal del aplicativo</strong>.
	 */
	JFrame frame = new JFrame();
	
	/**
	 * <strong>Imitaci�n del m�tico color gris del embellecedor de la pantalla de la Game Boy cl�sica</strong>.
	 */
	Color grayGameBoy = new Color(144, 141, 147);
}
