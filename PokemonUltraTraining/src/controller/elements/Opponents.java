package controller.elements;

import model.pokemones.Pokemon.Gender;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Opponents {
    public enum values {
        player(null, null, 0, 0, ""),
        enemy(null, null, 0, 0, "");

        String name;
        Gender gender;
        String Tile;
        int hp;
        int lv;

        values (String name, String gender, int hp, int lv, String Sprite){};

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public Gender getGender() {return gender;}
        public void setGender(Gender gender) {this.gender = gender;}
        public int getHP() {return hp;}
        public void setHP(int hp) {this.hp = hp;}
        public int getLV() {return lv;}
        public void setLV(int lv) {this.lv = lv;}
        public void setTile(String Tile) {this.Tile = Tile;}
        public String getTile() {return Tile;}
    }
}