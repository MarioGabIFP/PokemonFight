package view.elements.screen;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import model.Player;
import model.Pokeball;
import model.Trainer;
import org.xml.sax.SAXException;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Sprites extends Assets {

    Trainer trainer = new Trainer();
    Player player = new Player();
    Pokeball pokeball = new Pokeball();

    void loadSprite(Image image, int x, int y);

    public ArrayList<Image> decodeSprites(File xml) throws IOException, SAXException, ParserConfigurationException;
}
