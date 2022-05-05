package controller.logic;

import gui.Graphic;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController {
    private static Graphic graphics;
    private static Thread render;
    
    public synchronized static void init() throws IOException, InterruptedException {
        render = new Thread (() -> {
            while (render.isAlive())
                try {
                    graphics.update();
                } catch (IOException | InterruptedException ex) {
                    Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
                }
        });
    }

    public static void setScreen(Graphic g) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (graphics != null) graphics.dispose();
        g.create();
        graphics = g;
        if (!render.isAlive()) render.start();
    }
}