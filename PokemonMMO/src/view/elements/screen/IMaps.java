package view.elements.screen;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface IMaps extends Assets {

    Canvas g_base = new Canvas();
    File _1_bmp = new File(Maps + "PuebloPaleta/1.bmp");

    public void loadMap(Image image);
}
