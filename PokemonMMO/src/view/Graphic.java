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
		loadMap(_1_bmp);
		loadSprite(player.getPlayer_bmp(), player.getX(), player.getY());
	}
	
	@Override
	public void loadSprite(File image, int x, int y) throws IOException {
		Image sprite = ImageIO.read(image).getScaledInstance(player.getWidth(), player.getHeight(), Image.SCALE_FAST);
		BufferStrategy bs = g_base.getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(sprite, x, y, null);
		
		if (g != null) {
	        g.dispose();
	    }
		
		bs.show();
	}

	@Override
	public void loadMap(File image) throws IOException {
		Image map = ImageIO.read(image).getScaledInstance(g_base.getWidth(), g_base.getHeight(), Image.SCALE_FAST);
		BufferStrategy bs = g_base.getBufferStrategy();
		
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		g.drawImage(map, 0, 0, null);
		
		if (g != null) {
	        g.dispose();
	    }
		
		bs.show();
	}
}

