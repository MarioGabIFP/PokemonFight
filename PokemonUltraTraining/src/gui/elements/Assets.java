package gui.elements;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Assets extends Base {

    /**
     * <strong>Sprite del jugador</strong>.
     *
     * <b><b>En el ámbito de los videojuegos, los sprites son un conjunto de
     * imágenes que representa un personaje u objeto (o una parte de ellos) de
     * manera gráfica y que se utiliza para poder crear cualquier efecto de
     * movimiento o para cambiar su estado o posición en la escena.
     */
    String spritePlayer = "assets/sprites/player/";

    /**
     * <strong>Sprites Pokeball</strong>.
     */
    String spritesPokeball = "assets/sprites/pokeballs/";
    
    /**
     * <strong>Sprites Pokeball</strong>.
     */
    String spritePointer = "assets/sprites/pointers/";

    /**
     * <strong>Sprites de Entrenadores</strong>.
     */
    String spritesTrainer = "assets/sprites/trainer/";

    /**
     * <strong>Mapas del Pueblo Paleta</strong>.
     */
    String _Alabastia_4_3 = "assets/maps/Alabastia/4_3/";
    
    /**
     * <strong>Mapas del Pueblo Paleta</strong>.
     */
    File battleBackground = new File("assets/maps/battle/1.png");
    
    /**
     * <strong>Simbolos del Sexo de Pokemones</strong>.
     */
    String genderImg = "assets/sprites/pokemon/gender/";
    
    /**
     * <strong>Sprites de los Pokemones</strong>.
     */
    String spritesPokemon = "assets/sprites/pokemon/";
    
    /**
     * @param xml
     * @param dir
     * @return
     * @throws IOException
     * @throws SAXException
     * @throws ParserConfigurationException
     */
    public abstract ArrayList<Image> tileMapper(File xml, String dir) throws IOException, SAXException, ParserConfigurationException;
}
