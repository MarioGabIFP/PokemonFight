package gui;

import controller.logic.Actions;
import controller.logic.Charger;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
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
import gui.elements.screen.Form;
import gui.elements.screen.IMaps;
import gui.elements.screen.Models;
import java.awt.Frame;
import java.awt.event.KeyListener;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Graphic extends Frame implements IMaps, Models, Form{
    public enum Adjust{down,up,left,right}
    
    public BufferStrategy bs;
    public Graphics2D g;
    public Adjust adjust;
    
    public abstract void create() throws IOException, SAXException, ParserConfigurationException, InterruptedException;
    public abstract void update() throws IOException, InterruptedException;
    public abstract void act();
    
    public final void setAdjust(Adjust adjust) {this.adjust = adjust;}
    public final Adjust getAdjust() {return adjust;}
    
    public final Canvas g_0 = new Canvas();
    
    protected final Charger chargeController = new Charger(this);
    protected final Actions actionController = new Actions(this);
    
    public Graphic() throws IOException {
        setUndecorated(true);
        setBounds(100, 100, 960, 640);
        setMaximizedBounds(getBounds());
        setResizable(false);
        g_0.addKeyListener((KeyListener) actionController);
        g_0.setFocusable(true);
        g_0.requestFocus();
        chargeController.charge();
    }
    
    @Override
    public void loadSprite(Image sprite, int x, int y) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.drawImage(sprite, x, y, null);
        g.dispose();
    }

    @Override
    public void loadMap(Image map, int x, int y) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.drawImage(map, x, y, null);
        g.dispose();
    }
    
    @Override
    public void loadImage(Image img, int x, int y) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.drawImage(img, x, y, null);
        g.dispose();
    }

    @Override
    public void loadString(int x, int y, Color color, String text, int w) {
        g = (Graphics2D) bs.getDrawGraphics();
        Font f = new Font("Monospaced", Font.BOLD, w);
        g.setFont(f);
        g.setColor(color);
        g.drawString(text, x, y);
        g.dispose();
    }

    @Override
    public void loadFillRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setColor(color);
        g.fillRoundRect(x, y, w, h, aW, aH);
        g.dispose();
    }
    
    @Override
    public void loadFillGradientRoundRect(int x, int y, int w, int h, GradientPaint color, BasicStroke thickness, int aW, int aH) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setPaint(color);
        g.fillRoundRect(x, y, w, h, aW, aH);
        g.dispose();
    }
    
    @Override
    public void loadRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setColor(color);
        g.drawRoundRect(x, y, w, h, aW, aH);
        g.dispose();
    }
    
    @Override
    public void loadRect(int x, int y, int w, int h, Color color, BasicStroke thickness) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setColor(color);
        g.drawRect(x, y, w, h);
        g.dispose();
    }
    
    @Override
    public void loadFillOval(int x, int y, int w, int h, Color color) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setColor(color);
        g.fillOval(x, y, w, h);
        g.dispose();
    }
    
    @Override
    public void loadFillRect(int x, int y, int w, int h, Color color, BasicStroke thickness) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setColor(color);
        g.fillRect(x, y, w, h);
        g.dispose();
    }

    @Override
    public void loadLine(int x, int y, int fx, int fy, Color color, BasicStroke thickness) {
        g = (Graphics2D) bs.getDrawGraphics();
        g.setStroke(thickness);
        g.setColor(color);
        g.drawLine(x, y, fx, fy);
        g.dispose();
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

                    if (name.equals("startW")) tsw = Integer.parseInt(property.getAttribute("value")); else 
                    if (name.equals("startH")) tsh = Integer.parseInt(property.getAttribute("value"));
                }
            }

            sprite = ImageIO.read(new File(dir + ((Element) document.getElementsByTagName("image").item(0)).getAttribute("source")));
            tw = Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("tileW"));
            th = Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("tileH"));
            
            if (tsw < Integer.parseInt(((Element) document.getElementsByTagName("image").item(0)).getAttribute("width")))
                tilesList.add(sprite.getSubimage(tsw, tsh, tw, th));
        }
        return tilesList;
    }
}
