package controller;

import gui.elements.Base;
import gui.frameable.Alabastia_4_3;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Launcher implements Base {

    /**
     * Método lanzador.
     *
     * Ejecuta el videojuego para el usuario activo.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        ScreenController.setScreen(new Alabastia_4_3());
    }
}
