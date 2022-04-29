package view.elements.screen;

import java.awt.Canvas;
import java.awt.Image;
import model.Map;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface IMaps extends Assets {

    Canvas g_0 = new Canvas();
    Map _map = new Map();

    public void loadMap(Image image, int x, int y);
}
