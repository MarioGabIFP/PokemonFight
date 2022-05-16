package controller.logic;

import controller.memory.TempMem;
import controller.memory.TempMem.BattleMem;
import gui.Graphic;
import gui.frameable.BattleScreen;
import java.io.IOException;
import java.util.ArrayList;
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
            BattleMem.enemy.setTile(enemySel.get(0).getTile());
            BattleMem.enemy.setHP(enemySel.get(0).getHp());
            BattleMem.enemy.setName(enemySel.get(0).getName());
            BattleMem.enemy.setGender(enemySel.get(0).getGender());
            BattleMem.enemy.setLV(enemySel.get(0).getLevel());

            BattleMem.player.setTile(pokemonSel.get(0).getBackTile());
            BattleMem.player.setHP(pokemonSel.get(0).getHp());
            BattleMem.player.setName(pokemonSel.get(0).getName());
            BattleMem.player.setGender(pokemonSel.get(0).getGender());
            BattleMem.player.setLV(pokemonSel.get(0).getLevel());
        }
    }

    public final ArrayList<Pokemon> getPokemones() {return pokemones;}
}
