package controller;

import controller.elements.Opponents.values;
import gui.Graphic;
import gui.frameable.BattleView;
import gui.frameable.Menu;
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
        if (screen instanceof BattleView) {
            values.enemy.setTile(Graphic.spritesPokemon + "gen3/25/25.png");
            values.enemy.setHP(30);
            values.enemy.setName("pepe");
            values.enemy.setGender(Pokemon.Gender.female);
            values.enemy.setLV(4);

            values.player.setTile(Graphic.spritesPokemon + "gen3/4/4_b.png");
            values.player.setHP(100);
            values.player.setName("Charmander");
            values.player.setGender(Pokemon.Gender.male);
            values.player.setLV(50);
        }
        
        if (screen instanceof Menu) {
            System.out.println("controller.MenuCharger.run()");
        }
    }
}
