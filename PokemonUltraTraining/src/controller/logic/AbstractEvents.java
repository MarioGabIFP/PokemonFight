package controller.logic;

import controller.memory.TempMem;
import gui.Graphic;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleScreen;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class AbstractEvents implements TempMem {
    public static void Evaluate(Graphic screen) {
        if (screen instanceof Alabastia_4_3 && !enemySel.isEmpty() && !pokemonSel.isEmpty()) {
            try {
                ScreenController.setScreen(new BattleScreen());
            } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                Logger.getLogger(Actions.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
