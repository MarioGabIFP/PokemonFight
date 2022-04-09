package controller.battle;

import controller.Charger;
import controller.elements.Opponents;
import model.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleCharger extends Charger implements Opponents{
    
    @Override
    public void run() {
        values.enemy.setHP(100);
        values.enemy.setName("El Tio la Vara");
        values.enemy.setGender(Pokemon.Gender.male);
        values.enemy.setLV(23);
        
        values.player.setHP(100);
        values.player.setName("Manolo");
        values.player.setGender(Pokemon.Gender.female);
        values.player.setLV(2);
    }
}
