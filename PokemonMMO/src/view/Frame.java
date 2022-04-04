package view;

import java.io.IOException;
import javax.swing.JFrame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Frame extends Graphic {

    private static final long serialVersionUID = 1L;

    /**
     * Contructor de la ventana.
     *
     * @throws IOException
     */
    public Frame() throws IOException {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 960, 640);
        frame.setMaximizedBounds(frame.getBounds());
        frame.setResizable(false);
        frame.setUndecorated(true);
        frame.getContentPane().setBackground(grayGameBoy);
        frame.setVisible(true);
    }
}
