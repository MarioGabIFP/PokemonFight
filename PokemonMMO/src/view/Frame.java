package view;

import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Frame extends Graphic implements Runnable, Updater {

    private static final long serialVersionUID = 1L;

    static Frame map = null;

    /**
     * Contructor de la ventana.
     *
     * @throws IOException
     */
    public Frame() throws IOException {
        Thread t = new Thread(this);

        if (frame.isVisible()) {
            t.setName("Screen");
            t.start();
        } else {
            frame.setUndecorated(true);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setBounds(100, 100, 960, 640);
            frame.setMaximizedBounds(frame.getBounds());
            frame.setResizable(false);
            frame.getContentPane().setBackground(grayGameBoy);
        }
    }

    public static void chargeMap(Frame maps) throws IOException, SAXException, ParserConfigurationException {
        map = maps;
    }

    @Override
    public void run() {
        if (frame.isVisible()) {
            //Controlamos el refresco de la pantalla
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            DisplayMode dm = gs.getDisplayMode();
            long OT = 1000000000 / dm.getRefreshRate();

            try {
                while (true) {
                    long prevTU = System.nanoTime();

                    Update();

                    long sleep = (OT - (System.nanoTime() - prevTU)) / 1000000000;

                    try {
                        Thread.sleep(sleep);
                    } catch (InterruptedException ex) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Update() throws IOException {
        if (map != null) {
            map.Update();
        } 
    }
}
