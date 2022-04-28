package controller;

import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Actions extends Frame {

    public Actions() throws IOException, SAXException, ParserConfigurationException, InterruptedException {}
    
    public boolean selectItem = false;
    
    public void stopRendering() {
        setExit(true);
    }
    
    public abstract void KeyisPressed();
}
