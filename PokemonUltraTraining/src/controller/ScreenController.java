package controller;

import gui.Graphic;
import gui.frameable.Alabastia_4_3;
import gui.frameable.BattleView;
import gui.frameable.Menu;
import java.awt.Component;
import java.awt.event.KeyListener;
import java.awt.event.WindowFocusListener;
import java.io.IOException;
import java.util.Arrays;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class ScreenController {
    private static Graphic graphics;
    public static boolean update = true;
    public static Orchestrator orchestra = new Orchestrator();

    public static void setScreen(Graphic g) throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (graphics != null) {
            setUpdate(false);
            graphics.dispose();
            for (Component component : graphics.getComponents()) graphics.remove(component);
        } 
        
        graphics = g;
        
        setController();
        graphics.create();
        setUpdate(true);
        render();
    }
    
    private static void render() throws IOException, InterruptedException {
        while (isUpdate()) {            
            graphics.update();
        }
    }

    private static void setController() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        if (graphics instanceof Menu) orchestra.setOtc(Orchestrator.ObjectTC.menu);
        if (graphics instanceof BattleView) orchestra.setOtc(Orchestrator.ObjectTC.battle);
        if (graphics instanceof Alabastia_4_3) orchestra.setOtc(Orchestrator.ObjectTC.player);
        
        orchestra.chargeController();
        graphics.g_0.addKeyListener((KeyListener) orchestra);
        graphics.addWindowFocusListener((WindowFocusListener) orchestra);
        graphics.g_0.setFocusable(true);
        graphics.g_0.requestFocus();
    }
    
    public  static void setUpdate(boolean updt) {
        update = updt;
    }

    public static boolean isUpdate() {
        return update;
    }
}