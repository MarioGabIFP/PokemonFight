package controller.menu;

import controller.Actions;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class MenuActions extends Actions {

    @Override
    public void run() {
        if (!KeyPressedList.isEmpty()) {
            if (KeyPressedList.size() == 1) {
                int codeKey = KeyPressedList.get(0);
                switch (codeKey) {
                    case 40 -> {
                        if (pointer.getRY() < 353) {
                            pointer.setRY(pointer.getRY() + 50);
                            pointer.setBounds(pointer.getX(), pointer.getY() + 50, pointer.getWidth(), pointer.getHeight());
                        }
                    }
                    case 38 -> {
                        if (pointer.getRY() > 64) {
                            pointer.setRY(pointer.getRY() - 50);
                            pointer.setBounds(pointer.getX(), pointer.getY() - 50, pointer.getWidth(), pointer.getHeight());
                        }
                    }
                    case 32 -> {
                        selectItem = true;
                    }
                }
            }
        }
    }
}
