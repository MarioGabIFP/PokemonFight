package view;

import view.frames.Updater;
import java.io.IOException;
import javax.swing.JFrame;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Frame extends Graphic implements Updater {
    static Frame map = null;
    public boolean exit;
    
    public void setExit(boolean exit) {
        this.exit = exit;
    }

    public boolean isExit() {
        return exit;
    }

    /**
     * Contructor de la ventana.
     *
     * @throws IOException
     */
    public Frame() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 960, 640);
        frame.setMaximizedBounds(frame.getBounds());
        frame.setResizable(false);
    }

    public static void chargeMap(Frame maps) throws IOException, SAXException, ParserConfigurationException {
        map = maps;
    }

    public void startRender() {
        if (isVisible()) {
            try {
                do {
                    Update(isExit());
                } while(!isExit());
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void Update(Boolean isUp) throws IOException, InterruptedException {}
}
