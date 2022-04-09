package model;

import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Pokemon {
    public enum Gender {
        male,female;
    }
    
    public int id;
    public String gender;
    public String type;
    public int hp;
    public int atack;
    public ArrayList<Pokemon> PList;
    public String name;
    public int level;
}
