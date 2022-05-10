package model.pokemones;

import gui.Graphic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.pokemones.tipos.Grass;
import model.pokemones.tipos.Normal;
import model.pokemones.tipos.Poison;
import model.pokemones.tipos.Type;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Ivysaur extends Pokemon implements Normal, Grass, Poison {
    public Ivysaur() {
        id = 2;
        name = "Ivysaur";
        gender = Gender.male;
        types = new ArrayList<>(Arrays.asList(tNormal,tGrass,tPoison));
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
