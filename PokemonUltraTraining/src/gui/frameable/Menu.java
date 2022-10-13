package gui.frameable;

import controller.memory.TempMem;
import gui.Graphic;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import model.pokemones.Pokemon;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public abstract class Menu extends Graphic implements TempMem{
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
        
        private MenuConstructor(PokedexValues PokedexVw) {this.PokedexV = PokedexVw;}
        private MenuConstructor(BattleOpt BO) {this.BO = BO;}

        public final PokedexValues getPokedexV() {return PokedexV;}
        public final BattleOpt getBO() {return BO;}
        public final void setPokedexV(PokedexValues PokedexV) {this.PokedexV = PokedexV;}
        public final void setBO(BattleOpt BO) {this.BO = BO;}
    }

    public Menu() throws IOException {}
    
    public final void setOpt(PokedexValues PV) {MenuConstructor.PokedexValue.setPokedexV(PV);}
    public final ArrayList<Image> getTiles() {return tiles;}
    
    public static Pokemon poke = pokemones.get(0);

    private final ArrayList<Image> tiles = new ArrayList<>();
    
    public static final void viewOpt(Pokemon pok) {poke = pok;}
    public static final void setOpt(BattleOpt bo) {MenuConstructor.BattleOptn.setBO(bo);}
    
    public static final void setOpt(Pokemon pok) {
        switch (MenuConstructor.PokedexValue.getPokedexV()) {
            case getPokemonFromMultiball:
                if (!pokemonSel.contains(pok)) {
                    pokemonSel.add(pok);
                } else {
                    pokemonSel.remove(pok);
                }
                break;
            case getEnemy:
                if (!enemySel.contains(pok)) {
                    enemySel.add(pok);
                } else {
                    enemySel.remove(pok);
                }
                break;
        }
    }
}
