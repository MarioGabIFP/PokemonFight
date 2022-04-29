package gui.elements.screen;

import java.awt.Image;
import model.Player;
import model.menu.Pointer;
import model.Pokeball;
import model.Trainer;
import gui.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Models extends Assets {
    Player player = new Player();
    Trainer trainer = new Trainer();
    Pokeball pokeball = new Pokeball(Pokeball.type.multiball);
    Pointer pointer = new Pointer();

    void loadSprite(Image image, int x, int y);
}
