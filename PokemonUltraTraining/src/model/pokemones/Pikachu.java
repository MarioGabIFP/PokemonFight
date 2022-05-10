package model.pokemones;

import static controller.memory.TempMem.pokemones;
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
public class Pikachu extends Pokemon {
    public Pikachu() {
        id = 25;
        name = "Pikachu";
        gender = Gender.female;
        type = Type.electrico;
        level = 10;
        hp = 27;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pikachu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
