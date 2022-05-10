package model.pokemones;

import gui.Graphic;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import model.pokemones.tipos.Fire;
import model.pokemones.tipos.Normal;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Charmander extends Pokemon implements Normal, Fire{
    public Charmander() {
        id = 4;
        name = "Charmander";
        gender = Gender.male;
        types = new ArrayList<>(Arrays.asList(tNormal,tFire));
        level = 13;
        hp = 12;
        
        try {
            tile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + ".png"));
            backTile = ImageIO.read(new File(Graphic.spritesPokemon + "gen3/" + id + "/" + id + "_b.png"));
        } catch (IOException ex) {
            Logger.getLogger(Charmander.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
