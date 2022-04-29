package controller.elements;

/**
 * @author Mario Gabriel Núñez Alcázar de Velasco
 */
public interface Options {
    public enum Act {
        setfigth,
        miPokedex,
        miBag,
        exit
    }
    
    public enum MenInfo {
        getPokemonFromMultiball("Toma un Pokemón"),
        getEnemy("Escoje contrincante");
        
        String title;
        
        MenInfo(String title) {
            this.title = title;
        }
        
        public String getTitle() {return title;}
    }
    
    public enum Battle {
        figth(Act.setfigth, true),
        pokemon(Act.miPokedex, false),
        bag(Act.miBag, false),
        skip(Act.exit, false);
        
        Act action;
        boolean selected;
        
        Battle(Act action, boolean selected){
            this.action = action;
            this.selected = selected;
        }

        public Act getAction() {return action;}
        public boolean isSelected() {return selected;}
        public void setSelected(boolean selected) {this.selected = selected;}
    }
}
