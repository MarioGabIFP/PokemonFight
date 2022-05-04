package gui.frameable;

import controller.elements.Opponents.values;
import gui.Graphic;
import java.awt.BasicStroke;
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
public class BattleView extends Graphic {
    ArrayList<Image> genderImages;
    String nameP;
    String nameE;
    
    @Override
    public void create() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        this.genderImages = new ArrayList<>();
        
        // Establecemos el espacio de juego.
        g_0.setBounds(223, 64, 514, 512);
        g_0.setBackground(new Color(0.086f, 0.714f, 0.404f));

        if (values.player.getName().length() > 7) {
            nameP = values.player.getName().substring(0, 7) + "..."; 
        } else {
            nameP = values.player.getName();
        }
        
        if (values.enemy.getName().length() > 7) {
            nameE = values.enemy.getName().substring(0, 7) + "..."; 
        } else {
            nameE = values.enemy.getName();
        }
        
        genderImages.addAll(tileMapper(new File(genderImg + "1.tsx"), genderImg));
        
        pointer.setBounds(280, 357, 30, 30);
        pointer.setRX(275);
        pointer.setRY(354);
        pointer.setPointerSprites(new File(spritePointer + "1.tsx"));
        pointer.addAllTiles(tileMapper(pointer.getPointerSprites(), spritePointer));
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
        loadImage(ImageIO.read(new File(values.player.getTile())).getScaledInstance(144, 144, ALLBITS), 50, 125);

        /**
         * Pinta informacion jugador
         */
        loadFillRoundRect(10 , 250, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10 , 250, 287, 70, BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(49, 291, 242, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(80, 300, 280, 300, WHITE, new BasicStroke(10.0f));
        hpPrint(80, 280, 300, 300, values.player);
        loadString(50, 277, BLACK, nameP, 25);
        loadImage(genderImages.get( switch (values.player.getGender()) {
                                        case male -> 1;
                                        case female -> 0;
                                    }).getScaledInstance(32, 32, ALLBITS), 19, 255);
        loadString(54, 305, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        loadString(200, 277, BLACK, "LV " + values.player.getLV(), 25);

        /*
         * Sprite Pokemon Enemigo
         */
        loadImage(ImageIO.read(new File(values.enemy.getTile())).getScaledInstance(144, 144, ALLBITS), 265, 40);

        /**
         * Pinta informacion enemigo
         */
        loadFillRoundRect(10, 10, 287, 70, new Color(0.984f, 0.965f, 0.839f), new BasicStroke(6.0f), 10, 10);
        loadRoundRect(10, 10, 287, 70, BLACK, new BasicStroke(6.0f), 10, 10);
        loadFillRoundRect(49, 47, 242, 19, new Color(0.322f, 0.412f, 0.341f), new BasicStroke(6.0f), 10, 10);
        loadLine(80, 56, 280, 56, WHITE, new BasicStroke(10.0f));
        hpPrint(80, 280, 56, 56, values.enemy);
        loadString(55, 36, BLACK, nameE, 25);
        loadImage(genderImages.get( switch (values.enemy.getGender()) {
                                        case male -> 1;
                                        case female -> 0;
                                    }).getScaledInstance(32, 32, ALLBITS), 19, 13);
        loadString(54, 61, new Color(0.941f, 0.702f, 0.286f), "HP", 15);
        loadString(200, 36, BLACK, "LV " + values.enemy.getLV(), 25);

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
        loadString(40, 425, BLACK, values.player.getName() + "?", 20);

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
    
    public void hpPrint(int sx, int fx, int sy, int fy, values p) {
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
}
