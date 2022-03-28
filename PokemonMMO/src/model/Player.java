package model;

import java.io.File;
import java.util.ArrayList;
import javax.swing.JLabel;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Player extends JLabel{
	private static final long serialVersionUID = 1L;
	
	ArrayList<Pokemon> pokeBuffer = new ArrayList<Pokemon>();
	File player_bmp;
	
	public ArrayList<Pokemon> getPokeBuffer() {
		return pokeBuffer;
	}
	
	public void addPokemon(Pokemon pokemon) {
		this.pokeBuffer.add(pokemon);
	}
	
	public File getPlayer_bmp() {
		return player_bmp;
	}
	
	public void setPlayer_bmp(File player_bmp) {
		this.player_bmp = player_bmp;
	}
}
