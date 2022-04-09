package view.elements.screen;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Image;
import view.elements.Assets;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Form extends Assets {

    Canvas g_1 = new Canvas();

    public void loadLine(int x, int y, int fx, int fy, Color color, BasicStroke thickness);
    public void loadFillRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH);
    public void loadFillGradientRoundRect(int x, int y, int w, int h, GradientPaint color, BasicStroke thickness, int aW, int aH);
    public void loadRoundRect(int x, int y, int w, int h, Color color, BasicStroke thickness, int aW, int aH);
    public void loadRect(int x, int y, int w, int h, Color color, BasicStroke thickness);
    public void loadFillRect(int x, int y, int w, int h, Color color, BasicStroke thickness);
    public void loadString(int x, int y, Color color, String text, int w);
    public void loadImage(Image img, int x, int y);
}
