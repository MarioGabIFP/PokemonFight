package view.frameable;

import controller.Actions;
import controller.battle.BattleActions;
import controller.Orchestrator;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import view.frames.Updater;
import static view.elements.Base.frame;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleView extends Frame implements Updater {
    public BattleView() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        Actions ba = new Orchestrator(Orchestrator.ObjectTC.battle);
        
        // Establecemos el espacio de juego.
        g_1.setBounds(223, 64, 514, 512);
        g_1.setBackground(new Color(0.086f, 0.714f, 0.404f));
        
        frame.add(g_1);
        frame.pack();
        frame.setVisible(true);
        frame.addKeyListener((KeyListener) ba);
        frame.addWindowFocusListener((WindowFocusListener) ba);

        //Corremos los graficos
        super.run();
    }

    @Override
    public void Update() throws IOException, InterruptedException {
        bs = g_1.getBufferStrategy();

        if (bs == null) {
            g_1.createBufferStrategy(3);
            return;
        }
        
        loadImage(ImageIO.read(battleBackground).getScaledInstance(514, 256, ALLBITS), 0, 0);
        
        loadFillRoundRect(-10 , 250, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(-10 , 250, 287, 70, Color.BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(29, 291, 242, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(60, 300, 260, 300, Color.WHITE, new BasicStroke(10.0f));
        hpPrint(60, 260, 300, 300, BattleActions.values.player);
        
        loadString(34, 305, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        
        loadFillRoundRect(220, 10, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(220, 10, 287, 70, Color.BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(227, 47, 242, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(260, 56, 460, 56, Color.WHITE, new BasicStroke(10.0f));
        hpPrint(260, 460, 56, 56, BattleActions.values.player);
        
        loadString(233, 61, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        
        loadFillRoundRect(0, 330, 514, 200, new Color(0.600f, 0.659f, 0.718f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(0, 330, 514, 200, Color.BLACK, new BasicStroke(6.0f), 10, 10);
        
        loadFillRoundRect(10, 340, 257, 165, new Color(0.430f, 0.469f, 0.518f), new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(30, 355, 220, 135, Color.WHITE, new BasicStroke(6.0f), 10, 10);
        loadRoundRect(15, 345, 250, 155, new Color(0.941f, 0.702f, 0.286f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10, 340, 260, 165, Color.BLACK, new BasicStroke(8.0f), 10, 10);
        
        loadString(40, 400, Color.black, "¿que va a hacer ", 20);
        loadString(40, 425, Color.black, BattleActions.values.player.getName() + "?", 20);
        
        bs.show();
    }
    
    public void hpPrint(int sx, int fx, int sy, int fy, BattleActions.values p) {
        int c = (((fx * p.getHP()) / 100) + sx);
        
        if (c > sx) {
            if (c > fx) {
                loadLine(sx, sy, c - sx, fy, new Color(0.475f, 0.953f, 0.659f), new BasicStroke(5.0f));
            } else {
                loadLine(sx, sy, c, fy, new Color(0.475f, 0.953f, 0.659f), new BasicStroke(5.0f));
            }
        } else {
            loadLine(sx, sy, c, fy, Color.WHITE, new BasicStroke(5.0f));
        }
    }
}
