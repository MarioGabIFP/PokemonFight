package gui.frameable;

import controller.memory.TempMem.BattleMem;
import gui.Graphic;
import java.awt.BasicStroke;
import gui.frameable.Menu.MenuConstructor;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class BattleScreen extends Graphic {
    private ArrayList<Image> genderImages;
    private String nameP, nameE;

    public BattleScreen() throws IOException {}
    
    @Override public void act() {
        switch (MenuConstructor.BattleOptn.getBO()) {
            case setfigth -> {
                System.out.println("Lucha");
            }
            case miPokedex -> {
                System.out.println("Pokemon");
            }
            case miBag -> {
                System.out.println("Mochila");
            }
            case exit -> {
                System.out.println("Salida");
            }
        }
    }
    
    public void hpPrint(int sx, int fx, int sy, int fy, BattleMem p) {
        int c = (((fx * p.getHP()) / 100) + sx);
        
        if (c > sx) {
            if (c > fx) {
                loadLine(sx, sy, c - sx, fy, new Color(0.475f, 0.953f, 0.659f), new BasicStroke(5.0f));
            } else {
                loadLine(sx, sy, c, fy, new Color(0.475f, 0.953f, 0.659f), new BasicStroke(5.0f));
            }
        } else {
            loadLine(sx, sy, c, fy, WHITE, new BasicStroke(5.0f));
        }
    }
    
    @Override
    public void create() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        this.genderImages = new ArrayList<>();
        
        // Establecemos el espacio de juego.
        g_0.setBounds(223, 64, 514, 512);
        g_0.setBackground(new Color(0.086f, 0.714f, 0.404f));

        if (BattleMem.player.getName().length() > 15) {
            nameP = BattleMem.player.getName().substring(0, 15) + "..."; 
        } else {
            nameP = BattleMem.player.getName();
        }
        
        if (BattleMem.enemy.getName().length() > 15) {
            nameE = BattleMem.enemy.getName().substring(0, 15) + "..."; 
        } else {
            nameE = BattleMem.enemy.getName();
        }
        
        genderImages.addAll(tileMapper(new File(genderImg + "1.tsx"), genderImg));
        
        pointer.setBounds(280, 357, 30, 30);
        pointer.setRX(275);
        pointer.setRY(354);
        pointer.setPointerSprites(new File(spritesPokeball + "1.tsx"));
        pointer.addAllTiles(tileMapper(pointer.getPointerSprites(), spritesPokeball));
        pointer.setPointerTile(pointer.getTileBuffer().get(1).getScaledInstance(pointer.getWidth(), pointer.getHeight(), ALLBITS));
        
        add(g_0);
        pack();
        setVisible(true);
    }

    @Override
    public void update() throws IOException, InterruptedException {
        bs = g_0.getBufferStrategy();

        if (bs == null) {
            g_0.createBufferStrategy(3);
            return;
        }

        loadImage(ImageIO.read(battleBackground).getScaledInstance(514, 256, ALLBITS), 0, 0);

        /*
         * Sprite Pokemon Jugador
         */
        loadImage(BattleMem.player.getTile().getScaledInstance(144, 144, ALLBITS), 50, 125);

        /**
         * Pinta informacion jugador
         */
        loadFillRoundRect(10 , 250, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10, 250, 287, 70, BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(69, 295, 222, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(100, 304, 280, 304, WHITE, new BasicStroke(10.0f));
        hpPrint(100, 280, 304, 304, BattleMem.player);
        loadString(69, 270, BLACK, nameP, 15);
        
        loadImage(genderImages.get( switch (BattleMem.player.getGender()) {
                                        case male -> 1;
                                        case female -> 0;
                                    }).getScaledInstance(32, 32, ALLBITS), 19, 255);
        
        loadString(74, 309, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        loadString(245, 270, BLACK, "LV " + BattleMem.player.getLV(), 15);

        /*
         * Sprite Pokemon Enemigo
         */
        loadImage(BattleMem.enemy.getTile().getScaledInstance(144, 144, ALLBITS), 265, 40);

        /**
         * Pinta informacion enemigo
         */
        loadFillRoundRect(10, 10, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10, 10, 287, 70, BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(69, 55, 222, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(100, 64, 280, 64, WHITE, new BasicStroke(10.0f));
        hpPrint(100, 280, 64, 64, BattleMem.enemy);
        loadString(69, 28, BLACK, nameE, 15);
        
        loadImage(genderImages.get( switch (BattleMem.enemy.getGender()) {
                                        case male -> 1;
                                        case female -> 0;
                                    }).getScaledInstance(32, 32, ALLBITS), 19, 13);
        
        loadString(74, 69, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        loadString(245, 28, BLACK, "LV " + BattleMem.enemy.getLV(), 15);

        /**
         * Recuadro inferior
         */
        loadFillRoundRect(0, 330, 514, 200, new Color(0.600f, 0.659f, 0.718f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(0, 330, 514, 200, BLACK, new BasicStroke(6.0f), 10, 10);

        /**
         * Recuadro de informacion
         */
        loadFillRoundRect(10, 340, 257, 165, new Color(0.430f, 0.469f, 0.518f), new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(30, 355, 220, 135, WHITE, new BasicStroke(6.0f), 10, 10);
        loadRoundRect(15, 345, 250, 155, new Color(0.941f, 0.702f, 0.286f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10, 340, 260, 165, BLACK, new BasicStroke(8.0f), 10, 10);
        loadString(40, 400, BLACK, "¿Que va a hacer ", 20);
        loadString(40, 425, BLACK, BattleMem.player.getName() + "?", 20);

        /**
         * Recuadro de acciones
         */
        loadFillRoundRect(260, 338, 245, 169, new Color(0.439f, 0.408f, 0.502f), new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(270, 350, 225, 145, WHITE, new BasicStroke(6.0f), 10, 10);
        loadRoundRect(260, 338, 245, 169, BLACK, new BasicStroke(8.0f), 10, 10);

        loadRoundRect(pointer.getRX(), pointer.getRY(), 215, 36, RED, new BasicStroke(4.0f), 10, 10);

        loadString(320, 380, BLACK, "Lucha", 25);
        loadString(320, 410, BLACK, "Pokémon", 25);
        loadString(320, 440, BLACK, "Mochila", 25);
        loadString(320, 470, BLACK, "Huida", 25);

        loadSprite(pointer.getPointerTile(), pointer.getX(), pointer.getY());

        bs.show();
    }
}
