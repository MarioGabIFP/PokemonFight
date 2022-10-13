package model;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pokeball extends Canvas {
    public enum Typ {
        multiball
    }
    
    private Typ pokeballType;
    private Image actualTile;
    private File pokeSprites;

    private final ArrayList<Image> tiles = new ArrayList<>();
    
    public Pokeball(Typ pokeballType) {this.pokeballType = pokeballType;}

    public final void setPokeballType(Typ pokeballType) {this.pokeballType = pokeballType;}
    public final void setPokeTile(Image pokeSpriteFront) {this.actualTile = pokeSpriteFront;}
    public final void addAllTiles(ArrayList<Image> tiles) {this.tiles.addAll(tiles);}
    public final void setPokeSprites(File pokeSprites) {this.pokeSprites = pokeSprites;}
    public final Typ setPokeballType() {return pokeballType;}
    public final File getPokeSprites() {return pokeSprites;}
    public final Image getPokeTile() {return actualTile;}
    public final ArrayList<Image> getTileBuffer() {return tiles;}

}
