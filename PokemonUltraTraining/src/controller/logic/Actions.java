package controller.logic;

import controller.memory.TempMem;
import gui.Graphic;
import static gui.elements.screen.Models.pointer;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleScreen;
import gui.frameable.Menu;
import gui.frameable.Pokedex;
import gui.frameable.Menu.PokedexValues;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import model.Player;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions implements KeyListener, TempMem {
    private final Graphic screen;
    
    private int pointerPos = 1;
    
    public Actions(Graphic screen) {this.screen = screen;}
    
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}
    @Override public void loadSprite(Image image, int x, int y) {}
    @Override public ArrayList<Image> tileMapper(File xml, String dir) throws IOException, SAXException, ParserConfigurationException {return null;}

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
                
                if (screen instanceof Alabastia_4_3) {
                    if (player.evaliuateWith(pokeball)) {
                        try {
                            Menu.MenuConstructor.PokedexValue.setPokedexV(PokedexValues.getPokemonFromMultiball);
                            ScreenController.setScreen(new Pokedex());
                        } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                            Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else if (player.evaliuateWith(trainer)) {
                        try {
                            Menu.MenuConstructor.PokedexValue.setPokedexV(PokedexValues.getEnemy);
                            ScreenController.setScreen(new Pokedex());
                        } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                            Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
            
            case 37, 65 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (player.getX() - 5 >= screen._map.getX()) {
                        player.walk(Player.Dir.left, player.getX() - 5, player.getY());
                    } 
                    
                    if (player.getX() - 5 <= screen.g_0.getX() && screen._map.getX() < 0) {
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
                    if (player.getY() + 25 >= screen._map.getY()) 
                        player.walk(Player.Dir.up, player.getX(), player.getY() - 5);
                    
                    if (player.getY() <= screen.g_0.getY() && screen._map.getY() < 0) {
                        screen.setAdjust(Graphic.Adjust.down);
                        screen.act();
                    }
                }
            }
            
            case 39, 68 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (player.getX() + 5 >= screen._map.getX()) player.walk(Player.Dir.right, player.getX() + 5, player.getY());
                    if (player.getX() - 5 <= screen.g_0.getX() - player.getWidth() && screen._map.getX() >= -19) {
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
                    if (player.getY() + 5 <= screen._map.getY() + (screen._map.getHeight() - (player.getHeight() - 30))) 
                        player.walk(Player.Dir.down, player.getX(), player.getY() + 5);
                    
                    if (player.getY() + 5 >= screen.g_0.getHeight() - (screen._map.getHeight() - 30) && screen._map.getY() >= - 19) {
                        screen.setAdjust(Graphic.Adjust.up);
                        screen.act();
                    }
                }
            }
            
            case 83 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (player.getY() + 5 <= screen._map.getY() + (screen._map.getHeight() - (player.getHeight() - 30))) 
                        player.walk(Player.Dir.down, player.getX(), player.getY() + 5);
                    
                    if (player.getY() + 5 >= screen.g_0.getHeight() - (screen._map.getHeight() - 30) && screen._map.getY() >= - 19) {
                        screen.setAdjust(Graphic.Adjust.up);
                        screen.act();
                    }
                }
            }
            
            case 87 -> {
                if (screen instanceof Alabastia_4_3) {
                    if (player.getY() + 25 >= screen._map.getY()) 
                        player.walk(Player.Dir.up, player.getX(), player.getY() - 5);
                    
                    if (player.getY() <= screen.g_0.getY() && screen._map.getY() < 0) {
                        screen.setAdjust(Graphic.Adjust.down);
                        screen.act();
                    }
                }
            }
            
            case 112 -> {
                if (screen instanceof Pokedex) {
                    try {
                        ScreenController.setScreen(new Alabastia_4_3());
                    } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                        Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
}
