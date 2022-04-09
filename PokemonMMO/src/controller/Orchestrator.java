package controller;

import controller.Actions;
import controller.Charger;
import controller.controllable.PlayerActions;
import controller.menu.MenuActions;
import controller.menu.MenuCharger;
import controller.battle.BattleCharger;
import controller.battle.BattleActions;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Orchestrator extends PlayerActions implements KeyListener, WindowFocusListener{
    public enum ObjectTC{
        player,
        menu, 
        battle
    }
    
    Actions actions = null;
    Charger charger = null;

    public Orchestrator(ObjectTC otc) {
        switch (otc) {
            case player -> {
                actions = new PlayerActions();
            }
            case menu -> {
                actions = new MenuActions();
                charger = new MenuCharger();
            }
            case battle -> {
                actions = new BattleActions();
                charger = new BattleCharger();
            }
        }
        
        if (charger != null) {
            charger.run();
        }
    }
    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        int codeKey = e.getKeyCode();

        if (!KeyPressedList.contains(codeKey)) {
            KeyPressedList.add(codeKey);
        }
        
        actions.run();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        KeyPressedList.remove((Object) e.getKeyCode());
        
        actions.run();
    }

    @Override
    public void windowGainedFocus(WindowEvent e) {}

    @Override
    public void windowLostFocus(WindowEvent e) {
        KeyPressedList.clear();
    }
}
