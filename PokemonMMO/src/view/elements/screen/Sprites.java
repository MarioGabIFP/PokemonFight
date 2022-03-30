package view.elements.screen;

import java.io.File;
import java.io.IOException;
import model.Player;
import model.Pokeball;
import model.Trainer;
import view.elements.Assets;

public interface Sprites extends Assets {
	Trainer trainer = new Trainer();
	Player player = new Player();
	Pokeball pokeball = new Pokeball();
	
	void loadSprite(File image, int x, int y) throws IOException;
}
