package gui.frameable;

import gui.Graphic;
import static java.awt.image.ImageObserver.ALLBITS;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.xml.parsers.ParserConfigurationException;
import model.Pokeball;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Alabastia_4_3 extends Graphic {
    @Override 
    public void act() {
        switch (super.getAdjust()) {
            case down -> _map.setBounds(_map.getX(), _map.getY() + 5, _map.getWidth(), _map.getHeight());
            case up -> _map.setBounds(_map.getX(), _map.getY() - 5, _map.getWidth(), _map.getHeight());
            case left ->_map.setBounds(_map.getX() - 5, _map.getY(), _map.getWidth(), _map.getHeight());
            case right -> _map.setBounds(_map.getX() + 5, _map.getY(), _map.getWidth(), _map.getHeight());
        }
    }
    
    @Override
    public void create() throws IOException, SAXException, ParserConfigurationException, InterruptedException {
        // Establecemos el espacio de juego.
        g_0.setBounds(223, 64, 514, 512);

        _map.setBounds(0, 0, g_0.getWidth(), g_0.getHeight());
        _map.setMapSprite(new File(_Alabastia_4_3 + "1.tsx"));
        _map.setTiles(tileMapper(_map.getMapSprite(), _Alabastia_4_3));

        trainer.setBounds(250, 100, 35, 80);
        trainer.setPlayerSprites(new File(spritesTrainer + "gen3/oak/1.tsx"));
        trainer.addAllTiles(tileMapper(trainer.getPlayerSprites(), spritesTrainer + "gen3/oak/"));
        trainer.setPlayerTile(trainer.getTileBuffer().get(1).getScaledInstance(trainer.getWidth(), trainer.getHeight(), ALLBITS));

        pokeball.setBounds(377, 180, 25, 25);
        pokeball.setPokeballType(Pokeball.type.multiball);
        pokeball.setActualTile(ImageIO.read(new File(spritesPokeball + "1.png")).getScaledInstance(pokeball.getWidth(), pokeball.getHeight(), ALLBITS));

        player.setBounds(200, 200, 35, 80);
        player.setPlayerSprites(new File(spritePlayer + "1.tsx"));
        player.addAllTiles(tileMapper(player.getPlayerSprites(), spritePlayer));
        player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ALLBITS));
        
        add(g_0);
        pack();
        setVisible(true);
    }

    @Override
    public void update() throws IOException, InterruptedException {
        bs = g_0.getBufferStrategy();

        if (bs == null) {
            g_0.createBufferStrategy(3);
        } else {
            int x = 0;
            int y = 0;

            for (int i = 0; i < 169; i++) {
                int w = _map.getWidth() / 12;
                int h = _map.getHeight() / 12;
                int _x = _map.getX() + x;
                int _y = _map.getY() + y;

                switch (i) {
                    case 0 ->
                        loadMap(_map.getTiles().get(38).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 1 ->
                        loadMap(_map.getTiles().get(40).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 2 ->
                        loadMap(_map.getTiles().get(41).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 3, 4 ->
                        loadMap(_map.getTiles().get(52).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 5, 6, 10 ->
                        loadMap(_map.getTiles().get(1).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 7 ->
                        loadMap(_map.getTiles().get(17).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 8, 21, 47, 112, 118, 138, 144 ->
                        loadMap(_map.getTiles().get(0).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 9 ->
                        loadMap(_map.getTiles().get(49).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 11 ->
                        loadMap(_map.getTiles().get(23).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 12 ->
                        loadMap(_map.getTiles().get(24).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 13, 26, 52, 65 ->
                        loadMap(_map.getTiles().get(44).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 14 ->
                        loadMap(_map.getTiles().get(46).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 15 ->
                        loadMap(_map.getTiles().get(48).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 16 ->
                        loadMap(_map.getTiles().get(25).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 17 ->
                        loadMap(_map.getTiles().get(26).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 18 ->
                        loadMap(_map.getTiles().get(27).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 20, 46, 111, 137 ->
                        loadMap(_map.getTiles().get(22).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 22, 48, 113, 119, 139, 145 ->
                        loadMap(_map.getTiles().get(21).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 27 ->
                        loadMap(_map.getTiles().get(53).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 28, 54 ->
                        loadMap(_map.getTiles().get(35).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 29 ->
                        loadMap(_map.getTiles().get(32).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 30 ->
                        loadMap(_map.getTiles().get(33).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 31 ->
                        loadMap(_map.getTiles().get(34).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 33, 59, 124, 150, 163 ->
                        loadMap(_map.getTiles().get(29).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 34, 60, 125, 131, 151, 157, 164 ->
                        loadMap(_map.getTiles().get(14).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 35, 61, 126, 132, 152, 158, 165 ->
                        loadMap(_map.getTiles().get(28).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 39 ->
                        loadMap(_map.getTiles().get(39).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 40 ->
                        loadMap(_map.getTiles().get(54).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 41 ->
                        loadMap(_map.getTiles().get(55).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 53 ->
                        loadMap(_map.getTiles().get(43).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 66 ->
                        loadMap(_map.getTiles().get(50).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 67 ->
                        loadMap(_map.getTiles().get(42).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 77 ->
                        loadMap(_map.getTiles().get(2).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 78, 91 ->
                        loadMap(_map.getTiles().get(36).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 79, 92 ->
                        loadMap(_map.getTiles().get(37).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 80, 93, 106 ->
                        loadMap(_map.getTiles().get(7).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 90 ->
                        loadMap(_map.getTiles().get(9).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 103 ->
                        loadMap(_map.getTiles().get(16).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 104 ->
                        loadMap(_map.getTiles().get(45).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 105 ->
                        loadMap(_map.getTiles().get(51).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 108 ->
                        loadMap(_map.getTiles().get(5).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 109 ->
                        loadMap(_map.getTiles().get(6).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 117, 143 ->
                        loadMap(_map.getTiles().get(3).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 121 ->
                        loadMap(_map.getTiles().get(12).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 122 ->
                        loadMap(_map.getTiles().get(13).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 130, 156 ->
                        loadMap(_map.getTiles().get(10).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 134 ->
                        loadMap(_map.getTiles().get(19).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 135 ->
                        loadMap(_map.getTiles().get(20).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 167 ->
                        loadMap(_map.getTiles().get(30).getScaledInstance(w, h, ALLBITS), _x, _y);
                    case 168 ->
                        loadMap(_map.getTiles().get(31).getScaledInstance(w, h, ALLBITS), _x, _y);
                    default ->
                        loadMap(_map.getTiles().get(8).getScaledInstance(w, h, ALLBITS), _x, _y);
                }

                y += 41;
                if (y >= g_0.getHeight()) {
                    y = 0;
                    x += 41;
                }
            }

            loadSprite(pokeball.getActualTile(), pokeball.getX() + _map.getX(), pokeball.getY() + _map.getY());
            loadSprite(trainer.getPlayerTile(), trainer.getX() + _map.getX(), trainer.getY() + _map.getY());
            loadSprite(player.getPlayerTile(), player.getX(), player.getY());

            bs.show();  
        }
    }
}
