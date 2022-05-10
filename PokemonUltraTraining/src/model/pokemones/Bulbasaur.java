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
public class Bulbasaur extends Pokemon {
    public Bulbasaur() {
        id = 1;
        name = "Bulbasaur";
        gender = Gender.male;
        type = new Type[]{Type.planta, Type.veneno};
        level = 12;
        hp = 27;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Bulbasaur.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
