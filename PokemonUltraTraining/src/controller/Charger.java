package controller;

import gui.Graphic;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Charger extends Graphic {
    public abstract void charge();
    
    @Override
    public void create() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public void update() throws IOException, InterruptedException {}
}
