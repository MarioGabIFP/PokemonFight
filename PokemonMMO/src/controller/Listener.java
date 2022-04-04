package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Listener extends Actions {

    private static final long serialVersionUID = 1L;

    Listener() throws IOException {
        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
                KeyPressedList.remove((Object) e.getKeyCode());
                PlayerActions().run();
            }

            @Override
            public void keyPressed(KeyEvent e) {
                int codeKey = e.getKeyCode();

                if (!KeyPressedList.contains(codeKey)) {
                    KeyPressedList.add(codeKey);
                }

                PlayerActions().run();
            }
        });
    }
}
