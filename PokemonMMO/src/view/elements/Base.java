package view.elements;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Base {
    public static final Color WHITE = new Color(0.973f, 0.973f, 0.973f);
    public static final Color BLACK = new Color(0.157f, 0.188f, 0.188f);
    public static final Color RED = new Color(0.914f, 0.188f, 0.192f);
    
    /**
     * <strong>Ventana principal del aplicativo</strong>.
     */
    public JFrame frame = new JFrame();
    
    public ArrayList<Integer> KeyPressedList = new ArrayList<>();
}
