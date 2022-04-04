package view.elements;

import java.awt.Color;
import javax.swing.JFrame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Base {

    /**
     * <strong>Ventana principal del aplicativo</strong>.
     */
    JFrame frame = new JFrame();

    /**
     * <strong>Imitación del mítico color gris del embellecedor de la pantalla
     * de la Game Boy clásica</strong>.
     */
    Color grayGameBoy = new Color(144, 141, 147);
}
