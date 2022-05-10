package model.pokemones;

import gui.Graphic;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.pokemones.miscellaneus.Type;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Ivysaur extends Pokemon {
    public Ivysaur() {
        id = 2;
        name = "Ivysaur";
        gender = Gender.male;
        type = new Type[]{Type.planta, Type.veneno};
        level = 25;
        hp = 34;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Ivysaur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
