package model.menu;

import java.awt.Canvas;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public class Menu extends Canvas {
    public enum BattleOpt {setfigth,miPokedex,miBag,exit}
    
    public enum PokedexValues {
        getPokemonFromMultiball("Toma un Pokemón"),
        getEnemy("Escoje contrincante");
        
        private String title;
        
        private PokedexValues(String title) {this.title = title;}
        
        public final String getTitle() {return title;}
    }
    
    public enum MenuConstructor {
        BattleOptn(BattleOpt.setfigth),
        PokedexValue(PokedexValues.getPokemonFromMultiball);

        private PokedexValues PokedexV;
        private BattleOpt BO;
        
        private MenuConstructor(PokedexValues PokedexV) {this.PokedexV = PokedexV;}
        private MenuConstructor(BattleOpt BO) {this.BO = BO;}

        public final PokedexValues getPokedexV() {return PokedexV;}
        public final BattleOpt getBO() {return BO;}
        public final void setPokedexV(PokedexValues PokedexV) {this.PokedexV = PokedexV;}
        public final void setBO(BattleOpt BO) {this.BO = BO;}
    }
    
    private ArrayList<Image> tiles = new ArrayList<>();
    private File menuSprite;

    public final void setMenuSprite(File mapSprite) {this.menuSprite = mapSprite;}
    public final void setTiles(ArrayList<Image> tiles) {this.tiles = tiles;}
    public final void setOpt(BattleOpt BO) {MenuConstructor.BattleOptn.setBO(BO);}
    public final void setOpt(PokedexValues PV) {MenuConstructor.PokedexValue.setPokedexV(PV);}
    public final File getMenuSprite() {return menuSprite;}
    public final ArrayList<Image> getTiles() {return tiles;}
}
