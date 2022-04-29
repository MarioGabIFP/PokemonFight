package gui.elements.screen;

import java.awt.Image;
import model.Map;
import gui.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface IMaps extends Assets {
    Map _map = new Map();

    public void loadMap(Image image, int x, int y);
}
