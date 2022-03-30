package model;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends Canvas{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Pokemon> pokeBuffer = new ArrayList<Pokemon>();
	Image playerSprite;
	File playerSprites;
	
	public ArrayList<Pokemon> getPokeBuffer() {
		return pokeBuffer;
	}
	
	public void addPokemon(Pokemon pokemon) {
		this.pokeBuffer.add(pokemon);
	}
	
	public File getPlayerSprites() {
		return playerSprites;
	}
	
	public void setPlayerSprites(File playerSprites) {
		this.playerSprites = playerSprites;
	}
	
	public Image getPlayerSprite() {
		return playerSprite;
	}
	
	public void setPlayerSprite(Image playerSpriteFront) {
		this.playerSprite = playerSpriteFront;
	}
}
