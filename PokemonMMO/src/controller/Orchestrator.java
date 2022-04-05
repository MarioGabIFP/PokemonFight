package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import view.frameable.Alabastia_4_3;
import view.frameable.dctrOakTalks;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Orchestrator extends Actions {

    private static final long serialVersionUID = 1L;

    Orchestrator() throws IOException, SAXException, ParserConfigurationException {
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
        
        Frame.chargeMap(new dctrOakTalks());
    }
}
