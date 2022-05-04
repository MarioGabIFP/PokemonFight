package controller;

import controller.elements.Opponents;
import controller.elements.Options;
import gui.Graphic;
import static gui.elements.screen.Models.pointer;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleView;
import gui.frameable.Menu;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions implements KeyListener {
    private final Graphic screen;
    
    int i = 100;
    int speed;
    int x;
    int y;
    int w;
    int h;
    
    public boolean selectItem = false;
    
    public Actions(Graphic screen) {this.screen = screen;}
    
    @Override public void keyTyped(KeyEvent e) {}
    @Override public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case 32 -> {
                if (screen instanceof BattleView) {
                    for (Options.Battle b: Options.Battle.values()) {
                        if (b.isSelected()) {
                            switch (b.getAction()) {
                                case setfigth -> {
                                    System.out.println("Lucha");
                                    Opponents.values.enemy.setHP(i);
                                    Opponents.values.player.setHP(i);

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
                
                if (screen instanceof Menu) {
                    selectItem = true;
                }
            }
            
            case 40 -> {
                if (screen instanceof BattleView) {
                    if (pointer.getRY() < 444) {
                        pointer.setRY(pointer.getRY() + 30);
                        pointer.setBounds(pointer.getX(), pointer.getY() + 30, pointer.getWidth(), pointer.getHeight());

                        evaluateRY();
                    }
                }
                
                if (screen instanceof Menu) {
                    if (pointer.getRY() < 353) {
                        pointer.setRY(pointer.getRY() + 50);
                        pointer.setBounds(pointer.getX(), pointer.getY() + 50, pointer.getWidth(), pointer.getHeight());
                    }
                }
            }
            
            case 38 -> {
                if (screen instanceof BattleView) {
                    if (pointer.getRY() > 354) {
                        pointer.setRY(pointer.getRY() - 30);
                        pointer.setBounds(pointer.getX(), pointer.getY() - 30, pointer.getWidth(), pointer.getHeight());

                        evaluateRY();
                    }
                }
                
                if (screen instanceof Menu) {
                    if (pointer.getRY() > 64) {
                        pointer.setRY(pointer.getRY() - 50);
                        pointer.setBounds(pointer.getX(), pointer.getY() - 50, pointer.getWidth(), pointer.getHeight());
                    }
                }
            }
            
            case 112 -> {
                try {
                    ScreenController.setScreen(new Menu());
                } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                    Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            case 113 -> {
                try {
                    ScreenController.setScreen(new BattleView());
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
        }
    }

    protected void evaluateRY() {
        switch (pointer.getRY()) {
            case 354 -> {
                Options.Battle.figth.setSelected(true);
                Options.Battle.pokemon.setSelected(false);
                Options.Battle.bag.setSelected(false);
                Options.Battle.skip.setSelected(false);
            }
            case 384 -> {
                Options.Battle.figth.setSelected(false);
                Options.Battle.pokemon.setSelected(true);
                Options.Battle.bag.setSelected(false);
                Options.Battle.skip.setSelected(false);
            }
            case 414 -> {
                Options.Battle.figth.setSelected(false);
                Options.Battle.pokemon.setSelected(false);
                Options.Battle.bag.setSelected(true);
                Options.Battle.skip.setSelected(false);
            }
            case 444 -> {
                Options.Battle.figth.setSelected(false);
                Options.Battle.pokemon.setSelected(false);
                Options.Battle.bag.setSelected(false);
                Options.Battle.skip.setSelected(true);
            }
        }
    }
}
