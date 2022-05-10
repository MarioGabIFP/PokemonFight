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
public class Charmander extends Pokemon {
    public Charmander() {
        id = 4;
        name = "Charmander";
        gender = Gender.male;
        type = Type.fuego;
        level = 13;
        hp = 43;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Charmander.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
