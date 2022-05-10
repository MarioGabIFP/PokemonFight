package controller.logic;

import gui.Graphic;
import static gui.elements.screen.Models.pointer;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleScreen;
import gui.frameable.Pokedex;
import gui.frameable.Menu.PokedexValues;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import model.Player;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions implements KeyListener {
    private final Graphic screen;
    
    private int pointerPos = 1;
    
    public Actions(Graphic screen) {this.screen = screen;}
    
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32 -> {
                if (screen instanceof BattleScreen) {
                    screen.act();
                }
                
                if (screen instanceof Pokedex) {
                    pointer.selectPokemon(pointerPos);
                }
            }
            
            case 37, 65 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getX() - 5 >= Graphic._map.getX()) {
                        Graphic.player.walk(Player.Dir.left, Graphic.player.getX() - 5, Graphic.player.getY());
                    }
                    if (Graphic.player.getX() - 5 <= screen.g_0.getX() && Graphic._map.getX() < 0) {
                        screen.setAdjust(Graphic.Adjust.right);
                        screen.act();
                    }
                }
            }
            
            case 38 -> {
                if (screen instanceof BattleScreen) {
                    if (pointer.getRY() > 354) {
                        pointer.setRY(pointer.getRY() - 30);
                        pointer.setBounds(pointer.getX(), pointer.getY() - 30, pointer.getWidth(), pointer.getHeight());

                        pointer.evaluateBattleOpt();
                    }
                }
                
                if (screen instanceof Pokedex) {
                    if (pointer.getRY() > 64) {
                        pointerPos--;
                        pointer.setRY(pointer.getRY() - 50);
                        pointer.setBounds(pointer.getX(), pointer.getY() - 50, pointer.getWidth(), pointer.getHeight());
                        
                        pointer.preSel(pointerPos);
                    }
                }
                
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getY() + 25 >= Graphic._map.getY()) 
                        Graphic.player.walk(Player.Dir.up, Graphic.player.getX(), Graphic.player.getY() - 5);
                    
                    if (Graphic.player.getY() <= screen.g_0.getY() && Graphic._map.getY() < 0) {
                        screen.setAdjust(Graphic.Adjust.down);
                        screen.act();
                    }
                }
            }
            
            case 39, 68 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getX() + 5 >= Graphic._map.getX()) Graphic.player.walk(Player.Dir.right, Graphic.player.getX() + 5, Graphic.player.getY());
                    if (Graphic.player.getX() - 5 <= screen.g_0.getX() - Graphic.player.getWidth() && Graphic._map.getX() >= -19) {
                        screen.setAdjust(Graphic.Adjust.left);
                        screen.act();
                    }
                }
            }
            
            case 40 -> {
                if (screen instanceof BattleScreen) {
                    if (pointer.getRY() < 444) {
                        pointer.setRY(pointer.getRY() + 30);
                        pointer.setBounds(pointer.getX(), pointer.getY() + 30, pointer.getWidth(), pointer.getHeight());

                        pointer.evaluateBattleOpt();
                    }
                }
                
                if (screen instanceof Pokedex) {
                    if (pointer.getRY() < 353 && pointer.getLimit() > pointerPos) {
                        pointerPos++;
                        pointer.setRY(pointer.getRY() + 50);
                        pointer.setBounds(pointer.getX(), pointer.getY() + 50, pointer.getWidth(), pointer.getHeight());
                        
                        pointer.preSel(pointerPos);
                    }
                }
                
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getY() + 5 <= Graphic._map.getY() + (Graphic._map.getHeight() - (Graphic.player.getHeight() - 30))) 
                        Graphic.player.walk(Player.Dir.down, Graphic.player.getX(), Graphic.player.getY() + 5);
                    
                    if (Graphic.player.getY() + 5 >= screen.g_0.getHeight() - (Graphic._map.getHeight() - 30) && Graphic._map.getY() >= - 19) {
                        screen.setAdjust(Graphic.Adjust.up);
                        screen.act();
                    }
                }
            }
            
            case 83 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getY() + 5 <= Graphic._map.getY() + (Graphic._map.getHeight() - (Graphic.player.getHeight() - 30))) 
                        Graphic.player.walk(Player.Dir.down, Graphic.player.getX(), Graphic.player.getY() + 5);
                    
                    if (Graphic.player.getY() + 5 >= screen.g_0.getHeight() - (Graphic._map.getHeight() - 30) && Graphic._map.getY() >= - 19) {
                        screen.setAdjust(Graphic.Adjust.up);
                        screen.act();
                    }
                }
            }
            
            case 87 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (Graphic.player.getY() + 25 >= Graphic._map.getY()) 
                        Graphic.player.walk(Player.Dir.up, Graphic.player.getX(), Graphic.player.getY() - 5);
                    
                    if (Graphic.player.getY() <= screen.g_0.getY() && Graphic._map.getY() < 0) {
                        screen.setAdjust(Graphic.Adjust.down);
                        screen.act();
                    }
                }
            }
            
            case 112 -> {
                try {
                    ScreenController.setScreen(new Pokedex(PokedexValues.getPokemonFromMultiball));
                } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                    Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 113 -> {
                try {
                    ScreenController.setScreen(new BattleScreen());
                } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                    Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 114 -> {
                try {
                    ScreenController.setScreen(new Alabastia_4_3());
                } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                    Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 115 -> {
                try {
                    ScreenController.setScreen(new Pokedex(PokedexValues.getEnemy));
                } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                    Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
