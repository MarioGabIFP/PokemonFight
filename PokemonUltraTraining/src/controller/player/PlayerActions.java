package controller.player;

import controller.Actions;
import controller.ScreenController;
import gui.frameable.Alabastia_4_3;
import gui.frameable.Menu;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class PlayerActions extends Actions {

    public PlayerActions() throws IOException, SAXException, ParserConfigurationException, InterruptedException {}

    @Override
    public void KeyisPressed() {
        if (!KeyPressedList.isEmpty()) {
            int speed = 5;

            int x = player.getX();
            int y = player.getY();
            int w = player.getWidth();
            int h = player.getHeight();
            if (KeyPressedList.size() == 1) {
                int codeKey = KeyPressedList.get(0);
                switch (codeKey) {
                    case 40, 83 -> {
                        player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ALLBITS));
                        int _y = y + speed;
                        if (_y <= _map.getY() + (_map.getHeight() - (h - 30))) {
                            player.setBounds(x, _y, w, h);
                        }
                        if (_y >= g_0.getHeight() - (h - 30) && _map.getY() >= - 19) {
                            _map.setBounds(_map.getX(), _map.getY() - speed, _map.getWidth(), _map.getHeight());
                        }
                    }
                    case 38, 87 -> {
                        player.setPlayerTile(player.getTileBuffer().get(4).getScaledInstance(player.getWidth(), player.getHeight(), ALLBITS));
                        if ((y + 30) - speed >= _map.getY()) {
                            player.setBounds(x, y - speed, w, h);
                        }
                        if (y <= g_0.getY() && _map.getY() < 0) {
                            _map.setBounds(_map.getX(), _map.getY() + speed, _map.getWidth(), _map.getHeight());
                        }
                    }
                    case 37, 65 -> {
                        player.setPlayerTile(player.getTileBuffer().get(10).getScaledInstance(player.getWidth(), player.getHeight(), ALLBITS));
                        int _x = x - speed;
                        if (_x >= _map.getX()) {
                            player.setBounds(_x, y, w, h);
                        }
                        if (_x <= g_0.getX() && _map.getX() < 0) {
                            _map.setBounds(_map.getX() + speed, _map.getY(), _map.getWidth(), _map.getHeight());
                        }
                    }
                    case 39, 68 -> {
                        player.setPlayerTile(player.getTileBuffer().get(7).getScaledInstance(player.getWidth(), player.getHeight(), ALLBITS));
                        int _x = x + speed;
                        if (_x <= _map.getX() + _map.getWidth()) {
                            player.setBounds(_x, y, w, h);
                        }
                        if (_x >= g_0.getWidth() - w && _map.getX() >= -19) {
                            _map.setBounds(_map.getX() - speed, _map.getY(), _map.getWidth(), _map.getHeight());
                        }
                    }
                    case 32 -> {
                        try {
                            ScreenController.setScreen(new Menu());
                        } catch (IOException | SAXException | ParserConfigurationException | InterruptedException ex) {
                            Logger.getLogger(PlayerActions.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    default -> {
                        System.out.println(codeKey); 
                    }
                }
            }
        }
    }
}
