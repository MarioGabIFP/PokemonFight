package view;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Screen extends Frame {

    private static final long serialVersionUID = 1L;

    public Screen() throws IOException, SAXException, ParserConfigurationException {
        player.setBounds(200, 200, 35, 80);
        player.setPlayerSprites(new File(spritePlayer + "playerSprite.tsx"));
        player.addAllTiles(decodeSprites(player.getPlayerSprites()));
        player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));

        // Establecemos el espacio de juego.
        g_base.setBounds(223, 64, 514, 512);
        frame.add(g_base);

        //Corremos los graficos
        super.run();
    }
}
