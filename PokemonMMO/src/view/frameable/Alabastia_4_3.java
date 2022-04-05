package view.frameable;

import java.awt.Image;
import static java.awt.image.ImageObserver.ABORT;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import model.Pokeball;
import model.Trainer;
import org.xml.sax.SAXException;
import view.Frame;
import view.Updater;
import static view.elements.Assets.spritePlayer;
import static view.elements.Assets.spritesPokeball;
import static view.elements.Assets.spritesTrainer;
import static view.elements.Base.frame;
import static view.elements.screen.IMaps._1_bmp;
import static view.elements.screen.IMaps.g_base;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Alabastia_4_3 extends Frame implements Updater{

    Trainer trainer = new Trainer();
    Pokeball pokeball = new Pokeball();
        
    public Alabastia_4_3() throws IOException, SAXException, ParserConfigurationException {
        
        trainer.setBounds(200, 100, 35, 80);
        trainer.setPlayerSprites(new File(spritesTrainer + "gen3/oak/1.tsx"));
        trainer.addAllTiles(decodeSprites(trainer.getPlayerSprites(), spritesTrainer + "gen3/oak/"));
        trainer.setPlayerTile(trainer.getTileBuffer().get(1).getScaledInstance(trainer.getWidth(), trainer.getHeight(), ABORT));
        
        pokeball.setBounds(365, 170, 25, 25);
        pokeball.setPokeballType(Pokeball.type.multiball);
        pokeball.setActualTile(ImageIO.read(new File(spritesPokeball + "1.png")).getScaledInstance(pokeball.getWidth(), pokeball.getHeight(), ABORT));
        
        player.setBounds(200, 200, 35, 80);
        player.setPlayerSprites(new File(spritePlayer + "1.tsx"));
        player.addAllTiles(decodeSprites(player.getPlayerSprites(), spritePlayer));
        player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));

        // Establecemos el espacio de juego.
        g_base.setBounds(223, 64, 514, 512);
        frame.add(g_base);
        frame.pack();
        frame.setVisible(true);
        //Corremos los graficos
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
        loadSprite(pokeball.getActualTile(), pokeball.getX(), pokeball.getY());
        loadSprite(trainer.getPlayerTile(), trainer.getX(), trainer.getY());
        loadSprite(player.getPlayerTile(), player.getX(), player.getY());

        bs.show();
    }
}
