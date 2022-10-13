package model;

import gui.frameable.Menu;
import gui.frameable.Menu.MenuConstructor;
import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pointer extends Canvas {
    private final ArrayList<Image> tiles = new ArrayList<>();
    private Image actualTile;
    private File pointerSprites;
    private int rX, rY, limit;

    public final void setRX(int rX) {this.rX = rX;}
    public final void setRY(int rY) {this.rY = rY;}
    public final void setLimit(int limit) {this.limit = limit;}
    public final void setPointerTile(Image pointerSpriteFront) {this.actualTile = pointerSpriteFront;}
    public final void addAllTiles(ArrayList<Image> tiles) {this.tiles.addAll(tiles);}
    public final void setPointerSprites(File pointerSprites) {this.pointerSprites = pointerSprites;}
    public final int getRX() {return rX;}
    public final int getRY() {return rY;}
    public final int getLimit() {return limit;}
    public final File getPointerSprites() {return pointerSprites;}
    public final Image getPointerTile() {return actualTile;}
    public final ArrayList<Image> getTileBuffer() {return tiles;}
    
    public final void evaluateBattleOpt() {
        switch (getRY()) {
            case 354 -> Menu.setOpt(Menu.BattleOpt.setfigth);
            case 384 -> Menu.setOpt(Menu.BattleOpt.miPokedex);
            case 414 -> Menu.setOpt(Menu.BattleOpt.miBag);
            case 444 -> Menu.setOpt(Menu.BattleOpt.exit);
        }
    }

    public final void selectPokemon(int pointerPos) {Menu.setOpt(Menu.pokemones.get(pointerPos - 1));}
    public final void selectEnemy(int pointerPos) {Menu.setOpt(Menu.pokemones.get(pointerPos - 1));}
    public final void preSel(int pointerPos) {Menu.viewOpt(Menu.pokemones.get(pointerPos - 1));}
}
