package controller;

import static java.awt.image.ImageObserver.ABORT;
import java.util.ArrayList;
import view.Graphic;
import static view.elements.screen.Sprites.player;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions extends Graphic {

    private static final long serialVersionUID = 1L;

    ArrayList<Integer> KeyPressedList = new ArrayList<Integer>();

    public Runnable PlayerActions() {
        Runnable move = new Runnable() {
            @Override
            public void run() {
                if (!KeyPressedList.isEmpty()) {
                    int x = player.getX();
                    int y = player.getY();
                    int w = player.getWidth();
                    int h = player.getHeight();

                    if (KeyPressedList.size() == 1) {
                        int codeKey = KeyPressedList.get(0);

                        switch (codeKey) {
                            case 40:
                            case 83:
                                player.setPlayerTile(player.getTileBuffer().get(1).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));
                                player.setBounds(x, y + 5, w, h);
                                break;
                            case 38:
                            case 87:
                                player.setPlayerTile(player.getTileBuffer().get(4).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));
                                player.setBounds(x, y - 5, w, h);
                                break;
                            case 37:
                            case 65:
                                player.setPlayerTile(player.getTileBuffer().get(10).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));
                                player.setBounds(x - 5, y, w, h);
                                break;
                            case 39:
                            case 68:
                                player.setPlayerTile(player.getTileBuffer().get(7).getScaledInstance(player.getWidth(), player.getHeight(), ABORT));
                                player.setBounds(x + 5, y, w, h);
                                break;
                            default:
                                break;
                        }
                    }
                }
            }
        };

        return move;
    }

}
