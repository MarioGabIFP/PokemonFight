package model.pokemones;

import model.pokemones.miscellaneous.Movements;
import model.pokemones.miscellaneous.Type;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pokemon implements Movements {
    public enum Gender {
        male,female;
    }
    
    public enum Nature {
        unfavorable(0.9f), neutral(1.0f), favorable(1.1f);
        
        float value;
        
        Nature (float value) {this.value = value;}
    }
    
    public int id;
    public int hp;
    public int stroke;
    public int specialStroke;
    public int defending;
    public int specialDefending;
    public int velocity;
    public int precision;
    public int evasion;
    public int iv;
    public int ev;
    public float natur;
    public Gender gender;
    public Type type;
    public Nature nature;
    public int level;
    
    public void setHP() {}
    
    public void setCharas() {}
}
