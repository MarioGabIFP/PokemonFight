package controller;

import java.awt.Component;
import java.awt.event.KeyEvent;
/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Actions extends KeyEvent {

    public Actions(Component source, int id, long when, int modifiers, int keyCode, char keyChar, int keyLocation) {
        super(source, id, when, modifiers, keyCode, keyChar, keyLocation);
    }

    public Actions(Component source, int id, long when, int modifiers, int keyCode, char keyChar) {
        super(source, id, when, modifiers, keyCode, keyChar);
    }
}
