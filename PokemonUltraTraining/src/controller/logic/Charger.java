package controller.logic;

import controller.memory.TempMem.BattleMem;
import gui.Graphic;
import gui.frameable.BattleScreen;
import gui.frameable.Pokedex;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Charger {
    private final Graphic screen;
    
    public Charger(Graphic screen) {
        this.screen = screen;
    }
    
    public void charge() {
        if (screen instanceof BattleScreen) {
            BattleMem.enemy.setTile(Graphic.spritesPokemon + "gen3/25/25.png");
            BattleMem.enemy.setHP(30);
            BattleMem.enemy.setName("pepe");
            BattleMem.enemy.setGender(Pokemon.Gender.female);
            BattleMem.enemy.setLV(4);

            BattleMem.player.setTile(Graphic.spritesPokemon + "gen3/4/4_b.png");
            BattleMem.player.setHP(100);
            BattleMem.player.setName("Charmander");
            BattleMem.player.setGender(Pokemon.Gender.male);
            BattleMem.player.setLV(50);
        }
        
        if (screen instanceof Pokedex) {
            System.out.println("controller.MenuCharger.run()");
        }
    }
}
