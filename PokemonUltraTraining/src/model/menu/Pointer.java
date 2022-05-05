package model.menu;

import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends Menu {
    private ArrayList<Image> tiles = new ArrayList<>();
    private Image actualTile;
    private File pointerSprites;
    private int rX, rY;

    public final void setRX(int rX) {this.rX = rX;}
    public final void setRY(int rY) {this.rY = rY;}
    public final void setPointerTile(Image pointerSpriteFront) {this.actualTile = pointerSpriteFront;}
    public final void addAllTiles(ArrayList<Image> tiles) {this.tiles.addAll(tiles);}
    public final void setPointerSprites(File pointerSprites) {this.pointerSprites = pointerSprites;}
    public final int getRX() {return rX;}
    public final int getRY() {return rY;}
    public final File getPointerSprites() {return pointerSprites;}
    public final Image getPointerTile() {return actualTile;}
    public final ArrayList<Image> getTileBuffer() {return tiles;}
    
    public final void evaluateBattleOpt() {
        switch (getRY()) {
            case 354 -> setOpt(BattleOpt.setfigth);
            case 384 -> setOpt(BattleOpt.miPokedex);
            case 414 -> setOpt(BattleOpt.miBag);
            case 444 -> setOpt(BattleOpt.exit);
        }
    }
}
