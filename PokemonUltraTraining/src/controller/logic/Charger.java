package controller.logic;

import controller.memory.TempMem;
import controller.memory.TempMem.BattleMem;
import gui.Graphic;
import gui.frameable.BattleScreen;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Charger implements TempMem {
    private final Graphic screen;
    
    public Charger(Graphic screen) {
        this.screen = screen;
    }
    
    public void charge() throws IOException {
        if (screen instanceof BattleScreen) {
            BattleMem.enemy.setTile(ImageIO.read(new File(Graphic.spritesPokemon + "gen3/25/25.png")));
            BattleMem.enemy.setHP(30);
            BattleMem.enemy.setName("pepe");
            BattleMem.enemy.setGender(Pokemon.Gender.female);
            BattleMem.enemy.setLV(4);

            BattleMem.player.setTile(pokemonSel.get(0).getBackTile());
            BattleMem.player.setHP(pokemonSel.get(0).getHp());
            BattleMem.player.setName(pokemonSel.get(0).getName());
            BattleMem.player.setGender(pokemonSel.get(0).getGender());
            BattleMem.player.setLV(pokemonSel.get(0).getIv());
        }
    }

    public final ArrayList<Pokemon> getPokemones() {return pokemones;}
}
