package controller.battle;

import controller.battle.elements.Opponents;
import controller.Charger;
import controller.elements.Options;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleCharger extends Charger implements Opponents, Options{
    
    @Override
    public void charge() {
        values.enemy.setTile(spritesPokemon + "gen3/25/25.png");
        values.enemy.setHP(30);
        values.enemy.setName("pepe");
        values.enemy.setGender(Pokemon.Gender.female);
        values.enemy.setLV(4);
        
        values.player.setTile(spritesPokemon + "gen3/4/4_b.png");
        values.player.setHP(100);
        values.player.setName("Charmander");
        values.player.setGender(Pokemon.Gender.male);
        values.player.setLV(50);
    }
}
