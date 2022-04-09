/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package controller.elements;

import model.Pokemon.Gender;

/**
 *
 * @author mario
 */
public interface Opponents {
    public enum values {
        player(null, null, 0, 0),
        enemy(null, null, 0, 0);

        String name;
        Gender gender;
        int hp;
        int lv;

        values (String name, String gender, int hp, int lv){};

        public String getName() {return name;}
        public void setName(String name) {this.name = name;}
        public Gender getGender() {return gender;}
        public void setGender(Gender gender) {this.gender = gender;}
        public int getHP() {return hp;}
        public void setHP(int hp) {this.hp = hp;}
        public int getLV() {return lv;}
        public void setLV(int lv) {this.lv = lv;}
    }
}