package view.frameable;

import controller.Orchestrator;
import controller.elements.Options.MenInfo;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.event.KeyListener;
import java.awt.event.WindowFocusListener;
import static java.awt.image.ImageObserver.ALLBITS;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import static view.elements.Assets.spritePointer;
import static view.elements.Base.BLACK;
import static view.elements.Base.RED;
import static view.elements.Base.WHITE;
import static view.elements.Base.frame;
import view.frames.Updater;
import static view.elements.screen.Form.g_1;
import static view.elements.screen.Models.pointer;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class PokeDex extends Frame implements Updater {
    String title;
    Orchestrator ma;
    
    public PokeDex(MenInfo typeMenu) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        this.title = typeMenu.getTitle();
        ma = new Orchestrator(Orchestrator.ObjectTC.menu);
        
        // Establecemos el espacio de juego.
        g_1.setBounds(223, 64, 514, 512);

        pointer.setBounds(263, 64, 20, 20);
        pointer.setRX(250);
        pointer.setRY(53);
        pointer.setPointerSprites(new File(spritePointer + "1.tsx"));
        pointer.addAllTiles(tileMapper(pointer.getPointerSprites(), spritePointer));
        pointer.setPointerTile(pointer.getTileBuffer().get(2).getScaledInstance(pointer.getWidth(), pointer.getHeight(), ALLBITS));
        
        frame.add(g_1);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener((KeyListener) ma);
        frame.addWindowFocusListener((WindowFocusListener) ma);

        //Corremos los graficos
        super.run();
    }

    @Override
    public void Update() throws IOException, InterruptedException {
        int h1 = 0;
        int h2 = 0;
        int w = 0;

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
            loadLine(0, i, 514, i, BLACK, new BasicStroke(3.0f));
        }

        /*
         * Nombre Pokemón
         */
        loadFillRoundRect(8, 50, 230, 41, RED, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(28, 54, 190, 32, WHITE, new BasicStroke(6.0f), 10, 10);
        loadRect(28, 54, 190, 32, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(6.0f));
        loadRoundRect(8, 50, 230, 41, BLACK, new BasicStroke(6.0f), 10, 10);
        loadString(35, 77, BLACK, "Null", 25);

        /*
         * Datos pokemón
         */
        h1 = 350;
        h2 = 354;
        for (int i = 0; i < 2; i++) {
            loadFillRoundRect(8, h1, 230, 41, RED, new BasicStroke(6.0f), 10, 10);
            loadFillRoundRect(28, h2, 190, 32, WHITE, new BasicStroke(6.0f), 10, 10);
            loadRect(28, h2, 190, 32, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(6.0f));
            loadRoundRect(8, h1, 230, 41, BLACK, new BasicStroke(6.0f), 10, 10);
            loadString(35, h2 + 23, BLACK, "Null", 25);
            h1 += 55;
            h2 += 55;
        }

        /*
         * Lista Pokemones
         */
        loadFillRoundRect(250, 50, 250, 395, RED, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(300, 50, 200, 395, WHITE, new BasicStroke(6.0f), 10, 10);
        loadLine(300, 53, 300, 441, new Color(0.949f, 0.612f, 0.647f), new BasicStroke(8.0f));
        loadRoundRect(250, 50, 250, 395, BLACK, new BasicStroke(6.0f), 10, 10);
        
        h1 = 60;
        h2 = 83;
        for (int i = 0; i < 7; i++) {
            loadFillOval(258, h1, 30, 30, WHITE); // ma.actions.selectItem ? Color.BLUE : WHITE
            loadString(315, h2, BLACK, "Null", 25);
            h1 += 50;
            h2 += 50;
            ma.actions.selectItem = false;
        }
        
        loadRoundRect(pointer.getRX(), pointer.getRY(), 250, 45, WHITE, new BasicStroke(8.0f), 10, 10);
        loadRoundRect(pointer.getRX(), pointer.getRY(), 250, 45, RED, new BasicStroke(4.0f), 10, 10);
        loadSprite(pointer.getPointerTile(), pointer.getX(), pointer.getY());

        /*
         * Botones de acción
         */
        w = 8;
        for (int i = 0; i < 4; i++) {
            loadFillGradientRoundRect(w, 460, 115, 40, new GradientPaint(0, 0, WHITE, 0, 40, new Color(0.600f, 0.659f, 0.718f)), new BasicStroke(6.0f), 10, 10);
            loadRoundRect(w, 460, 115, 40, BLACK, new BasicStroke(4.0f), 10, 10);
            w += 126;
        }

        /*
         * Titulo
         */
        loadString((g_1.getWidth() / 2) - (title.length() * 9), 25, WHITE, title, 30);
        
        /*
         * Opciones de ventana
         */
        loadString(26, 487, BLACK, "SALIR", 25);
        loadString(144, 487, BLACK, "BUSCAR", 25);
        loadString(278, 487, BLACK, "COGER", 25);
        loadString(391, 487, BLACK, "MOCHILA", 25);

        bs.show();
    }
}