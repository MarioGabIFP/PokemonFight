package controller;

import gui.Graphic;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Launcher {

    /**
     * Método lanzador.
     *
     * Ejecuta el videojuego para el usuario activo.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        Graphic g = new Graphic();
        g.render();
        g.update();
    }
}
