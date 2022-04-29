package model;

import java.awt.Canvas;
import java.awt.Image;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pokeball extends Canvas {
    public enum type {
        multiball
    }
    
    type pokeballType;
    Image actualTile;

    public Pokeball(type pokeballType) {
        this.pokeballType = pokeballType;
    }

    public Image getActualTile() {
        return actualTile;
    }
    
    public void setActualTile(Image actualTile) {
        this.actualTile = actualTile;
    }

    public void setPokeballType(type pokeballType) {
        this.pokeballType = pokeballType;
    }
}
