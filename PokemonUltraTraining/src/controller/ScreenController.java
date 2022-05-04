package controller;

import gui.Graphic;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleView;
import gui.frameable.Menu;
import java.awt.Component;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.EventListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController {
    private static Graphic graphics;
    
    public static boolean update = true;
    
    private static void render() throws IOException, InterruptedException {while (isUpdate()) graphics.update();}
    public  static void setUpdate(boolean updt) {update = updt;}
    public static boolean isUpdate() {return update;}

    public static void setScreen(Graphic g) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (graphics != null) setUpdate(false);
        g.create();
        
        g.g_0.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                System.out.println(".keyTyped()");
            }

            @Override
            public void keyPressed(KeyEvent e) {
                System.out.println(".keyPressed()");
                
                switch (e.getKeyCode()) {
                    case 112 -> {
                        try {
                            ScreenController.setScreen(new Menu());
                        } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                            Logger.getLogger(ScreenController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                System.out.println(".keyReleased()");
            }
        });
        
        g.g_0.setFocusable(true);
        g.g_0.requestFocusInWindow();
        graphics = g;
        setUpdate(true);
        render();
    }
}