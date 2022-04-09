package view.elements.screen;

import java.awt.Image;
import model.Player;
import model.Pokeball;
import model.Trainer;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Models extends Assets {
    Player player = new Player();
    Trainer trainer = new Trainer();
    Pokeball pokeball = new Pokeball(Pokeball.type.multiball);

    void loadSprite(Image image, int x, int y);
}
