package model;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Map extends Canvas {
    ArrayList<Image> tiles = new ArrayList<>();
    File mapSprite;

    public void setMapSprite(File mapSprite) {
        this.mapSprite = mapSprite;
    }

    public File getMapSprite() {
        return mapSprite;
    }

    public void setTiles(ArrayList<Image> tiles) {
        this.tiles = tiles;
    }

    public ArrayList<Image> getTiles() {
        return tiles;
    }
}
