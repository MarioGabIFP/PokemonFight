package gui;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import view.elements.screen.Form;
import view.elements.screen.IMaps;
import view.elements.screen.Models;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Graphic extends JFrame implements IMaps, Models, Form{
    Canvas g_0 = new Canvas();
    public BufferStrategy bs;
    public Graphics g;
    
    public Graphic() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 960, 640);
        setMaximizedBounds(getBounds());
        setResizable(false);
    }
    
    public void render() {
        g_0.setBounds(223, 64, 514, 512);
        add(g_0);
        pack();
        setVisible(true);
    }
    
    public void update() {
        while (true) {
            bs = g_0.getBufferStrategy();

            if (bs == null) {
                g_0.createBufferStrategy(3);
            } else {
                g = bs.getDrawGraphics();
                ((Graphics2D) g).setColor(Color.BLACK);
                ((Graphics2D) g).fillRoundRect(10, 10, 10, 10, 10, 10);
                bs.show();
            }
        }
    }
    
    @Override
    public void loadSprite(Image sprite, int x, int y) {
        g = bs.getDrawGraphics();
        g.drawImage(sprite, x, y, null);
        g.dispose();
    }

    @Override
    public void loadMap(Image map, int x, int y) {
        g = bs.getDrawGraphics();
        g.drawImage(map, x, y, null);
        g.dispose();
    }
    
    @Override
    public void loadImage(Image img, int x, int y) {
        g = bs.getDrawGraphics();
        g.drawImage(img, x, y, null);
        g.dispose();
    }

    @Override
    public void loadString(int x, int y, Color color, String text, int w) {
        g = bs.getDrawGraphics();
        Font f = new Font("Monospaced", Font.BOLD, w);
        ((Graphics2D) g).setFont(f);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).drawString(text, x, y);
        ((Graphics2D) g).dispose();
    }

    @Override
    public void loadFillRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).fillRoundRect(x, y, w, h, aW, aH);
        ((Graphics2D) g).dispose();
    }
    
    @Override
    public void loadFillGradientRoundRect(int x, int y, int w, int h, GradientPaint color, BasicStroke thickness, int aW, int aH) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setPaint(color);
        ((Graphics2D) g).fillRoundRect(x, y, w, h, aW, aH);
        ((Graphics2D) g).dispose();
    }
    
    @Override
    public void loadRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).drawRoundRect(x, y, w, h, aW, aH);
        ((Graphics2D) g).dispose();
    }
    
    @Override
    public void loadRect(int x, int y, int w, int h, Color color, BasicStroke thickness) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).drawRect(x, y, w, h);
        ((Graphics2D) g).dispose();
    }
    
    @Override
    public void loadFillOval(int x, int y, int w, int h, Color color) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).fillOval(x, y, w, h);
        ((Graphics2D) g).dispose();
    }
    
    @Override
    public void loadFillRect(int x, int y, int w, int h, Color color, BasicStroke thickness) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).fillRect(x, y, w, h);
        ((Graphics2D) g).dispose();
    }

    @Override
    public void loadLine(int x, int y, int fx, int fy, Color color, BasicStroke thickness) {
        g = bs.getDrawGraphics();
        ((Graphics2D) g).setStroke(thickness);
        ((Graphics2D) g).setColor(color);
        ((Graphics2D) g).drawLine(x, y, fx, fy);
        ((Graphics2D) g).dispose();
    }

    @Override
    public ArrayList<Image> tileMapper(File xml, String dir) throws IOException, SAXException, ParserConfigurationException {
        int tsw = 0;
        int tsh = 0;
        int tw = 0;
        int th = 0;
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
                    } else if (name.equals("startH")) {
                        tsh = Integer.parseInt(property.getAttribute("value"));
                    }
                }
            }

            sprite = ImageIO.read(new File(dir + ((Element) document.getElementsByTagName("image").item(0)).getAttribute("source")));
            tw = Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("tileW"));
            th = Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("tileH"));
            
            if (tsw < Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("width"))) {
                tilesList.add(sprite.getSubimage(tsw, tsh, tw, th));
            }
        }
        return tilesList;
    }
}
