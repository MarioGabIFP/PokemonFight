package view;

import java.awt.Canvas;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import view.elements.screen.IMaps;
import view.elements.screen.Sprites;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Graphic extends Canvas implements IMaps, Sprites, Runnable {

    private static final long serialVersionUID = 1L;

    BufferStrategy bs;

    @Override
    public void run() {
        //Controlamos el refresco de la pantalla
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        DisplayMode dm = gs.getDisplayMode();
        long OT = 1000000000 / dm.getRefreshRate();

        try {
            while (true) {
                long prevTU = System.nanoTime();

                Update();

                long sleep = (OT - (System.nanoTime() - prevTU)) / 1000000000;

                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException ex) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void Update() throws IOException {
        Image map = ImageIO.read(_1_bmp).getScaledInstance(g_base.getWidth(), g_base.getHeight(), Image.SCALE_FAST);
        bs = g_base.getBufferStrategy();

        if (bs == null) {
            g_base.createBufferStrategy(3);
            return;
        }

        loadMap(map);
        loadSprite(player.getPlayerTile(), player.getX(), player.getY());

        bs.show();
    }

    @Override
    public void loadSprite(Image sprite, int x, int y) {
        Graphics g = bs.getDrawGraphics();
        g.drawImage(sprite, x, y, null);
        g.dispose();
    }

    @Override
    public void loadMap(Image map) {
        Graphics g = bs.getDrawGraphics();
        g.drawImage(map, 0, 0, null);
        g.dispose();
    }

    @Override
    public ArrayList<Image> decodeSprites(File xml) throws IOException, SAXException, ParserConfigurationException {
        int tsw = 0;
        ArrayList<Image> tilesList = new ArrayList<>();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document document = db.parse(xml);
        NodeList tiles;
        BufferedImage sprite;

        document.getDocumentElement().normalize();

        tiles = document.getElementsByTagName("tile");

        for (int i = 0; i < tiles.getLength(); i++) {
            NodeList tileProperties = ((Element) tiles.item(i)).getElementsByTagName("properties");

            for (int j = 0; j < tileProperties.getLength(); j++) {
                NodeList tileProperties_1 = ((Element) tiles.item(i)).getElementsByTagName("property");

                for (int k = 0; k < tileProperties_1.getLength(); k++) {
                    Element property = (Element) tileProperties_1.item(k);
                    String name = property.getAttribute("name");

                    if (name.equals("startW")) {
                        tsw = Integer.parseInt(property.getAttribute("value"));
                    }
                }
            }

            sprite = ImageIO.read(new File(spritePlayer + ((Element) document.getElementsByTagName("image").item(0)).getAttribute("source")));

            if (tsw < Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("width"))) {
                tilesList.add(sprite.getSubimage(tsw, 0, 14, 32));
            }
        }

        return tilesList;
    }
}
