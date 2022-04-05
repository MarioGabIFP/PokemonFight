package controller;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import view.frameable.Alabastia_4_3;
import view.frameable.dctrOakTalks;

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
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {
        new Frame();
        new Orchestrator();
    }
}
