package controller;

import gui.Graphic;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Actions extends Graphic {
    public boolean selectItem = false;

    public Actions() throws IOException, SAXException, ParserConfigurationException, InterruptedException {}
    
    public abstract void KeyisPressed();
    
    @Override
    public void create() throws IOException, SAXException, ParserConfigurationException {}

    @Override
    public void update() throws IOException, InterruptedException {}
}
