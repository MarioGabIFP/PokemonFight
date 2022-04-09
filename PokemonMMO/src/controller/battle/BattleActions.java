package controller.battle;

import controller.Actions;
import controller.elements.Opponents;
import model.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleActions extends Actions implements Opponents {
    int i = 100;
    
    @Override
    public void run() {
        values.enemy.setHP(i);
        
        values.player.setHP(i);
        
        if (i > 0 || i < 100) {
            i--;
        } else {
            i = 100;
        }
    }
}
