package model;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends Canvas {
    public enum Dir {down,up,left,right;}
    
    private final ArrayList<Pokemon> pokeBuffer = new ArrayList<>();
    private final ArrayList<Image> tiles = new ArrayList<>();
    
    private Image actualTile;
    private File playerSprites;

    public final void addPokemon(Pokemon pokemon) {this.pokeBuffer.add(pokemon);}
    public final void setPlayerSprites(File playerSprites) {this.playerSprites = playerSprites;}
    public final void setPlayerTile(Image playerSpriteFront) {this.actualTile = playerSpriteFront;}
    public final void addAllTiles(ArrayList<Image> tiles) {this.tiles.addAll(tiles);}
    public final File getPlayerSprites() {return playerSprites;}
    public final Image getPlayerTile() {return actualTile;}
    public final ArrayList<Pokemon> getPokeBuffer() {return pokeBuffer;}
    public final ArrayList<Image> getTileBuffer() {return tiles;}
    public final boolean evaliuateWith(Canvas model) {return getBounds().x <= model.getBounds().x + 30 && getBounds().x >= model.getBounds().x - 30;}
    
    public final void walk(Dir d, int x, int y) {
        switch (d) {
            case down -> setPlayerTile(getTileBuffer().get(1).getScaledInstance(getWidth(), getHeight(), ALLBITS));
            case up -> setPlayerTile(getTileBuffer().get(4).getScaledInstance(getWidth(), getHeight(), ALLBITS));
            case left -> setPlayerTile(getTileBuffer().get(10).getScaledInstance(getWidth(), getHeight(), ALLBITS));
            case right -> setPlayerTile(getTileBuffer().get(7).getScaledInstance(getWidth(), getHeight(), ALLBITS));
        }
        
        setBounds(x, y, getWidth(), getHeight());
    };
}
