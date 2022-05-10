package model.pokemones;

import java.awt.Image;
import model.pokemones.miscellaneus.Movements;
import model.pokemones.miscellaneus.Type;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pokemon implements Movements {
    public enum Gender {male,female;}
    
    public enum Nature {
        unfavorable(0.9f), neutral(1.0f), favorable(1.1f);
        
        float value;
        
        Nature (float value) {this.value = value;}
    }
    
    protected int id;
    protected int hp;
    protected int stroke;
    protected int specialStroke;
    protected int defending;
    protected int specialDefending;
    protected int velocity;
    protected int precision;
    protected int evasion;
    protected int iv;
    protected int ev;
    protected Gender gender;
    protected Type[] type;
    protected Nature nature;
    protected int level;
    protected Image tile;
    protected Image backTile;
    protected String name;
    
    public void setHP() {}
    public void setCharas() {}
    
    public int getId() {return id;}
    public int getHp() {return hp;}
    public int getStroke() {return stroke;}
    public int getSpecialStroke() {return specialStroke;}
    public int getDefending() {return defending;}
    public int getSpecialDefending() {return specialDefending;}
    public int getVelocity() {return velocity;}
    public int getPrecision() {return precision;}
    public int getEvasion() {return evasion;}
    public int getIv() {return iv;}
    public int getEv() {return ev;}
    public Gender getGender() {return gender;}
    public Type[] getType() {return type;}
    public Nature getNature() {return nature;}
    public int getLevel() {return level;}
    public Image getTile() {return tile;}
    public Image getBackTile() {return backTile;}
    public String getName() {return name;}
}
