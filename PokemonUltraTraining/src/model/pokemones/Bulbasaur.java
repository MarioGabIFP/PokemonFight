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

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Bulbasaur extends Pokemon implements Normal, Grass, Poison {
    public Bulbasaur() {
        id = 1;
        name = "Bulbasaur";
        gender = Gender.male;
        types = new ArrayList<>(Arrays.asList(tNormal,tGrass,tPoison));
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
