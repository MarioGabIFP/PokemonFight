package controller.menu;

import controller.Charger;
import controller.elements.Options;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class MenuCharger extends Charger implements Options{
    public MenuCharger() throws IOException, SAXException, ParserConfigurationException, InterruptedException {}
    
    @Override
    public void run() {
        System.out.println("controller.MenuCharger.run()");
    }
}
