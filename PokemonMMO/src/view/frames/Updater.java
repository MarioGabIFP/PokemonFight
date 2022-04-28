package view.frames;

import java.io.IOException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Updater{
    public abstract void Update(Boolean isUp) throws IOException, InterruptedException;
}
