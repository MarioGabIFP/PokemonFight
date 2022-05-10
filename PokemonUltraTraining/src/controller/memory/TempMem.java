package controller.memory;

import java.awt.Image;
import java.util.ArrayList;
import java.util.Arrays;
import model.Trainer;
import model.pokemones.Charmander;
import model.pokemones.Pikachu;
import model.pokemones.Pokemon;
import model.pokemones.Pokemon.Gender;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface TempMem {
    public enum BattleMem {
        player(null, null, 0, 0, null),
        enemy(null, null, 0, 0, null);

        String name;
        Image tile;
        int hp, lv;
        
        Gender gender;

        BattleMem (String name, String gender, int hp, int lv, Image tile){};

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public Gender getGender() {return gender;}
        public void setGender(Gender gender) {this.gender = gender;}
        public int getHP() {return hp;}
        public void setHP(int hp) {this.hp = hp;}
        public int getLV() {return lv;}
        public void setLV(int lv) {this.lv = lv;}
        public void setTile(Image tile) {this.tile = tile;}
        public Image getTile() {return tile;}
    }
    
    public enum MenuMem {
        pokeSel(new ArrayList<Pokemon>()),
        trainerSel(new Trainer());
        
        ArrayList<Pokemon> selPok;
        Trainer trainer;
        
        MenuMem (ArrayList<Pokemon> selPok){this.selPok = selPok;}
        MenuMem (Trainer trainer){this.trainer = trainer;}
        
        public void addPoke(Pokemon pok) {this.selPok.add(pok);}
    }
    
    public static final ArrayList<Pokemon> pokemones = new ArrayList<>(Arrays.asList(new Pikachu(), new Charmander()));
    public static final ArrayList<Pokemon> pokemonSel = new ArrayList<>();
}