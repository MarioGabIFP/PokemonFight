package model.menu;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends Canvas {
    ArrayList<Image> tiles = new ArrayList<>();
    Image actualTile;
    File pointerSprites;
    int rX, rY;

    public int getRX() {return rX;}
    public int getRY() {return rY;}
    public void setRX(int rX) {this.rX = rX;}
    public void setRY(int rY) {this.rY = rY;}
    public File getPointerSprites() {return pointerSprites;}
    public void setPointerSprites(File pointerSprites) {this.pointerSprites = pointerSprites;}
    public Image getPointerTile() {return actualTile;}
    public void setPointerTile(Image pointerSpriteFront) {this.actualTile = pointerSpriteFront;}
    public void addAllTiles(ArrayList<Image> tiles) {this.tiles.addAll(tiles);}
    public ArrayList<Image> getTileBuffer() {return tiles;}
}
