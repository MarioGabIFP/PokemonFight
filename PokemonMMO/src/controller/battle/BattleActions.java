package controller.battle;

import controller.battle.elements.Opponents;
import controller.Actions;
import controller.elements.Options;
import static view.elements.Base.KeyPressedList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleActions extends Actions implements Opponents, Options {

    int i = 100;

    @Override
    public void run() {
        if (!KeyPressedList.isEmpty()) {
            if (KeyPressedList.size() == 1) {
                int codeKey = KeyPressedList.get(0);
                switch (codeKey) {
                    case 32 -> {
                        for (Battle b: Battle.values()) {
                            if (b.isSelected()) {
                                switch (b.getAction()) {
                                    case setfigth -> {
                                        System.out.println("Lucha");
                                        values.enemy.setHP(i);
                                        values.player.setHP(i);

                                        if (i > 0 || i < 100) {
                                            i--;
                                        } else {
                                            i = 100;
                                        }
                                    }
                                    case miPokedex -> {
                                        System.out.println("Pokemon");
                                    }
                                    case miBag -> {
                                        System.out.println("Mochila");
                                    }
                                    case exit -> {
                                        System.out.println("Salida");
                                    }
                                }
                            }
                        }
                    }
                    case 40 -> {
                        if (pointer.getRY() < 444) {
                            pointer.setRY(pointer.getRY() + 30);
                            pointer.setBounds(pointer.getX(), pointer.getY() + 30, pointer.getWidth(), pointer.getHeight());

                            evaluateRY();
                        }
                    }
                    case 38 -> {
                        if (pointer.getRY() > 354) {
                            pointer.setRY(pointer.getRY() - 30);
                            pointer.setBounds(pointer.getX(), pointer.getY() - 30, pointer.getWidth(), pointer.getHeight());

                            evaluateRY();
                        }
                    }
                }
            }
        }
    }
    
    protected void evaluateRY() {
        switch (pointer.getRY()) {
            case 354 -> {
                Battle.figth.setSelected(true);
                Battle.pokemon.setSelected(false);
                Battle.bag.setSelected(false);
                Battle.skip.setSelected(false);
            }
            case 384 -> {
                Battle.figth.setSelected(false);
                Battle.pokemon.setSelected(true);
                Battle.bag.setSelected(false);
                Battle.skip.setSelected(false);
            }
            case 414 -> {
                Battle.figth.setSelected(false);
                Battle.pokemon.setSelected(false);
                Battle.bag.setSelected(true);
                Battle.skip.setSelected(false);
            }
            case 444 -> {
                Battle.figth.setSelected(false);
                Battle.pokemon.setSelected(false);
                Battle.bag.setSelected(false);
                Battle.skip.setSelected(true);
            }
        }
    }
}
