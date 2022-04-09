package view;

import view.frames.Updater;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Frame extends Graphic implements Runnable, Updater {
    static Frame map = null;
    public Thread t = new Thread(this);

    /**
     * Contructor de la ventana.
     *
     * @throws IOException
     */
    public Frame() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (frame.isVisible()) {
            t.setName("Screen");
            t.start();
        } else {
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 960, 640);
            frame.setMaximizedBounds(frame.getBounds());
            frame.setResizable(false);
        }
    }

    public static void chargeMap(Frame maps) throws IOException, SAXException, ParserConfigurationException {
        map = maps;
    }

    @Override
    public void run() {
        if (isVisible()) {
            try {
                while (isVisible()) {
                    Update();
                }
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Update() throws IOException, InterruptedException {}
}
