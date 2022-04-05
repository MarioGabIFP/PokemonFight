package view.frameable;

import java.awt.Image;
import static java.awt.image.ImageObserver.ABORT;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import view.Frame;
import view.Updater;
import static view.elements.Assets.spritePlayer;
import static view.elements.Base.frame;
import static view.elements.screen.IMaps._1_bmp;
import static view.elements.screen.IMaps.g_base;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class dctrOakTalks extends Frame implements Updater{
    
    public dctrOakTalks() throws IOException, SAXException, ParserConfigurationException {
        player.setBounds(200, 200, 35, 80);
        player.setPlayerSprites(new File(spritePlayer + "1.tsx"));
        player.addAllTiles(decodeSprites(player.getPlayerSprites(), spritePlayer));
        player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));

        // Establecemos el espacio de juego.
        g_base.setBounds(223, 64, 514, 512);
        frame.add(g_base);
        frame.pack();
        frame.setVisible(true);
        
        // Corremos los graficos
        super.run();
    }
    
    @Override
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
}
