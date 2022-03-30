package view;

import java.awt.Canvas;
import java.awt.DisplayMode;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import view.elements.screen.IMaps;
import view.elements.screen.Sprites;

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
				
				try{
		            Thread.sleep(sleep);
		        } catch(InterruptedException ex){
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
		loadSprite(player.getPlayerSprite(), player.getX(), player.getY());
		
		bs.show();
	}
	
	@Override
	public void loadSprite(Image sprite, int x, int y) {
		Graphics g = bs.getDrawGraphics();
		g.drawImage(sprite, x, y, null);
		
		if (g != null) {
	        g.dispose();
	    }
	}

	@Override
	public void loadMap(Image map) {
		Graphics g = bs.getDrawGraphics();
		g.drawImage(map, 0, 0, null);
		
		if (g != null) {
	        g.dispose();
	    }
	}

	@Override
	public Image[] decodeSprites(File xml) throws IOException {
		return null;
	}
}

