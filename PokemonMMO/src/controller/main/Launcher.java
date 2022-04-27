package controller.main;

import controller.elements.Options;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.frameable.Alabastia_4_3;
import view.frameable.BattleView;
import view.frameable.PokeDex;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Launcher {

    /**
     * Método lanzador.
     *
     * Ejecuta el videojuego para el usuario activo.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        new Thread(() -> {
            try {
                new BattleView();
            } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
            }
        }){{start();}}.setName("BattleView");
        
//        new Thread(() -> {
//            try {
//                new PokeDex(Options.MenInfo.getPokemonFromMultiball);
//            } catch (IOException | ParserConfigurationException | SAXException | InterruptedException ex) {
//                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }){{start();}}.setName("PokeDexView");
        
//        new Thread(() -> {
//            try {
//                new Alabastia_4_3();
//            } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
//                Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }){{start();}}.setName("Alabastia_4_3");

//        Tools.calculateMapT();
    }
}
