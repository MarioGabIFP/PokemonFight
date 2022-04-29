package model.menu;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Menu extends Canvas {
    ArrayList<Image> tiles = new ArrayList<>();
    File menuSprite;

    public void setMenuSprite(File mapSprite) {
        this.menuSprite = mapSprite;
    }

    public File getMenuSprite() {
        return menuSprite;
    }

    public void setTiles(ArrayList<Image> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<Image> getTiles() {
        return tiles;
    }
}
