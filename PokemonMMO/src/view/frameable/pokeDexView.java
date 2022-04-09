package view.frameable;

import controller.Orchestrator;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import view.frames.Updater;
import static view.elements.Base.frame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class PokeDexView extends Frame implements Updater {

    public enum MenInfo {
        getPokemonFromMultiball,
        getEnemy
    }

    public static MenInfo typeMenu;

    public PokeDexView() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        // Establecemos el espacio de juego.
        g_1.setBounds(223, 64, 514, 512);

        frame.add(g_1);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener(new Orchestrator(Orchestrator.ObjectTC.menu));
        frame.addWindowFocusListener(new Orchestrator(Orchestrator.ObjectTC.menu));

        //Corremos los graficos
        super.run();
    }

    @Override
    public void Update() throws IOException, InterruptedException {
        int h1 = 0;
        int h2 = 0;
        int w = 0;

        String title = "";
        
        if (typeMenu != null) {
            switch (typeMenu) {
                case getPokemonFromMultiball -> {
                    title = "Toma un Pokemón";
                }
                case getEnemy -> {
                    title = "Escoje contrincante";
                }
            }
        }

        bs = g_1.getBufferStrategy();

        if (bs == null) {
            g_1.createBufferStrategy(3);
            return;
        }

        for (int i = 16; i < 514; i += 20) {
            loadLine(i, 0, i, 512, Color.LIGHT_GRAY, new BasicStroke(3.0f));
        }

        for (int i = 16; i < 512; i += 20) {
            loadLine(0, i, 514, i, Color.LIGHT_GRAY, new BasicStroke(3.0f));
        }

        for (int i = 0; i < 16; i++) {
            loadLine(0, i, 514, i, new Color(0.278f, 0.376f, 0.969f), new BasicStroke(3.0f));
        }

        for (int i = 16; i < 20; i++) {
            loadLine(0, i, 514, i, new Color(0.196f, 0.275f, 0.784f), new BasicStroke(3.0f));
        }

        for (int i = 20; i < 32; i++) {
            loadLine(0, i, 514, i, new Color(0.122f, 0.188f, 0.596f), new BasicStroke(3.0f));
        }

        for (int i = 32; i < 36; i++) {
            loadLine(0, i, 514, i, Color.BLACK, new BasicStroke(3.0f));
        }

        /*
         * Nombre Pokemón
         */
        loadFillRoundRect(8, 50, 230, 41, Color.RED, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(28, 54, 190, 32, Color.WHITE, new BasicStroke(6.0f), 10, 10);
        loadRect(28, 54, 190, 32, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(6.0f));
        loadRoundRect(8, 50, 230, 41, Color.BLACK, new BasicStroke(6.0f), 10, 10);

        /*
         * Datos pokemón
         */
        h1 = 350;
        h2 = 354;
        for (int i = 0; i < 2; i++) {
            loadFillRoundRect(8, h1, 230, 41, Color.RED, new BasicStroke(6.0f), 10, 10);
            loadFillRoundRect(28, h2, 190, 32, Color.WHITE, new BasicStroke(6.0f), 10, 10);
            loadRect(28, h2, 190, 32, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(6.0f));
            loadRoundRect(8, h1, 230, 41, Color.BLACK, new BasicStroke(6.0f), 10, 10);
            h1 += 55;
            h2 += 55;
        }

        /*
         * Lista Pokemones
         */
        loadFillRoundRect(250, 50, 250, 395, Color.RED, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(300, 50, 200, 395, Color.WHITE, new BasicStroke(6.0f), 10, 10);
        loadLine(300, 53, 300, 441, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(8.0f));
        loadRoundRect(250, 50, 250, 395, Color.BLACK, new BasicStroke(6.0f), 10, 10);

        /*
         * Botones de acción
         */
        w = 8;
        for (int i = 0; i < 4; i++) {
            loadFillGradientRoundRect(w, 460, 115, 40, new GradientPaint(0, 0, Color.WHITE, 0, 40, new Color(0.600f, 0.659f, 0.718f)), new BasicStroke(6.0f), 10, 10);
            loadRoundRect(w, 460, 115, 40, Color.BLACK, new BasicStroke(6.0f), 10, 10);
            w += 126;
        }

        /*
         * Texto 
         */
        loadString((g_1.getWidth() / 2) - (title.length() * 9), 25, Color.WHITE, title, 30);

        bs.show();
    }

    public static MenInfo getTypeMenu() {
        return typeMenu;
    }

    public static void setTypeMenu(MenInfo typeMenu2) {
        typeMenu = typeMenu2;
    }
}
