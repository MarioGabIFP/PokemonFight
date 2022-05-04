package controller;

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
}
