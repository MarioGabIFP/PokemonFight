package controller;

import gui.Graphic;
import java.awt.Component;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController {
    private static Graphic graphics;

    public static void setScreen(Graphic g) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (graphics != null) {
            graphics.dispose();
            for (Component component : graphics.getComponents()) graphics.remove(component);
            graphics = g;
        } else graphics = g;
        
        graphics.create();
        render();
    }
    
    private static void render() throws IOException, InterruptedException {
        while (true) {            
            graphics.update();
        }
    }
}