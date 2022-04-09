package view.elements;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Base {

    /**
     * <strong>Ventana principal del aplicativo</strong>.
     */
    JFrame frame = new JFrame();

    ArrayList<Integer> KeyPressedList = new ArrayList<>();
}
