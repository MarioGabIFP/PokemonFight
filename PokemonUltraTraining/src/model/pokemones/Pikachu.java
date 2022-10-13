package model.pokemones;

import gui.Graphic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.pokemones.tipos.Electric;
import model.pokemones.tipos.Normal;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pikachu extends Pokemon implements Normal, Electric{
    public Pikachu() {
        id = 25;
        name = "Pikachu";
        gender = Gender.female;
        types = new ArrayList<>(Arrays.asList(tNormal,tElectric));
        level = 10;
        hp = 13;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Pikachu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
