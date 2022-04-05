package view.elements.screen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import model.Player;
import org.xml.sax.SAXException;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Sprites extends Assets {
    Player player = new Player();

    void loadSprite(Image image, int x, int y);

    public ArrayList<Image> decodeSprites(File xml, String dir) throws IOException, SAXException, ParserConfigurationException;
}
